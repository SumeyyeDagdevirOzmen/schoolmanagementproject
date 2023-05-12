@20 @regression
Feature:Teacher toplantilari gorebilmeli guncelleyebilmeli ve silebilmeli

  Background:Teacher olarak giris
    Given Kullanicigul ansayfaya gider
    When Kullanicigul teacher olarak login olur
    And Kullanicigul menu butonuna tiklar
    And Kullanicigul menüden Meet Management'a tiklar

  @20_1
  Scenario: TC01_Teacher toplantilari gorebilmeli

    Then Kullanicigul Date bolumunu gorebilmelidir
    Then Kullanicigul Start Time alanini gorebilmelidir
    Then Kullanicigul Stop Time alanini gorebilmelidir
    Then Kullanicigul Description alanini gorebilmelidir
    Then kullanicigul logaut yapar
    Then Kullanicigul sayfayi kapatir

  @20_2
  Scenario: TC02_Teacher toplantilari guncelleyebilmeli_Date of meet
    Then Kullanicigul 2 saniye bekler
    And kullanici "Serkan yalcin" secer
    And kullanici zorunlu alanlari doldurur
    And kullanici Submit'e tiklar
    Then Kullanicigul 1 saniye bekler
    When Kullanicigul Edit alanina tiklar
    When  s2.Kulanicigul Date Of Meet alanini valid bir tarih ile degistirir
    Then Kullanicigul "Succesfuly" mesaji gorebilmelidir
    Then kullanicigul logaut yapar
    Then Kullanicigul sayfayi kapatir

  @20_3
    Scenario: Teacher toplantilari guncelleyebilmeli (Start time)
    Then Kullanicigul 2 saniye bekler
    When Kullanicigul Edit alanina tiklar
    Then s.3Kulanicigul Start Time alanini valid bir saat ile degistirir
    Then Kullanicigul "Succesfuly" mesaji gorebilmelidir
    Then kullanicigul logaut yapar
    Then Kullanicigul sayfayi kapatir

@20_4
  Scenario: Teacher toplantilari guncelleyebilmeli (Stop  time)
  Then Kullanicigul 2 saniye bekler
  When Kullanicigul Edit alanina tiklar
  Then s.4Kulanicigul St0p Time alanini valid bir saat ile degistirir
  Then Kullanicigul "Succesfuly" mesaji gorebilmelidir
  Then kullanicigul logaut yapar
  Then Kullanicigul sayfayi kapatir

  @20_5
    Scenario:Teacher toplantilari guncelleyebilmeli (Description)
    Then Kullanicigul 1 saniye bekler
    When Kullanicigul Edit alanina tiklar
    Then s.5Kulanicigul St0p Time alanini valid bir saat ile degistirir
    Then Kullanicigul "Succesfuly" mesaji gorebilmelidir
    Then kullanicigul logaut yapar
    Then Kullanicigul sayfayi kapatir




  @20_6
  Scenario:Teacher toplantilari silebilmeli


    Then Kullanicigul 2 saniye bekler
    When  s6.Kullanicigul delete alanina tiklar
    Then kullanicigul  "Meet deleted successfully " mesaji gormelidir
    Then kullanicigul logaut yapar
    Then Kullanicigul sayfayi kapatir















