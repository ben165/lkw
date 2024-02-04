#!/usr/bin/bash

folder="/home/asdf/Downloads/2024_java/05_lkw/src/main/java/org/truck"
date1=$(date +%y-%m-%d--%H-%M)
backup1="/home/asdf/Downloads/2024_java/backup/"

#echo $folder
#echo $date1

tar -czf $date1.tar $folder
mv $date1.tar $backup1

