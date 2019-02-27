#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <wait.h>
#include "makeargv.h"
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#define  SIZE 100
void usage (char *prog) {
   printf("usage : %s [aock] file", prog);
}
int oflag, aflag, cflag, kflag;
int mdo(char ***argvDo,int n){
   int pid, val, i, j, status;
   int stat;
   int pids[SIZE];
   char cmd[SIZE];
   int counter=0;
   char *arg[2];
   arg[1]=NULL;
    for (i = 0; i < n; i++){
      pids[i]=-1;
    }
   if(aflag==1){
        stat=EXIT_SUCCESS;
    }
    else{
        stat=EXIT_FAILURE;
    }
   for ( i = 0; i < n; i++) {
       pid=fork();
       switch (pid) {
         case -1:
           exit(EXIT_FAILURE);
         case 0:
           arg[0]=argvDo[i][0];
           execvp(arg[0],argvDo[i]);
           exit(EXIT_FAILURE);
         default:
           pids[counter++]=pid;

       }
   }
   for (i = 0; i < n; i++) {
      pid = wait(&status);
      assert(pid != -1);
      for(j=0;j<n;j++){
        if( pid == pids[j]){
            pids[j]=-1;
        }
      }
      if(WIFEXITED(status)){
        val=WEXITSTATUS(status);
          if(aflag==1 && val== EXIT_FAILURE ){
              stat=EXIT_FAILURE;
              if(cflag==1){
                if( kflag==1 ){
                  for(j=0;j < n;j++){
                    if( -1 != pids[j]){
                        snprintf(cmd,200,"kill %d",pids[j]);
                        system(cmd);
                    }
                }
              }
              return stat;
            }
          }
        if( oflag == 1 && val== EXIT_SUCCESS ){
          stat=EXIT_SUCCESS;
          if(cflag==1){
            if(kflag == 1){
              for(j=0;j < n;j++){
                if( -1 != pids[j]){
                    snprintf(cmd,100,"kill %d",pids[j]);
                    system(cmd);
                  }
              }
            }
            return stat;
          }
        }

      }
   }
 return stat;
}
int main(int argc, char *argv[]){
  int i, fd, status;
  char ch;
  char **cmdargvDo[SIZE];
  char **cmdargv;
  oflag = 0;
  aflag = 0;
  cflag = 0;
  kflag = 0;

  fd = open("fichier.txt", O_WRONLY|O_CREAT|O_TRUNC, 0644);
  dup2(fd, STDOUT_FILENO);
  close(fd);

  while ((ch = getopt(argc, argv, "oack")) != -1) {
			 switch (ch) {
    		 	 	case 'o':
    		    		oflag = 1;
    		   	  	break;
    				case 'a':
      			  	aflag = 1;
      			  	break;
            case 'c':
      			  	cflag = 1;
      			  	break;
            case 'k':
      			  	kflag = 1;
      			  	break;
	      default:
   		  usage(argv[0]);
		   }
	}
	argc -= optind;
  argv += optind;

  for (i = 0; i < argc; i++) {
      cmdargv = makeargv(argv[i]);
      assert(cmdargv != NULL);
      cmdargvDo[i]=cmdargv;
  }
  status=mdo(cmdargvDo,argc);
  for (i = 0; i < argc; i++){
    freeargv(cmdargvDo[i]);
  }
  return status;

}
