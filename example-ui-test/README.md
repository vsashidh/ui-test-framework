MR2 QA Framework
===================

Use ``` develop ``` branch for active development.  ``` master ``` branch is to version control healthy set of tests.

Once you have cloned the project 
 1. check out the ``` develop ``` branch : ``` git checkout develop ```
 2. create feature branches using ``` git checkout -b feature\<feature-name> ```
 3. Make changes , commit and push the local feature branch to remote( or origin)
 4. Create a merge request to be merged into develop branch

### Prepare environment
``` ./setup.sh ```

### Run tests locally
``` mvn clean install -Denv=local```

``` tf @mr2mgmt_1228``` (to run a specific feature file)

OR

``` mvn clean install -Dcucumber.options="--tags @mr2mgmt_1228" -Denv=local ```


### Releasing at the end of a sprint
From ``` develop ``` branch run : 

1. ``` mvn jgitflow:release-start ```
2. ``` mvn jgitflow:release-finish -Dmaven.test.skip=true ```

### deploy QA container
``` docker compose up -d --build ```

### destroy QA container
``` docker compose down ```

#### Running all test on the Vagrant VM
```bash
docker exec -it [container_name] mvn install -Denv=vm
```
#### Running single test on the Vagrant VM
```bash
docker exec -it [container_name] mvn install -Dcucumber.options="--tags [tag_name_with_@_symbol]" -Denv=vm
```

