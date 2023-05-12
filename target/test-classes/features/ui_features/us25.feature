
@US25 @regression @smoke


Feature: Admin olarak ogrenci ekleme

  Scenario: Admin olarak ogrenci ekleme
    Given KKullanıcı sayfaya gider
    When KKullanıcı uygulamaya Admin olarak login olur
    And KKullanici Menu butonuna tiklar
    And KKullanici Student Management secegine tiklar
    And KKullanici dropdown menusunden ogretmen secimini yapar
    And Kullanicik Name Alanina valid bir isim girer
    And KSurname alanina valid bir Surname girilir
    And KBirthplace alanina valid bir Birthplace girilir
    And KKullanici valid bir email adresini girer
    And KGender seceneklerinden biri secilir
    And KDate Of Birth alanina valid bir dogum tarihi girilir
    And KPhone Number alanina valid bir Phone Number girilir
    And KSSN alanina valid bir SSN numarasi girilir
    And KUser Name alanina valid bir kullanici adi girilir
    And KKullanici Father name girer
    And KKullanici Mother name girer
    And KPassword alanina valid bir Password girilir
    And KSubmit butonuna tiklanir
    Then Ogrenci basariyla eklendi mesaji goruntulenir.
    And KSayfayi kapatir.





























