@contact_message_dean @dean @apiRegression
Feature: Message Sending

  @TC01_ContactMessage_P_Pass
  Scenario: TC01_User_can_send_the_message
    Given UserF sends the post request for the message
    Then  UserF verify the response

  @TC02_ContactMessage_N_Pass
  Scenario: TC02_User_can_send_the_message
    Given UserF sends the post request without name for the message
    Then  UserF verify the status code should be 400

  @TC03_ContactMessage_N_Pass
  Scenario: TC02_User_can_send_the_message
    Given UserF sends the post request(mail) without @ and . for the message
    Then  UserF verify the response without @ und .

  @TC04_ContactMessage_N_Fail
  Scenario: TC02_User_can_send_the_message
    Given UserF sends the post request(mail) without point for the message
    Then  UserF verify the response without  .


  @TC05_ContactMessage_N_Pass
  Scenario: TC02_User_can_send_the_message
    Given UserF sends the post request(mail) without @ for the message
    Then  UserF verify the status code should be 400

  @TC06_ContactMessage_N_Pass
  Scenario: TC02_User_can_send_the_message
    Given UserF sends the post request without subject
    Then  UserF verify the response without  subject