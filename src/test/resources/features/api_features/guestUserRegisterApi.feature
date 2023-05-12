
@admin  @ApiUS01 @apiRegression

Feature:Register_Guest_User


  Background:
    Given Userfrz set the URL




  @US01_TC001_Positive
  Scenario: TC01_post_guest_user
    Given Userfrs send post request for guest user
    Then Userfrs gets the register data and assert


  @US01_TC002_Negative
  Scenario: TC02_post_guest_user
    When Vice Deanfrs send post request without choose name
    Then Vice Deanfrs verify the status code should be 400




  @US01_TC003_Negative
  Scenario: TC03_post_guest_user
    When Vice Deanfrs send post request without choose ssn nummer
    Then Vice Deanfrs verify the status code should be 400



  @US01_TC004_Negative
  Scenario: TC04_post_guest_user
    When Vice Deanfrs send post request without choose password
    Then Vice Deanfrs verify the status code should be 400



  @US01_TC005_Negative
  Scenario: TC05_post_guest_user
    When Vice Deanfrs send post request without choose surname
    Then Vice Deanfrs verify the status code should be 400



  @US01_TC006_Negative
  Scenario: TC06_post_guest_user

    When Vice Deanfrs send post request without choose username
    Then Vice Deanfrs verify the status code should be 400












