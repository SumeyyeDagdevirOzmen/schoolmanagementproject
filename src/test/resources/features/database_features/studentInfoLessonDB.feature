@DB21 @DBRegression

Feature:US21_ChooseLesson List Validation
  Scenario:TC01_Chooselist
    Given User21 connect to database
    When  User21 send query for lesson name
    Then  User21 valide the lesson name
    When  User21 see which lesson_program_id matches lesson_id
    Then  User21 valide lesson_program_id
    When  user21  send query for start_time,stop_time
    Then  user21 valide start_time,stop_time
    When  user21 send query to see teacher id in the choose Lesson
    Then  user21 valide the data
    When  user21 send query to see teacher name
    Then  user21 valide teacher name


  Scenario:TC02_see_meeting
    Given User21 connect to database
    When User21 send query to see meeting information
    Then User21 validation meeting information



  Scenario:TC02_see_student_grades
    Given User21 connect to database
    When  User21 sends query to see student grades
    Then User21 validation see student grades


