@Contact_Message
  Feature: Contact_Message

    Background:
    Given  KullaniciF sayfaya gider
    When Kullanici Contact butonuna tıklar

      @Tc01_P_Pass
   Scenario: TC01 Contact Message
   And Kullanici Your Name textboxa valid "farukD" bir deger girer
   And Kullanici Your Mail textboxa valid "farukDRM@gmail.com" bir deger girer
   And Kullanici Subject  textboxina valid "LMS" bir deger girer
   And Kullanici Massage textboxina valid "LMS neden kapali" bir deger girer
   And Kullanici Send Message butonuna tıklar
   Then Kullanici mesajin gönderildigini dogrular
   Then KullanicF sayfayi kapatir

     @Tc02_N_Fail
    Scenario: TC02_Contact_Message_Negative

    And Kullanici Your Name textboxa invalid "" bir deger girer
    And Kullanici Your Mail textboxa valid "" bir deger girer
    And Kullanici Subject  textboxina valid "LMS" bir deger girer
    And Kullanici Massage textboxina valid "LMS neden surekli kapaniyor" bir deger girer
    And Kullanici Send Message butonuna tıklar
    Then Kullanici hata mesaji alindigini dogrular
    Then KullanicF sayfayi kapatir

    @Tc03_N_Pass
    Scenario: TC03_Contact_Message_Negative

    And Kullanici Your Name textboxa valid "Faruk" bir deger girer
    And Kullanici Your Mail textboxa invalid "faruk1mail" bir deger girer
    And Kullanici Subject  textboxina valid "LMS" bir deger girer
    And Kullanici Massage textboxina valid "LMS neden surekli kapaniyor" bir deger girer
    And Kullanici Send Message butonuna tıklar
    Then Kullanici hata mesaji alindigini dogrular
    Then KullanicF sayfayi kapatir

    @Tc04_N_Fail
       Scenario: TC04_Contact_Message_Negative

   And  Kullanici Your Name textboxa valid "Faruk" bir deger girer
   And  Kullanici Your Mail textboxa invalid "faruk21@gmailcom" bir deger girer
   And Kullanici Subject  textboxina valid "LMS" bir deger girer
   And Kullanici Massage textboxina valid "LMS neden surekli kapaniyor" bir deger girer
   And Kullanici Send Message butonuna tıklar
   Then Kullanici hata mesaji alindigini dogrular
   Then KullanicF sayfayi kapatir

    @Tc05_N_Pass
         Scenario: TC05_Contact_Message_Negative

      And  Kullanici Your Name textboxa valid "Faruk" bir deger girer
      And  Kullanici Your Mail textboxa invalid "faruk25gmail.com" bir deger girer
      And Kullanici Subject  textboxina valid "LMS" bir deger girer
      And Kullanici Massage textboxina valid "LMS neden surekli kapaniyor" bir deger girer
      And Kullanici Send Message butonuna tıklar
      Then Kullanici hata mesaji alindigini dogrular
      Then KullanicF sayfayi kapatir

    @Tc06_N_Fail
    Scenario: TC06_Contact_Message_Negative

      And  Kullanici Your Name textboxa valid "Faruk" bir deger girer
      And  Kullanici Your Mail textboxa valid "" bir deger girer
      And Kullanici Subject  textboxina invalid "" bir deger girer
      And Kullanici Massage textboxina valid "LMS neden surekli kapaniyor" bir deger girer
      And Kullanici Send Message butonuna tıklar
      Then Kullanici hata mesaji alindigini dogrular
      Then KullanicF sayfayi kapatir

    @Tc07_N_Fail
    Scenario: TC07_Contact_Message_Negative

      And  Kullanici Your Name textboxa valid "Faruk" bir deger girer
      And  Kullanici Your Mail textboxa valid "" bir deger girer
      And Kullanici Subject  textboxina valid "LMS" bir deger girer
      And Kullanici Massage textboxina invalid "" bir deger girer
      And Kullanici Send Message butonuna tıklar
      Then Kullanici hata mesaji alindigini dogrular
      Then KullanicF sayfayi kapatir