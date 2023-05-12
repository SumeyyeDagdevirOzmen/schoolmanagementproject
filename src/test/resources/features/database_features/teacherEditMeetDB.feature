@db20 @DBRegression
  Feature: Meet_validation
    Scenario: TC01_Validate_Meet_Database
      Given usergul connect to database
      When Usergul finds meet by MeetID
      Then Usergul validates Data