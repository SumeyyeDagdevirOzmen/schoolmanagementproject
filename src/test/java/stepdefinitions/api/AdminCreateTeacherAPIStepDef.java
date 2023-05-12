package stepdefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import testdata.TeacherCreateTestData;
import utilities.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class AdminCreateTeacherAPIStepDef {
     String email= Faker.instance().name().firstName()+ "@gmail.com";
     String name = Faker.instance().name().firstName();
     String surname= Faker.instance().name().lastName();
     String phoneNumber="532-"+ Faker.instance().number().numberBetween(100,999)+"-1598";
     String ssn= Faker.instance().number().numberBetween(100,999)+ "-" + Faker.instance().number().numberBetween(10,99) + "-" + Faker.instance().number().numberBetween(1000,9999);
     String username= Faker.instance().name().username();
     TeacherCreateTestData obj;
      static List<Integer> lessonsIdList;
     Map<String,Object> expectedData;
     Map<String,Object> actualData;
     static Response response;
    @Given("UserNhl sets the url for teeacher creation")
    public void user_nhl_sets_the_url_for_teeacher_creation() {

        spec.pathParams("first","teachers","second","save");

    }
    @When("UserNhl sends post request for teacher creation")
    public void user_nhl_sends_post_request_for_teacher_creation() {

        obj=new TeacherCreateTestData();
        lessonsIdList=new ArrayList<>();
        lessonsIdList.add(4);
        expectedData = obj.teacherExpectedData("1982-05-01","istanbul",email,"FEMALE",true,lessonsIdList,name,"Team03team",phoneNumber,ssn,surname,username);
        System.out.println("expectedData = " + expectedData);



        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
        actualData= ObjectMapperUtils.convertJsonToJawa(response.asString(),HashMap.class);


    }
    @When("UserNhl verifys that the status code is {int} for teacher creation")
    public void user_nhl_verifys_that_the_status_code_is_for_teacher_creation(int statusCode) {
        Assert.assertEquals(statusCode,response.getStatusCode());

    }
    @Then("UserNhl asserts response body for teacher creation")
    public void user_nhl_asserts_response_body_for_teacher_creation() {

        Assert.assertEquals(expectedData.get("birthDay"),((Map)actualData.get("object")).get("birthDay"));
        Assert.assertEquals(expectedData.get("birthPlace"),((Map)actualData.get("object")).get("birthPlace"));
        Assert.assertEquals(expectedData.get("email"),((Map)actualData.get("object")).get("email"));
        Assert.assertEquals(expectedData.get("email"),((Map)actualData.get("object")).get("email"));
        Assert.assertEquals(expectedData.get("gender"),((Map)actualData.get("object")).get("gender"));
        Assert.assertEquals(expectedData.get("gender"),((Map)actualData.get("object")).get("gender"));
        Assert.assertEquals(expectedData.get("name"),((Map)actualData.get("object")).get("name"));
        Assert.assertEquals(expectedData.get("phoneNumber"),((Map)actualData.get("object")).get("phoneNumber"));
        Assert.assertEquals(expectedData.get("ssn"),((Map)actualData.get("object")).get("ssn"));
        Assert.assertEquals(expectedData.get("surname"),((Map)actualData.get("object")).get("surname"));
        Assert.assertEquals(expectedData.get("username"),((Map)actualData.get("object")).get("username"));

    }

}
