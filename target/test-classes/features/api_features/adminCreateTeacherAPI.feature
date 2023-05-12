@admin @api24 @apiRegression
  Feature: Admin_Create_Teacher
    Scenario: US24_TeacherCreate
      Given UserNhl sets the url for teeacher creation
      When UserNhl sends post request for teacher creation
      And UserNhl verifys that the status code is 200 for teacher creation
      Then UserNhl asserts response body for teacher creation