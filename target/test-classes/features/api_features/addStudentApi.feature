@Api15 @vicedean @apiRegression
Feature:Save_Student

  Background: Set_the_url
    Given  User sevim sets the URL

  @positive15endtoend @run_first
  Scenario: TC001 post save student request - positive
    When user sevim sends post request with valid datas
    Then user sevim get response and assert status code is twoHundred and response body


  Scenario: TC002 post save student request - empty advisor teacher
    When user sevim sends post request with empty advisorTeacher
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC003 post save student request - empty username
    When user sevim sends post request with empty username
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC004 post save student request - empty name
    When user sevim sends post request with empty name
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC005 post save student request - empty surname
    When user sevim sends post request with empty surname
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC006 post save student request - empty birthDay
    When user sevim sends post request with empty birthDay
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC007 post save student request - empty birthPlace
    When user sevim sends post request with empty birthPlace
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC008 post save student request - empty ssn
    When user sevim sends post request with empty ssn
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC009 post save student request - empty phoneNumber
    When user sevim sends post request with empty phoneNumber
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC010 post save student request - empty gender
    When user sevim sends post request with empty gender
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC011 post save student request - empty motherName
    When user sevim sends post request with empty motherName
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC012 post save student request - empty fatherName
    When user sevim sends post request with empty fatherName
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC013 post save student request - empty email
    When user sevim sends post request with empty email
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC014 post save student request - ssn format xx-xxx-xxxxx
    When user sevim sends post request with ssn format xx-xxx-xxxxx
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC015 post save student request - ssn format xxx-xxx-xxxxx
    When user sevim sends post request with ssn format xxx-xxx-xxxx
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC016 post save student request - ssn format x-xxxx-xxxxx
    When user sevim sends post request with ssn format x-xxxx-xxxxx
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC017 post save student request - empty password
    When user sevim sends post request with empty password
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC018 post save student request - password with 7 charachter
    When user sevim sends post request with password with 7 character
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC019 post save student request - pasword with 8 space character
    When user sevim sends post request with password with 8 space character
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC020 post save student request - email format ABC..
    When user sevim sends post request containing an e-mail in ABC.. format
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC021 post save student request - email format ABC..@1
    When user sevim sends post request containing an e-mail in ABC..@1 format
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC022 post save student request - email format ABC..@gmail
    When user sevim sends post request containing an e-mail in ABC..@gmailcom format
    Then user sevim get response and assert status code is fourHundred

  Scenario: TC023 post save student request - email format name.gmail@com
    When user sevim sends post request containing an e-mail in name.gmail@com format
    Then user sevim get response and assert status code is fourHundred
