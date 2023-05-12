@DeanYusuf
Feature: Dean Vice Dean hesabi olusturabilmeli

  Background:Vice Dean Managementon
    Given Dean ysf Anasayfaya gider
    When Dean ysf Login olur

  @US06  @smoke #Test gecmelir
  Scenario: US06 Pozitif test

    And Dean ysf Add Vice Dean List'deki tum bilgileri doldurur
    And Dean ysf Submit butonuna tiklar
    And Dean ysf Vice Dean hesabinin olusturuldugunu dogrular
    And Logout yapilir


  @US06TC10 #Test gecmeli
  Scenario: US06TC1 Negatif test

    And Dean ysf Vice Dean bolumunde Name kismini bos birakir sonraki tum bilgileri doldurur
    And Dean ysf Submit butonuna tiklar
    And Dean ysf Vice Dean hesabinin olusturulmadigini dogrular
    And Logout yapilir

  @US06TC11 #Test gecmeli
  Scenario: US06TC2 Negatif test

    And Dean ysf Vice Dean bolumunde Surname kismini bos birakir sonraki tum bilgileri doldurur
    And Dean ysf Submit butonuna tiklar
    And Dean ysf Vice Dean hesabinin olusturulmadigini dogrular
    And Logout yapilir

  @US06TC12 #Test gecmeli
  Scenario: US06TC3 Negatif test

    And Dean ysf Vice Dean bolumunde Birth Place kismini bos birakir sonraki tum bilgileri doldurur
    And Dean ysf Submit butonuna tiklar
    And Dean ysf Vice Dean hesabinin olusturulmadigini dogrular
    And Logout yapilir

  @US06TC04 #Test gecmeli
  Scenario: US06TC04 Negatif test

    And Dean ysf Vice Dean bolumunde Gender kismini bos birakir sonraki tum bilgileri doldurur
    And Dean ysf Submit butonuna tiklar
    And Dean ysf Vice Dean hesabinin olusturulmadigini dogrular
    And Logout yapilir

  @US06TC05 #Test gecmeli
  Scenario: US06TC5 Negatif test

    And Dean ysf Vice Dean bolumunde Date Of Birth  kismini bos birakir sonraki tum bilgileri doldurur
    And Dean ysf Submit butonuna tiklar
    And Dean ysf Vice Dean hesabinin olusturulmadigini dogrular
    And Logout yapilir

  @US06TC06 #Test gecmeli
  Scenario: US06TC6 Negatif test

    And Dean ysf Vice Dean bolumunde Phone   kismini bos birakir sonraki tum bilgileri doldurur
    And Dean ysf Submit butonuna tiklar
    And Dean ysf Vice Dean hesabinin olusturulmadigini dogrular
    And Logout yapilir

  @US06TC07 #Test gecmeli
  Scenario: US06TC7 Negatif test

    And Dean ysf Vice Dean bolumunde Ssn kismini bos birakir sonraki tum bilgileri doldurur
    And Dean ysf Submit butonuna tiklar
    And Dean ysf Vice Dean hesabinin olusturulmadigini dogrular
    And Logout yapilir

  @US06TC08 #Test gecmeli
  Scenario: US06TC8 Negatif test

    And Dean ysf Vice Dean bolumunde Username kismini bos birakir sonraki tum bilgileri doldurur
    And Dean ysf Submit butonuna tiklar
    And Dean ysf Vice Dean hesabinin olusturulmadigini dogrular
    And Logout yapilir

  @US06TC09 #Test gecmeli
  Scenario: US06TC9 Negatif test

    And Dean ysf Vice Dean bolumunde Password kismini bos birakir sonraki tum bilgileri doldurur
    And Dean ysf Submit butonuna tiklar
    And Dean ysf Vice Dean hesabinin olusturulmadigini dogrular
    And Logout yapilir

  @US06TC01 #Test kalmali
  Scenario: US06TC01 Negatif test

    And Dean ysf Vice Dean bolumunde Name kismina space karekter girilir ve sonraki tum bilgileri doldurur
    And Dean ysf Submit butonuna tiklar
    And Dean ysf Vice Dean hesabinin olusturuldugunu dogrular
    And Logout yapilir

  @US06TC02 #Test kalmali
  Scenario: US06TC02 Negatif test

    And Dean ysf Vice Dean bolumunde Surname kismina space karekter girilir ve sonraki tum bilgileri doldurur
    And Dean ysf Submit butonuna tiklar
    And Dean ysf Vice Dean hesabinin olusturuldugunu dogrular
    And Logout yapilir

  @US06TC03 #Test kalmali
  Scenario: US06TC03 Negatif test

    And Dean Vice Dean bolumunde Birth Place kismina space karekter girilir ve sonraki tum bilgileri doldurur
    And Dean ysf Submit butonuna tiklar
    And Dean ysf Vice Dean hesabinin olusturuldugunu dogrular
    And Logout yapilir


