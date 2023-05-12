package stepdefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.US22_AdminDataPojo;
import pojos.US22_ResponseAdminPojo;
import testdata.AdminTestData;
import utilities.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Us22_AdminCreate {


    US22_AdminDataPojo expecteddata;
    static Response response;

    @When("User22 send post request for admin")
    public void user22_send_post_request_for_admin() {
        int num1 = Faker.instance().number().numberBetween(1000, 9999);

        //set the expected data
        expecteddata = new US22_AdminDataPojo("2001-03-03", "istanbul", "MALE", "alican", "12345678",
                "023-886-" + num1 + "", "884-54-" + num1 + "", "Tan", num1 + "kubra", false);
        //send the request get the response
       // spec.pathParams("first","admin","second","save");
        response = given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();


    }
    /*
     /*
        {
            "id": 222,
            "username": "762l7kubra",
            "ssn": "884-54-0627",
            "name": "alican",
            "surname": "Tan",
            "birthDay": "2000-03-03",
            "birthPlace": "istanbul",
            "phoneNumber": "023-883-7627",
            "gender": "FEMALE",
            "built_in": false
        }
         */


    @Then("User22 gets the admin data and assert")
    public void user22_gets_the_admin_data_and_assert() {
        /*
        {
    "object": {
        "userId": 224,
        "username": "76217kubra",
        "name": "alican",
        "surname": "Tan",
        "birthDay": null,
        "ssn": "884-54-0620",
        "birthPlace": null,
        "phoneNumber": "023-803-7627",
        "gender": "FEMALE"
    },
    "message": "Admin Saved",
    "httpStatus": "CREATED"
}
         */

        US22_ResponseAdminPojo actueldata = ObjectMapperUtils.convertJsonToJawa(response.asString(), US22_ResponseAdminPojo.class);
        System.out.println("actueldata = " + actueldata);
        assertEquals(200, response.getStatusCode());
        assertEquals(expecteddata.getGender(), actueldata.getObject().getGender());
        assertEquals(expecteddata.getName(), actueldata.getObject().getName());
        assertEquals(expecteddata.getSurname(), actueldata.getObject().getSurname());
        assertEquals(expecteddata.getSsn(), actueldata.getObject().getSsn());
        assertEquals(expecteddata.getPhoneNumber(), actueldata.getObject().getPhoneNumber());
        assertEquals(expecteddata.getUsername(), actueldata.getObject().getUsername());
        assertEquals(expecteddata.getBirthDay(), actueldata.getObject().getBirthDay());
        assertEquals(expecteddata.getBirthPlace(), actueldata.getObject().getBirthPlace());

        assertEquals("Admin Saved", actueldata.getMessage());
        assertEquals("CREATED", actueldata.getHttpStatus());


    }

    @When("User22 send post withoutname for admin")
    public void userSendPostWithoutnameForAdmin() {
        int num2 = Faker.instance().number().numberBetween(1000, 9999);

        //set the expected data
        expecteddata = new US22_AdminDataPojo("2001-03-03", "istanbul", "MALE", null, "12345678",
                "023-806-" + num2 + "", "894-54-" + num2 + "", "Tan", num2 + "kubra", false);
        //send the request get the response
        response = given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();
        //  HerOkuAppTestData obj1 = new HerOkuAppTestData();
        //        Map<String, String> bookingdatesMap = obj1.bookingdatesMapMethod("2018-01-01","2019-01-01");
        //
        //        Map<String, Object> expectedData = obj1.expectedDataMethod("John","Smith",111,true,bookingdatesMap,"Breakfast");
        //        System.out.println("expectedData = " + expectedData);


    }

    @Then("User22 gets witoutname the admin data and assert")
    public void userGetsWitoutnameTheAdminDataAndAssert() {

        Map<String, String> validationsmap = new HashMap<>();
        validationsmap.put("name", "Please enter your name");

        AdminTestData obj = new AdminTestData();
        Map<String, Object> expectedData = obj.expectedDataMethod("Validation failed for object='adminRequest'. Error count: 1", 400, "/admin/save", validationsmap);
// assertEquals(bookingdatesMap.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        Map<String, Object> actualData = response.as(HashMap.class);//De-Serialization

        Response response = given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        assertEquals(expectedData.get("statusCode"), actualData.get("statusCode"));
        assertEquals(expectedData.get("message"), actualData.get("message"));
        assertEquals(expectedData.get("path"), actualData.get("path"));
        assertEquals(validationsmap.get("name"), ((Map) actualData.get("validations")).get("name"));




        /*
         {
    "message": "Validation failed for object='adminRequest'. Error count: 1",
    "statusCode": 400,
    "path": "/admin/save",
    "timeStamp": 1681949978843,
    "validations": {
        "birthDay": "Please enter your birthday"
    }
         */

    }

    @When("User22 send post withoutsurname for admin")
    public void userSendPostWithoutsurnameForAdmin() {
        int num3 = Faker.instance().number().numberBetween(1000, 9999);

        //set the expected data
        expecteddata = new US22_AdminDataPojo("2001-03-03", "istanbul", "MALE", "dfgh", "12345678",
                "023-806-" + num3 + "", "894-54-" + num3 + "", null, num3 + "kubra", false);
        //send the request get the response
        response = given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();


    }


    @Then("User22 gets witoutnsurname the admin data and assert")
    public void userGetsWitoutnsurnameTheAdminDataAndAssert() {
        Map<String, String> validationsmap = new HashMap<>();
        validationsmap.put("surname", "Please enter your surname");

        AdminTestData obj = new AdminTestData();
        Map<String, Object> expectedData = obj.expectedDataMethod("Validation failed for object='adminRequest'. Error count: 1", 400, "/admin/save", validationsmap);
// assertEquals(bookingdatesMap.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        Map<String, Object> actualData = response.as(HashMap.class);//De-Serialization

        Response response = given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        assertEquals(expectedData.get("statusCode"), actualData.get("statusCode"));
        assertEquals(expectedData.get("message"), actualData.get("message"));
        assertEquals(expectedData.get("path"), actualData.get("path"));
        assertEquals(validationsmap.get("surname"), ((Map) actualData.get("validations")).get("surname"));


    }

    @When("User22 send post withoutbirthplace for admin")
    public void userSendPostWithoutbirthplaceForAdmin() {
        int num4 = Faker.instance().number().numberBetween(1000, 9999);

        //set the expected data
        expecteddata = new US22_AdminDataPojo("2001-03-03", null, "MALE", "dfgh", "12345678",
                "023-806-" + num4 + "", "894-54-" + num4 + "", "tan", num4 + "kubra", false);
        //send the request get the response
        response = given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();


    }

    @Then("User22 gets withoutbirthplace the admin data and assert")
    public void userGetsWithoutbirthplaceTheAdminDataAndAssert() {
        Map<String, String> validationsmap = new HashMap<>();
        validationsmap.put("birthPlace", "Please enter your birth place");

        AdminTestData obj = new AdminTestData();
        Map<String, Object> expectedData = obj.expectedDataMethod("Validation failed for object='adminRequest'. Error count: 1", 400, "/admin/save", validationsmap);

        Map<String, Object> actualData = response.as(HashMap.class);//De-Serialization

        Response response = given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        assertEquals(expectedData.get("statusCode"), actualData.get("statusCode"));
        assertEquals(expectedData.get("message"), actualData.get("message"));
        assertEquals(expectedData.get("path"), actualData.get("path"));
        assertEquals(validationsmap.get("birthPlace"), ((Map) actualData.get("validations")).get("birthPlace"));
    }

    @When("User22 send post withoutgender for admin")
    public void userSendPostWithoutgenderForAdmin() {
        int num5 = Faker.instance().number().numberBetween(1000, 9999);

        //set the expected data
        expecteddata = new US22_AdminDataPojo("2001-03-03", "Istanbul", null, "alican", "12345678",
                "023-806-" + num5 + "", "894-54-" + num5 + "", "tan", num5 + "kubra", false);
        //send the request get the response
        response = given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();


    }

    @Then("User22 gets withoutgender the admin data and assert")
    public void userGetsWithoutgenderTheAdminDataAndAssert() {
        Map<String, String> validationsmap = new HashMap<>();
        validationsmap.put("gender", "Please enter your gander");

      // Map<String, Object> expectedData = new HashMap<>();
        //        expectedData.put("firstname","John");
        //        expectedData.put("lastname","Smith");
        //        expectedData.put("totalprice",111);
        //        expectedData.put("depositpaid",true);
        //        expectedData.put("bookingdates",bookingdatesMap);
        //        expectedData.put("additionalneeds","Breakfast");
        //
        //        System.out.println("expectedData = " + expectedData);

        AdminTestData obj = new AdminTestData();
        Map<String, Object> expectedData = obj.expectedDataMethod("Validation failed for object='adminRequest'. Error count: 1", 400, "/admin/save",validationsmap);

        Map<String, Object> actualData = response.as(HashMap.class);//De-Serialization

        Response response = given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        assertEquals(expectedData.get("statusCode"), actualData.get("statusCode"));
        assertEquals(expectedData.get("message"), actualData.get("message"));
        assertEquals(expectedData.get("path"), actualData.get("path"));



        /*
        {
    "message": "JSON parse error: Cannot coerce empty String (\"\") to `com.project.schoolmanagment.entity.enums.Gender` value (but could if coercion was enabled using `CoercionConfig`); nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Cannot coerce empty String (\"\") to `com.project.schoolmanagment.entity.enums.Gender` value (but could if coercion was enabled using `CoercionConfig`)\n at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 52] (through reference chain: com.project.schoolmanagment.payload.request.AdminRequest[\"gender\"])",
    "statusCode": 400,
    "path": "/admin/save",
    "timeStamp": 1681951300609
}

         */


    }

    @When("User22 send post withoutdateofbirth for admin")
    public void userSendPostWithoutdateofbirthForAdmin() {
        int num6 = Faker.instance().number().numberBetween(1000, 9999);

        //set the expected data
        expecteddata = new US22_AdminDataPojo(null, "istanbul", "MALE", "dfgh", "12345678",
                "023-806-" + num6 + "", "894-54-" + num6 + "", "tan", num6 + "kubra", false);
        //send the request get the response
        response = given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();


    }

    @Then("User22 gets withoutdateofbirth the admin data and assert")
    public void userGetsWithoutdateofbirthTheAdminDataAndAssert() {
        Map<String, String> validationsmap = new HashMap<>();
        validationsmap.put("birtday", "Please enter your birthday");



        AdminTestData obj = new AdminTestData();
        Map<String, Object> expectedData = obj.expectedDataMethod("Validation failed for object='adminRequest'. Error count: 1", 400, "/admin/save",validationsmap);

        Map<String, Object> actualData = response.as(HashMap.class);//De-Serialization

        Response response = given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        assertEquals(expectedData.get("statusCode"), actualData.get("statusCode"));
        assertEquals(expectedData.get("message"), actualData.get("message"));
        assertEquals(expectedData.get("path"), actualData.get("path"));



   /*     // 2. Yol: JsonPath ile
        JsonPath jsonPath = response.jsonPath();
        assertEquals(400, jsonPath.getInt("statusCode"));
        assertEquals("Validation failed for object='adminRequest'. Error count: 1", jsonPath.getString("message"));
        assertEquals("/admin/save", jsonPath.getString("path"));
        assertEquals("Please enter your birthday", jsonPath.getString("validations.birthDay"));
*/

//    });
//{

    }

    @When("User22 send post withoutphonenumber for admin")
    public void userSendPostWithoutphonenumberForAdmin() {
        int num7 = Faker.instance().number().numberBetween(1000, 9999);

        //set the expected data
        expecteddata = new US22_AdminDataPojo("2001-03-03", "istanbul", "MALE", "alican", "12345678",
                "", "894-54-" + num7 + "", "tan", num7 + "kubra", false);
        //send the request get the response
        response = given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();

    }

    @Then("User22 gets withoutphonenumber the admin data and assert")
    public void userGetsWithoutphonenumberTheAdminDataAndAssert() {
        Map<String, String> validationsmap = new HashMap<>();
        validationsmap.put("phoneNumber", "Please enter valid phone number");
        AdminTestData obj = new AdminTestData();
        Map<String, Object> expectedData = obj.expectedDataMethod("Validation failed for object='adminRequest'. Error count: 2", 400, "/admin/save",validationsmap);

        Map<String, Object> actualData = response.as(HashMap.class);//De-Serialization

        Response response = given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        assertEquals(expectedData.get("statusCode"), actualData.get("statusCode"));
        assertEquals(expectedData.get("message"), actualData.get("message"));
        assertEquals(expectedData.get("path"), actualData.get("path"));

    }

    @When("User22 send post withoutusername for admin")
    public void userSendPostWithoutusernameForAdmin() {
        int num15 = Faker.instance().number().numberBetween(1000, 9999);

        //set the expected data
        expecteddata = new US22_AdminDataPojo("2001-03-03", "istanbul", "MALE", "alican", "12345678",
                "023-806-" + num15 + "", "894-54-" + num15 + "", "tan", null, false);
        //send the request get the response
        response = given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();

    }

    @Then("User22 gets withoutusername the admin data and assert")
    public void userGetsWithoutusernameTheAdminDataAndAssert() {
        Map<String, String> validationsmap = new HashMap<>();
        validationsmap.put("username", "Please enter your  username");



        AdminTestData obj = new AdminTestData();
        Map<String, Object> expectedData = obj.expectedDataMethod("Validation failed for object='adminRequest'. Error count: 1", 400, "/admin/save", validationsmap);

        Map<String, Object> actualData = response.as(HashMap.class);//De-Serialization


        Response response = given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        assertEquals(expectedData.get("statusCode"), actualData.get("statusCode"));
        assertEquals(expectedData.get("message"), actualData.get("message"));
        assertEquals(expectedData.get("path"), actualData.get("path"));


        //{
        //    "message": "Error: User with username  already register",
        //    "statusCode": 409,
        //    "path": "/admin/save",
        //    "timeStamp": 1682159931054
        //}


    }

    @When("User22 send post withoutSSN for admin")
    public void userSendPostWithoutSSNForAdmin() {
        int num8 = Faker.instance().number().numberBetween(1000, 9999);

        //set the expected data
        expecteddata = new US22_AdminDataPojo("2001-03-03", "istanbul", "MALE", "alican", "12345678",
                "023-806-" + num8 + "", "", "tan", num8 + "kubra", false);
        //send the request get the response
        response = given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();


    }

    @Then("User22 gets withoutSSN the admin data and assert")
    public void userGetsWithoutSSNTheAdminDataAndAssert() {
        Map<String, String> validationsmap = new HashMap<>();
        validationsmap.put("ssn", "Please enter valid SSN number");

        AdminTestData obj = new AdminTestData();
        Map<String, Object> expectedData = obj.expectedDataMethod("Validation failed for object='adminRequest'. Error count: 1", 400, "/admin/save", validationsmap);

        Map<String, Object> actualData = response.as(HashMap.class);//De-Serialization

        Response response = given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        assertEquals(expectedData.get("statusCode"), actualData.get("statusCode"));
        assertEquals(expectedData.get("message"), actualData.get("message"));
        assertEquals(expectedData.get("path"), actualData.get("path"));
        assertEquals(validationsmap.get("ssn"), ((Map) actualData.get("validations")).get("ssn"));

    }
    @When("User22 send post SSN_after the number iki_and_bes shuold be - and and total dokuz number for admin")
    public void userSendPostSSN_afterTheNumberIki_and_besShuoldBeAndAndTotalDokuzNumberForAdmin() {
        int num9 = Faker.instance().number().numberBetween(1000, 9999);

        //set the expected data
        expecteddata = new US22_AdminDataPojo("2001-03-03", "istanbul", "MALE", "alican", "12345678",
                "023-806-" + num9+ "", "894-54-" + num9 + "", "tan", num9 + "kubra", false);
        //send the request get the response
        response = given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();

    }


    @Then("User22 gets withinvalidSSN  the admin data and assert")
    public void userGetsWithinvalidSSNTheAdminDataAndAssert() {
        Map<String, String> validationsmap = new HashMap<>();
        validationsmap.put("ssn", "Please enter valid SSN number");
        AdminTestData obj = new AdminTestData();
        Map<String, Object> expectedData = obj.expectedDataMethod("Validation failed for object='adminRequest'. Error count: 1", 400, "/admin/save",validationsmap);

        Map<String, Object> actualData = response.as(HashMap.class);//De-Serialization

        Response response = given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        assertEquals(expectedData.get("statusCode"), actualData.get("statusCode"));
        assertEquals(expectedData.get("message"), actualData.get("message"));
        assertEquals(expectedData.get("path"), actualData.get("path"));



    }

    @Given("User22 sets the Url")
    public void userSetsTheUrl() {
        //set the url
        spec.pathParams("first", "admin", "second", "save");

    }




    @And("UserK22 verifys that HTTPS code is 200")
    public void userkVerifysThatHTTPSCodeIs() {
       Assert.assertEquals(200,response.statusCode());
        //       Assert.assertFalse(adminManagementPage.adminSaved.isEnabled());
    }

    @And("User22 verifys that HTTPS code is 400")
    public void userVerifysThatHTTPSCodeIs() {
        assertEquals(400, response.getStatusCode());

    }

    @Then("User22 gets withvalidSSN  the admin data and assert")
    public void userGetsWithvalidSSNTheAdminDataAndAssert() {
        US22_ResponseAdminPojo actueldata = ObjectMapperUtils.convertJsonToJawa(response.asString(), US22_ResponseAdminPojo.class);
        System.out.println("actueldata = " + actueldata);
        assertEquals(200, response.getStatusCode());
        assertEquals(expecteddata.getGender(), actueldata.getObject().getGender());
        assertEquals(expecteddata.getName(), actueldata.getObject().getName());
        assertEquals(expecteddata.getSurname(), actueldata.getObject().getSurname());
        assertEquals(expecteddata.getSsn(), actueldata.getObject().getSsn());
        assertEquals(expecteddata.getPhoneNumber(), actueldata.getObject().getPhoneNumber());
        assertEquals(expecteddata.getUsername(), actueldata.getObject().getUsername());



        assertEquals("Admin Saved", actueldata.getMessage());
        assertEquals("CREATED", actueldata.getHttpStatus());


    }


    @When("User22 send post SSN_after the number dort_and_bes shuold be - and and total dokuz number for admin")
    public void userSendPostSSN_afterTheNumberDort_and_besShuoldBeAndAndTotalDokuzNumberForAdmin() {
        int num10 = Faker.instance().number().numberBetween(1000, 9999);

        //set the expected data
        expecteddata = new US22_AdminDataPojo("2001-03-03", "istanbul", "MALE", "alican", "12345678",
                "023-806-" + num10+ "", num10+"-5-" + num10 + "", "tan", num10 + "kubra", false);
        //send the request get the response
        response = given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();
    }

    @When("User22 send post SSN_after the number three_and_four shuold be - and and total neun number for admin")
    public void userSendPostSSN_afterTheNumber_and_ShuoldBeAndAndTotalNumberForAdmin() {

        int num11 = Faker.instance().number().numberBetween(10000, 99999);
        int num011 =Faker.instance().number().numberBetween(1000, 9999);

        //set the expected data
        expecteddata = new US22_AdminDataPojo("2001-03-03", "istanbul", "MALE", "alican", "12345678",
                "023-806-" + num011+ "", "125-5" + num11 + "", "tan", num11 + "kubra", false);
        //send the request get the response
        response = given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint(); }

    @When("User22 send post SSN_after the number three_and_six shuold be - and and total neun number for admin")
    public void userSendPostSSN_afterTheNumberThree_and_sixShuoldBeAndAndTotalNeunNumberForAdmin() {
        int num12 = Faker.instance().number().numberBetween(1000, 9999);
        int num012 = Faker.instance().number().numberBetween(100, 999);

        //set the expected data
        expecteddata = new US22_AdminDataPojo("2001-03-03", "istanbul", "MALE", "alican", "12345678",
                "023-806-" + num12+ "", "123-"+"123-" + num012, "tan", num12 + "kubra", false);
        //send the request get the response
        response = given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint(); }

    @When("User22 send post SSN_after the number three_and_five shuold be - and and total eight number for admin")
    public void userSendPostSSN_afterTheNumberThree_and_fiveShuoldBeAndAndTotalEightNumberForAdmin() {
        int num13 = Faker.instance().number().numberBetween(1000, 9999);
        int num013 = Faker.instance().number().numberBetween(100, 999);

        //set the expected data
        expecteddata = new US22_AdminDataPojo("2001-03-03", "istanbul", "MALE", "alican", "12345678",
                "023-806-" + num13+ "", "123-"+"12-" + num013, "tan", num13 + "kubra", false);
        //send the request get the response
        response = given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint(); }

    @When("User22 send post SSN_after the number three_and_five shuold be - and and total ten number for admin")
    public void userSendPostSSN_afterTheNumberThree_and_fiveShuoldBeAndAndTotalTenNumberForAdmin() {
        int num14 = Faker.instance().number().numberBetween(1000, 9999);
        int num014 = Faker.instance().number().numberBetween(10000, 99999);

        //set the expected data
        expecteddata = new US22_AdminDataPojo("2001-03-03", "istanbul", "MALE", "alican", "12345678",
                "023-806-" + num14+ "", "123-"+"12-" + num014, "tan", num14 + "kubra", false);
        //send the request get the response
        response = given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint(); }

    @When("User22 send post with seven character password for admin")
    public void userSendPostWithSevenCharacterPasswordForAdmin() {
        int num15 = Faker.instance().number().numberBetween(1000, 9999);

        //set the expected data
        expecteddata = new US22_AdminDataPojo("2001-03-03", "istanbul", "MALE", "alican", "1234567",
                "023-886-" + num15 + "", "884-54-" + num15 + "", "Tan", num15 + "kubra", false);
        //send the request get the response
        response = given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();


    }

    @Then("User22 gets withinvalid password the admin data and assert")
    public void userGetsWithinvalidPasswordTheAdminDataAndAssert() {
        Map<String, String> validationsmap = new HashMap<>();
        validationsmap.put("password", "Please enter your password as at least 8 characters");

        AdminTestData obj = new AdminTestData();
        Map<String, Object> expectedData = obj.expectedDataMethod("Validation failed for object='adminRequest'. Error count: 1", 400, "/admin/save", validationsmap);

        Map<String, Object> actualData = response.as(HashMap.class);//De-Serialization

        Response response = given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        assertEquals(expectedData.get("statusCode"), actualData.get("statusCode"));
        assertEquals(expectedData.get("message"), actualData.get("message"));
        assertEquals(expectedData.get("path"), actualData.get("path"));
        assertEquals(validationsmap.get("ssn"), ((Map) actualData.get("validations")).get("ssn"));
        //"password": "Please enter your password as at least 8 characters"
    }

    @When("User22 send post with nein character password for admin")
    public void userSendPostWithNeinCharacterPasswordForAdmin() {
        int num17 = Faker.instance().number().numberBetween(1000, 9999);

        //set the expected data
        expecteddata = new US22_AdminDataPojo("2001-03-03", "istanbul", "MALE", "alican", "123456789",
                "023-886-" + num17 + "", "884-54-" + num17 + "", "Tan", num17 + "kubra", false);
        //send the request get the response
        response = given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();

    }

    @When("User22 send post withoutcharacter password for admin")
    public void userSendPostWithoutcharacterPasswordForAdmin() {
        int num17 = Faker.instance().number().numberBetween(1000, 9999);

        //set the expected data
        expecteddata = new US22_AdminDataPojo("2001-03-03", "istanbul", "MALE", "alican", null,
                "023-886-" + num17 + "", "884-54-" + num17 + "", "Tan", num17 + "kubra", false);
        //send the request get the response
        response = given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();

    }

    @Then("User22 gets withvalid password the admin data and assert")
    public void userGetsWithvalidPasswordTheAdminDataAndAssert() {

        US22_ResponseAdminPojo actueldata = ObjectMapperUtils.convertJsonToJawa(response.asString(), US22_ResponseAdminPojo.class);
        System.out.println("actueldata = " + actueldata);
        assertEquals(200, response.getStatusCode());
        assertEquals(expecteddata.getGender(), actueldata.getObject().getGender());
        assertEquals(expecteddata.getName(), actueldata.getObject().getName());
        assertEquals(expecteddata.getSurname(), actueldata.getObject().getSurname());
        assertEquals(expecteddata.getSsn(), actueldata.getObject().getSsn());
        assertEquals(expecteddata.getPhoneNumber(), actueldata.getObject().getPhoneNumber());
        assertEquals(expecteddata.getUsername(), actueldata.getObject().getUsername());



        assertEquals("Admin Saved", actueldata.getMessage());
        assertEquals("CREATED", actueldata.getHttpStatus());

    }

    @When("User22 send post request for student")
    public void userSendPostRequestForStudent() {


    }


}



