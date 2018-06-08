ui-test-framework
===================

The is a UI test framework, which will be referenced by test projects.


### Creating your first test project (not required if exploring this framework)
``` mvn archetype:generate -Dfilter=com.xyz ```

### Structure of this project

* root
* |- ui-tests-base (**THE framework**)
* |- ui-tests-archetype (**archetype project used to generate a test project**)
* |- example-ui-test (a sample test project)

### Run tests locally 
``` mvn clean install -Denv=local```


OR

``` mvn clean install -Dcucumber.options="--tags @smoke" -Denv=local```

### Run API tests locally

```mvn clean install -Dcucumber.options="--tags @api" -DapiTest -Denv=aws```

### Viewing the cucumber reports
In the test project navigate to `target/cucumber-html-reports/overview-steps.html`

### Collaboration
Use ``` develop ``` branch for active development.  ``` master ``` branch is to version control healthy set of tests.

Once you have cloned the project 
 1. check out the ``` develop ``` branch : ``` git checkout develop ```
 2. create feature branches using ``` git checkout -b feature\<feature-name> ```
 3. Make changes , commit and push the local feature branch to remote( or origin)
 4. Create a merge request to be merged into develop branch

### Releasing at the end of a sprint
From ``` develop ``` branch run : 

1. ``` mvn jgitflow:release-start ```
2. ``` mvn jgitflow:release-finish -Dmaven.test.skip=true ```

