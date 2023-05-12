@Mesajdila @admin
Feature: Admin Guest User List
  Scenario: TC01 mesaj goruntuleme
    Given UserDila URL e Get request yapar
    Then userDila gets all data and assert

  Scenario: TC02_Delete_guestdata
    Given userDila sends delete request for guests data
    Then userDila delete data and assert