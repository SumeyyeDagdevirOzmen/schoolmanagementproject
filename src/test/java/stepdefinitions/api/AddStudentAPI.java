package stepdefinitions.api;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import pojos.US25_StudentDataPojo;
import pojos.US25_StudentResponsePojo;
import testdata.CreateStudentTestData;
import utilities.ObjectMapperUtils;

import java.util.Map;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class AddStudentAPI {



    Response response;
    Map<String,Object> expectedData;
    CreateStudentTestData studentTestData;
    public US25_StudentDataPojo expected;
    US25_StudentResponsePojo actual;
    public static Integer userId ;
    public static String birthDay;
    public static String birthPlace;
    public static String email;
    public static String fatherName;
    public static String gender;
    public static String motherName;
    public static String name;
    public static String password;
    public static String userName;
    public static String surName;



    @Given("User sevim sets the URL")
    public void user_sevim_sets_the_url() {
        spec.pathParams("first","students","second","save");
    }
    @When("user sevim sends post request with valid datas")
    public void user_sevim_sends_post_request_with_valid_datas() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyPozitive();
        System.out.println("username = " + studentTestData.expectedStudentBodyPozitive().get("username"));
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
        expected=new US25_StudentDataPojo((String) studentTestData.expectedStudentBodyPozitive().get("username"),
                (String) studentTestData.expectedStudentBodyPozitive().get("name"),
                (String) studentTestData.expectedStudentBodyPozitive().get("surname"),
                (String) studentTestData.expectedStudentBodyPozitive().get("birthDay"),
                (String) studentTestData.expectedStudentBodyPozitive().get("birthPlace"),
                (String) studentTestData.expectedStudentBodyPozitive().get("phoneNumber"),
                (String) studentTestData.expectedStudentBodyPozitive().get("gender"),
                (String) studentTestData.expectedStudentBodyPozitive().get("motherName"),
                (String) studentTestData.expectedStudentBodyPozitive().get("fatherName"),
                (String) studentTestData.expectedStudentBodyPozitive().get("email"),
                (String) studentTestData.expectedStudentBodyPozitive().get("advisorTeacherId").toString(),
                (String) studentTestData.expectedStudentBodyPozitive().get("ssn"),
                (String) studentTestData.expectedStudentBodyPozitive().get("password")
        );
        actual=ObjectMapperUtils.convertJsonToJawa(response.asString(),US25_StudentResponsePojo.class);


    }
    @Then("user sevim get response and assert status code is {int}")
    public void user_sevim_get_response_and_assert_status_code_is(Integer int1) {
        response.prettyPrint();
        assertEquals(response.statusCode(),200);
    }


    @When("user sevim sends post request with empty advisorTeacher")
    public void userSevimSendsPostRequestWithEmptyAdvisorTeacher() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyEmptyAdvTeacher();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }


    @Then("user sevim get response and assert status code is fourHundred")
    public void userSevimGetResponseAndAssertStatusCodeIsFourHundred() {
        response.prettyPrint();
        assertEquals(response.statusCode(),400);
    }

    @When("user sevim sends post request with empty username")
    public void userSevimSendsPostRequestWithEmptyUsername() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyEmptyUsername();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }

    @When("user sevim sends post request with empty name")
    public void userSevimSendsPostRequestWithEmptyName() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyEmptyName();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }

    @When("user sevim sends post request with empty surname")
    public void userSevimSendsPostRequestWithEmptySurname() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyEmptySurName();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }


    @When("user sevim sends post request with empty birthDay")
    public void userSevimSendsPostRequestWithEmptyBirthDay() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyEmptyBirthDay();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }

    @When("user sevim sends post request with empty birthPlace")
    public void userSevimSendsPostRequestWithEmptyBirthPlace() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyEmptyBirthPlace();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }

    @When("user sevim sends post request with empty ssn")
    public void userSevimSendsPostRequestWithEmptySsn() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyEmptySsn();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }

    @When("user sevim sends post request with empty phoneNumber")
    public void userSevimSendsPostRequestWithEmptyPhoneNumber() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyEmptyPhoneNumber();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }


    @When("user sevim sends post request with empty gender")
    public void userSevimSendsPostRequestWithEmptyGender() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyEmptyGender();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }

    @When("user sevim sends post request with empty motherName")
    public void userSevimSendsPostRequestWithEmptyMotherName() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyEmptyMotherName();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }

    @When("user sevim sends post request with empty fatherName")
    public void userSevimSendsPostRequestWithEmptyFatherName() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyEmptyFatherName();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");

    }

    @When("user sevim sends post request with empty email")
    public void userSevimSendsPostRequestWithEmptyEmail() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyEmptyEmail();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }

    @When("user sevim sends post request with ssn format xx-xxx-xxxxx")
    public void userSevimSendsPostRequestWithSsnFormatXxXxxXxxxx() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodySsnFormat1();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }

    @When("user sevim sends post request with ssn format xxx-xxx-xxxx")
    public void userSevimSendsPostRequestWithSsnFormatXxxXxxXxxx() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodySsnFormat2();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }

    @When("user sevim sends post request with ssn format x-xxxx-xxxxx")
    public void userSevimSendsPostRequestWithSsnFormatXXxxxXxxxx() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodySsnFormat3();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }

    @When("user sevim sends post request with empty password")
    public void userSevimSendsPostRequestWithEmptyPassword() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyEmptyPassword();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }

    @When("user sevim sends post request with password with {int} character")
    public void userSevimSendsPostRequestWithPasswordWithCharacter(int arg0) {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodySevenCharacterPassword();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }

    @When("user sevim sends post request with password with {int} space character")
    public void userSevimSendsPostRequestWithPasswordWithSpaceCharacter(int arg0) {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyEightSpaceCharacterPassword();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");

    }

    @When("user sevim sends post request containing an e-mail in ABC..@1 format")
    public void userSevimSendsPostRequestContainingAnEMailInABCFormat1() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyEmailFormat1();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }

    @When("user sevim sends post request containing an e-mail in ABC..@gmailcom format")
    public void userSevimSendsPostRequestContainingAnEMailInABCGmailcomFormat() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyEmailFormat2();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");

    }

    @When("user sevim sends post request containing an e-mail in name.gmail@com format")
    public void userSevimSendsPostRequestContainingAnEMailInNameGmailComFormat() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyEmailFormat3();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }

    @When("user sevim sends post request containing an e-mail in ABC.. format")
    public void userSevimSendsPostRequestContainingAnEMailInABCFormat() {
        studentTestData =new CreateStudentTestData();
        expectedData= studentTestData.expectedStudentBodyEmailFormat0();
        response= given(spec).header("Accept","*/*").body(expectedData).post("{first}/{second}");
    }

    @Then("user sevim get response and assert status code is twoHundred and response body")
    public void userSevimGetResponseAndAssertStatusCodeIsTwoHundredAndResponseBody() {
        studentTestData =new CreateStudentTestData();
        response.prettyPrint();
        assertEquals(response.statusCode(),200);
        assertEquals(expected.getUsername(),actual.getObject().getUsername());
        assertEquals(expected.getName(),actual.getObject().getName());
        assertEquals(expected.getSurname(),actual.getObject().getSurname());
        assertEquals(expected.getBirthDay(),actual.getObject().getBirthDay());
        assertEquals(expected.getFatherName(),actual.getObject().getFatherName());
        assertEquals(expected.getMotherName(),actual.getObject().getMotherName());
        assertEquals(expected.getEmail(),actual.getObject().getEmail());
        userId=actual.getObject().getUserId();
        birthDay=expected.getBirthDay();
        birthPlace=expected.getBirthPlace();
        email=expected.getEmail();
        fatherName=expected.getFatherName();
        gender=expected.getGender();
        motherName=expected.getMotherName();
        name=expected.getName();
        userName=expected.getUsername();
        surName=expected.getSurname();
    }
}
