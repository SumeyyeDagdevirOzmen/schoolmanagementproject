@EndToEndTeacher @admin
Feature: teacher creation_End to End

  Scenario: teacher creation_UI
    Given kullanici siteye gider...
    When kullanici "AdminB103" ismi ve "12345678" sifresi ile login olur
    And kullanici Menu butonuna tiklar
    And kullaniciNihal Teacher Management'a tiklar
    And kullaniciNihal ChooseLessons'tan ders secer
    And kullaniciNihal Name alanina valid bir deger yazar
    And kullaniciNihal Surname alanina valid bir deger girer
    And kullaniciNihal BirthPlace alanina valid bir deger girer
    And kullaniciNihal Email alanina valid bir deger girer
    And kullaniciNihal PhoneNumber alanina valid bir deger girer
    And kullaniciNihal IsAdvisor butonunu secer
    And kullaniciNihal Gender'i secer
    And kullaniciNihal Date Of Birth alanina valid bir deger girer
    And kullaniciNihal SSN alanina valid bir deger girer
    And kullaniciNihal Username alanina valid bir deger girer
    And kullaniciNihal Password alanina valid bir deger girer
    And kullaniciNihal Submit'e tiklar
    Then kullaniciNihal ogretmen olusturabildigini dogrular
    And kullanici sayfayi kapatir..


    Scenario: teacher creation_Api
      Given UserNhl sets the url and sends get request
      Then UserNhl verifys response body

    Scenario: teacher creation_DB
      Given  UserNhl connect to DataBase
      When UserNhl finds teacher by ssn
      Then UserNhl verifys Data

