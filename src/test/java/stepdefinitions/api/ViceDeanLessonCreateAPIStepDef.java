package stepdefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.US08_LesObjectPojo;


import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ViceDeanLessonCreateAPIStepDef {


    US08_LesObjectPojo expectedObject;
    static Response response;
    JsonPath jsonPath;
    static int lessonId;




   static Faker faker =new Faker();

   String lessonName = faker.lorem().word();

    @Given("Vice Deanfrz set the URL")
    public void vice_deanfrz_set_the_url() {

        spec.pathParams("first", "lessons", "second", "save");

    }


    @Given("Vice Deanfrz send  post request for add lesson")
    public void vice_deanfrz_send_post_request_for_add_lesson() {

       // US08_ResponseLesPojo responseLesPojo=new US08_ResponseLesPojo(null,num4+"lesson created","OK");

        expectedObject = new US08_LesObjectPojo(lessonId, lessonName, 5,true);
        response = given(spec).when().body(expectedObject).post("/{first}/{second}");
        response.prettyPrint();


    }

    @Then("Vice Deanfrz gets the data and verify")
    public void vice_deanfrz_gets_the_data_and_verify() {

        jsonPath = response.jsonPath();
        lessonId = jsonPath.getInt("object.lessonId");
        System.out.println("id = " + lessonId);
        assertEquals(200, response.getStatusCode());



    }

    @Given("Vice Deanfrz send post request without choose lessonName")
    public void vice_deanfrz_send_post_request_without_choose_lesson_name() {

        expectedObject = new US08_LesObjectPojo(lessonId, "", 4, true);
        response = given(spec).when().body(expectedObject).post("/{first}/{second}");
        response.prettyPrint();


    }

    @Then("Vice Deanfrz verify the status code should be {int}")
    public void vice_deanfrz_verify_the_status_code_should_be(Integer int1) {

        response.prettyPrint();
        assertEquals(response.statusCode(),400);

    }

    @Given("Vice Deanfrz send invalid post request for creditScore")
    public void vice_deanfrz_send_invalid_post_request_for_credit_score() {
        expectedObject = new US08_LesObjectPojo(lessonId, lessonName,-5, true);
        response = given(spec).when().body(expectedObject).post("/{first}/{second}");
        response.prettyPrint(); // Bug





    }






}
