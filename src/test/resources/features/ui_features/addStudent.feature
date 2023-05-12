@US15 @regression
  Feature:Us15_ViceDean_Ogrenci_ekleyebilmeli

    Background:Sign in as Vice Dean
      Given Kullanici sayfaya gider ve ViceDean olarak login olur
      When Menu butonuna tiklanir
      And Student Management secenegi secilir

    @TC001_OgrenciEkleme_happyPath @smoke
    Scenario:ViceDean_ogrenci_ekleyebilir
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And SSN alanina valid bir SSN numarasi girilir
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanina valid bir Father Name girilir
      And Mother Name alanina valid bir Mother Name girilir
      And Password alanina valid bir Password girilir
      And Submit butonuna tiklanir
      Then Ogrencinin eklendigi dogrulanir
      And Logout yapilir

    @TC002_OgrenciEkleme_BosTeacher
    Scenario:chooseTeacher_alani_bos_birakilamaz
      And Choose Teacher alani bos birakilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And SSN alanina valid bir SSN numarasi girilir
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanina valid bir Father Name girilir
      And Mother Name alanina valid bir Mother Name girilir
      And Password alanina valid bir Password girilir
      And Submit butonuna tiklanir
      Then Choose Teacher alaninin bos birakilamayacagina dair uyari alindigi dogrulanir
      And Logout yapilir

    @TC003_OgrenciEkleme_BosName
    Scenario:Name_alani_boS_birakilamaz
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alani bos birakilir
      Then Name alaninin altinda required uyarisinin goruntulendigi dogrulanir
      And Logout yapilir

    @TC004_OgrenciEkleme_BosSurname
    Scenario:surname_alani_bos_birakilamaz
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alani bos birakilir
      Then SurName alaninin altinda required uyarisinin goruntulendigi dogrulanir
      And Logout yapilir

    @TC005_OgrenciEkleme_BosBirthPlace
    Scenario:birthplace_alani_bos_birakilamaz
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alani bos birakilir
      Then Birth Place alaninin altinda required uyarisinin goruntulendigi dogrulanir
      And Logout yapilir

    @TC0O6_email_negatif_test1    #kalan test case = bug = Uyari almadan ogrenci eklenebiliyor
    Scenario:email_alanina_formatdisi_data_girilemez1
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina .com icermeyen bir email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And SSN alanina valid bir SSN numarasi girilir
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanina valid bir Father Name girilir
      And Mother Name alanina valid bir Mother Name girilir
      And Password alanina valid bir Password girilir
      And Submit butonuna tiklanir
      Then Invalid Email girildigine dair mesaj alindigi dogrulanir
      And Logout yapilir


    @TC0O7_email_negatif_test2   #geciyor
    Scenario:email_alanina_formatdisi_data_girilemez2
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina @ ve .com icermeyen bir email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And SSN alanina valid bir SSN numarasi girilir
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanina valid bir Father Name girilir
      And Mother Name alanina valid bir Mother Name girilir
      And Password alanina valid bir Password girilir
      And Submit butonuna tiklanir
      Then Invalid Email girildigine dair mesaj alindigi dogrulanir
      And Logout yapilir

    @TC0O8_phone_negatif_test1  #geciyor
    Scenario:phone_alani_bos_birakilamaz
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alani bos birakilir
      Then Phone alaninin altinda required uyarisinin goruntulendigi dogrulanir
      And Logout yapilir


    @TC009_phone_negatif_test2   #geciyor
    Scenario:phone_number_ngtftest_12rakam
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina invalid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And SSN alanina valid bir SSN numarasi girilir
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanina valid bir Father Name girilir
      And Mother Name alanina valid bir Mother Name girilir
      And Password alanina valid bir Password girilir
      And Submit butonuna tiklanir
      Then Invalid Phone Number uyarisi alinmalidir
      And Logout yapilir


    @TC010_dateOfBirth_negatif_test1  #geciyor
    Scenario:date_of_birth_alani_bos_birakilamaz
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alani bos birakilir
      Then Date Of Birth alaninin altinda required uyarisinin goruntulendigi dogrulanir
      And Logout yapilir


    @TC011_dateOfBirth_negatif_test2   #kalan test = MS 12 yilini bile kabul ediyor : beklenen>>uyari almak : actual>>succesfully saved
    Scenario:date_of_birth_alani_realite_disi_yil_girisi1
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina makul olmayan bir dogum tarihi girilir
      And SSN alanina valid bir SSN numarasi girilir
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanina valid bir Father Name girilir
      And Mother Name alanina valid bir Mother Name girilir
      And Password alanina valid bir Password girilir
      And Submit butonuna tiklanir
      Then Invalid Date of Birth uyarisi goruntulenmelidir
      And Logout yapilir


    @TC012_dateOfBirth_negatif_test3     #kaliyor>>cunku parse error yerine okunakli bir mesaj bekleniyor
    Scenario:date_of_birth_alani_realite_disi_yil_girisi2
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina makul olmayan gelecek yillardan bir dogum tarihi girilir
      And SSN alanina valid bir SSN numarasi girilir
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanina valid bir Father Name girilir
      And Mother Name alanina valid bir Mother Name girilir
      And Password alanina valid bir Password girilir
      And Submit butonuna tiklanir
      Then Invalid Date of Birth uyarisi goruntulenmelidir
      And Logout yapilir

    @TC013_OgrenciEkleme_SSN_ngtf1
    Scenario:OgrenciEkleme_SSN_ngtf1
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And sevimSSN alani bos birakilir
      Then SSN alaninin altinda required uyarisi alindigi dogrulanir
      And Logout yapilir


    @TC014_OgrenciEkleme_SSN_ngtf2
    Scenario:OgrenciEkleme_SSN_ngtf2
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And sevimSSN Alanina XXX-XX-XXXXX seklinde bir deger girilir2
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanina valid bir Father Name girilir
      And Mother Name alanina valid bir Mother Name girilir
      And Password alanina valid bir Password girilir
      And Submit butonuna tiklanir
      Then sevimSSN alanina invalid bir deger girildigine dair uyari alindigi dogrulanir
      And Logout yapilir

    @TC015_OgrenciEkleme_SSN_ngtf3
    Scenario:OgrenciEkleme_SSN_ngtf3
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And sevimSSN Alanina XX-XXX-XXXXX seklinde bir deger girilir1
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanina valid bir Father Name girilir
      And Mother Name alanina valid bir Mother Name girilir
      And Password alanina valid bir Password girilir
      And Submit butonuna tiklanir
      Then sevimSSN alanina invalid bir deger girildigine dair uyari alindigi dogrulanir
      And Logout yapilir

    @TC016_OgrenciEkleme_username_bos_birakilamaz
    Scenario:username_bos_birakilamaz
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And SSN alanina valid bir SSN numarasi girilir
      And User Name alanini bos birakilir
      Then User Name alani altinda required uyarisinin goruntulendigi dogrulanir
      And Logout yapilir

    @TC017_OgrenciEkleme_fathername_bos_birakilamaz
    Scenario:fathername_bos_birakilamaz
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And SSN alanina valid bir SSN numarasi girilir
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanibos birakilir
      Then Father Name alani altinda required uyarisinin goruntulendigi dogrulanir
      And Logout yapilir

    @TC018_OgrenciEkleme_mothername_bos_birakilamaz
    Scenario:mothername_bos_birakilamaz
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And SSN alanina valid bir SSN numarasi girilir
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanina valid bir Father Name girilir
      And Mother Name alanibos birakilir
      Then Mother Name alani altinda required uyarisinin goruntulendigi dogrulanir
      And Logout yapilir

    @TC019_OgrenciEkleme_password_bos_birakilamaz_ngtf1
    Scenario:password_bos_birakilamaz
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And SSN alanina valid bir SSN numarasi girilir
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanina valid bir Father Name girilir
      And Mother Name alanina valid bir Mother Name girilir
      And Password Alanini bos birakilir
      Then Password alaninin altinda required uyarisi goruntulendigi dogrulanir
      And Logout yapilir

    @TC020_password_ngtf2
    Scenario:password_min8_karakter
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And SSN alanina valid bir SSN numarasi girilir
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanina valid bir Father Name girilir
      And Mother Name alanina valid bir Mother Name girilir
      And Password alanina yedi karakterden olusan bir password girer
      Then Password alaninin altinda min sekiz karakter uyarisi goruntulendigi dogrulanir
      And Logout yapilir

    @TC021_OgrenciEkleme_passwordSpaceIceremez
    Scenario:passwordSpaceIceremez
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And SSN alanina valid bir SSN numarasi girilir
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanina valid bir Father Name girilir
      And Mother Name alanina valid bir Mother Name girilir
      And Password alanina bosluk iceren bir Password girilir
      And Submit butonuna tiklanir
      Then Invalid password uyarisi alindigi dogrulanir
      And Logout yapilir

    @TC022_name_sadece_spacelerden_olusamaz
    Scenario:name_sadece_spacelerden_olusamaz
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina sadece spacelerden olusan bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And SSN alanina valid bir SSN numarasi girilir
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanina valid bir Father Name girilir
      And Mother Name alanina valid bir Mother Name girilir
      And Password alanina valid bir Password girilir
      And Submit butonuna tiklanir
      Then Invalid Name girildigine dair uyari mesaji alindigi dogrulanir
      And Logout yapilir

    @TC023_surname_sadece_spacelerden_olusamaz
    Scenario:surname_sadece_spacelerden_olusamaz
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina sadece spacelerden olusan bir SurName girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And SSN alanina valid bir SSN numarasi girilir
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanina valid bir Father Name girilir
      And Mother Name alanina valid bir Mother Name girilir
      And Password alanina valid bir Password girilir
      And Submit butonuna tiklanir
      Then Invalid SurName girildigine dair uyari mesaji alindigi dogrulanir
      And Logout yapilir

    @TC024_fatherName_sadece_spacelerden_olusamaz
    Scenario:fatherName_sadece_spacelerden_olusamaz
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And SSN alanina valid bir SSN numarasi girilir
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanina sadece spacelerden olusan bir Father Name girilir
      And Mother Name alanina valid bir Mother Name girilir
      And Password alanina valid bir Password girilir
      And Submit butonuna tiklanir
      Then Invalid FatherName girildigine dair uyari mesaji alindigi dogrulanir
      And Logout yapilir

    @TC025_motherName_sadece_spacelerden_olusamaz
    Scenario:motherName_sadece_spacelerden_olusamaz
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender seceneklerinden biri secilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And SSN alanina valid bir SSN numarasi girilir
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanina valid bir Father Name girilir
      And Mother Name alanina sadece spacelerden olusan bir Mother Name girilir
      And Password alanina valid bir Password girilir
      And Submit butonuna tiklanir
      Then Invalid MotherName girildigine dair uyari mesaji alindigi dogrulanir
      And Logout yapilir


    @TC026_gender_alani_bos_birakilamaz
    Scenario:gender_alani_bos_birakilamaz
      And Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir
      And Name alanina valid bir Name girilir
      And Surname alanina valid bir Surname girilir
      And Birthplace alanina valid bir Birthplace girilir
      And Email alanina valid bir Email girilir
      And Phone Number alanina valid bir Phone Number girilir
      And Gender secenekleri bos birakilir
      And Date Of Birth alanina valid bir dogum tarihi girilir
      And SSN alanina valid bir SSN numarasi girilir
      And User Name alanina valid bir kullanici adi girilir
      And Father Name alanina valid bir Father Name girilir
      And Mother Name alanina valid bir Mother Name girilir
      And Password alanina valid bir Password girilir
      And Submit butonuna tiklanir
      Then Sevim-Gender alaninin bos birakilamayacagina dair uyari alindigi dogrulanir
      And Logout yapilir