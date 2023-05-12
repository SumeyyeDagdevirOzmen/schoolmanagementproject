@admin @ApiUS22 @apiRegression
Feature:Admin_Create

Background:
    Given User22 sets the Url

@TC01
 Scenario: US22_admin_happy_path
    When User22 send post request for admin
    And UserK22 verifys that HTTPS code is 200
    Then User22 gets the admin data and assert

  @TC02
  Scenario: US22_admin_name_alani_bos_birakilamaz
    When User22 send post withoutname for admin
    And User22 verifys that HTTPS code is 400
    Then User22 gets witoutname the admin data and assert

  @TC03
  Scenario: US22_admin_surname_alani_bos_birakilamaz
    When User22 send post withoutsurname for admin
    And User22 verifys that HTTPS code is 400
    Then User22 gets witoutnsurname the admin data and assert

  @TC04
  Scenario: US22_admin_birthplace_alani_bos_birakilamaz

    When User22 send post withoutbirthplace for admin
    And User22 verifys that HTTPS code is 400
    Then User22 gets withoutbirthplace the admin data and assert

  @TC05
  Scenario: US22_admin_gender_alani_bos_birakilamaz

    When User22 send post withoutgender for admin
    And User22 verifys that HTTPS code is 400
    Then User22 gets withoutgender the admin data and assert

  @TC06
  Scenario: US22_admin_dateofbirth_alani_bos_birakilamaz

    When User22 send post withoutdateofbirth for admin
    And User22 verifys that HTTPS code is 400
    Then User22 gets withoutdateofbirth the admin data and assert

  @TC07
  Scenario: US22_admin_phonenumber_alani_bos_birakilamaz

    When User22 send post withoutphonenumber for admin
    And User22 verifys that HTTPS code is 400
    Then User22 gets withoutphonenumber the admin data and assert

  @TC08
  Scenario: US22_admin_SSN_alani_bos_birakilamaz

    When User22 send post withoutSSN for admin
    And User22 verifys that HTTPS code is 400
    Then User22 gets withoutSSN the admin data and assert

  @TC09
  Scenario: US22_admin_SSN_2_ve_5_den_sonra_"-"_icermeli_ve_9_rakamdan_olusmalidir

    When User22 send post SSN_after the number iki_and_bes shuold be - and and total dokuz number for admin
    And UserK22 verifys that HTTPS code is 200
    Then User22 gets withvalidSSN  the admin data and assert
@TC10
  Scenario: US22_admin_SSN_4_ve_5_den_sonra_"-"_icermeli_ve_9_rakamdan_olusamaz

    When User22 send post SSN_after the number dort_and_bes shuold be - and and total dokuz number for admin
    And User22 verifys that HTTPS code is 400
    Then User22 gets withinvalidSSN  the admin data and assert
@TC11
  Scenario: US22_admin_SSN_3_ve_4_den_sonra_"-"_icermeli_ve_9_rakamdan_olusamaz

    When User22 send post SSN_after the number three_and_four shuold be - and and total neun number for admin
    And User22 verifys that HTTPS code is 400
    Then User22 gets withinvalidSSN  the admin data and assert
  @TC12
  Scenario: US22_admin_SSN_3_ve_6_den_sonra_"-"_icermeli_ve_9_rakamdan_olusamaz

    When User22 send post SSN_after the number three_and_six shuold be - and and total neun number for admin
    And User22 verifys that HTTPS code is 400
    Then User22 gets withinvalidSSN  the admin data and assert
    @TC13
    Scenario: US22_admin_SSN_3_ve_5_den_sonra_"-"_icermeli_ve_8_rakamdan_olusamaz

      When User22 send post SSN_after the number three_and_five shuold be - and and total eight number for admin
      And User22 verifys that HTTPS code is 400
      Then User22 gets withinvalidSSN  the admin data and assert
      @TC14
  Scenario: US22_admin_SSN_3_ve_5_den_sonra_"-"_icermeli_ve_10_rakamdan_olusamaz

    When User22 send post SSN_after the number three_and_five shuold be - and and total ten number for admin
    And User22 verifys that HTTPS code is 400
    Then User22 gets withinvalidSSN  the admin data and assert
  @TC15
  Scenario: US22_admin_username_alani_bos_birakilamaz

    When User22 send post withoutusername for admin
    And User22 verifys that HTTPS code is 400
    Then User22 gets withoutusername the admin data and assert


@TC16
  Scenario: US22_admin_sifre_7_karakterden_olusamaz

  When User22 send post with seven character password for admin
  And User22 verifys that HTTPS code is 400
  Then User22 gets withinvalid password the admin data and assert


@TC17
Scenario: US22_admin_sifre_9_karakterden_olusabilir

  When User22 send post with nein character password for admin
  And UserK22 verifys that HTTPS code is 200
  Then User22 gets withvalid password the admin data and assert

  @TC18
  Scenario: US22_admin_sifre_bos_birakilamaz

    When User22 send post withoutcharacter password for admin
    And User22 verifys that HTTPS code is 400
    Then User22 gets withinvalid password the admin data and assert

