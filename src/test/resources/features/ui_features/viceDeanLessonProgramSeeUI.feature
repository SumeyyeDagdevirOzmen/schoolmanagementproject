@vicedeanUS11
Feature: US11
  Background: School_Management_sayfasina_git
    Given kullanici anasayfaya gider
    When kullanici uygulamaya vicedean hesabiyla login olur
    And kullanici Lesson program basligina tiklar

  @vicedean1101
  Scenario: TC01_ViceDean_Gorme
    Then kullanici "Lesson" basligi altinda olusturulan dersi gordugunu dogrular
    Then kullanici "Day" basligi altinda olusturulan gunu gordugunu dogrular
    Then kullanici "Start Time" basligi altinda olusturulan baslangic zamanini gordugunu dogrular
    Then kullanici "Stop Time" basligi altinda olusturulan bitis zamanini gordugunu dogrular
    Then uygulamayi kapat

  @vicedean1102
  Scenario: (BUG)TC02_ViceDean_Guncelleme
    Then kullanici "Lesson" basligi altinda olusturdugu dersin edit butonuna tiklar
    Then uygulamayi kapat


  @vicedean1103
  Scenario: (BUG)TC03_ViceDean_Silme
    Then kullanici "Lesson" basligi altinda olusturdugu dersin delete butonuna tiklar
    Then uygulamayi kapat


