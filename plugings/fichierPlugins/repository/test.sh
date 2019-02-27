#!/bin/bash

make

gcc -Wall true.c -o mtrue
gcc -Wall false.c -o mfalse

echo "./do  -a  "mtrue""
./do  -a   "./mtrue"
if [[ $? -eq 0 ]]; then
  echo "OK"
elif [[ $? -ne 0 ]]; then
  echo "NOK"
fi

echo "./do  -a "./mfalse""
./do  -a   "./mfalse"
if [[ $? -eq 0 ]]; then
  echo "OK"
elif [[ $? -ne 0 ]]; then
  echo "NOK"
fi

echo "./do  -o "mtrue""
./do  -o  "./mtrue"
if [[ $? -eq 0 ]]; then
  echo "OK"
elif [[ $? -ne 0 ]]; then
  echo "NOK"
fi

echo "./do  -o  "./mfalse""
./do  -o   "./mfalse"
if [[ $? -eq 0 ]]; then
  echo "OK"
elif [[ $? -ne 0 ]]; then
  echo "NOK"
fi


echo "./do  -a "ls" "mtrue""
./do  -a  "ls" "./mtrue"
if [[ $? -eq 0 ]]; then
  echo "OK"
elif [[ $? -ne 0 ]]; then
  echo "NOK"
fi

echo "./do  -a "ls" "./mfalse""
./do  -a  "ls" "./mfalse"
if [[ $? -eq 0 ]]; then
  echo "OK"
elif [[ $? -ne 0 ]]; then
  echo "NOK"
fi

echo "./do  -o "ls" "mtrue""
./do  -o  "ls" "./mtrue"
if [[ $? -eq 0 ]]; then
  echo "OK"
elif [[ $? -ne 0 ]]; then
  echo "NOK"
fi

echo "./do  -o "./mfalse" "./mfalse""
./do  -o  "./mfalse" "./mfalse"
if [[ $? -eq 0 ]]; then
  echo "OK"
elif [[ $? -ne 0 ]]; then
  echo "NOK"
fi


echo "./do -a  -k   "ls -al" "ls" "
./do -a -c -k  "ls -al" "ls"
if [[ $? -eq 0 ]]; then
  echo "OK"
elif [[ $? -ne 0 ]]; then
  echo "NOK"
fi


echo "./do -a  -k   "mfalse" "ls -al" "ls" "ls" "ls" "
./do -a -c -k   "mfalse" "ls -al" "ls" "ls" "ls"
if [[ $? -eq 0 ]]; then
  echo "OK"
elif [[ $? -ne 0 ]]; then
  echo "NOK"
fi


echo "./do -o  -k   "mfalse" "ls -al" "ls" "ls -al" "ls" "
./do -o  -k   "mfalse" "ls -al" "ls" "ls" "ls"
if [[ $? -eq 0 ]]; then
  echo "OK"
elif [[ $? -ne 0 ]]; then
  echo "NOK"
fi

echo "./do -a -c -k   "ls -al" "ls" "
./do -a -c -k  "ls -al" "ls"
if [[ $? -eq 0 ]]; then
  echo "OK"
elif [[ $? -ne 0 ]]; then
  echo "NOK"
fi


echo "./do -a  -c -k   "mfalse" "ls -al" "ls" "ls" "ls" "
./do -a -c -k   "mfalse" "ls -al" "ls" "ls" "ls"
if [[ $? -eq 0 ]]; then
  echo "OK"
elif [[ $? -ne 0 ]]; then
  echo "NOK"
fi


echo "./do -o -c -k   "mfalse" "ls -al" "ls" "ls -al" "ls" "
./do -o -c -k   "mfalse" "ls -al" "ls" "ls" "ls"
if [[ $? -eq 0 ]]; then
  echo "OK"
elif [[ $? -ne 0 ]]; then
  echo "NOK"
fi


echo "./do -o -c -k  "ls" "emacs" "firefox" "xtern" "
./do -o -c -k  "ls" "emacs" "firefox" "xtern"
if [[ $? -eq 0 ]]; then
  echo "OK"
elif [[ $? -ne 0 ]]; then
  echo "NOK"
fi

rm fichier.txt
rm mtrue
rm mfalse
