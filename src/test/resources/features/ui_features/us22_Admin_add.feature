@US22 @regression
Feature: Admin ekleme

  Background: Admin olarak giris
    Given Kullanicik sayfaya gider
    When Kullanicik admin olarak login olur
    And Kullanicik menu butonuna basar
    And KAdmin management secenegini tiklar


  @TC001_Admin_ekleme_Happy_Path  @smoke

  Scenario: Admin ekleme happypath

    And Kullanicik Name Alanina valid bir isim girer
    And KSurname alanina valid bir Surname girilir
    And KBirthplace alanina valid bir Birthplace girilir
    And KGender seceneklerinden biri secilir
    And KDate Of Birth alanina valid bir dogum tarihi girilir
    And KPhone Number alanina valid bir Phone Number girilir
    And KSSN alanina valid bir SSN numarasi girilir
    And KUser Name alanina valid bir kullanici adi girilir
    And KPassword alanina valid bir Password girilir
    And KSubmit butonuna tiklanir
    Then Basariyla eklendi mesaji goruntulenir.
    And KSayfayi kapatir.


  @TC002_Admin_ekleme_name_bos_birakilamaz

  Scenario:name_alani_bos_birakilamaz

    And Kullanicik Name Alanina bos karakter girer
    And KSurname alanina valid bir Surname girilir
    And KBirthplace alanina valid bir Birthplace girilir
    And KGender seceneklerinden biri secilir
    And KDate Of Birth alanina valid bir dogum tarihi girilir
    And KPhone Number alanina valid bir Phone Number girilir
    And KSSN alanina valid bir SSN numarasi girilir
    And KUser Name alanina valid bir kullanici adi girilir
    And KPassword alanina valid bir Password girilir
    And KSubmit butonuna tiklanir
    Then KName alaninin bos birakilamayacagina dair uyari alindigi dogrulanir
    And KSayfayi kapatir.

  @TC003_Admin_ekleme_surname_bos_birakilamaz

  Scenario:surname_alani_bos_birakilamaz

    And KName alanina valid bir Name girilir
    And KKullanici Surname Alanina bos karakter girer
    And KBirthplace alanina valid bir Birthplace girilir
    And KGender seçeneklerinden biri secilir
    And KDate Of Birth alanina valid bir dogum tarihi girilir
    And KPhone Number alanina valid bir Phone Number girilir
    And KSSN alanina valid bir SSN numarasi girilir
    And KUser Name alanina valid bir kullanici adi girilir
    And KPassword alanina valid bir Password girilir
    And KSubmit butonuna tiklanir
    Then KSurname alaninin bos birakilamayacagina dair uyari alindigi dogrulanir
    And KSayfayi kapatir.


  @TC004_Admin_ekleme_birthplace_alani_bos_birakilamaz

  Scenario:birthplace_alani_bos_birakilamaz

    And KName alanina valid bir Name girilir
    And KSurname alanina valid bir Surname girilir
    And KBirthplace alanina bos karakter girer.
    And KGender seçeneklerinden biri secilir
    And KDate Of Birth alanina valid bir dogum tarihi girilir
    And KPhone Number alanina valid bir Phone Number girilir
    And KSSN alanina valid bir SSN numarasi girilir
    And KUser Name alanina valid bir kullanici adi girilir
    And KPassword alanina valid bir Password girilir
    And KSubmit butonuna tiklanir
    Then KBirthplace alaninin bos birakilamayacagina dair uyari alindigi dogrulanir
    And KSayfayi kapatir.

  @TC005_Admin_ekleme_gender_alani_bos_birakilamaz

  Scenario:gender_alani_bos_birakilamaz

    And KName alanina valid bir Name girilir
    And KSurname alanina valid bir Surname girilir
    And KBirthplace alanina valid bir Birthplace girilir
    And KGender secenekleri bos birakilir
    And KDate Of Birth alanina valid bir dogum tarihi girilir
    And KPhone Number alanina valid bir Phone Number girilir
    And KSSN alanina valid bir SSN numarasi girilir
    And KUser Name alanina valid bir kullanici adi girilir
    And KPassword alanina valid bir Password girilir
    And KSubmit butonuna tiklanir
    Then KGender alaninin bos birakilamayacagina dair uyari alindigi dogrulanir
    And KSayfayi kapatir.

  @TC006_Admin_ekleme_dateofbirth_alani_bos_birakilamaz

  Scenario:dateofbirth_alani_bos_birakilamaz

    And KName alanina valid bir Name girilir
    And KSurname alanina valid bir Surname girilir
    And KBirthplace alanina valid bir Birthplace girilir
    And KGender seceneklerinden biri secilir
    And KDate Of Birth alanı bos birakilir
    And KPhone Number alanina valid bir Phone Number girilir
    And KSSN alanina valid bir SSN numarasi girilir
    And KUser Name alanina valid bir kullanici adi girilir
    And KPassword alanina valid bir Password girilir
    And KSubmit butonuna tiklanir
    Then KDateofbirth alaninin bos birakilamayacagina dair uyari alindigi dogrulanir
    And KSayfayi kapatir.


  @TC007_Admin_ekleme_phonenumber_alani_bos_birakilamaz

  Scenario:phonenumber_alani_bos_birakilamaz

    And KName alanina valid bir Name girilir
    And KSurname alanina valid bir Surname girilir
    And KBirthplace alanina valid bir Birthplace girilir
    And KGender seceneklerinden biri secilir
    And KDate Of Birth alanina valid bir dogum tarihi girilir
    And KPhone Number alani bos birakilir
    And KSSN alanina valid bir SSN numarasi girilir
    And KUser Name alanina valid bir kullanici adi girilir
    And KPassword alanina valid bir Password girilir
    And KSubmit butonuna tiklanir
    Then KPhone_number alaninin bos birakilamayacagina dair uyari alindigi dogrulanir
    And KSayfayi kapatir.

  @TC008_Admin_SSN_alani_bos_birakilamaz

  Scenario:SSN_alani_bos_birakilamaz

    And KName alanina valid bir Name girilir
    And KSurname alanina valid bir Surname girilir
    And KBirthplace alanina valid bir Birthplace girilir
    And KGender seceneklerinden biri secilir
    And KDate Of Birth alanina valid bir dogum tarihi girilir
    And KPhone Number alanina valid bir Phone Number girilir
    And KSSN alani bos birakilir
    And KUser Name alanina valid bir kullanici adi girilir
    And KPassword alanina valid bir Password girilir
    And KSubmit butonuna tiklanir
    Then KSSN_number alaninin bos birakilamayacagina dair uyari alindigi dogrulanir
    And KSayfayi kapatir.

  @TC009_Admin_ekleme_SSN_2_ve_5_den_sonra_"-"_icermeli_ve_9_rakamdan_olusmalıdır
  Scenario: 2 ve 5 den sonra -
    And KName alanina valid bir Name girilir
    And KSurname alanina valid bir Surname girilir
    And KBirthplace alanina valid bir Birthplace girilir
    And KGender seceneklerinden biri secilir
    And KDate Of Birth alanina valid bir dogum tarihi girilir
    And KPhone Number alanina valid bir Phone Number girilir
    And KSSN alanina XX-XXX-XXXX formatinda bir deger girilir
    And KUser Name alanina valid bir kullanici adi girilir
    And KPassword alanina valid bir Password girilir
    And KSubmit butonuna tiklanir
    Then KSSN alaninin valid bir deger girilmesine dair uyari alindigi dogrulanir
    And KSayfayi kapatir.


  @TC010_Admin_ekleme_SSN_4_ve_5_den_sonra_"-"_icermeli_ve_9_rakamdan_olusmalıdır
  Scenario: 4 ve 5 den sonra -
    And KName alanina valid bir Name girilir
    And KSurname alanina valid bir Surname girilir
    And KBirthplace alanina valid bir Birthplace girilir
    And KGender seceneklerinden biri secilir
    And KDate Of Birth alanina valid bir dogum tarihi girilir
    And KPhone Number alanina valid bir Phone Number girilir
    And KSSN Alanina XXXX-X-XXXX formatinda bir deger girer
    And KUser Name alanina valid bir kullanici adi girilir
    And KPassword alanina valid bir Password girilir
    And KSubmit butonuna tiklanir
    Then KSSN alaninin valid bir deger girilmesine dair uyari alindigi dogrulanir
    And KSayfayi kapatir.


  @TC011_Admin_ekleme_SSN_3_ve_4_den_sonra_"-"_icermeli_ve_9_rakamdan_olusmalıdır
  Scenario: 3 ve 4 den sonra -
    And KName alanina valid bir Name girilir
    And KSurname alanina valid bir Surname girilir
    And KBirthplace alanina valid bir Birthplace girilir
    And KGender seceneklerinden biri secilir
    And KDate Of Birth alanina valid bir dogum tarihi girilir
    And KPhone Number alanina valid bir Phone Number girilir
    And KSSN Alanina XXX-X-XXXXX formatindan bir deger girer
    And KUser Name alanina valid bir kullanici adi girilir
    And KPassword alanina valid bir Password girilir
    And KSubmit butonuna tiklanir
    Then KSSN alaninin valid bir deger girilmesine dair uyari alindigi dogrulanir
    And KSayfayi kapatir.

  @TC012_Admin_ekleme_SSN_3_ve_6_den_sonra_"-"_icermeli_ve_9_rakamdan_olusmalıdır
  Scenario: 3 ve 6 den sonra -
    And KName alanina valid bir Name girilir
    And KSurname alanina valid bir Surname girilir
    And KBirthplace alanina valid bir Birthplace girilir
    And KGender seceneklerinden biri secilir
    And KDate Of Birth alanina valid bir dogum tarihi girilir
    And KPhone Number alanina valid bir Phone Number girilir
    And KSSN Alanina XXX-XXX-XXX formatindan bir deger girmelidir
    And KUser Name alanina valid bir kullanici adi girilir
    And KPassword alanina valid bir Password girilir
    And KSubmit butonuna tiklanir
    Then KSSN alaninin valid bir deger girilmesine dair uyari alindigi dogrulanir
    And KSayfayi kapatir.


  @TC013_Admin_ekleme_SSN_3_ve_5_den_sonra_"-"_icermeli_ve_8_rakamdan_olusmalıdır
  Scenario: 3 ve 5 den sonra - toplam 8
    And KName alanina valid bir Name girilir
    And KSurname alanina valid bir Surname girilir
    And KBirthplace alanina valid bir Birthplace girilir
    And KGender seceneklerinden biri secilir
    And KDate Of Birth alanina valid bir dogum tarihi girilir
    And KPhone Number alanina valid bir Phone Number girilir
    And KSSN Alanina XXX-XX-XXX seklinde bir deger girmelidir
    And KUser Name alanina valid bir kullanici adi girilir
    And KPassword alanina valid bir Password girilir
    And KSubmit butonuna tiklanir
    Then KSSN alaninin min 11 karakter girilmesine dair uyari alindigi dogrulanir
    And KSayfayi kapatir.

  @TC014_Admin_ekleme_SSN_3_ve_5_den_sonra_"-"_icermeli_ve_10_rakamdan_olusmalıdır
  Scenario: 3 ve 5 den sonra - toplam 10
    And KName alanina valid bir Name girilir
    And KSurname alanina valid bir Surname girilir
    And KBirthplace alanina valid bir Birthplace girilir
    And KGender seceneklerinden biri secilir
    And KDate Of Birth alanina valid bir dogum tarihi girilir
    And KPhone Number alanina valid bir Phone Number girilir
    And KSSN Alanina XXX-XX-XXXXX seklinde bir deger girilir
    And KUser Name alanina valid bir kullanici adi girilir
    And KPassword alanina valid bir Password girilir
    And KSubmit butonuna tiklanir
    Then KSSN alaninin valid bir deger girilmesine dair uyari alindigi dogrulanir
    And KSayfayi kapatir.


  @TC015_Admin_ekleme_username_alani_bos_birakilamaz

  Scenario:username_alani_bos_birakilamaz

    And KName alanina valid bir Name girilir
    And KSurname alanina valid bir Surname girilir
    And KBirthplace alanina valid bir Birthplace girilir
    And KGender seceneklerinden biri secilir
    And KDate Of Birth alanina valid bir dogum tarihi girilir
    And KPhone Number alanina valid bir Phone Number girilir
    And KSSN alanina valid bir SSN numarasi girilir
    And KUser Name alani bos birakilir
    And KPassword alanina valid bir Password girilir
    And KSubmit butonuna tiklanir
    Then KUsername alaninin bos birakilamayacagina dair uyari alindigi dogrulanir
    And KSayfayi kapatir.


  @TC016_Admin_ekleme_password_alani_enaz_7_karakterden_olusamaz

  Scenario:password_alani_enaz_7_karakterden_olusamaz

    And KName alanina valid bir Name girilir
    And KSurname alanina valid bir Surname girilir
    And KBirthplace alanina valid bir Birthplace girilir
    And KGender seceneklerinden biri secilir
    And KDate Of Birth alanina valid bir dogum tarihi girilir
    And KPhone Number alanina valid bir Phone Number girilir
    And KSSN alanina valid bir SSN numarasi girilir
    And KUser Name alanina valid bir kullanici adi girilir
    And KPassword alanina yedi karakter girer
    And KSubmit butonuna tiklanir
    Then KPassword alaninin valid bir deger girilmesine dair uyari alindigi dogrulanir
    And KSayfayi kapatir.


  @TC017_Admin_ekleme_password_alani_enaz_9_karakterden_olusabilir

  Scenario:password_alani_enaz_9_karakterden_olusabilir

    And KName alanina valid bir Name girilir
    And KSurname alanina valid bir Surname girilir
    And KBirthplace alanina valid bir Birthplace girilir
    And KGender seceneklerinden biri secilir
    And KDate Of Birth alanina valid bir dogum tarihi girilir
    And KPhone Number alanina valid bir Phone Number girilir
    And KSSN alanina valid bir SSN numarasi girilir
    And KUser Name alanina valid bir kullanici adi girilir
    And KPassword alanina dokuz karakter girer
    And KSubmit butonuna tiklanir
    Then KAdmin basariyla eklendigi goruntulenir
    And KSayfayi kapatir.

  @TC018_Admin_ekleme_password_alani_bos_birakilamaz

  Scenario:password_alani_bos_birakilamaz

    And KName alanina valid bir Name girilir
    And KSurname alanina valid bir Surname girilir
    And KBirthplace alanina valid bir Birthplace girilir
    And KGender seceneklerinden biri secilir
    And KDate Of Birth alanina valid bir dogum tarihi girilir
    And KPhone Number alanina valid bir Phone Number girilir
    And KSSN alanina valid bir SSN numarasi girilir
    And KUser Name alanina valid bir kullanici adi girilir
    And KPassword alani bos birakilir
    And KSubmit butonuna tiklanir
    Then Kpassword alaninin bos birakilamayacagina dair uyari alindigi dogrulanir
    And KSayfayi kapatir.


