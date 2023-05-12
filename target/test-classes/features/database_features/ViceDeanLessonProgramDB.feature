@Us10DataBase @DBRegression
Feature:Us10_DatabaseTesti

  Scenario: TC05_get_Lessons_program_DataBase
    Given user connects to database
    When  userHtc finds from Lesson program by id
    Then  validate data