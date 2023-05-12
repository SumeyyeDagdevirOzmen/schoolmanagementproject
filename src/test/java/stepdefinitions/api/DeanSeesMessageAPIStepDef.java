package stepdefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class DeanSeesMessageAPIStepDef {

    static Response response;

    @Given("User7 URL e Get request yapar")
    public void user7_url_e_get_request_yapar() {
        spec.pathParams("first","contactMessages","second","getAll")
                .queryParams("page","0","size","100","sort","date","type","desc");

    }
    @Then("Gelen body'de name,email,subject,message,date oldugunu gorur")
    public void gelen_body_de_name_email_subject_message_date_oldugunu_gorur() {
         response = given(spec).get("/{first}/{second}");
        response.prettyPrint();
        Assert.assertEquals(200,response.statusCode());
        JsonPath jsonPath = response.jsonPath();
        List<String> namesHava= jsonPath.getList("content.findAll{it.name}.name");
        List<String> emailHava= jsonPath.getList("content.findAll{it.email}.email");
        List<String> subjectHava= jsonPath.getList("content.findAll{it.subject}.subject");
        List<String> messageHava= jsonPath.getList("content.findAll{it.message}.message");
        List<String> dateHava= jsonPath.getList("content.findAll{it.date}.date");
        Assert.assertTrue(namesHava.size()!=0);
        Assert.assertTrue(emailHava.size()!=0);
        Assert.assertTrue(subjectHava.size()!=0);
        Assert.assertTrue(messageHava.size()!=0);
        Assert.assertTrue(dateHava.size()!=0);


    }

    ///contactMessages/getAll?page=0&size=100&sort=date&type=desc
}
