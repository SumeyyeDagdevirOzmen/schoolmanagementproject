@ApiUs12 @vicedean @apiRegression
Feature: Vice_Dean_should_be_assign_lesson_to_the_teacher

  @US12_TC01
  Scenario: TC01_Vice_dean_should_be_create_the_lesson_in_the_lesson_program_list
    Given Vice DeanAy sends Post request for lesson program list
    Then Vice DeanAy gets the response and verify lesson

  @US12_TC02
  Scenario: TC02_ViceDeanAy sends get request for lessonPrograms
    Given ViceDeanAy sends get request for lessonsProgram
    Then ViceDeanAy verifys must be seen lessonsprogram

  @US12_TC03
  Scenario: TC03_Vice_dean_should_be_choose_the_teacher_in_the_lesson_program
    Given Vice DeanAy sends post request for choose the teacher to the lesson program
    Then Vice DeanAy gets the response and verify teacher

  @US12_TC04
  Scenario: TC04_ViceDeanAy should be delete from the lessonProgramList
    Given ViceDeanAy sends the delete request
    Then ViceDeanAy must be verify statusCode 200


