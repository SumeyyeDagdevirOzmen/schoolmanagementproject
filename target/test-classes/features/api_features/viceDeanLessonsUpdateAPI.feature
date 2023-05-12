@vicedean @Api09 @apiRegression
Feature:ViceDean_Validate_LessonList

@PostLesson
  Scenario:  TC01_Vicedean_Post_Lesson
    Given Userz sets the url for post lesson
    When Userz sends a POST request lesson

@GetLesson
  Scenario: TC02_ViceDean_Get_Lesson
    Given Userz sets the url for get request lesson
    When Userz sends a GET request for lesson
    Then Userz verifies that HTTP Status Code is 200 voor get lesson
    Then Userz verifies lesson response body

@DeleteLesson
  Scenario:TC03_ViceDean_Delete_Lesson
    Given Usez sets the url for delete request
    When Userz sends a DELETE request
    Then Userz verifies that HTTP Status Code is 200 voor delete









