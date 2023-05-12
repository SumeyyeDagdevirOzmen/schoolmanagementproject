@teacher @Api20 @apiRegression
Feature:Teacher_Edit_Meet


  Scenario: TC01_Teacher_should_be_able_to_create_the_meetings

    Given user20_Set_the_url
    When user20_send POST Request to the Url


  Scenario: TC02_Teacher_should_be_able_to_see_the_meetings

    Given s2.user20 set the url for get
    When s2.user20 sends a GET Request to the Url
    Then s2.for user20 HTTP Status Code Should be 200
    And s2.Response body should be like;

  Scenario: TC03_Teacher_should_be_able_to_update_the_meeting description

    Given s3.user20 set the url for update
    When s3.user20 sends a PUT Request to the Url
    Then s3.for user20 Http Status Code Should be 200
    Then s3.Response body should be like:

  Scenario: TC04_Teacher_should_be_able_to_update_the_meeting_date

    Given s4.user20 set the url for update
    When s4.user20 sends a PUT Request to the Url
    Then s4.for user20 Http Status Code Should be 200
    Then s4.Response body should be like:

  Scenario: TC05_Teacher_should_be_able_to_update_the_meeting_time

    Given s5.user20 set the url for update time
    When s5.user20 sends a PUT Request to the Url
    Then s5.for user20 Http Status Code Should be 200
    Then s5.Response body should be like:


  Scenario: TC06_Teacher_should_be_able_to_DELETE_the_meetings

    Given s.user20 set the url for delete meet
    Then s.for user20 HTTP Status Code Should be 200
    And s.Response body should be like;




