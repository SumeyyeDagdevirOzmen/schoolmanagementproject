@us05
Feature:Dean_Edit

  Background: Login olur
    Given  Kullanici anasayfaya gider
    When   Kullanici Admin olarak login olur
    Then   Admin menu butonuna tiklar
    Then   Admin menüden Dean Management'a tiklar


@Dean01
  Scenario: TC01_Informations_Dean
    And  Admin Dean List'deki name Surname gorur
    And  Admin Dean List'deki gender gorur
    And  Admin Dean List'deki phone name gorur
    And  Admin Dean List'deki SSN gorur
    And  Admin Dean List'deki User name gorur
    Then Admin List alanini gordugunu dogrular
    And Admin sayfayi kapatir

@Dean02  @smoke
  Scenario Outline: TC_03_Dean_Edit
    And KullaniciF edit butonuna tiklar
    And KullaniciF "<name>" Alanina ismini girer
    And KullaniciF "<surname>" Alanina soyisim girer
    And KullaniciF "<birthplace>" Alanina sehir girer
    And KullaniciF Genderfemale seceneklerinden birini secer
    And KullaniciF "<date>" Of Birth Alanina dogum tarihi girer
    And KullaniciF "<phone>" Number Alanina telefon numarasini girer
    And KullaniciF "<ssn>" Alanina valid bir ssn numarasi girer
    And KullaniciF "<userName>" Alanina username girer
    And KullaniciF "<password>" Alanina password girer
    And  KullaniciF submitbuton butonuna tiklar
    Then KullaniciF basariyla eklendigi goruntulenir
    Then KullaniciF edit sayfasini kapatir
    And Admin sayfayi kapatir
    Examples:
      | name  | surname | birthplace | date       | phone        | ssn         | userName | password   |
      | Sahra | Yilmaz  | Izmir      | 15.08.2004 | 555-404-3030 | 101-29-1092 | sahraY   | Team03team |


  @Dean03
  Scenario: TC03_Negatif
     And  KullaniciF edit butonuna tiklar
     And  AdminF Gender seceneklerinden birini secmez
     And  AdminF password alanini bos birakir
    And   AdminF submit butonuna tiklar
    And   AdminF tekrardan Dean password girmedigi icin uyari mesaji alir
    And   AdminF "Team03team" Alanina password girer
    And   AdminF submit butonuna tiklar
    Then  AdminF Gender alaninda secim yapmadigi icin anlasilir uyari mesaji alir
    And  Admin sayfayi kapatir
























