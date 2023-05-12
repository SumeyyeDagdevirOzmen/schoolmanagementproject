@4
Feature: Admin_Dean_Creation

  Background: login_admin
    Given Kullanicigul ansayfaya gider
    Then Kullanicigul 1 saniye bekler
    When Kullanicigul Admin olarak login olur
    Then Kullanicigul 1 saniye bekler
    And Kullanicigul menu butonuna tiklar
    When Kullanicigul Dean Management a tiklar

  @4_1
  Scenario: Herhangi bir karakter iceren ve bos birakilamayan  bir name olmalidir

    Then s2.Kullanici surname textbox, ini bos birakir
    Then s1.Kullanicigul "Required"  uyari sini gorebilmelidir
    Then s1.Kullanicigul name textbox, ina space  girer
    Then kullanicigul onaylanmis mavi renkli textbox gormemelidir
    Then kullanicigul logaut yapar

  @4_2
  Scenario: Herhangi bir karakter iceren ve bos birakilamayan  bir "surname" olmalidir

    Then s2.Kullanici surname textbox, ini bos birakir
    Then s2.Kullanicigul "Required"  uyari sini gorebilmelidir
    Then s2.Kullanici surname textbox, ina space  girer
    Then kullanicigul onaylanmis mavi renkli textbox gormemelidir
    Then kullanicigul logaut yapar

  @4_3
  Scenario:Herhangi bir karakter iceren ve bos birakilamayan  bir "Birth place" olmalidir

    Then s3.Kullanici Birth place textbox, ini bos birakir
    Then s3.Kullanici "Required"  uyari sini gorebilmelidir
    Then s3.Kullanici Birth place textbox, ina space  girer
    Then kullanicigul onaylanmis mavi renkli textbox gormemelidir

  @4_4
  Scenario: Gender alani secili olmalidir

    Then Kullanicigul 1 saniye bekler
    Then s4.kullanicigul gender alanini bos birakarak diger alanlari valid sekilde doldurur
    Then Kullanicigul submit butonuna tiklar
    Then Kullanicigul hata mesaji almali
    Then kullanicigul logaut yapar
    Then Kullanicigul sayfayi kapatir


  @4_5
  Scenario: Date of birth alani doldurulmalidir

    Then s5.Kullanicigul Date of birth textbox, ini bos birakir
    Then s5.Kullanicigul "Required"  uyari sini gorebilmelidir
    Then s5.Kullanicigul Date of birth alanina invalid yil girer
    Then kullanicigul onaylanmis mavi renkli textbox gormemelidir

  @4_6
  Scenario:phone alani 12 karakterden olusacak sekilde doldurulmalidir

    Then s6.Kullanicigu phone textbox, ini bos birakir
    Then s6.Kullanicigul "Required"  uyari sini gorebilmelidir
    Then s6.Kullanicigul phone textbox, in'a "611-22-333" karakter girer
    Then s6. Kullanicigul "Minimum 12 character (XXX-XXX-XXXX)" mesji almalidir
    Then kullanicigul logaut yapar
    Then Kullanicigul sayfayi kapatir

  @4_7
  Scenario:Ssn alani 3. ve 5. rakamdan sonra "-" icerecek ve 9 rakamdan olusacak ve essiz olacak sekilde doldurulmalidir

    Then s7.Kullanicigul Ssn textbox, ini bos birakir
    Then s7.Kullanicigul "Required"  uyari sini gorebilmelidir
    Then s7.Kullanicigul Ssn textbox, ina tiresiz invalid deger girer
    Then s.7Kullanicigul "Minimum 11 character (XXX-XX-XXXX)" uyari sini gorebilmelidir
    Then kullanicigul logaut yapar
    Then Kullanicigul sayfayi kapatir

  @4_8
  Scenario: ssn textboxina 9 rakam girilmelidir

    Then Kullanicigul 1 saniye bekler
    Then s8.kullanicigul ssn alanina "33334449999" onbir rakam girerek diger alanlari doldurur
    Then Kullanicigul submit butonuna tiklar
    Then s.8Kullanicigul "Please enter valid SSN number" mesaji alir
    Then kullanicigul logaut yapar
    Then Kullanicigul sayfayi kapatir


  @4_9
  Scenario:Herhangi bir karakter iceren ve bos birakilamayan  bir username olmalidir

    Then s.9Kullanicigul username, alanini bos birakir
    Then s.9Kullanicigul "Required"  uyari sini gorebilmelidir
    Then kullanicigul logaut yapar
    Then Kullanicigul sayfayi kapatir

  @4_10
  Scenario:pasword alanini bos birakilamamali ve minimum 8 karakter olmali

    Then s10.Kullanicigul pasword, ini bos birakir
    Then s10.Kullanicigul "Required"  uyarisini gorebilmelidir
    Then s10.Kullanicigul password alanina 1234567 karakter girer
    Then s10.Kullanicigul "Minimum 8 character" uyari sini gorebilmelidir
    Then kullanicigul logaut yapar
    Then Kullanicigul sayfayi kapatir

  @4_11
  Scenario: admin Dean ekleyebilmelidir

    Then Kullanicigul 1 saniye bekler
    Then s.11Kullanicigul tum textboxlara valid degerler girerek doldurur
    Then Kullanicigul submit butonuna tiklar
    Then s11Kullanicigul "Dean Saved" mesaji gormelidir
    Then kullanicigul logaut yapar
    Then Kullanicigul sayfayi kapatir














































































































