@DeanHava
Feature:dean_messajlari_gormeli
  Background: Dean_mesajIcerigi_gorur
    Given DeanHava siteye gider
    When DeanHava login olur
    And DeanHava Menu secenegine tiklar
    And DeanHava Contact Get all a tiklar
    @TC01_DEAN_MESAJ
  Scenario: TC01_Hava_Dean
    And DeanHava Contact Message sayfasina gelir
    Then DeanHava bu sayfada mesajlari gorur
    And DeanHava yazilan mesajlarin kime ait oldugunu gorur
    And DeanHava yazan kisinin emailini gorur
    And DeanHava mesajlarin hangi tarihte yazildigini gorur
    And DeanHava yazilan mesajlarin  hangi ders icin oldugunu gorur
    And Teacher sayfayi kapatir




