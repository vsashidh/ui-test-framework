QA Framework
===================

Use ``` develop ``` branch for active development.  ``` master ``` branch is to version control healthy set of tests.

Once you have cloned the project 
 1. check out the ``` develop ``` branch : ``` git checkout develop ```
 2. create feature branches using ``` git checkout -b feature\<feature-name> ```
 3. Make changes , commit and push the local feature branch to remote( or origin)
 4. Create a merge request to be merged into develop branch

### Creating your first test project
``` mvn archetype:generate -Dfilter=com.foundationmedicine:fmi-ui-test-archetype ```

### Run tests locally
``` mvn clean install -Denv=local```


OR

``` mvn clean install -Dcucumber.options="--tags @smoke" -Denv=local```

### Run API tests locally

```mvn clean install -Dcucumber.options="--tags @api" -DapiTest -Denv=aws```


### Releasing at the end of a sprint
From ``` develop ``` branch run : 

1. ``` mvn jgitflow:release-start ```
2. ``` mvn jgitflow:release-finish -Dmaven.test.skip=true ```



