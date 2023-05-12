
@databaseFaruk @admin @DBRegression
Feature:Contact_Message_Database
  Scenario: TC01_Contact_Message_Verification
    Given user connects to database
    When userFrk creates a message  by api.
    Then userFrk asserts this data in databas