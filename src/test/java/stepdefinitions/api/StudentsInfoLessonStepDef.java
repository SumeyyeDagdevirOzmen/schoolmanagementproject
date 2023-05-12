package stepdefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.hasItem;

public class StudentsInfoLessonStepDef {

    Response response;
    JsonPath jsonPath;
    int id;


    int start = Faker.instance().number().numberBetween(10, 22);

    Faker faker = new Faker();

    LocalDate startDate = LocalDate.now().with(DayOfWeek.MONDAY);
    LocalDate endDate = startDate.plusDays(6);

    long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
    LocalDate randomDate = startDate.plusDays(faker.random().nextInt((int) daysBetween + 1));
    DayOfWeek randomDayOfWeek = randomDate.getDayOfWeek();


    int stop = start + 1;
    String startTime = "" + start + ":00";
    String stopTime = "" + stop + ":00";
    static int lessonProgramId;




    @Given("s1.user21 set the url for get")
    public void s1_user21_set_the_url_for_get() {
        //set the url
        spec.pathParams("first", "lessonPrograms", "second", "getAllLessonProgramByStudent");
    }

    @When("s1.user201 sends a GET Request to the Url")
    public void s1_user201sends_a_get_request_to_the_url() {

        response = given(spec).when().get("/{first}/{second}");
        response.prettyPrint();
    }

    @Then("s1.for user21 Http Status Code Should be {int}")
    public void s1_for_user21_http_status_code_should_be(Integer int1) {
        Assert.assertEquals(200,response.statusCode());
    }

