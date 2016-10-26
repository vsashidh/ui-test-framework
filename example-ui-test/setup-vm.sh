printf 'testFeature() {\nmvn clean install -Dcucumber.options="--tags $1" -Dtest.browser=CHROME\n}' >> ~/.bash_profile

printf '\nalias tf=testFeature' >> ~/.bash_profile
source ~/.bash_profile