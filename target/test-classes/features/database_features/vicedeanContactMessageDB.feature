  @Us16_Database @DBRegression
  Feature: vicedean_contact_message

    Scenario: TC01_Vicedean_must be able to see messages(message)
      Given user connects to database
      Then userFrk asserts this data in database(message)