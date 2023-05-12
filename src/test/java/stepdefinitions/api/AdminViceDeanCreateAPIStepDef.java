package stepdefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.US01_RegisterPojo;
import pojos.US04_DeanCreationResponsePojo;
import pojos.US04_ObjectPojo;
import utilities.ObjectMapperUtils;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class AdminViceDeanCreateAPIStepDef {

    Response response;
    US04_ObjectPojo object;
    US01_RegisterPojo expecteddata;


    US04_DeanCreationResponsePojo responsedata;
    int numd = Faker.instance().number().numberBetween(1000, 9999);


    @Given("userdla_Set_the_url")
    public void userdla_set_the_url() {

        spec.pathParams("first","vicedean","second","save");

    }
    @When("User_dla send POST Request to the Url for happy_path")
    public void user_dla_send_post_request_to_the_url_for_happy_path() {
        expecteddata=new US01_RegisterPojo("2000-11-11","Paris","FEMALE","fatma","12345678","023-786-"+numd+"","484-54-"+numd+"","yalcin",numd+"yalcin");
        response=given(spec).when().body(expecteddata).post("/{first}/{second}");
        response.prettyPrint();
    }
    @Then("User_dla HTTP Status Code Should be {int}")
    public void user_dla_http_status_code_should_be(Integer int1) {
        response.then().statusCode(int1);
    }
    @Then("User_dla assertion")
    public void user_dla_assertion() {
        responsedata=new US04_DeanCreationResponsePojo(object,"Vice dean Saved","CREATED");
        US04_DeanCreationResponsePojo actualdata= ObjectMapperUtils.convertJsonToJawa(response.asString(),US04_DeanCreationResponsePojo.class);
        assertEquals(expecteddata.getBirthDay(),actualdata.object.getBirthDay());
        assertEquals(expecteddata.getBirthPlace(),actualdata.object.getBirthPlace());
        assertEquals(expecteddata.getGender(),actualdata.object.getGender());
        assertEquals(expecteddata.getName(),actualdata.object.getName());
        assertEquals(expecteddata.getPhoneNumber(),actualdata.object.getPhoneNumber());
        assertEquals(expecteddata.getSsn(),actualdata.object.getSsn());
        assertEquals(expecteddata.getSurname(),actualdata.object.getSurname());
        assertEquals(expecteddata.getUsername(),actualdata.object.getUsername());
        assertEquals(responsedata.getMessage(),actualdata.getMessage());
        assertEquals(responsedata.getHttpStatus(),actualdata.getHttpStatus());
    }
    }
