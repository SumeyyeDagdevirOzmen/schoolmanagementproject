@DB05


Feature: US05_Dean_Database

  Scenario Outline: US05 Dean (DataBase)

    Given "<username>" ile dean al
    Then resultSet bodyi dogrula: userId="<userId>", username="<username>", name="<name>", surname="<surname>", birthDay="<birthDay>", ssn="<ssn>", birthPlace="<birthPlace>", phoneNumber="<phoneNumber>", gender="<gender>"
    Examples:
      | userId | username  | name  | surname | birthDay   | ssn         | birthPlace | phoneNumber  | gender |
      | 24     | 7947david | david | Som     | 2001-11-03 | 484-54-7947 | bitlis     | 071-786-7947 | MALE   |







    #Feature:Dean_validation

 # Scenario:TC01_Dean_Database
 #   Given f1.user05 connects to database
 #  When  f1.user05 Find dean by ssn
 # Then  f1.user05 Validate data