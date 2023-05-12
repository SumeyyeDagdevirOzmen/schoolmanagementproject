package stepdefinitions.api;

import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.StudentInfoExpectedPojo;
import pojos.StudentObjectPojo;
import pojos.StudentResponsePojo;
import utilities.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

//{---------Post-----
//        "object": {
//        "id": 27,
//        "midtermExam": 30.0,
//        "finalExam": 70.0,
//        "absentee": 3,
//        "infoNote": "basarili bir ogrenci",
//        "lessonName": "Postman",
//        "creditScore": 5,
//        "educationTerm": "SPRING_SEMESTER",
//        "average": 54.0,
//        "studentResponse": {
//                    "userId": 15,
//                    "username": "Ayse03",
//                    "name": "Ayse03",
//                    "surname": "Ayse",
//                    "birthDay": "1987-01-15",
//                    "birthPlace": "Paris",
//                    "phoneNumber": "643-546-6666",
//                    "gender": "FEMALE",
//                    "studentNumber": 1013,
//                    "motherName": "mama",
//                    "fatherName": "papa",
//                    "email": "ayse123@gmail.com",
//                    "active": true
//        },
//             "compulsory": true,
//             "note": "DD"
//        },
//        "message": "Student Info saved Successfully",
//        "httpStatus": "CREATED"
//        }
public class TeacherStudentInfoApiStepDef {

   static  Response response;
     StudentInfoExpectedPojo expectedPojo;
     StudentResponsePojo responseexpectedpojo;
     StudentObjectPojo   objectexpectedpojo;
    StudentObjectPojo actualdatapojo;




    static int id;
 //  static int getId;




    List<StudentObjectPojo> genelPojo=new ArrayList<>();

    @Given("userhatice set the url for Post")
    public void userhaticeSetTheUrlForPost() {
        spec.pathParams("first","studentInfo","second","save");
        expectedPojo=new StudentInfoExpectedPojo(3,1,70.0,"basarili bir ogrenci",3,30.0,42);
        response=given(spec).body(expectedPojo).post("/{first}/{second}");
        response.prettyPrint();
        id= response.jsonPath().getInt("object.id");


    }

    @Given("userhatice get the url")
    public void userhaticeGetTheUrl() {
        //{{baseUrl}}/studentInfo/getByStudentId/:studentId
        spec.pathParams("first","studentInfo","second","getByStudentId","third",42);
    }


    @When("userhatice send get request for Student info")
    public void userhaticeSendGetRequestForStudentInfo() {
        response=given(spec).get("/{first}/{second}/{third}");
        response.prettyPrint();

        responseexpectedpojo=new StudentResponsePojo(42,"Amine03","Amine","Amine","1987-01-15","Paris","346-546-7777","FEMALE",1040,"mama","papa","amine123@gmail.com",true);
        objectexpectedpojo=new StudentObjectPojo(id,30.0,70.0,3,"basarili bir ogrenci","JAVA",8,"SPRING_SEMESTER",54.0,responseexpectedpojo,false,"DD");
        List<Object> actuellData=new Gson().fromJson(response.asString(),ArrayList.class);
        System.out.println(actuellData);

       // List<Object> actuellData=  ObjectMapperUtils.convertJsonToJawa(response.asString(),ArrayList.class);

        double x=((double)((Map)actuellData.get(0)).get("id"));
        System.out.println("x = " + x);
        int actualID=(int) x;

        double absentee=((double)((Map)actuellData.get(0)).get("absentee"));
        System.out.println("absentee = " + absentee);
        int actualabsentee=(int) absentee;

        double creditscore=((double)((Map)actuellData.get(0)).get("creditScore"));
        System.out.println("creditscore = " + creditscore);
        int actualcreditscore=(int) creditscore;




        assertEquals(objectexpectedpojo.getId(), actualID);
        assertEquals(objectexpectedpojo.getMidtermExam(), ((Map) actuellData.get(0)).get("midtermExam"));
        assertEquals(objectexpectedpojo.getFinalExam(), ((Map) actuellData.get(0)).get("finalExam"));
        assertEquals(objectexpectedpojo.getAbsentee(), actualabsentee);
        assertEquals(objectexpectedpojo.getInfoNote(), ((Map) actuellData.get(0)).get("infoNote"));
        assertEquals(objectexpectedpojo.getLessonName(), ((Map) actuellData.get(0)).get("lessonName"));
        assertEquals(objectexpectedpojo.getCreditScore(), actualcreditscore);
        assertEquals(objectexpectedpojo.getEducationTerm(), ((Map) actuellData.get(0)).get("educationTerm"));
        assertEquals(objectexpectedpojo.getAverage(), ((Map) actuellData.get(0)).get("average"));

        double n = ((double) ((Map) ((Map) actuellData.get(0)).get("studentResponse")).get("userId"));
        int actualgetID = (int) n;

        double studentNumber = ((double) ((Map) ((Map) actuellData.get(0)).get("studentResponse")).get("studentNumber"));
        int actualstudentNumber = (int) studentNumber;


        assertEquals(responseexpectedpojo.getUserId(), actualgetID);
        assertEquals(responseexpectedpojo.getUsername(), ((Map) ((Map) actuellData.get(0)).get("studentResponse")).get("username"));
        assertEquals(responseexpectedpojo.getName(), ((Map) ((Map) actuellData.get(0)).get("studentResponse")).get("name"));
        assertEquals(responseexpectedpojo.getSurname(), ((Map) ((Map) actuellData.get(0)).get("studentResponse")).get("surname"));
        assertEquals(responseexpectedpojo.getBirthDay(), ((Map) ((Map) actuellData.get(0)).get("studentResponse")).get("birthDay"));
        assertEquals(responseexpectedpojo.getBirthPlace(), ((Map) ((Map) actuellData.get(0)).get("studentResponse")).get("birthPlace"));
        assertEquals(responseexpectedpojo.getPhoneNumber(), ((Map) ((Map) actuellData.get(0)).get("studentResponse")).get("phoneNumber"));
        assertEquals(responseexpectedpojo.getGender(), ((Map) ((Map) actuellData.get(0)).get("studentResponse")).get("gender"));
        assertEquals(responseexpectedpojo.getStudentNumber(), actualstudentNumber);
        assertEquals(responseexpectedpojo.getMotherName(), ((Map) ((Map) actuellData.get(0)).get("studentResponse")).get("motherName"));
        assertEquals(responseexpectedpojo.getFatherName(), ((Map) ((Map) actuellData.get(0)).get("studentResponse")).get("fatherName"));
        assertEquals(responseexpectedpojo.getEmail(), ((Map) ((Map) actuellData.get(0)).get("studentResponse")).get("email"));
    }
    @And("userhatice gets the student info and assert")
    public void userhaticeGetsTheStudentInfoAndAssert() {
      //  assertEquals(objectexpectedpojo.getMidtermExam(),genelPojo.get(0).getMidtermExam(),50.0);

    }

