Feature:US002 Admin Guest User List

  @US002-TC001
  Scenario: Admin Name, Phone Number, SSN, User Name görebilmeli.
    Given Admin managementonschools adresine gider
    Then  Admin first Login butonuna tiklar.
    Then  Admin User Name girer.
    And   Admin Password girer.
    And   Admin Login butonuna tiklar.
    And   Admin MENU butonuna tiklar.
    And   Admin Main Menu Butonuna tiklar.
    And   Admin acilan sayfadan Name, Phone Number, SSN, User Name gorur.
    Then AdminD sayfayi kapatir


  @US002-TC002 @regression
  Scenario: Admin Guest User List bilgilerini silebilmeli
    Given Admin managementonschools adresine gider
    Then  Admin first Login butonuna tiklar.
    Then  Admin User Name girer.
    And   Admin Password girer.
    And   Admin Login butonuna tiklar.
    And   Admin MENU butonuna tiklar.
    And   Admin Main Menu Butonuna tiklar.
    And   Admin ilgili User icin delete buttonina tiklar.
    And   Admin Guest User Deleted Successful yazisini gorur.
