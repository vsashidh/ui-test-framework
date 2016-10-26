#!/usr/bin/env bash

if [ ! -d "/Volumes/qe-mavenrepo$" ]; then
  echo "Mounting shared drive..."

  while true; do
    echo "Enter username for shared drive authentication: "
    read username
    username=$(echo $username | xargs)
    if [ "$username" != "" ]; then
      echo "Using username: $username"
      break
    fi
  done

  mkdir -p  /Volumes/qe-mavenrepo$
  mount_smbfs smb://$username@fm-150sec-nas01-smb01/qe-mavenrepo$ /Volumes/qe-mavenrepo$
fi


printf 'testFeature() {\nmvn clean install -Dcucumber.options="--tags $1" -Dtest.browser=CHROME\n}' >> ~/.bash_profile

printf '\nalias tf=testFeature' >> ~/.bash_profile

source ~/.bash_profile