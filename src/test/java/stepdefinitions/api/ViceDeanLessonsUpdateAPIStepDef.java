package stepdefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.*;

import utilities.ObjectMapperUtils;


import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ViceDeanLessonsUpdateAPIStepDef {

    US09_LessonObject expectedObject;
    static Response response;
    JsonPath jsonPath;
    static int lessonId;

    static Faker faker = new Faker();
    @Given("Userz sets the url for post lesson")
    public void userz_sets_the_url_for_post_lesson() {

        spec.pathParams("first", "lessons", "second", "save");
    }

    @When("Userz sends a POST request lesson")
    public void userz_sends_a_post_request_lesson() {

        expectedObject = new US09_LessonObject(lessonId, "husamettin", 4, true);

        response = given(spec).when().body(expectedObject).post("/{first}/{second}");
        response.prettyPrint();

        jsonPath = response.jsonPath();
        lessonId = jsonPath.getInt("object.lessonId");
        System.out.println("id = " + lessonId);


        assertEquals(200, response.getStatusCode());

    }

    @Given("Userz sets the url for get request lesson")
    public void userz_sets_the_url_for_get_request_lesson()
    {
      //set the url
        spec.pathParams("first", "lessons", "second", "getAllLessonByLessonId").queryParams("lessonId",lessonId);
    }

    @When("Userz sends a GET request for lesson")
    public void userz_sends_a_get_request_for_lesson() {
        expectedObject = new US09_LessonObject(lessonId, "husamettin", 4, true);

    }

    @Then("Userz verifies that HTTP Status Code is {int} voor get lesson")
    public void userz_verifies_that_http_status_code_is_voor_get_lesson(Integer int1) {
        //Do assertion
        assertEquals(200, response.statusCode());
    }
    @Then("Userz verifies lesson response body")
    public void userz_verifies_lesson_response_body() {
        US09_ResponseLesson actueldata = ObjectMapperUtils.convertJsonToJawa(response.asString(), US09_ResponseLesson.class);
        System.out.println("actueldata = " + actueldata);
        expectedObject = new US09_LessonObject(lessonId,"husamettin", 4,
                true);

        assertEquals(expectedObject.getLessonId(), actueldata.getObject().getLessonId());
        assertEquals(expectedObject.getLessonName(), actueldata.getObject().getLessonName());
        assertEquals(expectedObject.getCompulsory(), actueldata.getObject().getCompulsory());
        assertEquals(expectedObject.getCreditScore(), actueldata.getObject().getCreditScore());

    }

    @Given("Usez sets the url for delete request")
    public void usez_sets_the_url_for_delete_request() {
        spec.pathParams("first", "lessons", "second", "delete","third",lessonId);
    }

    @When("Userz sends a DELETE request")
    public void userz_sends_a_delete_request() {
        response = given(spec).when().delete("/{first}/{second}/{third}");
        response.prettyPrint();
    }

    @Then("Userz verifies that HTTP Status Code is {int} voor delete")
    public void userz_verifies_that_http_status_code_is_voor_delete(Integer int1) {

        assertEquals( "Lesson Deleted", response.jsonPath().getString("message"));


    }
}







