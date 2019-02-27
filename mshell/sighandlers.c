/* mshell - a job manager */

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <signal.h>
#include <sys/wait.h>
#include <errno.h>
#include <assert.h>
#include <sys/wait.h>
#include <unistd.h>
#include <string.h>
#include "jobs.h"
#include "common.h"
#include "sighandlers.h"

/*
 * wrapper for the sigaction function
 */
int sigaction_wrapper(int signum, handler_t * handler) {
    struct sigaction action;
    action.sa_handler = handler;
    sigemptyset(&action.sa_mask);
    action.sa_flags = SA_RESTART;
    sigaction(signum, &action, NULL);
    return 1;
}

/*
 * sigchld_handler - The kernel sends a SIGCHLD to the shell whenever
 *     a child job terminates (becomes a zombie), or stops because it
 *     received a SIGSTOP or SIGTSTP signal. The handler reaps all
 *     available zombie children
 */
 void sigchld_handler(int sig) {
   int pid, status;
   struct job_t *job;

     if (verbose)
         printf("sigchld_handler: entering \n");
     while((pid = waitpid(-1,&status,WNOHANG|WUNTRACED|WCONTINUED)) != -1 &&  pid != 0 ){
       if(pid!=0){
           if(WIFEXITED(status)){
                /* true if the child terminated normally */
                jobs_deletejob(pid);
           }
           else {
                 if(WIFSTOPPED(status)){
                         /* if the child process was stopped by delivery of a signal */
                   job = jobs_getjobpid(pid);
                   if(job!=NULL){
                     job -> jb_state = ST;
                   }
                 }
                 if(WIFSIGNALED(status)){
                        /*  true if the child process was terminated by a signal */
                        jobs_deletejob(pid);
                 }
                 else if(WIFCONTINUED(status)){
                   job = jobs_getjobpid(pid);

                   if(job!=NULL){
                     if(job -> jb_state == ST){
                 	    job -> jb_state = BG;
			}
                   }
                 }

             }
       }
     }
     if (verbose)
         printf("sigchld_handler: exiting \n");

     return;
 }


/*
 * sigint_handler - The kernel sends a SIGINT to the shell whenver the
 *    user types ctrl-c at the keyboard.  Catch it and send it along
 *    to the foreground job.
 */
void sigint_handler(int sig) {
    int pid;
    if (verbose)
        printf("sigint_handler: entering\n");
    if( (pid = jobs_fgpid())  != 0){
        kill(-pid,sig);  /* the "-" before the pid is used that we can also send signal to a process group */
    }

    if (verbose)
        printf("sigint_handler: exiting\n");

    return;
}

/*
 * sigtstp_handler - The kernel sends a SIGTSTP to the shell whenever
 *     the user types ctrl-z at the keyboard. Catch it and suspend the
 *     foreground job by sending it a SIGTSTP.
 */
void sigtstp_handler(int sig) {
    int pid;
    if (verbose)
        printf("sigtstp_handler: entering \n");
    if( (pid = jobs_fgpid())  != 0){
        kill(-pid,sig);  /* the "-" before the pid is used that we can also send signal to a process group */
    }
    if (verbose)
        printf("sigtstp_handler: exiting \n");

    return;
}
