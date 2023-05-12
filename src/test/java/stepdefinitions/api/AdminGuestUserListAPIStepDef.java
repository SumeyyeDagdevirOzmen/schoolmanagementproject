package stepdefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminGuestUserListAPIStepDef {

    static Response response;

    @Given("UserDila URL e Get request yapar")
    public void userdilaURLEGetRequestYapar() {
        spec.pathParams("first","guestUser","second","getAll")
                .queryParams("page","0","size","10","sort","name","type","desc");

    }
    @Then("userDila gets all data and assert")
    public void userdilaGetsAllDataAndAssert() {
         response = given(spec).get("/{first}/{second}");
        response.prettyPrint();
        assertEquals(200,response.statusCode());
        String actualData= response.asString();
        assertTrue(actualData.contains("name"));
        assertTrue(actualData.contains("id"));
        assertTrue(actualData.contains("ssn"));
        assertTrue(actualData.contains("surname"));
        assertTrue(actualData.contains("birthDay"));
        assertTrue(actualData.contains("birthPlace"));
        assertTrue(actualData.contains("phoneNumber"));
        assertTrue(actualData.contains("gender"));


    }

    @Given("userDila sends delete request for guests data")
    public void userdilaSendsDeleteRequestForGuestsData() {


        spec.pathParams("first","guestUser","second","delete","third","110");
        response = given(spec).delete("/{first}/{second}/{third}");
        response.prettyPrint();

    }

    @Then("userDila delete data and assert")
    public void userdilaDeleteDataAndAssert() {
        assertEquals(200,response.statusCode());
    }

    ///contactMessages/getAll?page=0&size=100&sort=date&type=desc
}