    @Then("s1.for user21 Response body should be like;")
    public void s1_for_user21_response_body_should_be_like() {


        List<String> startTime= response.jsonPath().getList("findAll{it.lessonProgramId==2}.startTime");
        System.out.println("startTime : " +startTime);
        String expectedStartTime = "10:00:00";

        Assert.assertTrue(startTime.contains(expectedStartTime));

        List<String> stopTime= response.jsonPath().getList("findAll{it.lessonProgramId==2}.stopTime");
        System.out.println("stopTime :" + stopTime);
        String expectedStopTime = "12:00:00";
        Assert.assertTrue(stopTime.contains(expectedStopTime));

         List<String>less= response.jsonPath().getList("lessonName.lessonName[0]");
         System.out.println("less = " + less);
         Assert.assertTrue(less.size() != 0);


        List<String>teacherName= response.jsonPath().getList("teachers.name.");
        System.out.println("teacherName = " + teacherName);
        Assert.assertTrue(teacherName.size() != 0);

//        List<List<String>>teachersname= response.jsonPath().getList("teachers.name.");
//        System.out.println("teachersName = " + teachersname);
//        Assert.assertTrue(teachersname.get(0).contains("ayse"));


        List<String> day= response.jsonPath().getList("findAll{it.lessonProgramId==2}.day");
        System.out.println("day = " + day);
        Assert.assertTrue(day.size() != 0);


//List<String>lessonname=  response.jsonPath().getList("findAll{it.lessonName.findAll{it.lessonName=='CALCULUS'}}.lessonName");

        //      List< String> expectedLessonName = new ArrayList<>(Arrays.asList("CYPRESS"));
//        Assert.assertTrue(less.contains(expectedLessonName));


//      List<String>teachersname=  response.jsonPath().getList("findAll{it.teachers.findAll{it.userId==8}}.name");


//       //  String expctisim="yasemin";
//
//
////       List< String> expectedTeacherName = new ArrayList<>(Arrays.asList("yasemin"));
////
////

////     //String expectedDay="TUESDAY";
////     Assert.assertTrue(day.contains(expectedDay));

        //response.then().body("lessonName.lessonName",equalTo("CALCULUS"));

  // JsonPath jsonPath1=  response.jsonPath();

   //Assert.assertEquals("CALCULUS",jsonPath1.getString(lessonName.lessonName));


       // System.out.println("teachername = " + teachername);


    }
    @Given("cr01.sends Post request for lesson program list")
    public void cr_sends_post_request_for_lesson_program_list() {

        spec.pathParams("first","lessonPrograms","second","save");
        List<Integer> lessonId = new ArrayList<>();
        lessonId.add(4);
        Map<String,Object> expectedAY = new HashMap<>();
        expectedAY.put("day",randomDayOfWeek);
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
    @Then("cr01.gets the response and verify lesson")
    public void cr_gets_the_response_and_verify_lesson() {
        Assert.assertEquals(200,response.statusCode());
    }


    @Given("s2.user21 set the url for post")
    public void s2_user21_set_the_url_for_post() {
        spec.pathParams("first", "students", "second", "chooseLesson");
    }
    @When("s2.user21 sends a POST Request to the Url")
    public void s2_user21_sends_a_post_request_to_the_url() {
        Map<String,Object> expectedobject= new HashMap<>();  // burda gonderecegim datalari map e ceviriyorum
        List<Integer> dersId=new ArrayList<>();
        dersId.add(lessonProgramId);

        expectedobject.put("lessonProgramId",dersId);

        response = given(spec).when().body(expectedobject).post("/{first}/{second}");
        response.prettyPrint();


    }
    @Then("s2.for user21 HTTP Status Code Should be {int}")
    public void s2_for_user21_http_status_code_should_be(Integer int1) {
        Assert.assertEquals(200,response.statusCode());
    }
    @Then("s2.for {int} Response body should be like;")
    public void s2_for_response_body_should_be_like(Integer int1) {

        US25_StudentResponseDataPojo object =new US25_StudentResponseDataPojo("idil03","idil","Bksgn","2007-01-01","istanbul","555-755-1485","FEMALE","nihal","hakan","idil@hotmail.com",true,6,1004);
        US21Pojos actualData=new US21Pojos(object,"Lesson added to Student","CREATED");

        System.out.println("actualdata = " + actualData);

        Assert.assertEquals(200,response.statusCode());

        Assert.assertEquals(object.getUsername(), actualData.getObject().getUsername());
        Assert.assertEquals(object.getName(), actualData.getObject().getName());
        Assert.assertEquals(object.getSurname(), actualData.getObject().getSurname());
        Assert.assertEquals(object.getBirthDay(),actualData.getObject().getBirthDay());
        Assert.assertEquals(object.getStudentNumber(), actualData.getObject().getStudentNumber());
        Assert.assertEquals(object.getBirthPlace(), actualData.getObject().getBirthPlace());
        Assert.assertEquals(object.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        Assert.assertEquals(object.getGender(), actualData.getObject().getGender());
        Assert.assertEquals(object.getMotherName(),actualData.getObject().getMotherName());
        Assert.assertEquals(object.getFatherName(),actualData.getObject().getFatherName());
        Assert.assertEquals(object.getEmail(),actualData.getObject().getEmail());

        Assert.assertEquals("Lesson added to Student",actualData.getMessage());
        Assert.assertEquals("CREATED",actualData.getHttpStatus());


    }


    @Given("s3.user21 set the url for post")
    public void s3_user21_set_the_url_for_post() {
        spec.pathParams("first", "students", "second", "chooseLesson");

    }
    @When("s3.user201 sends POST Request to Url to select courses with the same time and day")
    public void s3_user201_sends_post_request_to_url_to_select_courses_with_the_same_time_and_day() {

        Map<String,Object> expectedobject= new HashMap<>();  // burda gonderecegim datalari map e ceviriyorum
        List<Integer> dersId=new ArrayList<>();
        dersId.add(532);
        dersId.add(533);

        expectedobject.put("lessonProgramId",dersId);

        response = given(spec).when().body(expectedobject).post("/{first}/{second}");
        response.prettyPrint();

    }
    @Then("s3.for user21 HTTP Status Code Should be {int}")
    public void s3_for_user21_http_status_code_should_be(Integer int1) {
        Assert.assertEquals(400,response.statusCode());


    }
    @Then("s3.for {int} Response body should be like;")
    public void s3_for_response_body_should_be_like(Integer int1) {


        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals("Error: Course schedule cannot be selected for the same hour and day",actualData.get("message"));


    }

    @Given("s4.user21 set the url for get")
    public void s4_user21_set_the_url_for_get() {
        id=6;

        spec.pathParams("premier", "studentInfo", "second", "getByStudentId", "third", id);
    }
    @When("s4.user201sends a GET Request to the Url")
    public void s4_user201sends_a_get_request_to_the_url() {
        response = given(spec).when().get("/{premier}/{second}/{third}");
        response.prettyPrint();
    }
    @Then("s4.for user21 Http Status Code Should be {int}")
    public void s4_for_user21_http_status_code_should_be(Integer int1) {
        response.then().statusCode(200);
    }
    @Then("s4.for user21 Response body should be like;")
    public void s4_for_user21_response_body_should_be_like() {
/*
[
    {
        "id": 407,
        "midtermExam": 21.0,
        "finalExam": 33.0,
        "absentee": 12,
        "infoNote": "basic note",
        "lessonName": "HEAT TRANSFER",
        "creditScore": 3,
        "educationTerm": "SPRING_SEMESTER",
        "average": 28.200000000000003,
        "studentResponse": {
            "userId": 6,
            "username": "idil03",
            "name": "idil",
            "surname": "Bksgn",
            "birthDay": "2007-01-01",
            "birthPlace": "istanbul",
            "phoneNumber": "555-755-1485",
            "gender": "FEMALE",
            "studentNumber": 1004,
            "motherName": "nihal",
            "fatherName": "hakan",
            "email": "idil@hotmail.com",
            "active": true
        },
        "compulsory": false,
        "note": "FF"
    },
 */

        List<Integer> getid= response.jsonPath().getList("findAll{it.studentResponse.userId==42}.id");
        System.out.println("getid = " + getid);
       // getId=getid.get(0);

        List<Integer>midtermExam=response.jsonPath().getList("findAll{it.id==407}.midtermExam");
        System.out.println("midtermExam = " + midtermExam);
        Assert.assertTrue(midtermExam.size() != 0);


        List<Integer>finalExam=response.jsonPath().getList("findAll{it.id==407}.finalExam");
        System.out.println("finalExam = " + finalExam);
        Assert.assertTrue(finalExam.size() != 0);



        List<Integer>absentee=response.jsonPath().getList("findAll{it.id==407}.absentee");
        System.out.println("absentee = " + absentee);
        Assert.assertTrue(absentee.size() != 0);


        List<Integer>infoNote=response.jsonPath().getList("findAll{it.id==407}.infoNote");
        System.out.println("infoNote = " + infoNote);
        Assert.assertTrue(infoNote.size() != 0);


        List<Integer>lessonName=response.jsonPath().getList("findAll{it.id==407}.lessonName");
        System.out.println("lessonName = " + lessonName);
        Assert.assertTrue(lessonName.size() != 0);


        List<Integer>note=response.jsonPath().getList("findAll{it.id==407}.note");
        System.out.println("note = " + note);
        Assert.assertTrue(note.size() != 0);


        List<Integer>average=response.jsonPath().getList("findAll{it.id==407}.average");
        System.out.println("average = " + average);
        Assert.assertTrue(average.size() != 0);



    }


    @Given("s5.user21 set the url for get")
    public void s5_user21_set_the_url_for_get() {
        spec.pathParams("premier", "meet", "second", "getAllMeetByStudent");
    }
    @When("s5.user201sends a GET Request to the Url")
    public void s5_user201sends_a_get_request_to_the_url() {

        response = given(spec).when().get("/{premier}/{second}");
        response.prettyPrint();


    }
    @Then("s5.for user21 Http Status Code Should be {int}")
    public void s5_for_user21_http_status_code_should_be(Integer int1) {
        response.then().statusCode(200);

    }
    @Then("s5.for user21 Response body should be like;")
    public void s5_for_user21_response_body_should_be_like() {


        List<Integer> description= response.jsonPath().getList("findAll{it.id==3}.description");
        System.out.println("description = " + description);
        Assert.assertTrue(description.size() != 0);


        List<Integer> date= response.jsonPath().getList("findAll{it.id==3}.date");
        System.out.println("date = " + date);
        Assert.assertTrue(date.size() != 0);

        List<Integer> startTime= response.jsonPath().getList("findAll{it.id==3}.startTime");
        System.out.println("startTime = " + startTime);
        Assert.assertTrue(startTime.size() != 0);

        List<Integer> stopTime= response.jsonPath().getList("findAll{it.id==3}.stopTime");
        System.out.println("stopTime = " + stopTime);
        Assert.assertTrue(stopTime.size() != 0);


    }



}













//List<String>lessonname=  response.jsonPath().getList("findAll{it.lessonName.findAll{it.lessonName=='CALCULUS'}}.lessonName");

    //      List< String> expectedLessonName = new ArrayList<>(Arrays.asList("CYPRESS"));
//        Assert.assertTrue(less.contains(expectedLessonName));


//       List<String>teachersname=  response.jsonPath().getList("findAll{it.teachers.findAll{it.userId==8}}.name");


//       //  String expctisim="yasemin";
//
//
////       List< String> expectedTeacherName = new ArrayList<>(Arrays.asList("yasemin"));
////
////

////     //String expectedDay="TUESDAY";
////     Assert.assertTrue(day.contains(expectedDay));

    //response.then().body("lessonName.lessonName",equalTo("CALCULUS"));

    // JsonPath jsonPath1=  response.jsonPath();

    //Assert.assertEquals("CALCULUS",jsonPath1.getString(lessonName.lessonName));


    // System.out.println("teachername = " + teachername);







