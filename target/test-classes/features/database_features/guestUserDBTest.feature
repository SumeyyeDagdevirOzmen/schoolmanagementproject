@DBTest01 @DBRegression

Feature: US01_Guest_User_DB

  Scenario Outline: US01_Get_GuestUserById_DB

    Given Sendfrz query to get guest user by id "<id>"
    Then bodys should be like: username="<username>" ssn="<ssn>" name="<name>" surname="<surname>" birthDay="<birthDay>" birthPlace="<birthPlace>" phoneNumber="<phoneNumber>" gender="<gender>"

    Examples:
      | id  | username   | ssn               | name  | surname   | birthDay   | birthPlace | phoneNumber  | gender |
      | 33  | yusuf      | 293-30-3120       | murat | gunes     | 2005-12-12 | turkiye    | 369-540-1020 | MALE   |




