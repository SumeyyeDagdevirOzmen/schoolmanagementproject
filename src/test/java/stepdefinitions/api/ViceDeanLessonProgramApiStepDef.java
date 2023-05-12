package stepdefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import testdata.LessonProgramTestData;
import utilities.ObjectMapperUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;


public class ViceDeanLessonProgramApiStepDef {


    static Response response;
    Map<String, Object> expectedData;
    Map<String, Object> map3;
    Map<String, Object> map2;
    Map<String, Object> actualData;
    List<Integer> lessonId;
    LessonProgramTestData obj;
    static int lessonProgramId;

    int start = Faker.instance().number().numberBetween(10, 22);
    int stop = start + 1;
    String startTime = "" + start + ":00";
    String stopTime = "" + stop + ":00";

    @Given("useron set the url")
    public void useronSetTheUrl() {
        spec.pathParams("first", "lessonPrograms", "second", "save");
    }

    @Given("user10_send Post request for guest LessonProgram..")
    public void userSendPostRequestForGuestLessonProgram() throws IOException {
        obj = new LessonProgramTestData();
        List<Integer> lessonId = new ArrayList<>();
        lessonId.add(75);
        expectedData = obj.expectedData("MONDAY", "1",lessonId, startTime, stopTime);
        System.out.println("expectedData = " + expectedData);
        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
        Map<String, Object> actualData = ObjectMapperUtils.convertJsonToJawa(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);
        lessonProgramId =response.jsonPath().getInt("object.lessonProgramId");
        System.out.println("lessonProgramId = " + lessonProgramId);

    }
    @When("user10HTTP Status code should be {int}")
    public void httpStatusCodeShouldBe(int statusCode) {

        Assert.assertEquals(statusCode,response.getStatusCode());
    }

    @Then("user10_gets the register data und assert...")
    public void userGetsTheRegisterDataUndAssert() {
        spec.pathParams("first","lessonPrograms","second","getAll");
        response=given(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        List<Integer> ids=response.jsonPath().getList("lessonProgramId");
        System.out.println(ids);
        Assert.assertTrue(ids.contains(lessonProgramId));


//        // 1.validation
//        response.then().body("object.day", equalTo("MONDAY")).
//                body("object.startTime", equalTo("12:30:00")).
//                body("object.stopTime", equalTo("18:30:00"));

//        Assert.assertEquals(expectedData.get("day"),actualData.get("object.day"));
//        Assert.assertEquals(expectedData.get("startTime"),actualData.get("object.startTime"));
//        Assert.assertEquals(expectedData.get("stopTime"),actualData.get("object.stopTime"));

//        //2.validation
//        JsonPath jsonPath = response.jsonPath();
//        Assert.assertEquals("MONDAY", jsonPath.getString("object.day"));
//        Assert.assertEquals("12:30", jsonPath.getString("object.startTime"));
//        Assert.assertEquals("18:30", jsonPath.getString("object.stopTime"));

//        //3.validation
//        Map<String, Object> actualDataMap = response.as(HashMap.class);
//        Assert.assertEquals(expectedData.get("day"), map2.get("day"));
//        Assert.assertEquals(expectedData.get("startTime"), map2.get("startTime"));
//        Assert.assertEquals(expectedData.get("stopTime"), map2.get("stopTime"));

    }

    @Given("user10_send Post reguest StartTime empty")
    public void userSendPostReguestStartTimeEmpty() {
        obj = new LessonProgramTestData();
        Map<String, Object> expectedData = obj.expectedData("MONDAY", "1",lessonId, "", stopTime);
        System.out.println("expectedData = " + expectedData);
        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }

    @Given("user10_send Post reguest StopTime empty")
    public void userSendPostReguestStopTimeEmpty() {
         obj = new LessonProgramTestData();
        Map<String, Object> expectedData = obj.expectedData("MONDAY", "1",lessonId, startTime, "");
        System.out.println("expectedData = " + expectedData);
        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }

    @Given("user10_send Post reguest Day empty")
    public void userSendPostReguestDayEmpty() {
        obj = new LessonProgramTestData();
        Map<String, Object> expectedData = obj.expectedData("", "1",lessonId, startTime, stopTime);
        System.out.println("expectedData = " + expectedData);
        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }

    @When("10.HTTP Status code should be {int} ..")
    public void htchttpStatusCodeShouldBe(int statuscod) {

        Assert.assertEquals(statuscod,response.getStatusCode());
    }

}


