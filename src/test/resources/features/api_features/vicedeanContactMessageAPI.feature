  @vicedean_Contact_Mesaage  @vicedean @apiRegression
  Feature: Vicedean_sees_message

    @Us16_Tc01
    Scenario:TC01_Vicedean_should_be_able_to_see_the_name_of_the_users.
      Given UserFrk sets the Url
      When UserFrk sends a get  request
      Then UserFrk verifys that https code is twohundert
      Then UserFrk as Vıcedean verifys response body  that messages are visible."
    @Us16_Tc02
     Scenario: TC02_Vicedean_schould_be_able_to_see_authors_of_the_massages.
       Given UserFrk sets the Url
       When UserFrk sends a get  request
       Then UserFrk verifys that https code is twohundert
       Then UserFrk as Vıcedean verifys response body  that authors are visible."
     @Us16_TC03
     Scenario: Tc03_Vicedean_schould_be_able_to_see_emails_address_of_the_users.
       Given UserFrk sets the Url
       When UserFrk sends a get  request
       Then UserFrk verifys that https code is twohundert
       Then UserFrk as Vıcedean verifys response body  that emails are visible."
     @Us16_Tc04
     Scenario:Tc04_Vicedean_schould_be_able_to_see_dates_of_the_messages
       Given UserFrk sets the Url
       When UserFrk sends a get  request
       Then UserFrk verifys that https code is twohundert
       Then UserFrk as Vıcedean verifys response body  that sentdate are visible."
     @Us16_Tc05
     Scenario: Tc05_Vicedean_schould_be_able_to_see_subjects_of_the_messages
       Given UserFrk sets the Url
       When UserFrk sends a get  request
       Then UserFrk verifys that https code is twohundert
       Then UserFrk as Vıcedean verifys response body  that subjects are visible."