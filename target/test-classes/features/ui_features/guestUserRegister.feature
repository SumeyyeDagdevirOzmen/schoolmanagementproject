@US01
Feature: Register ekleme

  Background:
    Given Kullanici ana sayfaya gider
    When  Kullanici Register butonuna tiklar




    @TC_01_RegisterEkleme @smoke
    Scenario:US01_TC_01-Pozitif_scenario
      And kullaniciF name alanina valid bir isim girer
      And kullaniciF surname alanina valid bir soyisim girer
      And kullaniciF birthplace alanina valid bir dogum yeri girer
      And kullaniciF phone  alanina valid bir telefon numarasi girer
      And kullaniciF gender kutularindan birini secer
      And kullaniciF Date Of Birth alanina valid bir dogum tarihi girer
      And kullaniciF SSN alanina valid bir SSN numarasi girer
      And kullaniciF User Name alanina valid bir kullanici adi girer
      And kullaniciF Password alanina valid bir sifre girer
      And kullaniciF Register1 butonuna tiklar
      Then kullaniciF Guest user registered yazisini gorur
      Then KullaniciF uygulamayi kapatir


  @TC_02_Negative_scenario_01
  Scenario:US01_TC_02_Negative01
    And kullaniciF name  alanini bos birakir
    And kullaniciF surname alanina valid bir soyisim girer
    And kullaniciF birthplace alanina valid bir dogum yeri girer
    And kullaniciF phone  alanina valid bir telefon numarasi girer
    And kullaniciF gender kutularindan birini secer
    And kullaniciF Date Of Birth alanina valid bir dogum tarihi girer
    And kullaniciF SSN alanina valid bir SSN numarasi girer
    And kullaniciF User Name alanina valid bir kullanici adi girer
    And kullaniciF Password alanina valid bir sifre girer
    And kullaniciF Required uyari yazisini gorur
    Then KullaniciF uygulamayi kapatir


  @TC_03_Negative_scenario_02
  Scenario:US_01_TC_03_Negative02
    And kullaniciF name alanina valid bir isim girer
    And kullaniciF surname alanini bos birakir
    And kullaniciF birthplace alanina valid bir dogum yeri girer
    And kullaniciF phone  alanina valid bir telefon numarasi girer
    And kullaniciF gender kutularindan birini secer
    And kullaniciF Date Of Birth alanina valid bir dogum tarihi girer
    And kullaniciF SSN alanina valid bir SSN numarasi girer
    And kullaniciF User Name alanina valid bir kullanici adi girer
    And kullaniciF Password alanina valid bir sifre girer
    And kullaniciF Required uyari yazisini gorur
    Then KullaniciF uygulamayi kapatir



  @TC_04_Negative_scenario_03
  Scenario:US_01_TC_04_Negative03
    And kullaniciF name alanina valid bir isim girer
    And kullaniciF surname alanina valid bir soyisim girer
    And kullaniciF birthplace alani bos birakir
    And kullaniciF phone  alanina valid bir telefon numarasi girer
    And kullaniciF gender kutularindan birini secer
    And kullaniciF Date Of Birth alanina valid bir dogum tarihi girer
    And kullaniciF SSN alanina valid bir SSN numarasi girer
    And kullaniciF User Name alanina valid bir kullanici adi girer
    And kullaniciF Password alanina valid bir sifre girer
    And kullaniciF Required uyari yazisini gorur
    Then KullaniciF uygulamayi kapatir

  @TC_05_Negative_scenario_04
  Scenario:US_01_TC_05_Negative04
    And kullaniciF name alanina valid bir isim girer
    And kullaniciF surname alanina valid bir soyisim girer
    And kullaniciF birthplace alanina valid bir dogum yeri girer
    And kullaniciF phone  alanini bos birakir
    And kullaniciF gender kutularindan birini secer
    And kullaniciF Date Of Birth alanina valid bir dogum tarihi girer
    And kullaniciF SSN alanina valid bir SSN numarasi girer
    And kullaniciF User Name alanina valid bir kullanici adi girer
    And kullaniciF Password alanina valid bir sifre girer
    And kullaniciF Required uyari yazisini gorur
    Then KullaniciF uygulamayi kapatir


  @TC_06_Negative_scenario_05
  Scenario:US_01_TC_06_Negative05
    And kullaniciF name alanina valid bir isim girer
    And kullaniciF surname alanina valid bir soyisim girer
    And kullaniciF birthplace alanina valid bir dogum yeri girer
    And kullaniciF phone  alanina valid bir telefon numarasi girer
    And kullaniciF gender kutularindan birini secer
    And kullaniciF Date Of Birth alanini bos birakir
    And kullaniciF SSN alanina valid bir SSN numarasi girer
    And kullaniciF User Name alanina valid bir kullanici adi girer
    And kullaniciF Password alanina valid bir sifre girer
    And kullaniciF Required uyari yazisini gorur
    Then KullaniciF uygulamayi kapatir


  @TC_07_Negative_scenario_06
  Scenario:US_01_TC_07_Negative06
    And kullaniciF name alanina valid bir isim girer
    And kullaniciF surname alanina valid bir soyisim girer
    And kullaniciF birthplace alanina valid bir dogum yeri girer
    And kullaniciF phone  alanina valid bir telefon numarasi girer
    And kullaniciF gender kutularindan birini secer
    And kullaniciF Date Of Birth alanina valid bir dogum tarihi girer
    And kullaniciF SSN alanini alanini bos birakir
    And kullaniciF User Name alanina valid bir kullanici adi girer
    And kullaniciF Password alanina valid bir sifre girer
    And kullaniciF Required uyari yazisini gorur
    Then KullaniciF uygulamayi kapatir



  @TC_08_Negative_scenario_07
  Scenario:US_01_TC_08_Negative07
    And kullaniciF name alanina valid bir isim girer
    And kullaniciF surname alanina valid bir soyisim girer
    And kullaniciF birthplace alanina valid bir dogum yeri girer
    And kullaniciF phone  alanina valid bir telefon numarasi girer
    And kullaniciF gender kutularindan birini secer
    And kullaniciF Date Of Birth alanina valid bir dogum tarihi girer
    And kullaniciF SSN alanina valid bir SSN numarasi girer
    And kullaniciF User Name alanini bos birakir
    And kullaniciF Password alanina valid bir sifre girer
    And kullaniciF Required uyari yazisini gorur
    Then KullaniciF uygulamayi kapatir



  @TC_09_Negative_scenario_08
  Scenario:US_01_TC_09_Negative08
    And kullaniciF name alanina valid bir isim girer
    And kullaniciF surname alanina valid bir soyisim girer
    And kullaniciF birthplace alanina valid bir dogum yeri girer
    And kullaniciF phone  alanina valid bir telefon numarasi girer
    And kullaniciF gender kutularindan birini secer
    And kullaniciF Date Of Birth alanina valid bir dogum tarihi girer
    And kullaniciF SSN alanina valid bir SSN numarasi girer
    And kullaniciF User Name alanina valid bir kullanici adi girer
    And kullaniciF Password alanini bos birakir
    And kullaniciF Required uyari yazisini gorur
    Then KullaniciF uygulamayi kapatir