    @Given("I send DELETE Request to the Url")
    public void ıSendDELETERequestToTheUrl() {
        //{{baseUrl}}/studentInfo/delete/:studentInfoId

        spec.pathParams("first","studentInfo","second","delete","third",id);
    }

    @Then("Response body is  message")
    public void responseBodyIsMessageIs() {
        Map<String, String> expectedData = new HashMap<>();
        expectedData.put("message","Student Info deleted Successfully");
        expectedData.put("httpStatus","OK");
        response=given(spec).when().delete("/{first}/{second}/{third}");
        response.prettyPrint();
        Map<String,String> actualData= ObjectMapperUtils.convertJsonToJawa(response.asString(),HashMap.class);
      Assert.assertEquals(expectedData.get("message"),actualData.get("message"));
      Assert.assertEquals(expectedData.get("httpStatus"),actualData.get("httpStatus"));


    }

    @Given("userhatice set the url for update")
    public void userhaticeSetTheUrlForUpdate() {
        spec.pathParams("first","studentInfo","second","update","third",id);
    }
    @When("userhatice send Update request for Student info")
    public void userhaticesendUpdateRequestForStudentInfo() {

        responseexpectedpojo=new StudentResponsePojo(42,"Amine03","Amine","Amine","1987-01-15","Paris","346-546-7777","FEMALE",1040,"mama","papa","amine123@gmail.com",true);
        objectexpectedpojo=new StudentObjectPojo(id,50.0,70.0,5,"idare eder","JAVA",8,"SPRING_SEMESTER",62.0,responseexpectedpojo,false,"CC");
        response=given(spec).body(objectexpectedpojo).put("/{first}/{second}/{third}");
        response.prettyPrint();
        actualdatapojo=  ObjectMapperUtils.convertJsonToJawa(response.asString(),StudentObjectPojo.class);

    }


    @Then("HTTP Status code should be {int}")
    public void httpStatusCodeShouldBe(int statuscode) {
        assertEquals(statuscode,response.getStatusCode());
    }



    @Then("htcHTTP Status eror code should be {int}")
    public void htchttpStatusErorCodeShouldBe(int statuscode) {
        Assert.assertEquals("Failed to convert value of type 'java.lang.String' to required type 'java.lang.Long'; nested exception is java.lang.NumberFormatException: For input string: \"<long>\"",response.jsonPath().getString("message"));
        Assert.assertEquals(statuscode,response.getStatusCode());
    }

}

