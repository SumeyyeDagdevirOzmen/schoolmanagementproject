package stepdefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import testdata.LessonProgramTestData;
import utilities.ObjectMapperUtils;

import java.util.*;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ViceDeanAssignsLessonTeacherAPIStepDef {
    Response response;
    Map<String, Object> expectedData;
    LessonProgramTestData obj;
    int start = Faker.instance().number().numberBetween(10, 22);
    int stop = start + 1;
    String startTime = "" + start + ":00";
    String stopTime = "" + stop + ":00";
    static int lessonProgramId;


    @Given("Vice DeanAy sends Post request for lesson program list")
    public void vice_dean_ay_sends_post_request_for_lesson_program_list() {
        //http://164.92.252.42:8080/lessonPrograms/save
        spec.pathParams("first","lessonPrograms","second","save");
        List<Integer> lessonId = new ArrayList<>();
        lessonId.add(4);
        Map<String,Object> expectedAY = new HashMap<>();
        expectedAY.put("day","MONDAY");
        expectedAY.put("educationTermId",2);
        expectedAY.put("lessonIdList",lessonId);
        expectedAY.put("startTime",startTime);
        expectedAY.put("stopTime",stopTime);
        System.out.println("expectedAY = " + expectedAY);
        response = given(spec).when().body(expectedAY).post("/{first}/{second}");
        response.prettyPrint();
        lessonProgramId =response.jsonPath().getInt("object.lessonProgramId");
        System.out.println("lessonProgramId = " + lessonProgramId);

    }
    @Then("Vice DeanAy gets the response and verify lesson")
    public void vice_dean_ay_gets_the_response_and_verify_lesson() {
        assertEquals(200,response.statusCode());
    }



    @Given("ViceDeanAy sends get request for lessonsProgram")
    public void vice_dean_ay_sends_get_request_for_lessons_program() {
        //http://164.92.252.42:8080/lessonPrograms/getAll
       spec.pathParams("first","lessonPrograms","second","getAll");
        response = given(spec).when().get("/{first}/{second}");
        response.prettyPrint();

    }
    @Then("ViceDeanAy verifys must be seen lessonsprogram")
    public void vice_dean_ay_verifys_must_be_seen_lessonsprogram() {
        assertEquals(200,response.statusCode());
        List<Integer> id = response.jsonPath().getList("lessonProgramId");
       System.out.println("id = " + id);
       assertTrue(id.contains(lessonProgramId));



    }



    @Given("Vice DeanAy sends post request for choose the teacher to the lesson program")
    public void vice_dean_ay_sends_post_request_for_choose_the_teacher_to_the_lesson_program() {
        spec.pathParams("first","teachers","second","chooseLesson");
        List<Integer> lessonIdS = new ArrayList<>();
        lessonIdS.add(lessonProgramId);
        Map<String,Object> expected = new HashMap<>();
        expected.put("lessonProgramId",lessonIdS);
        expected.put("teacherId",411);
       response = given(spec).when().body(expected).post("/{first}/{second}");
       response.prettyPrint();

    }
    @Then("Vice DeanAy gets the response and verify teacher")
    public void vice_dean_ay_gets_the_response_and_verify_teacher() {
        assertEquals(411,response.jsonPath().getInt("object.userId"));

    }




    @Given("ViceDeanAy sends the delete request")
    public void vice_dean_ay_sends_the_delete_request() {
       // http://164.92.252.42:8080/lessonPrograms/delete/44
       spec.pathParams("first","lessonPrograms","second","delete","third",lessonProgramId);
       response = given(spec).when().delete("/{first}/{second}/{third}");
       response.prettyPrint();

    }
    @Then("ViceDeanAy must be verify statusCode {int}")
    public void vice_dean_ay_must_be_verify_status_code(Integer int1) {
        Map<String, String> expecteddelete = new HashMap<>();
        expecteddelete.put("message", "Lesson Program Deleted");
        expecteddelete.put("httpStatus", "OK");
        Map actueldelete = ObjectMapperUtils.convertJsonToJawa(response.asString(), HashMap.class);
        assertEquals(200,response.statusCode());
        Assert.assertEquals(expecteddelete.get("message"), actueldelete.get("message"));
        Assert.assertEquals(expecteddelete.get("httpStatus"), actueldelete.get("httpStatus"));

    }





}
