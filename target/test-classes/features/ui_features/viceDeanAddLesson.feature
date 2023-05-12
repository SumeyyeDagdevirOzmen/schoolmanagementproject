@US08
Feature:Vice Dean Add Lesson

  Background: Vice Dean olarak login.
    Given Kullanici ana sayfaya gider.
    When Kullanici Vice dean hesabi ile login olur
    And Kullanici Lessons butonunu tiklar.



 @US08_Pozitive_scenario @smoke
  Scenario:TC01_Vice_Dean_Lesson_olusturabilmeli.
    And KullaniciV Lesson Name alanina valid bir deger girer
    And KullaniciV Compulsory alanina tiklar
    And KullaniciV Credit Score alanina tiklar
    And KullaniciV Credit Score alanina valid deger girer
    And KullaniciV Submit butonuna tiklar
    And KullaniciV Lesson Created yazisini gorur
    Then KullaniciV sayfayi kapatir


    @US_08_Negative_scenario_01
  Scenario:TC_02_Negative01
      And KullaniciV Lesson Name alanini bos birakir
      And KullaniciV Compulsory alanina tiklar
      And KullaniciV Credit Score alanina tiklar
      And KullaniciV Credit Score alanina valid deger girer
      And KullaniciV Required uyari yazisini gorur
      Then KullaniciV sayfayi kapatir





    @US_08_Negative_scenario_02
  Scenario:TC_03_Negative02
    And  KullaniciV Lesson Name alanina valid bir deger girer
    And  KullaniciV Compulsory alanina tiklar
    And  KullaniciV Credit Score alnini bos birakir
    And  KullaniciV Required uyari yazisini gorur
    Then KullaniciV sayfayi kapatir
