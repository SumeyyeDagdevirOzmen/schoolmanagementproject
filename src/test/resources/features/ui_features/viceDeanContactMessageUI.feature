@US16_ViceDean_Message @regression
  Feature: US16_ViceDeanSeesMessage

    Background:
      Given  KullaniciF sayfaya gider
      And Kullanici SignIn butonuna tiklar
      And Kullanici  User Name textboxa valid bir deger girer
      And Kullanici Password textboxa valid bir deger girer
      And KullaniciF Login butonuna tiklar
      And Kullanic acilan sayfada Menu butonuna tiklar
      And Kullanici solda acilan Contact Get All sekmesine tiklar

    @US16_TC01_P_Pass
    Scenario: TC01_ViceDean_ContactMessage

    Then Kullanici Mesajlarin in gorunur oldugunu dogrular
      Then KullanicF sayfayi kapatir


    @US16_TC02_P_Pass
    Scenario: TC02_ViceDean_ContactMessage

    Then Kullanici Subjectlerin gorunur oldugunu dogrular
      Then KullanicF sayfayi kapatir

    @US16_TC03_P_Pass
    Scenario: TC03_ViceDean_ContactMessage

      Then Kullanici Datelerin gorunur oldugunu dogrular
      Then KullanicF sayfayi kapatir

    @US16_TC04_P_Pass
    Scenario: TC04_ViceDean_ContactMessage

      Then Kullanici Emaillerin gorunur oldugunu dogrular
      Then KullanicF sayfayi kapatir

    @US16_TC05_P_Pass
    Scenario: TC05_ViceDean_ContactMessage

      Then Kullanici Namelerin gorunur oldugunu dogrular
      Then KullanicF sayfayi kapatir

    @US16_TC06_P_Fail
    Scenario: TC06_ViceDean_ContactMessage

      Then Kullanici herhangi bir mesaji silindigini dogrular
      Then KullanicF sayfayi kapatir