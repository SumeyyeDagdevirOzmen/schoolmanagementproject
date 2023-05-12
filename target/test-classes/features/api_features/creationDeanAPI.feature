@admin @Api4 @apiRegression
Feature:Dean_Creation

  Background:
    Given user04_Set_the_url

  Scenario:TC01_Admin_should_be_able_to_create_the_dean_negative_name

    When user04_send POST Request to the Url for empty name
    Then s.for user04 HTTP Status Code Should be 400

  Scenario:TC02_Admin_should_be_able_to_create_the_dean_negative_surname

    When s2.user04_send POST Request to the Url for empty surname
    Then s.for user04 HTTP Status Code Should be 400

  Scenario:TC03_Admin_should_be_able_to_create_the_dean_negative_Birth_placae

    When s3.user04_send POST Request to the Url for empty birthPlace
    Then s.for user04 HTTP Status Code Should be 400

  Scenario:TC04_Admin_should_be_able_to_create_the_dean_negative_gender

    When s4.user04_send POST Request to the Url for unselected gender
    Then s.for user04 HTTP Status Code Should be 400

  Scenario: TC05_Admin_should_be_able_to_create_the_dean_negative_date_of_birth

    When s5.user04_send POST Request to the Url for empty date
    Then s.for user04 HTTP Status Code Should be 400

    When s5.user04_send POST Request to the Url for invalid date
    Then s.for user04 HTTP Status Code Should be 400

  Scenario: TC06_Admin_should_be_able_to_create_the_dean_negative_phone

    When s6.user04_send POST Request to the Url for empty phone
    Then s.for user04 HTTP Status Code Should be 400

    When s6.user04_send POST Request to the Url for invalid phone
    Then s.for user04 HTTP Status Code Should be 400

  Scenario: TC07_Admin_should_be_able_to_create_the_dean_negative_ssn

    When s7.user04_send POST Request to the Url for empty ssn
    Then s.for user04 HTTP Status Code Should be 400

    When s7.user04_send POST Request to the Url for invalid ssn without hyphens
    Then s.for user04 HTTP Status Code Should be 400

    When s7.user04_send POST Request to the Url for invalid ssn of eleven digits
    Then s.for user04 HTTP Status Code Should be 400

  Scenario: TC08_Admin_should_be_able_to_create_the_dean_negative_username

    When s8.user04_send POST Request to the Url for empty username
    Then s.for user04 HTTP Status Code Should be 400

  Scenario: TC09_Admin_should_be_able_to_create_the_dean_negative_password

    When s9.user04_send POST Request to the Url for empty password
    Then s.for user04 HTTP Status Code Should be 400

    When s9.user04_send POST Request to the Url for invalid password of seven character
    Then s.for user04 HTTP Status Code Should be 400

  Scenario: TC10_Admin_should_be_able_to_create_the_dean_happy_path

    When s10.user04_send POST Request to the Url for happy_path
    Then s.for user04 HTTP Status Code Should be 200
    Then s10.do assertion

