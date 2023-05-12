@us24 @regression
  Feature: Us24_Admin Teacher Olusturabilmeli

    Scenario: TC01_Teacher Olusturma
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


