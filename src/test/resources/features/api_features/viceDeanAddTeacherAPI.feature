@vicedean @ApiUs13 @apiRegression
Feature:Teacher_Management_ViceDean_AddTeacher
  Background:
    Given Vice DeanS sets the URL

  @TC001Positive
  Scenario:TC001_Vice_Dean_Add_Teacher
    When Vice DeanS sends post for adding teacher
    Then Vice Dean gets the data and verify

  @TC002Negative
  Scenario:TC002_Vice_Dean_Add_Teacher
    When Vice DeanS sends post request without choose lessons dropdown
    Then Vice DeanS verify the status code should be 400

  @TC003Negative
  Scenario:TC003_Vice_Dean_Add_Teacher
    When Vice DeanS sends post request without name
    Then Vice DeanS verify the status code should be 400

  @TC004Negative
  Scenario:TC004_Vice_Dean_Add_Teacher
    When Vice Dean sends the post request with the space characters to the name field
    Then Vice DeanS verify the status code should be 400

  @TC005Negative
  Scenario:TC005_Vice_Dean_Add_Teacher
    When Vice Dean sends the post request without surname
    Then Vice DeanS verify the status code should be 400

  @TC006Negative
  Scenario:TC006_Vice_Dean_Add_Teacher
    When Vice Dean sends the post request with the space characters to the surname field
    Then Vice DeanS verify the status code should be 400

    @TC007Negative
    Scenario:TC007_Vice_Dean_Add_Teacher
      When Vice Dean sends the post request without birthplace
      Then Vice DeanS verify the status code should be 400

    @TC008Negative
    Scenario:TC008_Vice_Dean_Add_Teacher
      When Vice Dean sends the post request with the space characters to the birthplace field
      Then Vice DeanS verify the status code should be 400

    @TC009Negative
    Scenario:TC009_Vice_Dean_Add_Teacher
      When Vice Dean sends the post request without email
      Then Vice DeanS verify the status code should be 400

    @TC010Negative
    Scenario:TC010_Vice_Dean_Add_Teacher
      When Vice Dean sends the post request without .com for the email
      Then Vice DeanS verify the status code should be 400

    @TC011Negative
    Scenario:TC011_Vice_Dean_Add_Teacher
      When Vice Dean sends the post request without @ character for the email
      Then Vice DeanS verify the status code should be 400

    @TC012Negative
    Scenario:TC012_Vice_Dean_Add_Teacher
      When Vice Dean sends the post request without phoneNumber
      Then Vice DeanS verify the status code should be 400

    @TC013Negative
    Scenario:TC013_Vice_Dean_Add_Teacher
      When Vice Dean sends the post request with twelve digits without hyphen for the invalid phone number
      Then Vice DeanS verify the status code should be 400

    @TC014Negative
    Scenario:TC014_Vice_Dean_Add_Teacher
      When Vice Dean sends the post request with eleven digits for the invalid phone number
      Then Vice DeanS verify the status code should be 400

    @TC015Negative
    Scenario:TC015_Vice_Dean_Add_Teacher
      When Vice Dean sends the post request without gender options
      Then Vice DeanS verify the status code should be 400

  @TC016Negative
  Scenario:TC016_Vice_Dean_Add_Teacher
    When Vice Dean sends the post request without dateOfBirth field
    Then Vice DeanS verify the status code should be 400

  @TC017Negative
  Scenario:TC017_Vice_Dean_Add_Teacher
    When Vice Dean sends the post request without SSN field
    Then Vice DeanS verify the status code should be 400

  @TC018Negative
  Scenario:TC018_Vice_Dean_Add_Teacher
    When Vice Dean sends the post request without hyphen SSN number for the invalid SSN number
    Then Vice DeanS verify the status code should be 400

  @TC019Negative
  Scenario:TC019_Vice_Dean_Add_Teacher
    When Vice Dean sends the post request with hyphen after second and fourth numbers for the invalid SSN number
    Then Vice DeanS verify the status code should be 400

  @TC020Negative
  Scenario:TC020_Vice_Dean_Add_Teacher
    When Vice Dean sends the post request with hyphen after third and sixth numbers for the invalid SSN number
    Then Vice DeanS verify the status code should be 400

  @TC021Negative
  Scenario:TC021_Vice_Dean_Add_Teacher
    When Vice Dean sends the post request with invalid formatted SSN number
    Then Vice DeanS verify the status code should be 400

  @TC022Negative
  Scenario:TC022_Vice_Dean_Add_Teacher
    When Vice Dean sends the post request without UserName field
    Then Vice DeanS verify the status code should be 400

  @TC023Negative
  Scenario:TC023_Vice_Dean_Add_Teacher
    When Vice Dean sends the post request with the space characters to the username field
    Then Vice DeanS verify the status code should be 400

  @TC024Negative
  Scenario:TC024_Vice_Dean_Add_Teacher
    When Vice Dean sends the post request without password field
    Then Vice DeanS verify the status code should be 400

  @TC025Negative
  Scenario:TC025_Vice_Dean_Add_Teacher
    When Vice Dean sends the post request with invalid formatted password
    Then Vice DeanS verify the status code should be 400

  @TC026Negative
  Scenario:TC026_Vice_Dean_Add_Teacher
    When Vice Dean sends the post request with space characters for the invalid password
    Then Vice DeanS verify the status code should be 400

  @TC027Negative
  Scenario:TC027_Vice_Dean_Add_Teacher
    When Vice Dean sends the post request with invalid formatted dateOfBirth
    Then Vice DeanS verify the status code should be 400

  @TC028Negative
  Scenario:TC028_Vice_Dean_Add_Teacher
    When Vice DeanS sends the post request with invalid formatted dateOfBirth
    Then Vice DeanS verify the status code should be 400



