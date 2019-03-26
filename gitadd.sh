#On s'assure d'être à jour concernant les différentes versions du projet qui est en ligne
./gitmaj.sh
#On remonte ensuite les modifications à apporter au projet
git add .
git commit -m $1
git push
