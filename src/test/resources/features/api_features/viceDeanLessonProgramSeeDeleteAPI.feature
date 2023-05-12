@ApiUs11 @vicedean @apiRegression
Feature: Vice_Dean_should_be_update_delete_lesson_programs

  @US11_TC01
  Scenario: TC01_Vice_Dean_post_request_for_the_lesson_program
    Given Vice DeanAy send post request

  @US11_TC02
  Scenario: TC02_Vice_dean_should_be_see_the_lesson_program
    Given Vice DeanAy sends get request for lesson program
    Then Vice DeanAy gets the response and verify

  @US11_TC03
  Scenario: TC03_Vice_dean_should_be_delete_the_lesson_program
    Given Vice DeanAy sends delete request for lesson program
    Then Vice DeanAy gets the response and verify status code should be 200
