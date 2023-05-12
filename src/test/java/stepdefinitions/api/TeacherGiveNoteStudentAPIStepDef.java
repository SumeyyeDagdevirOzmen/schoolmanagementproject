package stepdefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.US17_TeacherPojo;

import java.util.HashMap;
import java.util.Map;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class TeacherGiveNoteStudentAPIStepDef {
    Response response;
    US17_TeacherPojo expectedData ;
    JsonPath jsonPath;
    private static int idHava ;

    @Given("UserHava URL e Post request yapar")
    public void userhavaURLEPostRequestYapar() {
            spec.pathParams("first","studentInfo","second","save");

        }


    @When("UserHava ogretmen ogrenciye not verir")
    public void userhavaOgretmenOgrenciyeNotVerir() {

        expectedData = new US17_TeacherPojo(5,4,50.0,"Cok Basarili",4,80.0,58);
        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
        jsonPath=response.jsonPath();
        idHava = jsonPath.getInt("object.id");
    }
    @Then("Verdigi Notlari gordugunu dogrular")
    public void verdigiNotlariGordugunuDogrular() {
        response
                .then()
                .body("object.midtermExam",equalTo(80.0f)
                        ,"object.finalExam",equalTo(50.0F)
                        ,"object.absentee",equalTo(5)
                        ,"object.infoNote",equalTo("Cok Basarili")
                        ,"object.educationTerm",equalTo("SPRING_SEMESTER")
                        ,"object.studentResponse.username",equalTo("EvaCasas")
                        ,"object.lessonName",equalTo("C#"));
        assertEquals(200,response.statusCode());

                  jsonPath = response.jsonPath();
                  assertEquals(expectedData.getAbsentee(),jsonPath.getInt("object.absentee"));
                  assertEquals("SPRING_SEMESTER",jsonPath.getString("object.educationTerm"));
                  assertEquals(expectedData.getFinalExam(),jsonPath.getFloat("object.finalExam"),50.0);
                  assertEquals(expectedData.getInfoNote(),jsonPath.getString("object.infoNote"));
                  assertEquals("C#",jsonPath.getString("object.lessonName"));
                  assertEquals(expectedData.getMidtermExam(),jsonPath.getFloat("object.midtermExam"),80.0);
                  assertEquals(expectedData.getStudentId(),jsonPath.getInt("object.studentResponse.userId"));
    }
    @When("UserHava ogretmen MidtermExam kismina not verir")
    public void userhavaOgretmenMidtermExamKisminaNotVerir() {
        expectedData = new US17_TeacherPojo(5,4,50.0,"Cok Basarili",4,102.0,58);
        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }
    @Then("Verdigi MidtermNotu Kabul edilmedigini dogrular")
    public void verdigiMidtermNotuKabulEdilmediginiDogrular() {
        response
                .then()
                .body("message",equalTo("Validation failed for object='studentInfoRequestWithoutTeacherId'. Error count: 1")
                        ,"statusCode",equalTo(400)
                        ,"path",equalTo("/studentInfo/save")
                        ,"validations.midtermExam",equalTo("must be less than or equal to 100.0"));
        assertEquals(400,response.statusCode());
        jsonPath = response.jsonPath();
        assertEquals("Validation failed for object='studentInfoRequestWithoutTeacherId'. Error count: 1",jsonPath.getString("message"));
        assertEquals("/studentInfo/save",jsonPath.getString("path"));
        assertEquals("must be less than or equal to 100.0",jsonPath.getString("validations.midtermExam"));
        assertEquals(400,jsonPath.getInt("statusCode"));
    }

    @When("UserHava ogretmen FinalExam kismina notu verir")
    public void userhavaOgretmenFinalExamKisminaNotuVerir() {
        expectedData = new US17_TeacherPojo(5,4,102.5,"Cok Basarili",4,80.0,58);
        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }
    @Then("Verdigi FinalExamNotu Kabul edilmedigini dogrular")
    public void verdigiFinalExamNotuKabulEdilmediginiDogrular() {
        response
                .then()
                .body("message",equalTo("Validation failed for object='studentInfoRequestWithoutTeacherId'. Error count: 1")
                        ,"statusCode",equalTo(400)
                        ,"path",equalTo("/studentInfo/save")
                        ,"validations.finalExam",equalTo("must be less than or equal to 100.0"));
        assertEquals(400,response.statusCode());
        jsonPath = response.jsonPath();
        assertEquals("Validation failed for object='studentInfoRequestWithoutTeacherId'. Error count: 1",jsonPath.getString("message"));
        assertEquals("/studentInfo/save",jsonPath.getString("path"));
        assertEquals("must be less than or equal to 100.0",jsonPath.getString("validations.finalExam"));
        assertEquals(400,jsonPath.getInt("statusCode"));
    }
    @When("UserHava ogretmen Choose Lesson kismini bos burakir")
    public void userhavaOgretmenChooseLessonKisminiBosBurakir() {
        expectedData = new US17_TeacherPojo(5,4,50.0,"Cok Basarili",0,80.0,58);
        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }

    @Then("UserHava Choose Lessonini bos biraktigi icin Hata mesaji alir")
    public void userhavaChooseLessoniniBosBiraktigiIcinHataMesajiAlir() {
        response
                .then()
                .body("message",equalTo("Error: Lesson with lesson id 0 not found")
                        ,"statusCode",equalTo(404)
                        ,"path",equalTo("/studentInfo/save"));

        assertEquals(404,response.statusCode());
        jsonPath = response.jsonPath();
        assertEquals("Error: Lesson with lesson id 0 not found",jsonPath.getString("message"));
        assertEquals("404",jsonPath.getString("statusCode"));
        assertEquals("/studentInfo/save",jsonPath.getString("path"));
    }

    @When("UserHava ogretmen Choose Student kismini bos burakir")
    public void userhavaOgretmenChooseStudentKisminiBosBurakir() {
        expectedData = new US17_TeacherPojo(5,4,50.0,"Cok Basarili",4,80.0,0);
        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }

    @Then("UserHava Choose Studenti bos biraktigi icin Hata mesaji alir")
    public void userhavaChooseStudentiBosBiraktigiIcinHataMesajiAlir() {
        response
                .then()
                .body("message",equalTo("Error: User with SSN 0 not found")
                        ,"statusCode",equalTo(404)
                        ,"path",equalTo("/studentInfo/save"));

        assertEquals(404,response.statusCode());
        jsonPath = response.jsonPath();
        assertEquals("Error: User with SSN 0 not found",jsonPath.getString("message"));
        assertEquals("404",jsonPath.getString("statusCode"));
        assertEquals("/studentInfo/save",jsonPath.getString("path"));
    }

    @When("UserHava ogretmen Choose Education Term kismini bos burakir")
    public void userhavaOgretmenChooseEducationTermKisminiBosBurakir() {
        expectedData = new US17_TeacherPojo(5,0,50.0,"Cok Basarili",4,80.0,58);
        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }

    @Then("UserHava Choose Education Termi bos biraktigi icin Hata mesaji alir")
    public void userhavaChooseEducationTermiBosBiraktigiIcinHataMesajiAlir() {
        response
                .then()
                .body("message",equalTo("Error: Education Term with id 0 not found")
                        ,"statusCode",equalTo(404)
                        ,"path",equalTo("/studentInfo/save"));

        assertEquals(404,response.statusCode());
        jsonPath = response.jsonPath();
        assertEquals("Error: Education Term with id 0 not found",jsonPath.getString("message"));
        assertEquals("404",jsonPath.getString("statusCode"));
        assertEquals("/studentInfo/save",jsonPath.getString("path"));

    }
    @Given("UserHava URL e Delete request yapar")
    public void userhavaURLEDeleteRequestYapar() {
        spec.pathParams("first","studentInfo","second","delete","third",idHava);
    }

    @When("UserHava ogretmen olusturdugu ogrenciyi siler")
    public void userhavaOgretmenOlusturduguOgrenciyiSiler() {
        //http://164.92.252.42:8080/studentInfo/delete/448

        response = given(spec).delete("/{first}/{second}/{third}");
        response.prettyPrint();

    }

    @Then("UserHava sildigi ogrencinin silindigini dogrular")
    public void userhavaSildigiOgrencininSilindiginiDogrular() {
        assertEquals(200,response.statusCode());
         response.
                       then().
                        body("message", equalTo("Student Info deleted Successfully")).
                        body("httpStatus", equalTo("OK"));

                //2. Validation
                JsonPath jsonPath = response.jsonPath();
                assertEquals("Student Info deleted Successfully", jsonPath.getString("message"));
                assertEquals("Student Info deleted Successfully", jsonPath.getString("message"));
                assertEquals(200,response.statusCode());
                //3. Validation
                Map<String, Object> actualDataMap = response.as(HashMap.class);
                assertEquals("Student Info deleted Successfully", actualDataMap.get("message"));
                assertEquals("OK", actualDataMap.get("httpStatus"));
    }


}




