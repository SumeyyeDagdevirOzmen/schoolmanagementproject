package stepdefinitions.api;


import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.US06_DeanViceDeanRequestPojo;
import pojos.US06_ResponsePojo;


import java.util.Locale;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Us06_DeanCreateViceDean {

    Response response;
    Faker faker = new Faker(Locale.US);
    String phoneNumber = faker.number().digits(3) + "-" + faker.number().digits(3) + "-" + faker.number().digits(4) + "";
    String ssn = faker.idNumber().ssnValid() + "";
    String userName = faker.name().username();
    static int userId;


    @When("user yusuf sends POST request and do the assertion for creating vice dean by dean")
    public void userYusufSendsPOSTRequestAndDoTheAssertionForCreatingViceDeanByDean() {
        spec.pathParams("first", "vicedean", "second", "save");
        US06_DeanViceDeanRequestPojo expectedData = new US06_DeanViceDeanRequestPojo("1990-04-17", "Paris", "MALE", "Natalia", "12345678", phoneNumber, ssn,
                "Karima", userName);
        response = given(spec).body(expectedData).contentType(ContentType.JSON).when().post("/{first}/{second}");
        US06_ResponsePojo actualData = response.as(US06_ResponsePojo.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getBirthDay(), actualData.getObject().getBirthDay());
        assertEquals(expectedData.getBirthPlace(), actualData.getObject().getBirthPlace());
        assertEquals(expectedData.getGender(), actualData.getObject().getGender());
        assertEquals(expectedData.getName(), actualData.getObject().getName());
        assertEquals(expectedData.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        assertEquals(expectedData.getSsn(), actualData.getObject().getSsn());
        assertEquals(expectedData.getSurname(), actualData.getObject().getSurname());
        assertEquals(expectedData.getUsername(), actualData.getObject().getUsername());
        assertEquals("Vice dean Saved", actualData.getMessage());
        userId = actualData.getObject().getUserId();
    }


    @And("user yusuf sends PUT request and do the assertion for creating vice dean by dean")
    public void userYusufSendsPUTRequestAndDoTheAssertionForCreatingViceDeanByDean() {
        spec.pathParams("first", "vicedean", "second", "update", "third", userId);
        US06_DeanViceDeanRequestPojo expectedData = new US06_DeanViceDeanRequestPojo("1994-05-17", "Italy", "FEMALE", "Suzie", "12345678", phoneNumber, ssn,
                "Alter", userName);
        response = given(spec).body(expectedData).contentType(ContentType.JSON).when().put("/{first}/{second}/{third}");
        US06_ResponsePojo actualData = response.as(US06_ResponsePojo.class);
        assertEquals(200, response.statusCode());
        assertEquals(userId, (int) actualData.getObject().getUserId());
        assertEquals(expectedData.getBirthDay(), actualData.getObject().getBirthDay());
        assertEquals(expectedData.getBirthPlace(), actualData.getObject().getBirthPlace());
        assertEquals(expectedData.getGender(), actualData.getObject().getGender());
        assertEquals(expectedData.getName(), actualData.getObject().getName());
        assertEquals(expectedData.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        assertEquals(expectedData.getSsn(), actualData.getObject().getSsn());
        assertEquals(expectedData.getSurname(), actualData.getObject().getSurname());
        assertEquals(expectedData.getUsername(), actualData.getObject().getUsername());
        assertEquals("Vice dean Updated Successful", actualData.getMessage());
    }

    @And("user yusuf sends DELETE request and do the assertion for creating vice dean by dean")
    public void userYusufSendsDELETERequestAndDoTheAssertionForCreatingViceDeanByDean() {
        spec.pathParams("first", "vicedean", "second", "delete", "third", userId);
        response = given(spec).when().delete("/{first}/{second}/{third}");
        response.then().statusCode(200).body("message", equalTo("Vice dean Deleted"), "httpStatus", equalTo("OK"));
    }

    @And("user yusuf sends GET request and do the assertion for creating vice dean by dean")
    public void userYusufSendsGETRequestAndDoTheAssertionForCreatingViceDeanByDean() {
        spec.pathParams("first", "vicedean", "second", "getViceDeanById", "third", userId);
        response = given(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();
        response.then().statusCode(400).body("message", equalTo("Error: User with SSN " + userId + " not found"));
    }


    @Given("User yusuf sets the Url")
    public void userYusufSetsTheUrl() {


    }
}






