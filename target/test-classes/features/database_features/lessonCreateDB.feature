@DBTest08 @DBRegression
Feature: Lesson_DataBase_Test

  Scenario: US_08_Validate_Lesson_DB
    Given Userfrs Find lesson by ID
    Then Userfrs Validate data lesson