@Us10
Feature: Lesson program olusturma
#  1	Kullanıcı sayfaya gider
#  2	Kullanıcı uygulamaya Vice Dean olarak login olur
#  3	Kullanici Menu butonuna tiklar
#  4	Kullanici Lesson Management basligina tiklar
#  5	Kullanici Lesson Program basligini secer
#  6	Kullanici valid bir Ders secer
#  7	Kullanici valid bir Semester secer
#  8	Kullanici valid bir Gun secer
#  9	Kullanici valid bir baslama saati girer
#  10	Kullanici valid bir bitis saati girer
#  11	Kullanici submit butonuna tiklar
#  12	Kullanici bir basari mesaji alir

  Background:
    Given kullanici siteye gider...
    And  kullanici uygulamaya Vice Dean olarak "hasan123" adi ile ve "12345678" login olur.
    And  kullanici Lesson Program secenegine tiklar..



  @Us10_Pozitive_scenario
  Scenario: Us10_Program olusturma
    And   kullanici valid bir Ders adi secer
    And   kullanici valid bir Semester secer.
    And   kullanici valid bir Gun girer
    And   kullanici valid bir Baslama Saati girer
    And   kullanici valid bir Bitis Saati girer
    And   kullanici submit butonuna tiklar.
    And   kullanici basari mesajini dogrular
    Then  kullanici sayfayi kapatir..


  @Us10_NegativeScenario_01
  Scenario:Us10_negative1
    And   kullanici valid bir Ders adi secer
    And   kullanici valid bir Semester secer.
    And   kullanici valid bir Gun girer
    And   kullanici baslama saatini bos birakir
    And   kullanici valid bir Bitis Saati girer
    And   kullanici submit butonuna tiklar.
    And   kullanici uyari mesajini dogrular.
    Then  kullanici sayfayi kapatir..

  @Us10_NegativeScenario_02
  Scenario:Us10_negative2
    And  kullanici valid bir Ders adi secer
    And  kullanici valid bir Semester secer.
    And  kullanici valid bir Gun girer
    And  kullanici valid bir Baslama Saati girer
    And  kullanici bitis saatini bos birakir
    And  kullanici submit butonuna tiklar.
    And  kullanici uyari mesajini dogrular.
    Then kullanici sayfayi kapatir..

  @Us10_NegativeScenario_03
  Scenario:us10_negative3(bug)
    And  kullanici ders alanini bos birakir
    And  kullanici valid bir Semester secer.
    And  kullanici valid bir Gun girer
    And  kullanici valid bir Baslama Saati girer
    And  kullanici valid bir Bitis Saati girer
    And  kullanici submit butonuna tiklar.
    And  kullanici error  mesaji alir
    Then kullanici sayfayi kapatir..


  @Us10_NegativeScenario_04
  Scenario:Us10_negative4(bug)
    And  kullanici valid bir Gun girer
    And  kullanici semester alanini bos birakir
    And  kullanici valid bir Gun girer
    And  kullanici valid bir Baslama Saati girer
    And  kullanici valid bir Bitis Saati girer
    And  kullanici submit butonuna tiklar.
    And  kullanici error  mesaji alir
    Then kullanici sayfayi kapatir..
