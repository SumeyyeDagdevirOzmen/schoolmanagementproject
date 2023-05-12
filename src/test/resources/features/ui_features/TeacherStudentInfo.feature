@Us18 @regression
 Feature:Student info list
#   Kullanıcı sayfaya gider
#   K@US18ullanıcı uygulamaya Teacher olarak login olur
#   Kullanici Ogrenci ismini gorur
#   Kullanici Ders adini gorur
#   Kullanici Absentee alanini gorur
#   Kullanici Mitdern Exam alanindaki degeri gorur
#   Kullanici Final Exam alaninindaki degeri gorur
#   Kullanici  InfoNote alanindaki degeri gorur


  Background:
    Given kullanici siteye gider...
    When kullanici "Nihal03" ismi ve "Team03team" sifresi ile login olur

    @Us18_TC01_pozitive_LessonProgram
    Scenario: Us18_Lessonprogram
    Then  kullanici ogrenci ismini "Ayse03 Ayse"  gorur.
    And   kullanici ders adini "CALCULUS" gorur.
    And   kullanici Absentee alanini "3" gorur
    And   kullanici Mitdern Exam alanini "30"  gorur
    And   kullanici Final exam alanini "70" gorur
    And   kullanici Note alanini "DD" gorur
    And   kullanici InfoNote alanindaki degeri "bir ogrenci" gorur.
    And   kullanici Average alanini "54" gorur.
    And  kullanici sayfayi kapatir..


   @Us18_TC02_Liste_Edit_Olmali
   Scenario:Us18_Liste_Edit_edilebilir_olmali
     Then kullanici edit butonuna tiklar
     And  kullanici ders adini "CALCULUS" secer
     And  kullanici valid bir "SPRING_SEMESTER" secer
     And  kullanici Absentee secenegini "3" gunceller
     And  kullanici Mitdern Exam secenegini "50" gunceller
     And  kullanici Final Exam secenegini "80" gunceller
     And  kullanici Info Note  secenegini "bir ogrenci" gunceller
     And  kullanici submit butonuna tiklar
     And  kullanici edit basari mesaji alir.
     And  kullanici sayfayi kapatir..


   @Us18_TC03_Choose_Lesson
   Scenario:Us18_Negative_scenario_01
     When  kullanici edit butonuna tiklar
     And   kullanici ders adini bos birakir
     And   kullanici valid bir "SPRING_SEMESTER" secer
     And   kullanici Absentee secenegini "3" gunceller
     And   kullanici Mitdern Exam secenegini "30" gunceller
     And   kullanici Final Exam secenegini "70" gunceller
     And   kullanici Info Note  secenegini "bir ogrenci" gunceller
     And   kullanici submit butonuna tiklar
     And   kullanici CooseLesson uyari mesajini dogrular.
     And   kullanici sayfayi kapatir..


   @Us18_TC04_Semester
   Scenario:Us18_Negative_scenario_02
     Then  kullanici edit butonuna tiklar
     And   kullanici ders adini "CALCULUS" secer
     And   kullanici Semester secenegini bos birakir
     And   kullanici Absentee secenegini "3" gunceller
     And   kullanici Mitdern Exam secenegini "30" gunceller
     And   kullanici Final Exam secenegini "70" gunceller
     And   kullanici Info Note  secenegini "bir ogrenci" gunceller
     And   kullanici submit butonuna tiklar
     And   kullanici LeesonEducationTerm uyari mesajini alir ve dogrular
     And   kullanici sayfayi kapatir..


   @Us18_TC05_Absentee
   Scenario:Us18_Negative_scenario_03
     When  kullanici edit butonuna tiklar
     And   kullanici ders adini "CALCULUS" secer
     And   kullanici valid bir "SPRING_SEMESTER" secer
     And   kullanici Absentee secenegini bos birakir
     And   kullanici Mitdern Exam secenegini "30" gunceller
     And   kullanici Final Exam secenegini "70" gunceller
     And   kullanici Info Note  secenegini "bir ogrenci" gunceller
     And   kullanici submit butonuna tiklar
     And   kullanici Absentee uyari mesajini dogrular.
     And   kullanici sayfayi kapatir..


   @Us18_TC06_MitdernExam
   Scenario:Us18_Negative_scenario_04
     When  kullanici edit butonuna tiklar
     And   kullanici ders adini "CALCULUS" secer
     And   kullanici valid bir "SPRING_SEMESTER" secer
     And   kullanici Absentee secenegini "3" gunceller
     And   kullanici Mitdern Exam secenegini  bos birakir
     And   kullanici Final Exam secenegini "70" gunceller
     And   kullanici Info Note  secenegini "bir ogrenci" gunceller
     And   kullanici submit butonuna tiklar
     And   kullanici Mitdern Exam uyari mesajini dogrular.
     And  kullanici sayfayi kapatir..


   @Us18_TC07_FinalExam
   Scenario:Us18_Negative_scenario_05
     When  kullanici edit butonuna tiklar
     And   kullanici ders adini "CALCULUS" secer
     And   kullanici valid bir "SPRING_SEMESTER" secer
     And   kullanici Absentee secenegini "3" gunceller
     And   kullanici Mitdern Exam secenegini "30" gunceller
     And   kullanici Final Exam secenegini  bos birakir
     And   kullanici Info Note  secenegini "bir ogrenci" gunceller
     And   kullanici submit butonuna tiklar
     And   kullanici Final Exam uyari mesajini dogrular.
     And  kullanici sayfayi kapatir..


   @Us18_TC08_InfoNote
   Scenario:Us18_Negative_scenario_06
     When  kullanici edit butonuna tiklar
     And   kullanici ders adini "CALCULUS" secer
     And   kullanici valid bir "SPRING_SEMESTER" secer
     And   kullanici Absentee secenegini "3" gunceller
     And   kullanici Mitdern Exam secenegini "30" gunceller
     And   kullanici Final Exam secenegini "70" gunceller
     And   kullanici Info Note  secenegini bos birakir
     And   kullanici submit butonuna tiklar
     And   kullanici infonoteuyari mesaji alir.
     And   kullanici sayfayi kapatir..


     @Us18_TC11_DeleteButonu
     Scenario:Us18_Delete_Butonu
     When  kullanici delete butonuna tiklar
     And   kullanici basari mesaj alir

















