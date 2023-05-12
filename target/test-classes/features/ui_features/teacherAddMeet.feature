@us19 @regression
  Feature: Us19_Teacher Toplanti Olusturabilmeli
    Background:
      Given kullanici siteye gider...
      When kullanici "Nihal03" ismi ve "Team03team" sifresi ile login olur
      And kullanici Menu butonuna tiklar
      And kullanici Meet Management'a tiklar
@us19_tc01
      Scenario Outline: TC01_Teacher ögrenciler ile toplanti duzenler
        And kullanici "<ogrenci>" secer
        And kullanici zorunlu alanlari doldurur
        And kullanici Submit'e tiklar
        Then kullanici toplanti olusturabildigini dogrular
        And kullanici sayfayi kapatir..

        Examples:
        |ogrenci      |
        |idil Bksgn|


@us19_tc02
  Scenario:TC02_Negatif senaryo1
    And kullanici ogrenci secer
    And kullanici tarih alanina gecmis bir tarih girer
    And kullanici diger zorunlu alanlari girer
    And kullanici Submit'e tiklar
    Then kullanici toplanti olusturamadigini dogrular
    And kullanici sayfayi kapatir..

@us19_tc03
  Scenario: TC03_Negatif senaryo2
    And kullanici ogrenci secer
    And kullanici tüm zorunlu alanlari bos birakir
    And kullanici Submit'e tiklar
    Then Kullanici Date Of Meet,StartTime,StopTime ve Description alanlarinin zorunlu oldugunu dogrular
    And kullanici sayfayi kapatir..

