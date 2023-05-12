@e2edean  @admin
Feature:Dean_Validation_Api
  Scenario: Validate_dean_with_ssn
    Given user sends get request for deanAll
    Then user validate ssn number

  Scenario: Validate_Dean_Database
    #Given usergul connect to database
    When Usergul finds dean by ssn
    Then Usergul validates DeanData
