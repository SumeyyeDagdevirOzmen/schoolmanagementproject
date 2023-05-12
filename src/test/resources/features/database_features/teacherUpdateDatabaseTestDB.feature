@DBTest14 @DBRegression
Feature: Teacher_DataBase_Test

  Scenario: TC05_Validate_Teacher_DB
    Given Find teacher by ID
    Then Validate data teacher


