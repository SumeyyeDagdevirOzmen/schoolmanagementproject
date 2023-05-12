@db23 @DBRegression
Feature:Dean_validation

  Scenario:TC01_Validate_ViceDean_Database
    Given userdla connects to database
    When userdla Find dean by ssn
    Then userdla Validate data