@US18DataBase @DBRegression
  Feature: Studentinfo_database

    Scenario: TC10_Validate_Studentinfo_DB
      Given user connects to database..
      When  find studentinfo by studentId
      Then  validate data student