package stepdefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.*;
import utilities.ObjectMapperUtils;

import java.util.ArrayList;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ViceDeanTeacherUpdateAPIStepDef {

    US13TeacherExpectedData expectedData;
    US13TeacherExpectedData lessonid;
    US13TeacherObjectPojo objectTeacher;
    US13TeacherActualPojo actuelData;

   static Response response;



    @Given("Userz sets the url for get request")
    public void userz_sets_the_url_for_get_request() {
        //set the url
        spec.pathParams("first","teachers","second","getSavedTeacherById","third","21");
    }
    @When("Userz sends a GET request")
    public void userz_sends_a_get_request() {

        //set the expected data
        objectTeacher = new US13TeacherObjectPojo(21, "Misal", "Mina",
                "Unsal", "2000-12-12", "554-87-6079", "istanbul", "786-666-4538",
                "FEMALE",
                "mina@hotmail.com");
        actuelData= new US13TeacherActualPojo(objectTeacher,"Teacher successfully found","OK");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        response = given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();}
        @Then("Userz verifies teacher response body")
    public void userz_verifies_teacher_response_body() {
        //do assertion
        US13TeacherActualPojo actueldata=ObjectMapperUtils.convertJsonToJawa(response.asString(), US13TeacherActualPojo.class);
            System.out.println("actueldata = " + actueldata);
            assertEquals(200, response.getStatusCode());
            assertEquals(objectTeacher.getUsername(),actueldata.getObject().getUsername());
            assertEquals(objectTeacher.getName(),actueldata.getObject().getName());
            assertEquals(objectTeacher.getSurname(),actueldata.getObject().getSurname());
            assertEquals(objectTeacher.getBirthDay(),actueldata.getObject().getBirthDay());
            assertEquals(objectTeacher.getSsn(),actueldata.getObject().getSsn());
            assertEquals(objectTeacher.getBirthPlace(),actueldata.getObject().getBirthPlace());
            assertEquals(objectTeacher.getPhoneNumber(),actueldata.getObject().getPhoneNumber());
            assertEquals(objectTeacher.getGender(),actueldata.getObject().getGender());
            assertEquals(objectTeacher.getEmail(),actueldata.getObject().getEmail());


            assertEquals("Teacher successfully found",actueldata.getMessage());
            assertEquals("OK",actueldata.getHttpStatus());

        }
    @Given("Userz sets the url for put request")
    public void userz_sets_the_url_for_put_request() {
        //Set the URL
        spec.pathParams("first", "teachers", "second","update","third","21");
    }
    @When("Userz sends a PUT request")
    public void userz_sends_a_put_request() {
        lessonid=new US13TeacherExpectedData();


        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,3);
        lessonid.getLessonsIdList().add(1,5);





        //Set the expected data
        expectedData= new US13TeacherExpectedData("2000-12-12","istanbul","mina@hotmail.com","FEMALE",true,lessonid.getLessonsIdList()
                ,
               "Mina","12345678","786-666-4538","554-87-6079","Unsal","Misal");

        System.out.println("expectedData = " + expectedData);



        //Send the request and get the response
        Response response = given().spec(spec).when().body(expectedData).put("/{first}/{second}/{third}");
        response.prettyPrint();
    }

    @Then("Userz verifies teacher response body voor positive update")
    public void userz_verifies_teacher_response_body_voor_positive_update() {
        objectTeacher = new US13TeacherObjectPojo(21, "Misal","Mina", "Unsal",
                "2000-12-12", "554-87-6079","istanbul", "786-666-4538",
                "FEMALE",
                "mina@hotmail.com");
        actuelData= new US13TeacherActualPojo(objectTeacher,"Teacher updated Successful","OK");
        System.out.println("actuelData = " + actuelData);

        assertEquals(200, response.getStatusCode());

        assertEquals(objectTeacher.getUsername(),actuelData.getObject().getUsername());
        assertEquals(objectTeacher.getName(),actuelData.getObject().getName());
        assertEquals(objectTeacher.getSurname(),actuelData.getObject().getSurname());
        assertEquals(objectTeacher.getBirthDay(),actuelData.getObject().getBirthDay());
        assertEquals(objectTeacher.getSsn(),actuelData.getObject().getSsn());
        assertEquals(objectTeacher.getBirthPlace(),actuelData.getObject().getBirthPlace());
        assertEquals(objectTeacher.getPhoneNumber(),actuelData.getObject().getPhoneNumber());
        assertEquals(objectTeacher.getGender(),actuelData.getObject().getGender());
        assertEquals(objectTeacher.getEmail(),actuelData.getObject().getEmail());
        assertEquals("Teacher updated Successful",actuelData.getMessage());
        assertEquals("OK",actuelData.getHttpStatus());





    }
    @When("Userz sends update request without choose lessons dropdown")
    public void userz_sends_update_request_without_choose_lessons_dropdown() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        //Set the expected data
        expectedData= new US13TeacherExpectedData("2000-12-12","istanbul","mina@hotmail.com","FEMALE",true,lessonid.getLessonsIdList()
                ,
                "Mina","12345678","786-666-4538","554-87-6079","Unsal","Misal");

        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}/{third}");
        response.prettyPrint();
   }

    @Then("Userz verifies that HTTP Status Code is {int}")
    public void userz_verifies_that_http_status_code_is(Integer int1) {
        Assert.assertEquals(405,response.statusCode());
    }
    @When("Userz sends update request without name")
    public void userz_sends_update_request_without_name() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,3);
        lessonid.getLessonsIdList().add(1,5);

//        //Set the expected data
        expectedData= new US13TeacherExpectedData("2000-12-12","istanbul","mina@hotmail.com","FEMALE",true,lessonid.getLessonsIdList()
                ,
                "","12345678","786-666-4538","554-87-6079","Unsal","Misal");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}/{third}");
        response.prettyPrint();
        }
    @When("Userz sends update without password")
    public void userz_sends_update_without_password() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,3);
        lessonid.getLessonsIdList().add(1,5);

        expectedData= new US13TeacherExpectedData("2000-12-12","istanbul","mina@hotmail.com","FEMALE",true,lessonid.getLessonsIdList()
                , "Mina","","786-666-4538","554-87-6079","Unsal","Misal");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}/{third}");
        response.prettyPrint();

    }
        @When("Userz sends update without gender")
        public void userz_sends_update_without_gender() {
            lessonid=new US13TeacherExpectedData();
            lessonid.setLessonsIdList(new ArrayList<>());
            lessonid.getLessonsIdList().add(0,3);
            lessonid.getLessonsIdList().add(1,5);
            expectedData= new US13TeacherExpectedData("2000-12-12","istanbul","mina@hotmail.com","",true,lessonid.getLessonsIdList()
                    ,
                    "Mina","12345678","786-666-4538","554-87-6079","Unsal","Misal");

            System.out.println("expectedData = " + expectedData);
            //send the request get the response
            response= given(spec).when().body(expectedData).post("/{first}/{second}/{third}");
            response.prettyPrint();
        }

    }




