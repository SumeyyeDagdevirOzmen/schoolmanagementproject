@US02_DBtest
Feature: US02_GuestUserList

  Scenario: US02_Admin_Guest_User_List
    Given Find Guest User Info
    Then Validate data US_02 id_192
