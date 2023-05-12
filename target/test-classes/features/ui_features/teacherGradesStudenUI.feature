@TeacherHava @regression
  Feature:Add_Student_Info
    Background: Teacher_Add_Student
      Given Teacher siteye gider
      When Teacher login olur
      And Teacher Add Student Info sayfasini gorur

    @TC01_Positive @smoke
    Scenario:TC01_Hava
      And Teacher Choose Lesson dan "HISTORIA" secer
      And Teacher Choose Student den "Evin Celik" secer
      And Teacher Choose Education Term den "SPRING_SEMESTER" secer
      And Teacher Absentee e "5" gun devamsizlik girer
      And Teacher Midterm Exam kismina ogrencinin notunu "70" girer
      And Teacher Final Exam kismina ogrencinin final notunu "70" girer
      And Teacher Info Note kismina ogrenci hakkindaki notu "Basarili bir ogrenci " olarak girer
      And Teacher Submit butonuna basar
      Then Teacher Islemin onaylandigi mesajini gorur
      And Teacher sayfayi kapatir
    @TC02_Hava
    Scenario:TC02_Hava
      And Teacher Choose Lesson dan "HISTORIA" secer
      And Teacher Choose Student den "Evin Celik" secer
      And Teacher Choose Education Term den "SPRING_SEMESTER" secer
      And Teacher Absentee e "8" gun devamsizlik girer
      And Teacher Midterm Exam kismina ogrencinin notunu "101" girer
      And Teacher Final Exam kismina ogrencinin final notunu "70" girer
      And Teacher Info Note kismina ogrenci hakkindaki notu "Basarili bir ogrenci " olarak girer
      And Teacher Submit butonuna basar
      Then Teacher Not ile ilgili hata mesaji alir
      And Teacher sayfayi kapatir
    @TC03Hava
    Scenario:TC03_Hava
      And Teacher Choose Lesson dan "HISTORIA" secer
      And Teacher Choose Student den "Evin Celik" secer
      And Teacher Choose Education Term den "SPRING_SEMESTER" secer
      And Teacher Absentee e "8" gun devamsizlik girer
      And Teacher Midterm Exam kismina ogrencinin notunu "100" girer
      And Teacher Final Exam kismina ogrencinin final notunu "70" girer
      And Teacher Info Note kismina ogrenci hakkindaki notu "Basarili bir ogrenci " olarak girer
      And Teacher Submit butonuna basar
      Then Teacher Islemin onaylandigi mesajini gorur
      And Teacher sayfayi kapatir
    @TC04Hava
    Scenario:TC04_Hava
      And Teacher Choose Lesson dan "HISTORIA" secer
      And Teacher Choose Student den "Evin Celik" secer
      And Teacher Choose Education Term den "SPRING_SEMESTER" secer
      And Teacher Absentee e "8" gun devamsizlik girer
      And Teacher Midterm Exam kismina ogrencinin notunu "99" girer
      And Teacher Final Exam kismina ogrencinin final notunu "70" girer
      And Teacher Info Note kismina ogrenci hakkindaki notu "Basarili bir ogrenci " olarak girer
      And Teacher Submit butonuna basar
      Then Teacher Islemin onaylandigi mesajini gorur
      And Teacher sayfayi kapatir
    @TC05Hava #BURDAN SONRASI ICIN YENI OGRENCI LAZIM
    Scenario:TC05_Hava
      And Teacher Choose Lesson dan "HISTORIA" secer
      And Teacher Choose Student den "Eva Casas" secer
      And Teacher Choose Education Term den "SPRING_SEMESTER" secer
      And Teacher Absentee e "8" gun devamsizlik girer
      And Teacher Midterm Exam kismina ogrencinin notunu "99" girer
      And Teacher Final Exam kismina ogrencinin final notunu "101" girer
      And Teacher Info Note kismina ogrenci hakkindaki notu "Basarili bir ogrenci " olarak girer
      And Teacher Submit butonuna basar
      Then Teacher Not ile ilgili hata mesaji alir
      And Teacher sayfayi kapatir
    @TC06Hava
    Scenario:TC06_Hava
      And Teacher Choose Lesson dan "HISTORIA" secer
      And Teacher Choose Student den "Evin Celik" secer
      And Teacher Choose Education Term den "SPRING_SEMESTER" secer
      And Teacher Absentee e "8" gun devamsizlik girer
      And Teacher Midterm Exam kismina ogrencinin notunu "99" girer
      And Teacher Final Exam kismina ogrencinin final notunu "100" girer
      And Teacher Info Note kismina ogrenci hakkindaki notu "Basarili bir ogrenci " olarak girer
      And Teacher Submit butonuna basar
      Then Teacher Islemin onaylandigi mesajini gorur
      And Teacher sayfayi kapatir
    @TC07Hava
    Scenario:TC07_Hava
      And Teacher Choose Lesson dan "HISTORIA" secer
      And Teacher Choose Student den "Eva Casas" secer
      And Teacher Choose Education Term den "SPRING_SEMESTER" secer
      And Teacher Absentee e "8" gun devamsizlik girer
      And Teacher Midterm Exam kismina ogrencinin notunu "99" girer
      And Teacher Final Exam kismina ogrencinin final notunu "99" girer
      And Teacher Info Note kismina ogrenci hakkindaki notu "Basarili bir ogrenci " olarak girer
      And Teacher Submit butonuna basar
      Then Teacher Islemin onaylandigi mesajini gorur
      And Teacher sayfayi kapatir
    @TC08Hava
    Scenario:TC08_Hava
      And Teacher Choose Lesson dan "Choose Lesson" secer
      And Teacher Choose Student den "Eva Casas" secer
      And Teacher Choose Education Term den "SPRING_SEMESTER" secer
      And Teacher Absentee e "8" gun devamsizlik girer
      And Teacher Midterm Exam kismina ogrencinin notunu "99" girer
      And Teacher Final Exam kismina ogrencinin final notunu "70" girer
      And Teacher Info Note kismina ogrenci hakkindaki notu "Basarili bir ogrenci " olarak girer
      And Teacher Submit butonuna basar
      Then Teacher Choose secmedigi icin hata mesaji gorur
      And Teacher sayfayi kapatir
    @TC09Hava
    Scenario:TC09_Hava
      And Teacher Choose Lesson dan "HISTORIA" secer
      And Teacher Choose Student den "Choose Student" secer
      And Teacher Choose Education Term den "SPRING_SEMESTER" secer
      And Teacher Absentee e "8" gun devamsizlik girer
      And Teacher Midterm Exam kismina ogrencinin notunu "99" girer
      And Teacher Final Exam kismina ogrencinin final notunu "70" girer
      And Teacher Info Note kismina ogrenci hakkindaki notu "Basarili bir ogrenci " olarak girer
      And Teacher Submit butonuna basar
      Then Teacher Choose secmedigi icin hata mesaji gorur
      And Teacher sayfayi kapatir
    @TC10Hava
    Scenario:TC10_Hava
      And Teacher Choose Lesson dan "HISTORIA" secer
      And Teacher Choose Student den "Eva Casas" secer
      And Teacher Choose Education Term den "Choose Education Term" secer
      And Teacher Absentee e "8" gun devamsizlik girer
      And Teacher Midterm Exam kismina ogrencinin notunu "99" girer
      And Teacher Final Exam kismina ogrencinin final notunu "70" girer
      And Teacher Info Note kismina ogrenci hakkindaki notu "Basarili bir ogrenci " olarak girer
      And Teacher Submit butonuna basar
      Then Teacher Choose secmedigi icin hata mesaji gorur
      And Teacher sayfayi kapatir




