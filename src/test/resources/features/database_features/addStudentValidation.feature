@US15DB @positive15endtoend @DBRegression
  Feature: Validate_student_added_or_not
@run_second
    Scenario: Validate_student_added_or_not_01
      Given User Sevim connects to DataBase
      When  User Sevim finds studentinfo by id
      Then  User Sevim validates data student