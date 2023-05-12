@US13
Feature:Teacher_Management
  Background:Vice_Dean_Olarak_login_olmali

    Given Kullanici  sayfaya gider uygulamaya Vice Dean hesabiyla login olur
    When Kullanici menu butonuna tiklar
    And Kullanici Teacher Management secenegine tiklar


  @TC001_AddTeacher
  Scenario:TC001_Positive_ViceDean_Ogretmen_Ekleyebilmeli

    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And Kullanici SSN alanina ssn girer
    And Kullanici UserName alanina gecerli bir username girer
    And Kullanici Password alanina gecerli bir password girer
    And KullaniciS Submit butonuna tiklar
    Then Kullanici ogretmen olusturdugunu dogrular
    Then Kullanici uygulamayi kapatir


  @TC002_AddTeacher
  Scenario:TC002_Negative_Choose_Lessons_Dropdown_bos_birakilamaz

    And Kullanici Choose Lessons dropdowni bos birakir
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And Kullanici SSN alanina ssn girer
    And Kullanici UserName alanina gecerli bir username girer
    And Kullanici Password alanina gecerli bir password girer
    And KullaniciS Submit butonuna tiklar
    And Kullanici "lessons must not empty" uyari mesajini aldigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC003_AddTeacher
  Scenario:TC003_Negative_Name_alani_bos_birakilamaz
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanini bos birakir
    And Kullanici "Required" uyari mesaji goruntulendigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC004_AddTeacher
  Scenario:TC004_Negative_Name_alani_space_karakterlerden_olusamaz
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina space karakter girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And Kullanici SSN alanina ssn girer
    And Kullanici UserName alanina gecerli bir username girer
    And Kullanici Password alanina gecerli bir password girer
    And KullaniciS Submit butonuna tiklar
    Then Kullanici invalid uyari mesaji aldigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC005_AddTeacher
  Scenario:TC005_Negative_Surname_alani_bos_birakilamaz
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanini bos birakir
    And Kullanici "Required" uyari mesaji goruntulendigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC006_AddTeacher
  Scenario:TC006_Negative_Surname_alani_space_karakterlerden_olusamaz
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina space karakter girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And Kullanici SSN alanina ssn girer
    And Kullanici UserName alanina gecerli bir username girer
    And Kullanici Password alanina gecerli bir password girer
    And KullaniciS Submit butonuna tiklar
    Then Kullanici invalid surname uyari mesaji aldigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC007_AddTeacher
  Scenario:TC007_Negative_BirthPlace_alani_bos_birakilamaz
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanini bos birakir
    And Kullanici "Required" uyari mesaji goruntulendigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC008_AddTeacher
  Scenario:TC008_Negative_BirthPlace_alani_space_karakterlerden_olusamaz
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina space karakter girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And Kullanici SSN alanina ssn girer
    And Kullanici UserName alanina gecerli bir username girer
    And Kullanici Password alanina gecerli bir password girer
    And KullaniciS Submit butonuna tiklar
    Then Kullanici invalid birthplace uyari mesaji aldigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC009_AddTeacher
  Scenario:TC009_Negative_Email_alani_bos_birakilamaz
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Email alanini bos birakir
    And Kullanici "Required" uyari mesaji goruntulendigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC010_AddTeacher
  Scenario:TC010_Negative_Email_alani_email_formatinda_girilmez
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina invalid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And Kullanici SSN alanina ssn girer
    And Kullanici UserName alanina gecerli bir username girer
    And Kullanici Password alanina gecerli bir password girer
    And KullaniciS Submit butonuna tiklar
    Then Kullanici "Please enter valid email" mesajini gordugunu dogrular
    Then Kullanici uygulamayi kapatir

  @TC011_AddTeacher
  Scenario:TC011_Negative_Email_alani_email_formatinda_girilmez
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina invalid olan bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And Kullanici SSN alanina ssn girer
    And Kullanici UserName alanina gecerli bir username girer
    And Kullanici Password alanina gecerli bir password girer
    And KullaniciS Submit butonuna tiklar
    Then Kullanici "Please enter valid email" mesajini gordugunu dogrular
    Then Kullanici uygulamayi kapatir

  @TC012_AddTeacher
  Scenario:TC012_Negative_Phone_alani_bos_birakilmamali
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanini bos birakir
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanini bos birakir
    And Kullanici "Required" uyari mesaji goruntulendigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC013_AddTeacher
  Scenario:TC013_Negative_Phone_alani_farkli_formatta_kabul_edilmemeli
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina invalid bir deger girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And Kullanici SSN alanina ssn girer
    And Kullanici UserName alanina gecerli bir username girer
    And Kullanici Password alanina gecerli bir password girer
    And KullaniciS Submit butonuna tiklar
    Then Kullanici "Please enter valid phone number" uyari mesaji aldigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC014_AddTeacher
  Scenario:TC014_Negative_Phone_alani_min_12_karakter_icermeli
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina onbir karakter girer
    Then Kullanici "Minimum 12 character (XXX-XXX-XXXX)" uyari yazisi aldigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC015_AddTeacher
  Scenario:TC015_Negative_Gender_alani_bos_birakilamaz
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secmez
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And Kullanici SSN alanina ssn girer
    And Kullanici UserName alanina gecerli bir username girer
    And Kullanici Password alanina gecerli bir password girer
    And KullaniciS Submit butonuna tiklar
    Then Kullanici invalid gender uyari mesaji aldigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC016_AddTeacher
  Scenario:TC016_Negative_Date_Of_Birth_alani_bos_birakilamaz
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanini bos birakir
    And Kullanici "Required" uyari mesaji goruntulendigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC017_AddTeacher
  Scenario:TC017_Negative_Ssn_alani_bos_birakilamaz
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And Kullanici Ssn alanini bos birakir
    And Kullanici "Required" uyari mesaji goruntulendigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC018_AddTeacher
  Scenario:TC018_Negative_Ssn_alanina_3._ve_5._rakamdan sonra_"-"_isareti_girilmeli_Invalid_ssn_girilemez
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And Kullanici Ssn alanina tiresiz invalid deger girer
    Then Kullanici "Minimum 11 character (XXX-XX-XXXX)" uyari mesaji gordugunu dogrular
    Then Kullanici uygulamayi kapatir

  @TC019_AddTeacher
  Scenario:TC019_Negative_Ssn_alanina_2._ve_4._rakamdan sonra_"-"_isareti_girilemez
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And Kullanici Ssn formatinda olmayan invalid deger girer
    And Kullanici UserName alanina gecerli bir username girer
    And Kullanici Password alanina gecerli bir password girer
    And KullaniciS Submit butonuna tiklar
    Then KullaniciS "Please enter valid SSN number" uyari mesaji goruntulendigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC020_AddTeacher
  Scenario:TC020_Negative_Ssn_alanina_3._ve_6._rakamdan sonra_"-"_isareti_girilemez
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And KullaniciS Ssn formatinda olmayan invalid deger girer
    And Kullanici UserName alanina gecerli bir username girer
    And Kullanici Password alanina gecerli bir password girer
    And KullaniciS Submit butonuna tiklar
    Then KullaniciS "Please enter valid SSN number" uyari mesaji goruntulendigini dogrular
    Then Kullanici uygulamayi kapatir


  @TC021_AddTeacher
  Scenario:TC021_Negative_Ssn_alanina_9_rakam_girilmeli
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And KullaniciS Ssn alaninina invalid bir deger girer
    And Kullanici UserName alanina gecerli bir username girer
    And Kullanici Password alanina gecerli bir password girer
    And KullaniciS Submit butonuna tiklar
    Then KullaniciS "Please enter valid SSN number" uyari mesaji goruntulendigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC022_AddTeacher
  Scenario:TC022_Negative_Username_girilmelidir_Bos_birakilamaz
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And Kullanici SSN alanina ssn girer
    And Kullanici UserName alanini bos birakir
    And Kullanici "Required" uyari mesaji goruntulendigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC023_AddTeacher
  Scenario:TC023_Negative_Username_alani_space_karakterlerden_olusamaz
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And Kullanici SSN alanina ssn girer
    And Kullanici UserName alanina space karakterler girer
    And Kullanici Password alanina gecerli bir password girer
    And KullaniciS Submit butonuna tiklar
    Then Kullanici invalid username uyari mesaji aldigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC024_AddTeacher
  Scenario:TC024_Negative_Password_girilmelidir_Bos_birakilamaz
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And Kullanici SSN alanina ssn girer
    And Kullanici UserName alanina gecerli bir username girer
    And Kullanici Password alanini bos birakir
    And Kullanici "Required" uyari mesaji goruntulendigini dogrular
    Then Kullanici uygulamayi kapatir


  @TC025_AddTeacher
  Scenario:TC025_Negative_Password_8_karakterden olusmalidir
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And Kullanici SSN alanina ssn girer
    And Kullanici UserName alanina gecerli bir username girer
    And KullaniciS Password alanina invalid bir deger girer
    And KullaniciS "Minimum 8 character" uyari mesaji aldigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC026_AddTeacher
  Scenario:TC026_Negative_Password_alani_space_karakterlerden_olusamaz
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina dogum tarihini girer
    And Kullanici SSN alanina ssn girer
    And Kullanici UserName alanina gecerli bir username girer
    And KullaniciS Password alanina invalid bir data girer
    And KullaniciS Submit butonuna tiklar
    Then Kullanici invalid password uyari mesaji aldigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC027_AddTeacher
  Scenario:TC027_ Negative_BirthDate_alani_makul_yillari_kabul_etmeli(1000_veya_2024_yilini_kabul etmemelidir)
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And Kullanici Date Of Birth alanina invalid bir dogum tarihi girer
    And Kullanici SSN alanina ssn girer
    And Kullanici UserName alanina gecerli bir username girer
    And Kullanici Password alanina gecerli bir password girer
    And KullaniciS Submit butonuna tiklar
    Then Kullanici "must be a past date" invalid uyari mesaji aldigini dogrular
    Then Kullanici uygulamayi kapatir

  @TC028_AddTeacher
  Scenario:TC028_ Negative_BirthDate_alani_makul_yillari_kabul_etmeli(1000_veya_2024_yilini_kabul etmemelidir)
    And Kullanici Choose Lessons dropdowna tiklar ve bir ders secer
    And Kullanici Name alanina name girer
    And Kullanici Surname alanina surname girer
    And Kullanici BirthPlace alanina birth_place degerini girer
    And Kullanici Email alanina valid bir email girer
    And Kullanici Phone alanina valid bir phone girer
    And Kullanici Is Advisor Teacher checkbox'ina tiklar
    And KullaniciS Gender seceneklerinden birini secer
    And KullaniciS Date Of Birth alanina invalid bir dogum tarihi girer
    And Kullanici SSN alanina ssn girer
    And Kullanici UserName alanina gecerli bir username girer
    And Kullanici Password alanina gecerli bir password girer
    And KullaniciS Submit butonuna tiklar
    And Kullanici invalid birthdate uyari mesaji aldigini dogrular
    Then Kullanici uygulamayi kapatir













