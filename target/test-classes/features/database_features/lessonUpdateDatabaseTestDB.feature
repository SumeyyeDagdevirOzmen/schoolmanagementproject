@DBTest09 @DBRegression
Feature: Lesson_DataBase_Test

  Scenario: TC05_Validate_Lesson_DB
    Given Find lesson by ID
    Then Validate data lessson

