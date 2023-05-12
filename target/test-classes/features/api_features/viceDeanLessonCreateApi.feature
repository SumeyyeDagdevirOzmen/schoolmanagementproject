 @vicedean @ApiUs08 @apiRegression
  Feature: Vice_Dean_Add_Lesson

    Background:
      Given Vice Deanfrz set the URL



    @US08_TC001_Positive
    Scenario:TC001_Vice_Deanfrz_Add_Lesson
      When Vice Deanfrz send  post request for add lesson
      Then Vice Deanfrz gets the data and verify


    @US08_TC002_Negative
    Scenario:TC002_Vice_Deanfrz_Add_Lesson
      When Vice Deanfrz send post request without choose lessonName
      Then Vice Deanfrz verify the status code should be 400



    @US08_TC003_Negative
    Scenario:TC003_Vice_Deanfrz_Add_Lesson
      When Vice Deanfrz send invalid post request for creditScore
      Then Vice Deanfrz verify the status code should be 400

