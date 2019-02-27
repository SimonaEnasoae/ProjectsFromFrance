/* mshell - a job manager */

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <string.h>
#include "cmd.h"
#include "sighandlers.h"
#include "jobs.h"
#include "pipe.h"
#include "common.h"


void do_pipe(char *cmds[MAXCMDS][MAXARGS], int nbcmd, int bg) {
    int i,j,fds[nbcmd][2];
    pid_t pid;
    char cmd[1000];
    sigset_t mask;
    pid_t pids[100];
    /* create the name of the comand (the name is only a part of the name of the comand )*/
    strcpy(cmd,cmds[0][0]);
    for(i=1;i<nbcmd;i++){
      strcat(cmd," | ");
      strcat(cmd,cmds[i][0]);
    }
    /* create nbcmd-1 pipes for the process */
    for(i=0;i< nbcmd-1; i++){
      assert(pipe(fds[i]) != -1);
    }
    /*
     * Block SIGCHLD, SIGINT, and SIGTSTP
     * signals until we can add the job to the job list. This
     * eliminates some nasty races between adding a job to the job
     * list and the arrival of SIGCHLD, SIGINT, and SIGTSTP signals.
     */
    if (sigemptyset(&mask) < 0)
        unix_error("sigemptyset error");
    if (sigaddset(&mask, SIGCHLD))
        unix_error("sigaddset error");
    if (sigaddset(&mask, SIGINT))
        unix_error("sigaddset error");
    if (sigaddset(&mask, SIGTSTP))
        unix_error("sigaddset error");
    if (sigprocmask(SIG_BLOCK, &mask, NULL) < 0)
        unix_error("sigprocmask error");



    for(i=0;i<nbcmd;i++){
      switch (pid=fork()) {
          case -1:
              exit(EXIT_FAILURE);
          case 0:
              /* Child unblocks signals */
              sigprocmask(SIG_UNBLOCK, &mask, NULL);
              /* Each child must get a the process group ID
                oof the first one ,so that the kernel  send ctrl-c and ctrl-z
                signals to all of the childs */

              if (i==0){
                  dup2(fds[0][1],STDOUT_FILENO);
                  for(j=0;j< nbcmd-1; j++){
                        close(fds[j][0]);
                        close(fds[j][1]);
                  }
                  execvp(cmds[0][0],cmds[0]);
                  exit(EXIT_FAILURE);
              }
              else {
                      if(i == nbcmd -1){

                            /* the last process */
                            dup2(fds[i-1][0],STDIN_FILENO);
                            for(j=0;j< nbcmd-1; j++){
                                  close(fds[j][1]);
                                  close(fds[j][0]);
                            }
                            execvp(cmds[i][0],cmds[i]);
                            exit(EXIT_FAILURE);
                      }

                      else{
                              /* for all the process without the last one */
                              dup2(fds[i-1][0],STDIN_FILENO);
                              dup2(fds[i][1],STDOUT_FILENO);
                              for(j=0;j< nbcmd-1; j++){
                                  close(fds[j][1]);
                                  close(fds[j][0]);
                              }
                              execvp(cmds[i][0],cmds[i]);
                              exit(EXIT_FAILURE);

                          }
                  }
          default:
            pids[i]=pid;
            if(i+1 == nbcmd){
              if (setpgid(pid, 0) < 0)
                    unix_error("setpgid error");
            }
          }
    }
    for(i=0;i<nbcmd-1;i++){
      setpgid(pids[i],pids[nbcmd-1]);
    }
    /*
     * Parent process
     */
    /* Parent adds the job, and then unblocks signals so that
       the signals handlers can run again */
    jobs_addjob(pids[nbcmd-1], (bg == 1 ? BG : FG), cmd);
    sigprocmask(SIG_UNBLOCK, &mask, NULL);
    /*  close the pipes */
    for(j=0;j< nbcmd-1; j++){
          close(fds[j][1]);
          close(fds[j][0]);
    }
    if (!bg)
        waitfg(pids[nbcmd-1]);

    return;
}
