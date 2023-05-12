@us21 @regression
Feature: Choose Lesson

  Background: Login olur
    Given  Kullanici anasayfaya gider
    When   Kullanicifatma ogrenci olarak login olur




  @Student01
  Scenario: TC01_Informations_Lesson
    And  Ogrencifatma menüden Choose Lesson'a tiklar
    And  Ogrencifatma menüden Lesson Listesinde Teacher bilgisini gorur
    And  Ogrencifatma menüden Lesson Listesinde Day bilgisini gorur
    And  Ogrencifatma menüden Lesson Listesinde Start Time bilgisini gorur
    And  Ogrencifatma menüden Lesson Listesinde Stop Time  bilgisini gorur
    Then Ogrencifatma sayfayi kapatir



  @Student02
  Scenario: TC02_Choose_Lesson
    And  Ogrencifatma listeden ayni gun ve saatte olmayan ders secer
    And  Ogrencifatma seçtiği dersi Lesson Program List’te gorur
    And Ogrencifatma sayfayi kapatir



  @Student03
 Scenario: TC03_Choose_Lesson(Negatif)
    And  Ogrencifatma menüden Choose Lesson'a tiklar
    And  Ogrencifatma listeden ayni gun ve saat olan dersleri secer
    And  Ogrencifatma hata mesaji alir
    And  Ogrencifatma sayfayi kapatir



  @Student04
  Scenario: TC04_Grade_Announcement
    And  Ogrencifatma menu butonuna tiklar
    And  Ogrencifatma menüden Grades et Announcement 'a tiklar
    And  Ogrencifatma Student Info List alaninda notlarini gorur
    And  Ogrencifatma Meet List alaninda toplantinlari gorur
    And  Ogrencifatma sayfayi kapatir






