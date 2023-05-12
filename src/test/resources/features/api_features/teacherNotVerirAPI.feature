@TeacherHavaAPI @teacher @apiRegression
Feature: Teacher_Not

 @Hava01
  Scenario: TC01 teacher not verir
   Given UserHava URL e Post request yapar
    When UserHava ogretmen ogrenciye not verir
    Then Verdigi Notlari gordugunu dogrular
  @Hava02
  Scenario: TC02 teacherHava Negatif
    Given UserHava URL e Post request yapar
    When UserHava ogretmen MidtermExam kismina not verir
    Then Verdigi MidtermNotu Kabul edilmedigini dogrular
  @Hava03
  Scenario: TC03 teacherHava Negatif_1
    Given UserHava URL e Post request yapar
    When UserHava ogretmen FinalExam kismina notu verir
    Then Verdigi FinalExamNotu Kabul edilmedigini dogrular
  @Hava04
  Scenario: TC04 teacherHava Negatif_2
    Given UserHava URL e Post request yapar
    When UserHava ogretmen Choose Lesson kismini bos burakir
    Then UserHava Choose Lessonini bos biraktigi icin Hata mesaji alir
  @Hava05
  Scenario: TC03 teacherHava Negatif_3
    Given UserHava URL e Post request yapar
    When UserHava ogretmen Choose Student kismini bos burakir
    Then UserHava Choose Studenti bos biraktigi icin Hata mesaji alir
  @Hava06
  Scenario: TC03 teacherHava Negatif_4
    Given UserHava URL e Post request yapar
    When UserHava ogretmen Choose Education Term kismini bos burakir
    Then UserHava Choose Education Termi bos biraktigi icin Hata mesaji alir
  @Hava07
  Scenario: TC03 teacherHava Delete
    Given UserHava URL e Delete request yapar
    When UserHava ogretmen olusturdugu ogrenciyi siler
    Then UserHava sildigi ogrencinin silindigini dogrular
