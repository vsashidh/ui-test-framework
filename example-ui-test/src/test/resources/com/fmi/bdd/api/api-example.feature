@api
Feature: Example feature
  I want to use this example to show how behavior-driven development tests work.

  @smoke
  Scenario: retrieve some data

    Given url 'https://api.myjson.com/bins/1avy3h'
    When method get
    Then status 200
    And match response ==
    """
    {
      "textModuleId": "DB2C9769-A6EA-11E7-A2FD-8FA6067CE4BB",
      "textModule": {
      "id": "DB2C9769-A6EA-11E7-A2FD-8FA6067CE4BB",
      "status": "Draft",
      "isDeleted": false,
      "isActive": false,
      "requiresScientificReview": false,
      "requiresEditorialReview": false,
      "version": 1,
      "validationErrors": [
        "a module type is required",
        "a status is required",
        "module text is required",
        "an expiration period is required",
        "at least one matching rule is required"
        ]
      }
    }
    """