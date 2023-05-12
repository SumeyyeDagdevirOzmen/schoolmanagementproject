package stepdefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;


public class VicedeanContactMessageAPIStepDef {

    Response response;

    @Given("UserFrk sets the Url")
    public void user_frk_sets_the_url() {
        spec.pathParams("first", "contactMessages", "second", "getAll")
                .queryParams("page", "0", "size", "100", "sort", "date", "type", "desc");
    }

    @When("UserFrk sends a get  request")
    public void user_frk_sends_a_get_request() {
        response = given(spec).when().get("/{first}/{second}");
    }

    @Then("UserFrk verifys that https code is twohundert")
    public void user_frk_verifys_that_https_code_is() {
        Assert.assertEquals(200, response.statusCode());
    }

    @Then("UserFrk as Vıcedean verifys response body  that messages are visible.\"")
    public void user_frk_as_vıcedean_verifys_response_body_that_messages_are_visible() {
        List<String> messageList = response.jsonPath().getList("content.findAll{it.message}.message");
        Assert.assertTrue(messageList.size() != 0);
    }


    @Then("UserFrk as Vıcedean verifys response body  that authors are visible.\"")
    public void userfrkAsVıcedeanVerifysResponseBodyThatAuthorsAreVisible() {
        List<String> nameList = response.jsonPath().getList("content.findAll{it.name}.name");
        Assert.assertTrue(nameList.size() != 0);
    }

    @Then("UserFrk as Vıcedean verifys response body  that emails are visible.\"")
    public void userfrkAsVıcedeanVerifysResponseBodyThatEmailsAreVisible() {
     List<String> emailList = response.jsonPath().getList("content.findAll{it.email}.email");
       Assert.assertTrue(emailList.size()!=0);
    }

    @Then("UserFrk as Vıcedean verifys response body  that sentdate are visible.\"")
    public void userfrkAsVıcedeanVerifysResponseBodyThatSentdateAreVisible() {
     List<String> dateList = response.jsonPath().getList("content.findAll{it.date}date");
      Assert.assertTrue(dateList.size()!=0);
    }

    @Then("UserFrk as Vıcedean verifys response body  that subjects are visible.\"")
    public void userfrkAsVıcedeanVerifysResponseBodyThatSubjectsAreVisible()  {
   List<String> subjectList = response.jsonPath().getList("content.findAll{it.subject}.subject");
   Assert.assertTrue(subjectList.size()!=0);
    }
}
