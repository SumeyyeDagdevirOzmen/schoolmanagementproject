@US12DB @DBRegression
  Feature:US12_Lesson_program_validacion
    Scenario:TC01_Find_lesson_program
      Given UserA connect to database
      When UserA send query for lesson pronram id
      Then UserA validate data

    Scenario:TC02_see_teacher_chooseLesson
      Given UserA connect to database
      When UserA send query to see teacher in the choose Lesson
      Then UserA validation data