@Mesaj23 @admin
Feature: AdminViceDean

  Scenario: TC01 Admin ViceDean Olusturma


    Given userdla_Set_the_url
    When User_dla send POST Request to the Url for happy_path
    Then User_dla HTTP Status Code Should be 200
    Then User_dla assertion
