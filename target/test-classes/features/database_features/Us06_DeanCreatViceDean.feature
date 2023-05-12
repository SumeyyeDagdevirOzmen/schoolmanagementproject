@admin @DeanCreateViceDean06
Feature: Dean Vice Dean ekleyebilmelidir.

  Scenario: TC01 Eklenen vice dean database gorulebilmelidir.

    Given Kullanici_yusuf Vice Dean ekler
    When Database_yusuf icin connect saglanir
    When Databaseden_yusuf olusturulan vice dean bilgileri sorgulanir
    Then Databasede_yusuf deanin ekledigi vice deanin goruldugu dogrulanir.



 # Scenario: TC02

  #  Given Kullanici_yusuf Vice Dean ekler
  #  When Database_yusuf icin connect saglanir
  #  When Databaseden_yusuf olusturulan "id" icin "5" ozellikli sorgu yapilir.
  #  Then Olusturulan_yusuf "id" icin "5" ozellikli verinin dogrulamasi yapilir
