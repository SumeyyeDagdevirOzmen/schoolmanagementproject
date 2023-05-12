@DBUS11 @DBRegression
Feature: US11_Lesson_Program_info_validation


  Scenario Outline: TC01_validate_lesson_program_info
    Given UserAy connect to database
    When Send query to get guest user by lessonProgramId "<id>"
    Then body should be like: day="<day>" start_time="<start_time>" stop_time="<stop_time>" education_term_id="<education_term_id>"

  Examples:
    | id | day    | start_time | stop_time | education_term_id |
    | 6  | SUNDAY | 12:00:00   | 14:00:00  | 1                 |
    | 10 | MONDAY | 12:30:00   | 18:30:00  | 1                 |


    #select * from public.lesson_program where id=6