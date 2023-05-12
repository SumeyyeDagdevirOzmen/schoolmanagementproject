@vicedeanUS12
Feature: US12
  Background: School_Management_sayfasina_git
    Given kullanici anasayfaya gider
    When kullanici uygulamaya vicedean hesabiyla login olur
    And kullanici Lesson program basligina tiklar

  @vicedean1201
  Scenario: TC01_ViceDean_Olusturulan_Dersi_Gorme
    And kullanici Choose Lessons basligina tiklar...
    And kullanici acilan listede olusturulan dersi gorur
    Then uygulamayi kapat

  @vicedean1202
  Scenario: TC02_ViceDean_Ogretmene_Ders_Atayabilme
    And kullanici Lesson Program Assigment basligini gorur
    And kullanici olusturulan derste checkbox a tiklar
    And kullanici Choose Teacher basligina tiklar
    And kullanici acilan listeden ders icin bir ogretmen secer
    And kullanici Submit butonuna tiklar..
    And kullanici "Lesson added to Teacher" mesajini gorur
    Then uygulamayi kapat

