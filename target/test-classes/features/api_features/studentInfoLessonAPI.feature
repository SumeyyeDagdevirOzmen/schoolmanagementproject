 @Api21 @apiRegression
Feature:Teacher_Edit_Meet

  @student @Tc2101
  Scenario:TC01_GetAllLessonProgram

    Given s1.user21 set the url for get
    When  s1.user201 sends a GET Request to the Url
    Then  s1.for user21 Http Status Code Should be 200
    Then  s1.for user21 Response body should be like;

  @vicedean  @Crt
  Scenario: CreateLessonProgram
    Given cr01.sends Post request for lesson program list
    Then  cr01.gets the response and verify lesson

  @student @Tc2102
  Scenario: TC02_Choose_Lesson

    Given s2.user21 set the url for post
    When  s2.user21 sends a POST Request to the Url
    Then  s2.for user21 HTTP Status Code Should be 200
    And   s2.for 21 Response body should be like;

  @student @Tc2103
  Scenario: TC023_Choose_Lesson(Negative)

    Given s3.user21 set the url for post
    When  s3.user201 sends POST Request to Url to select courses with the same time and day
    Then  s3.for user21 HTTP Status Code Should be 400
    And   s3.for 21 Response body should be like;


  @admin @Tc2104
  Scenario:TC04_Get_ByStudentId

    Given s4.user21 set the url for get
    When  s4.user201sends a GET Request to the Url
    Then  s4.for user21 Http Status Code Should be 200
    Then  s4.for user21 Response body should be like;


   @student     @Tc2105

  Scenario:TC05_GetAllMeetByStudent

    Given s5.user21 set the url for get
    When  s5.user201sends a GET Request to the Url
    Then  s5.for user21 Http Status Code Should be 200
    Then  s5.for user21 Response body should be like;