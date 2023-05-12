package stepdefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.MeetPojo;
import pojos.MeetResponsePojo;
import testdata.MeetTestData;
import utilities.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TeacherAddMeetAPIStepDef {
    /*
   {
  "date": "2023-05-05",
  "description": "Abwesenheit",
  "startTime": "09:00",
  "stopTime": "10:00",
  "studentIds": [
    6
  ]
}
     */


    /*
    {
    "object": {
        "id": 5,
        "description": "Abwesenheit",
        "date": "2023-05-05",
        "startTime": "09:00:00",
        "stopTime": "10:00:00",
        "advisorTeacherId": 8,
        "teacherName": "Nihal",
        "teacherSsn": "123-54-3478",
        "students": [
            {
                "id": 6,
                "username": "idil03",
                "ssn": "369-47-8523",
                "name": "idil",
                "surname": "Bksgn",
                "birthDay": "2007-01-01",
                "birthPlace": "istanbul",
                "phoneNumber": "555-755-1485",
                "gender": "FEMALE",
                "motherName": "nihal",
                "fatherName": "hakan",
                "studentNumber": 1004,
                "email": "idil@hotmail.com",
                "active": true
            }
        ]
    },
    "message": "Meet Saved Successfully",
    "httpStatus": "CREATED"
}
     */
    MeetPojo expectedData;
    Response response;
    int gun = Faker.instance().number().numberBetween(10, 28);
    int ay = Faker.instance().number().numberBetween(10, 12);
    String date = "2023-" + ay + "-" + gun + "";
    String pastDate= "2022"+ay +"-"+ gun + "";
    int start = Faker.instance().number().numberBetween(10, 22);
    int stop = start + 1;
    String startTime = "" + start + ":00";
    String stopTime = "" + stop + ":00";
    //List<Integer> studentIDs;
    MeetPojo studentID;
    MeetTestData expected;


    @Given("UserNhl sets the url")
    public void user_nhl_sets_the_url() {
        spec.pathParams("first", "meet", "second", "save");
    }

    @When("UserNhl sends post request")
    public void user_nhl_sends_post_request() {
        //set the expected Data
        studentID=new MeetPojo();
        studentID.setStudentIds(new ArrayList<>());
        studentID.getStudentIds().add(6);
//        studentIDs=new ArrayList<>();
//        studentIDs.add(6);
        expectedData = new MeetPojo(date, "Abwesenheit", startTime, stopTime, studentID.getStudentIds());

        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }

    @And("UserNhl verifys that the status code is {int}")
    public void usernhlVerifysThatTheStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());

    }

    @Then("UserNhl asserts response body")
    public void usernhlAssertsResponseBody() {

        //1.Validation
        response.then().body("object.description", equalTo("Abwesenheit"),
                "object.date", equalTo(date), "object.startTime.substring(0,5)", equalTo(startTime),
                "object.stopTime.substring(0,5)", equalTo(stopTime), "object.students.get(0).id",equalTo(6));

        //2.Validation
        MeetResponsePojo actualData = ObjectMapperUtils.convertJsonToJawa(response.asString(), MeetResponsePojo.class);
        System.out.println("actualData = " + actualData);

        Assert.assertEquals(expectedData.getDate(), actualData.getObject().getDate());
        Assert.assertEquals(expectedData.getDescription(), actualData.getObject().getDescription());
        Assert.assertEquals(expectedData.getStartTime(), actualData.getObject().getStartTime().substring(0,5));
        Assert.assertEquals(expectedData.getStopTime(), actualData.getObject().getStopTime().substring(0,5));
        List<Integer> id = new ArrayList<>();
        id.add(actualData.getObject().getStudents().get(0).getId());
        Assert.assertEquals(expectedData.getStudentIds(), id);

        //3.Validation
        JsonPath jsonPath= response.jsonPath();
        Assert.assertEquals(expectedData.getDate(),jsonPath.getString("object.date"));
        Assert.assertEquals(expectedData.getDescription(),jsonPath.getString("object.description"));
        Assert.assertEquals(expectedData.getStartTime(),jsonPath.getString("object.startTime.substring(0,5)"));
        Assert.assertEquals(expectedData.getStopTime(),jsonPath.getString("object.stopTime.substring(0,5)"));
        Assert.assertEquals(expectedData.getStudentIds(),id);

        //4.Validation

        expected=new MeetTestData();
        Map<Object,Object> expectedDataMAp=expected.MeetExpectedData(date,"Abwesenheit",startTime,stopTime,6);

        Map<String,Object> actualMap= ObjectMapperUtils.convertJsonToJawa(response.asString(), HashMap.class);
        Assert.assertEquals(expectedDataMAp.get("date"),((Map)actualMap.get("object")).get("date"));




    }

    @When("UserNhl sends a post request for a past date")
    public void usernhlSendsAPostRequestForAPastDate() {
        studentID=new MeetPojo();
        studentID.setStudentIds(new ArrayList<>());
        studentID.getStudentIds().add(6);
        expectedData = new MeetPojo(pastDate, "Abwesenheit", startTime, stopTime, studentID.getStudentIds());

        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @When("UserNhl sends a post request leaving the date field blank")
    public void usernhlSendsAPostRequestLeavingTheDateFieldBlank() {
        studentID=new MeetPojo();
        studentID.setStudentIds(new ArrayList<>());
        studentID.getStudentIds().add(6);
        expectedData = new MeetPojo("", "Abwesenheit", startTime, stopTime, studentID.getStudentIds());

        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @When("UserNhl sends a post request leaving the StartTime field blank")
    public void usernhlSendsAPostRequestLeavingTheStartTimeFieldBlank() {
        studentID=new MeetPojo();
        studentID.setStudentIds(new ArrayList<>());
        studentID.getStudentIds().add(6);
        expectedData = new MeetPojo(date, "Abwesenheit", "", stopTime, studentID.getStudentIds());

        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @When("UserNhl sends a post request leaving the StopTime field blank")
    public void usernhlSendsAPostRequestLeavingTheStopTimeFieldBlank() {
        studentID=new MeetPojo();
        studentID.setStudentIds(new ArrayList<>());
        studentID.getStudentIds().add(6);
        expectedData = new MeetPojo(date, "Abwesenheit", startTime, "", studentID.getStudentIds());

        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @When("UserNhl sends a post request leaving the Description field blank")
    public void usernhlSendsAPostRequestLeavingTheDescriptionFieldBlank() {
        studentID=new MeetPojo();
        studentID.setStudentIds(new ArrayList<>());
        studentID.getStudentIds().add(6);
        expectedData = new MeetPojo(date, "", startTime, stopTime, studentID.getStudentIds());

        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @When("UserNhl sends post request on the same day and time")
    public void usernhlSendsPostRequestOnTheSameDayAndTime() {
        studentID=new MeetPojo();
        studentID.setStudentIds(new ArrayList<>());
        studentID.getStudentIds().add(6);
        expectedData = new MeetPojo("2023-05-10", "Abwesenheit", "10:00", "11:00", studentID.getStudentIds());

        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }
}