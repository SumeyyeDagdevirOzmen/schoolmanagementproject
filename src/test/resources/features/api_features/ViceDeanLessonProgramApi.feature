@Us10TestData  @vicedean @apiRegression
Feature:LessonProgramtestdata

  Background:Us10_lesson_program
    Given useron set the url

   Scenario: TC01 post Lessons program
    When  user10_send Post request for guest LessonProgram..
    And   user10HTTP Status code should be 200
    Then  user10_gets the register data und assert...

  Scenario: TC02_StartTime is empty
    When   user10_send Post reguest StartTime empty
    Then   10.HTTP Status code should be 400 ..

  Scenario: TC03_StopTime is empty
    When   user10_send Post reguest StopTime empty
    Then   10.HTTP Status code should be 400 ..

  Scenario: TC04_Day is empty
    When   user10_send Post reguest Day empty
    Then   10.HTTP Status code should be 400 ..
