@vicedean @Api14 @apiRegression
Feature:ViceDean_Validate_Teacher

  @GetTeacher
  Scenario: TC01_ViceDean_Get_Teacher
    Given Userz sets the url for get request
    When Userz sends a GET request
    Then Userz verifies teacher response body

  @PozitiveTeacher
  Scenario:TC02_ViceDean_Update_Teacher_Positive
    Given Userz sets the url for put request
    When Userz sends a PUT request
    Then Userz verifies teacher response body voor positive update

  @NegativeChooseLesson
  Scenario:TC03_Vice_Dean_Update_Teacher
    Given Userz sets the url for put request
    When Userz sends update request without choose lessons dropdown
    When Userz sends a PUT request
    Then Userz verifies that HTTP Status Code is 405

  @NegativeName
  Scenario:TC04_Vice_Dean_Update_Teacher
    Given Userz sets the url for put request
    When Userz sends update request without name
    When Userz sends a PUT request
    Then  Userz verifies that HTTP Status Code is 405

  @NegativePassword
  Scenario:TC05_Vice_Dean_Update_Teacher
    Given Userz sets the url for put request
    When Userz sends update without password
    When Userz sends a PUT request
    Then Userz verifies that HTTP Status Code is 405

  @NegativeGender
  Scenario:TC06_Vice_Dean_Update_Teacher
    Given Userz sets the url for put request
    When Userz sends update without gender
    When Userz sends a PUT request
    Then Userz verifies that HTTP Status Code is 405
















