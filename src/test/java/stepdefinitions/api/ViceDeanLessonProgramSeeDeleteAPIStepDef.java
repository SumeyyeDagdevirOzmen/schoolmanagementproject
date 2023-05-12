package stepdefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import testdata.LessonProgramTestData;
import utilities.ObjectMapperUtils;

import java.util.*;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class ViceDeanLessonProgramSeeDeleteAPIStepDef {

    Response response;
    LessonProgramTestData obj;
    private static Map<String, Object> expectedData;
    JsonPath jsonPath;
    static int lessonProgramId;
    List<Integer> lessonsId;

    @Given("Vice DeanAy send post request")
    public void vice_dean_ay_send_post_request() {
        /*
        {
  "day": "MONDAY",
  "educationTermId": 1,
  "lessonIdList": [
    75
  ],
  "startTime": "13:00",
  "stopTime": "14:00"
}

{
    "object": {
        "lessonProgramId": 320,
        "startTime": "13:00:00",
        "stopTime": "14:00:00",
        "lessonName": [
            {
                "lessonId": 75,
                "lessonName": "Musik",
                "creditScore": 5,
                "compulsory": true
            }
        ],
        "day": "MONDAY"
    },
    "message": "Created Lesson Program",
    "httpStatus": "CREATED"
}
         */

        spec.pathParams("first", "lessonPrograms", "second", "save");
        obj = new LessonProgramTestData();
        lessonsId = new ArrayList<>();
        lessonsId.add(75);
        expectedData = obj.expectedData("MONDAY","1",lessonsId, "13:00", "14:00");
        response =  given(spec).when().body(expectedData).post("{first}/{second}");
        response.prettyPrint();

        jsonPath = response.jsonPath();
        lessonProgramId = jsonPath.getInt("object.lessonProgramId");
        System.out.println(lessonProgramId);
    }

    @Given("Vice DeanAy sends get request for lesson program")
    public void vice_dean_ay_sends_get_request_for_lesson_program() {

        spec.pathParams("first", "lessonPrograms", "second","getAllUnassigned");
        response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
    }
    @Then("Vice DeanAy gets the response and verify")
    public void vice_dean_ay_gets_the_response_and_verify() {
        /*
        [
    {
        "lessonProgramId": 251,
        "startTime": "12:12:00",
        "stopTime": "15:15:00",
        "lessonName": [
            {
                "lessonId": 26,
                "lessonName": "FranceBiologie",
                "creditScore": 21,
                "compulsory": true
            }
        ],
        "teachers": [],
        "students": [],
        "day": "SUNDAY"
    },
    {
         */

        jsonPath = response.jsonPath();
        List<String> startTime = jsonPath.getList("findAll{it.lessonProgramId=="+lessonProgramId+"}.startTime");
        System.out.println("startTime = " + startTime);
        Assert.assertEquals(expectedData.get("startTime"),startTime.get(0).substring(0,5));

        List<String> stopTime = jsonPath.getList("findAll{it.lessonProgramId=="+lessonProgramId+"}.stopTime");
        System.out.println("stopTime = " + stopTime);
        Assert.assertEquals(expectedData.get("stopTime"),stopTime.get(0).substring(0,5));

        List<String> day = jsonPath.getList("findAll{it.lessonProgramId=="+lessonProgramId+"}.day");
        System.out.println("day = " + day);
        Assert.assertEquals(expectedData.get("day"),day.get(0));
        
        List<Integer> lessonId = jsonPath.getList("findAll{it.lessonProgramId=="+lessonProgramId+"}.lessonName.lessonId");
        System.out.println("lessonId = " + lessonId);

        Assert.assertEquals(expectedData.get("lessonIdList"), lessonId.get(0)); //lessonId = [[75]]
    }

    @Given("Vice DeanAy sends delete request for lesson program")
    public void vice_dean_ay_sends_delete_request_for_lesson_program() {

        spec.pathParams("first","lessonPrograms","second","delete","third",lessonProgramId);
        response = given(spec).when().delete("/{first}/{second}/{third}");
        response.prettyPrint();
    }
    @Then("Vice DeanAy gets the response and verify status code should be {int}")
    public void vice_dean_ay_gets_the_response_and_verify_status_code_should_be(int statusCode) {

/*
{
    "message": "Lesson Program Deleted",
    "httpStatus": "OK"
}
 */

        Map<String, String> expectedDelete = new HashMap<>();
        expectedDelete.put("message", "Lesson Program Deleted");
        expectedDelete.put("httpStatus", "OK");
        
        Map<String, String> actualData = ObjectMapperUtils.convertJsonToJawa(response.asString(),HashMap.class);
        System.out.println("actualData = " + actualData);
        
        Assert.assertEquals(expectedDelete.get("message"), actualData.get("message"));
        Assert.assertEquals(expectedDelete.get("httpStatus"), actualData.get("httpStatus"));
        
        Assert.assertEquals(statusCode,response.getStatusCode());


    }
}
