@admin @ApiUS25 @apiRegression
Feature:Student_Create

  Background:
    Given User25 sets the Url

  @TC001
  Scenario: US25_student_create_happy_path
    When User25 send_post request for student
   And UserKubra_25 verifys that Status code is 200
    Then User25 gets the student data and assert