#   Gestionnaire de travaux
Simona Enasoae et Marcel Fernandez de la Pena


On a essayé de couvrir tous les possibilites.
On peux:
  - envoyer des signals aux processus (CTRL-Z, CTRL-C, SIGSTOP,SIGCONT) et la list des jobs se fait toujours des updates .
  - faire fg, bg, stop, kill et kill avec les pids ou les jids des processus
  - faire communiquer plusieurs travaux  grâce aux tubes


Exemple:
1. SIGNALS

- 1 MSHELL:

      xeyes

      CTRL-C

  Obs: le processus est terminé
- 2  MSHELL:

      xeyes

      CTRL-Z
  Obs: le processus est arreté
- 3  MSHELL:

      xeyes

      CTRL-Z

    TERM:

      kill -s SIGCONT %pid_du_processus%
  Obs: le processus continue
- 4  MSHELL:

      xeyes

   TERM:

      kill -s SIGKILL %pid_du_processus%

   Obs: le processus est terminé
- 5  MSHELL:

      xeyes

   TERM:

      kill -s SIGTSTP %pid_du_processus%

   Obs: le processus est arreté

2. DO

  - 1  MSHELL:

        xeyes &

        fg %1

    Obs: le processus commence en bg et apres on le met en fg
  - 2  MSHELL:

        xeyes

        CTRL-Z

        fg %1

    Obs: le processus commence  , on le stoppe et apres on le met en fg
  - 3  MSHELL:

        xeyes &

        kill %1

    Obs: le processus commence et apres on le tue

  - 4  MSHELL:

        xeyes &

        stop %1

    Obs: le processus commence et apres on l'arrete
  - 5  MSHELL:

        exit

    Obs: on sort du mshell
  - 6  MSHELL:

        xeyes

        CTRL-Z

        exit

      Obs: on ne peut pas sortir du mshell parce qu'il y a encore des jobs non termines
  - 7  MSHELL:

        xeyes &

        xeyes &

        exit

      Obs: on  peut  sortir du mshell et les processus en bg qui sont en running continue a vivre.
  - 8  MSHELL:

         xeyes &

      Obs: le processus commence en bg

  3. Travaux communicants par tubes
  - 1  MSHELL:

        emacs|emacs|emacs

        CTRL-C

        ps

      Obs: On ouvre 3 processus emacs, on les fermes, on verifie s'il y a des processus zombie.(il n'y en a pas :) )

  - 2 MSHELL:  

        cat cmd.c | grep include |wc -l

      Obs:On voie 8 comme resultat.
  - 3 MSHELL:  

        cat cmd.c |wc -l |wc

      Obs:On voie " 1       1       4 " comme resultat. (comme le vraie shell)
  - 4  MSHELL:

        emacs|emacs|emacs

        CTRL-Z

        jobs

        ps

      Obs: On ouvre 3 processus emacs, on les a arretes, on verifie la liste des jobs.
