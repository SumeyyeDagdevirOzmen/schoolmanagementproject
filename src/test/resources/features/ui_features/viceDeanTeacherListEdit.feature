@14zhr
Feature:Vice Dean Lessons List edit

  Background: Sign in as Vice Dean
    Given Kullaniciz sayfaya gider
    When Kullaniciz Vice dean olarak login olur
    And  Kullaniciz Menu butonuna tiklar
    And  Kullaniciz Teacher Management secenegine tiklar

@14_1
  Scenario:TC01 Teacher List alani gorulme testi
    And Kullaniciz Teacher List yazisini gorur
    And Kullaniciz Name Surname alanini gorur
    And Kullaniciz Phone number alanini gorur
    And Kullaniciz SSN alanini gorur
    And Kullaniciz User Name alanini gorur
    Then Kullaniciz sayfayi kapatir.

@14_2
  Scenario:TC02 Pozitive Teacher Edit

    And Kullaniciz listeden guncellenecek  ogretmeni secer.
    And Kullaniciz guncelleyecegi ogretmenin hizasindaki edit butonuna basar.
    And Kullaniciz cikan ekranda Chosose lessons alanina valid bir deger girer.
    And Kullaniciz name alanini gunceller.
    And Kullaniciz surname alanini gunceller.
    And Kullaniciz Birth Place alanini gunceller.
    And Kullaniciz Email alanini gunceller.
    And Kullaniciz Phone alanini gunceller.
    And Kullaniciz SSN alanini gunceller.
    And  Kullaniciz Gender alanini gunceller
    And Kullaniciz Date of birth alanini gunceller
    And Kullaniciz User name alanini gunceler
    And Kullaniciz password alanina vice dean passwordunu girer
    And Kullaniciz submit butonuna tiklar.
    And Kullaniciz Teacher updated succesful masajini gorur.
    Then Kullaniciz sayfayi kapatir.
@14_3
  Scenario:TC03 Is Advisor Teacher alaninin guncellenmesi
    And Kullaniciz listeden guncellenecek  ogretmeni secer.
    And Kullaniciz guncelleyecegi ogretmenin hizasindaki edit butonuna basar.
    And Kullaniciz cikan ekranda Chosose lessons alanina valid bir deger girer.
    And Is Advisor Teacher kismini günceller
    And Kullaniciz Gender alanini gunceller
    And Kullaniciz password alanina vice dean passwordunu girer
    And Kullaniciz submit butonuna tiklar.
    And Kullaniciz Teacher updated succesful masajini gorur.
    Then Kullaniciz sayfayi kapatir.


@14_4
  Scenario:TC04 Negative Teacher Edit
    And Kullaniciz listeden guncellenecek  ogretmeni secer.
    And Kullaniciz guncelleyecegi ogretmenin hizasindaki edit butonuna basar.
    And Kullaniciz cikan ekranda Chosose lessons alanina valid bir deger girer.
    And Kullaniciz name alanini bos birakir.
    And Name kutusu alrinda Required yazisis gorur.
    And  Password kutusu altinda required yazisi gorur.
    And  Name kutusuna valid bir guncelleme yapar.
    And Password kutusu altinda required yazisi gorur.
    And Kullaniciz password alanina vice dean passwordunu girer
    And Gender alanini bos birakir
    And Kullaniciz submit butonuna tiklar.
    And Kullaniciz hata mesaji alir.
    Then Kullaniciz sayfayi kapatir.


@14_5
  Scenario:TC05 ChooseLesson alaninin guncellenmesi
    And Kullaniciz listeden guncellenecek  ogretmeni secer.
    And Kullaniciz guncelleyecegi ogretmenin hizasindaki edit butonuna basar.
    And Kullaniciz choose lesson alanini bos birakir
    And Name kutusuna valid bir guncelleme yapar.
    And Kullaniciz password alanina vice dean passwordunu girer
    And Kullaniciz Gender alanini gunceller
    And Kullaniciz submit butonuna tiklar.
    And Kullaniciz hata mesaji alir.
    Then Kullaniciz sayfayi kapatir.




