package stepdefinitions.api;


import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.US01_RegisterPojo;
import pojos.US01_ResponseRegisterPojo;
import utilities.ObjectMapperUtils;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class RegisterAPIStepDef {
   static Response response;
    US01_RegisterPojo expecteddata;

    int num4 = Faker.instance().number().numberBetween(1000, 9999);

    @Given ("Userfrz set the URL")
    public void userfrz_set_the_url(){

        //set the url
        spec.pathParams("first","guestUser","second","register");

    }

    @When("Userfrs send post request for guest user")
    public void user1_send_post_request_for_guest_user() {

        //set the expected data
       expecteddata= new US01_RegisterPojo("2001-03-03","norvec","MALE","mert","12345678",
               "523-786-"+num4+"","489-54-"+num4+"","yalcin",num4+"yalcin");

        //send the request get the response
       response= given(spec).when().body(expecteddata).post("/{first}/{second}");
       response.prettyPrint();

    }
    @Then("Userfrs gets the register data and assert")
    public void user1_gets_the_register_data_and_assert() {
       US01_ResponseRegisterPojo actueldata=ObjectMapperUtils.convertJsonToJawa(response.asString(), US01_ResponseRegisterPojo.class);
        System.out.println("actueldata = " + actueldata);
        assertEquals(200, response.getStatusCode());
        assertEquals(expecteddata.getGender(),actueldata.getObject().getGender());
        assertEquals(expecteddata.getName(),actueldata.getObject().getName());
        assertEquals(expecteddata.getSurname(),actueldata.getObject().getSurname());
        assertEquals(expecteddata.getSsn(),actueldata.getObject().getSsn());
        assertEquals(expecteddata.getPhoneNumber(),actueldata.getObject().getPhoneNumber());
        assertEquals(expecteddata.getUsername(),actueldata.getObject().getUsername());
        assertEquals(expecteddata.getBirthDay(), actueldata.getObject().getBirthDay());
        assertEquals(expecteddata.getBirthPlace(), actueldata.getObject().getBirthPlace());

        assertEquals("Guest User registered.",actueldata.getMessage());
        assertEquals("CREATED",actueldata.getHttpStatus());   // Bug

    }

    @When("Vice Deanfrs send post request without choose name")
    public void vice_deanfrs_send_post_request_without_choose_name() {

        expecteddata= new US01_RegisterPojo("2001-03-03","norvec","MALE","","12345678",
                "023-786-"+num4+"","484-54-"+num4+"","yalcin",num4+"yalcin");

        //send the request get the response
        response= given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();


    }


    @Then("Vice Deanfrs verify the status code should be {int}")
    public void vice_deanfrs_verify_the_status_code_should_be(Integer int1) {
        response.then().statusCode(int1);


    }


    @When("Vice Deanfrs send post request without choose ssn nummer")
    public void vice_deanfrs_send_post_request_without_choose_ssn_nummer() {

        expecteddata= new US01_RegisterPojo("2001-03-03","norvec","MALE","mert","12345678",
                "023-786-"+num4+"","","yalcin",num4+"yalcin");

        //send the request get the response
        response= given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();





    }

    @When("Vice Deanfrs send post request without choose password")
    public void vice_deanfrs_send_post_request_without_choose_password() {

        expecteddata= new US01_RegisterPojo("2001-03-03","van","MALE","mert","",
                "023-786-"+num4+"","484-54-"+num4+"","yalcin",num4+"yalcin");

        //send the request get the response
        response= given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();




    }



    @When("Vice Deanfrs send post request without choose surname")
    public void vice_deanfrs_send_post_request_without_choose_surname() {

        expecteddata= new US01_RegisterPojo("2001-03-03","van","MALE","mert","12345678",
                "023-786-"+num4+"","484-54-"+num4+"","",num4+"yalcin");

        //send the request get the response
        response= given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();



    }


    @When("Vice Deanfrs send post request without choose username")
    public void vice_deanfrs_send_post_request_without_choose_username() {


        expecteddata= new US01_RegisterPojo("2001-03-03","van","MALE","mert","12345678",
                "023-786-"+num4+"","484-54-"+num4+"","yalcin","");

        //send the request get the response
        response= given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();







    }





















    }
