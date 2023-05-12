@admin @Api05 @apiRegression
Feature:Teacher_Edit_Meet
@FTC01
  Scenario:TC01_InformatıonDean

    Given user05_Set_the_url
    When  user05_send POST Request to the Url

@FTC02
  Scenario:TC02_Information_Dean

    Given f1.user05 set the url for get
    When  f1.user05 sends a GET Request to the Url
    Then  f1.for user05 HTTP Status Code Should be 200
    And   f1.user05 Response body should be like;

@FTC03
  Scenario:TC_03_Dean_Edit

    Given f2.user05 set the url for update
    When  f2.user05 sends a PUT Request to the Url
    Then  f2.for user05 Http Status Code Should be 200
    Then  f2.user05 Response body should be like:

  @FTC04
  Scenario: TC03_Dean_Delete

    Given f3.user05 set the url for delete dean
    Then  f3.for user05 HTTP Status Code Should be 200
    And   f3.user05 Response body should be like;






 #Scenario:TC04_Teacher_should_be_able_to_update_the_meeting_date

    #Given s4.user20 set the url for update
  #  When s4.user20 sends a PUT Request to the Url
   # Then s4.for user20 Http Status Code Should be 200
   # Then s4.Response body should be like:

  #Scenario:TC05_Teacher_should_be_able_to_update_the_meeting_time

 #   Given s5.user20 set the url for update time
  #  When s5.user20 sends a PUT Request to the Url
  #  Then s5.for user20 Http Status Code Should be 200
   # Then s5.Response body should be like:


 # Scenario:TC06_Teacher_should_be_able_to_DELETE_the_meetings



