package stepdefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import testdata.MeetTestData;
import utilities.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static base_url.SchoolManagement_BaseUrl.spec;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class TeacherEditmeetingAPIStepDef {
    MeetTestData obj = new MeetTestData();
    Response response;
    static Faker faker = new Faker();
    static int gun = faker.number().numberBetween(10, 28);
    static int ay = faker.number().numberBetween(10, 12);
    static String date = "2024-" + ay + "-" + gun + "";
    static String description = faker.animal().name();
    Map<String, Object> expectedDataPost;
    Map<String, Object> object;
    JsonPath jsonPath;
    static int id;//toplanti id si


    @Given("user20_Set_the_url")
    public void user20_set_the_url() {

        //set the url
        spec.pathParams("first", "meet", "second", "save");

    }

    @When("user20_send POST Request to the Url")
    public void user20_send_post_request_to_the_url() {//ilk once editleyip silebilecegimiz bir meet postu yapiyoruz
        //set the expected data
        /*
        {
      "date": "2024-06-30",
      "description": "Materyal",
      "startTime": "16:00",
      "stopTime": "17:00",
      "studentIds": [
          130,

       ]
        }
         */

        List<Integer> stId = new ArrayList<>();
        stId.add(41);
        expectedDataPost = new HashMap<>();
        expectedDataPost.put("date", date);
        expectedDataPost.put("description", "Materyal");
        expectedDataPost.put("startTime", "16:00");
        expectedDataPost.put("stopTime", "17:00");
        expectedDataPost.put("studentIds", stId);

        response = given(spec).when().body(expectedDataPost).post("/{first}/{second}");
        response.prettyPrint();
        response.then().statusCode(200);
        jsonPath = response.jsonPath();
        id = jsonPath.getInt("object.id");
        System.out.println("id = " + id);


    }

    @Given("s2.user20 set the url for get")
    public void user20_set_the_url_for_get() {

        spec.pathParams("premier", "meet", "deuxiem", "getMeetById", "third", id);


    }

    @When("s2.user20 sends a GET Request to the Url")
    public void user20_sends_a_get_request_to_the_url() {
        response = given(spec).when().get("/{premier}/{deuxiem}/{third}");
        response.prettyPrint();


    }

    @Then("s2.for user20 HTTP Status Code Should be {int}")
    public void for_user20_http_status_code_should_be(Integer int1) {
        response.then().statusCode(200);


    }

    @Then("s2.Response body should be like;")
    public void s2_response_body_should_be_like() {
        /*
         {
    "object": {
        "id": 31,
        "description": "Materyal",
        "date": "2024-10-30",
        "startTime": "17:30:00",
        "stopTime": "18:00:00",
        "advisorTeacherId": 8,
        "teacherName": "Nihal",
        "teacherSsn": "123-54-3478",
        "students": [
            {
                "id": 41,
                "username": "mehmetcan",
                "ssn": "333-22-9999",
                "name": "mehmet",
                "surname": "can",
                "birthDay": "2010-02-01",
                "birthPlace": "almanya",
                "phoneNumber": "111-222-9999",
                "gender": "MALE",
                "motherName": "ayse",
                "fatherName": "ali",
                "studentNumber": 1039,
                "email": "team08@gmail.com",
                "active": true
            }
        ]
    },
    "message": "Meet successfully found",
    "httpStatus": "CREATED"
}
         */


        //1. yol
        response.then().body("object.description", equalTo("Materyal"),
                "object.date", equalTo(date), "object.startTime", equalTo("16:00:00"),
                "object.stopTime", equalTo("17:00:00"), "object.advisorTeacherId", equalTo(8));
        //2. yol
         object = obj.object(id, "Materyal", date, "16:00", "17:00", obj.students());
        Map<String, Object> expecteddata = obj.meetData(object,"Meet successfully found", "CREATED");


        Map<String, Object> actualData = ObjectMapperUtils.convertJsonToJawa(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(object.get("id"),((Map) actualData.get("object")).get("id"));
        String starttime= ((String)((Map) actualData.get("object")).get("startTime"));//16:00:00
        Assert.assertEquals(object.get("startTime"), starttime.substring(0,5));
        String stoptime= ((String)((Map) actualData.get("object")).get("stopTime"));//17:00:00
        Assert.assertEquals(object.get("stopTime"),stoptime.substring(0,5));
        Assert.assertEquals(object.get("description"),((Map) actualData.get("object")).get("description"));
        Assert.assertEquals(object.get("date"),((Map) actualData.get("object")).get("date"));
        Assert.assertEquals((((Map) ((List) ((Map) expecteddata.get("object")).get("students")).get(0)).get("id")), (((Map) ((List) ((Map) actualData.get("object")).get("students")).get(0)).get("id")));
        Assert.assertEquals((((Map) ((List) ((Map) expecteddata.get("object")).get("students")).get(0)).get("username")), (((Map) ((List) ((Map) actualData.get("object")).get("students")).get(0)).get("username")));
        Assert.assertEquals(expecteddata.get("message"), actualData.get("message"));
        Assert.assertEquals(expecteddata.get("httpStatus"), actualData.get("httpStatus"));


    }

    @Given("s3.user20 set the url for update")
    public void s3_user20_set_the_url_for_update() {
        spec.pathParams("first", "meet", "second", "update", "third", id);

    }

    @When("s3.user20 sends a PUT Request to the Url")
    public void s3_user20_sends_a_put_request_to_the_url() {
        Map<String, Object> expectedput = obj.postOrPutData(date, description, "16:00", "17:00");
        response = given(spec).when().body(expectedput).put("/{first}/{second}/{third}");

    }

    @Then("s3.for user20 Http Status Code Should be {int}")
    public void s3_for_user20_http_status_code_should_be(Integer int1) {//bug description editlenemiyor
        response.then().statusCode(int1);

    }

    @Then("s3.Response body should be like:")
    public void s3_response_body_should_be_like() {


    }

    @Given("s4.user20 set the url for update")
    public void s4_user20_set_the_url_for_update() {
        spec.pathParams("first", "meet", "second", "update", "third", id);

    }

    @When("s4.user20 sends a PUT Request to the Url")
    public void s4_user20_sends_a_put_request_to_the_url() {


        Map<String, Object> expectedput = obj.postOrPutData("2025-07-05", "Materyal", "16:00", "17:00");
        response = given(spec).when().body(expectedput).put("/{first}/{second}/{third}");
        response.prettyPrint();


    }

    @Then("s4.for user20 Http Status Code Should be {int}")
    public void s4_for_user20_http_status_code_should_be(Integer int1) {
        response.then().statusCode(int1);
    }

    @Then("s4.Response body should be like:")
    public void s4_response_body_should_be_like() {
        object = obj.object(id, "Materyal", "2025-07-05", "16:00", "17:00", obj.students());
        Map<String, Object> expectedupdate = obj.meetData(object,"Meet Updated Successfully", "OK");



        Map<String, Object> actualData = ObjectMapperUtils.convertJsonToJawa(response.asString(), HashMap.class);
        Assert.assertEquals(object.get("id"),((Map) actualData.get("object")).get("id"));
       String starttime= ((String)((Map) actualData.get("object")).get("startTime"));//16:00:00
        Assert.assertEquals(object.get("startTime"), starttime.substring(0,5));
        String stoptime= ((String)((Map) actualData.get("object")).get("stopTime"));//17:00:00
        Assert.assertEquals(object.get("stopTime"),stoptime.substring(0,5));
        Assert.assertEquals(object.get("description"),((Map) actualData.get("object")).get("description"));
        Assert.assertEquals(object.get("date"),((Map) actualData.get("object")).get("date"));
        Assert.assertEquals((((Map) ((List) ((Map) expectedupdate.get("object")).get("students")).get(0)).get("id")), (((Map) ((List) ((Map) actualData.get("object")).get("students")).get(0)).get("id")));
        Assert.assertEquals((((Map) ((List) ((Map) expectedupdate.get("object")).get("students")).get(0)).get("username")), (((Map) ((List) ((Map) actualData.get("object")).get("students")).get(0)).get("username")));
        Assert.assertEquals(expectedupdate.get("message"), actualData.get("message"));
        Assert.assertEquals(expectedupdate.get("httpStatus"), actualData.get("httpStatus"));




    }

    @Given("s5.user20 set the url for update time")
    public void s5_user20_set_the_url_for_update_time() {
        spec.pathParams("first", "meet", "second", "update", "third", id);


    }

    @When("s5.user20 sends a PUT Request to the Url")
    public void s5_user20_sends_a_put_request_to_the_url() {
        Map<String, Object> expectedput = obj.postOrPutData("2025-07-05", "Materyal", "14:00", "15:00");
        response = given(spec).when().body(expectedput).put("/{first}/{second}/{third}");
        response.prettyPrint();


    }

    @Then("s5.for user20 Http Status Code Should be {int}")
    public void s5_for_user20_http_status_code_should_be(Integer int1) {
        response.then().statusCode(int1);


    }

    @Then("s5.Response body should be like:")
    public void s5_response_body_should_be_like() {
        object = obj.object(id, "Materyal", "2025-07-05", "14:00", "15:00", obj.students());
        Map<String, Object>expectedupdate = obj.meetData(object,"Meet Updated Successfully", "OK");



        Map<String, Object> actualData = ObjectMapperUtils.convertJsonToJawa(response.asString(), HashMap.class);
        Assert.assertEquals(object.get("id"),((Map) actualData.get("object")).get("id"));
        String starttime= ((String)((Map) actualData.get("object")).get("startTime"));//16:00:00
        Assert.assertEquals(object.get("startTime"), starttime.substring(0,5));
        String stoptime= ((String)((Map) actualData.get("object")).get("stopTime"));//17:00:00
        Assert.assertEquals(object.get("stopTime"),stoptime.substring(0,5));
        Assert.assertEquals(object.get("description"),((Map) actualData.get("object")).get("description"));
        Assert.assertEquals(object.get("date"),((Map) actualData.get("object")).get("date"));
        Assert.assertEquals((((Map) ((List) ((Map) expectedupdate.get("object")).get("students")).get(0)).get("id")), (((Map) ((List) ((Map) actualData.get("object")).get("students")).get(0)).get("id")));
        Assert.assertEquals((((Map) ((List) ((Map) expectedupdate.get("object")).get("students")).get(0)).get("username")), (((Map) ((List) ((Map) actualData.get("object")).get("students")).get(0)).get("username")));
        Assert.assertEquals(expectedupdate.get("message"), actualData.get("message"));
        Assert.assertEquals(expectedupdate.get("httpStatus"), actualData.get("httpStatus"));

    }

    @Given("s.user20 set the url for delete meet")
    public void s_user20_set_the_url_for_delete_meet() {
        spec.pathParams("first", "meet", "second", "delete", "third", id);
        response = given(spec).when().delete("/{first}/{second}/{third}");
        response.prettyPrint();

    }

    @Then("s.for user20 HTTP Status Code Should be {int}")
    public void s_for_user20_http_status_code_should_be(Integer int3) {
        response.then().statusCode(int3);

    }

    @Then("s.Response body should be like;")
    public void s_response_body_should_be_like() {
         /*
    {
        "message": "Meet deleted successfully ",
        "httpStatus": "OK"
    }
     */
        Map<String, String> expecteddelete = new HashMap<>();
        expecteddelete.put("message", "Meet deleted successfully ");
        expecteddelete.put("httpStatus", "OK");
        Map actueldelete = ObjectMapperUtils.convertJsonToJawa(response.asString(), HashMap.class);
        Assert.assertEquals(expecteddelete.get("message"), actueldelete.get("message"));
        Assert.assertEquals(expecteddelete.get("httpStatus"), actueldelete.get("httpStatus"));

    }


}


