@9zhr
Feature:Vice Dean Lessons List edit

  Background: Sign in as Vice Dean
    Given Kullaniciz sayfaya gider
    When Kullaniciz Vice dean olarak login olur
    And Kullaniciz Lessons butonuna tiklar.
@9_1
  Scenario:TC01_Vice_Dean_LessonList_alanini_gorebilmeli.
    And Kullaniciz Lesson List yazisini gorur.
    And Kullaniciz Lesson Name alanini gorur.
    And Kullaniciz Compulsory alanini  gorur.
    And Kullaniciz Credit Score alanini gorur.
    Then Kullaniciz sayfayi kapatir.
@9_2
  Scenario:TC02_Vice_Dean_Ders_silebilmelidir
    And Kullaniciz Lesson Name alanina deger girer
    And Kulllaniciz Compulsory alanini isaretler
    And Kullaniciz Credit score alanina "4" girer
    And Kullaniciz submit butonuna tiklar
    And Kullaniciz sayfanin sonuna gider
    And Kullaniciz olusturdugu dersi siler
    And Kullaniciz lesson deleted uyari mesajini alir.
    Then Kullaniciz sayfayi kapatir.

