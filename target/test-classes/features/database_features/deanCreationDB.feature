 @db4 @DBRegression
Feature:Dean_validation

  Scenario:TC01_Validate_Dean_Database
    Given usergul connects to database
    When usergul Find dean by ssn
    Then usergul Validate data

