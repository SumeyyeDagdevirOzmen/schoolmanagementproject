@e2edean
Feature: Dean_creation_UI
  Scenario: admin Dean ekleyebilmelidir
    Given Kullanicigul ansayfaya gider
    Then Kullanicigul 1 saniye bekler
    When Kullanicigul Admin olarak login olur
    Then Kullanicigul 1 saniye bekler
    And Kullanicigul menu butonuna tiklar
    When Kullanicigul Dean Management a tiklar
    Then Kullanicigul 1 saniye bekler
    Then s.11Kullanicigul tum textboxlara valid degerler girerek doldurur
    Then Kullanicigul submit butonuna tiklar
    Then s11Kullanicigul "Dean Saved" mesaji gormelidir
    Then kullanicigul logaut yapar
    Then Kullanicigul sayfayi kapatir