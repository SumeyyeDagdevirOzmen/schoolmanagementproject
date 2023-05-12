package stepdefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Us03_ContactMessageDataPojo;
import pojos.Us03_ResponsePojo;
import utilities.ObjectMapperUtils;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class ContactMessageAPIStepDef {

    Us03_ResponsePojo us03_responsePojo;
    Us03_ContactMessageDataPojo expectedData;

    Response response;

    @Given("UserF sends the post request for the message")
    public void userfSendsThePostRequestForTheMessage() {
        //set the url
        spec.pathParams("first","contactMessages","second","save");
        //set the expected data
        expectedData = new Us03_ContactMessageDataPojo(Faker.instance().name().firstName()+"@gmail.com","asdfghjklş","FARUK","LMSler");
        //SEND THE REQUEST GET THE RESPONSE
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }
    @Then("UserF verify the response")
    public void user_f_verify_the_response() {
        //Do assertion
        Us03_ResponsePojo actualData = ObjectMapperUtils.convertJsonToJawa(response.asString(), Us03_ResponsePojo.class);
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.getName(),actualData.getObject().getName());
        Assert.assertEquals(expectedData.getEmail(),actualData.getObject().getEmail());
        Assert.assertEquals(expectedData.getMessage(),actualData.getObject().getMessage());
        Assert.assertEquals(expectedData.getSubject(),actualData.getObject().getSubject());
        Assert.assertEquals("Contact Message Created Successfully",actualData.getMessage());
        Assert.assertEquals("CREATED",actualData.getHttpStatus());

    }


    @Given("UserF sends the post request without name for the message")
    public void userfSendsThePostRequestWithoutNameForTheMessage() {
        //set the url
        spec.pathParams("first","contactMessages","second","save");
        //set the expected data
        expectedData = new Us03_ContactMessageDataPojo(Faker.instance().internet().emailAddress(),"asdfghjklş","","LMS");
        //SEND THE REQUEST GET THE RESPONSE
        response= given(spec).when().body(expectedData).post("/{first}/{second}");

    }

    @Then("UserF verify the response without name")
    public void userfVerifyTheResponseWithoutName() {
        Assert.assertEquals(400,response.statusCode());
    }

    @Given("UserF sends the post request\\(mail) without @ and . for the message")
    public void userfSendsThePostRequestMailWithoutAndForTheMessage() {
        //set the url
        spec.pathParams("first","contactMessages","second","save");
        //set the expected data
        expectedData = new Us03_ContactMessageDataPojo("farukmailcom","asdfghjklş","ahmet","LMS");
        //SEND THE REQUEST GET THE RESPONSE
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
    }

    @Then("UserF verify the response without @ und .")
    public void userfVerifyTheResponseWithoutUnd() {
        Assert.assertEquals(400,response.statusCode());
    }

    @Given("UserF sends the post request\\(mail) without point for the message")
    public void userfSendsThePostRequestMailWithoutPointForTheMessage() {
        //set the url
        spec.pathParams("first","contactMessages","second","save");
        //set the expected data
        expectedData = new Us03_ContactMessageDataPojo("faruk@mailcom","asdfghjklş","faruk","LMS123");
        //SEND THE REQUEST GET THE RESPONSE
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
    }

    @Then("UserF verify the response without  .")
    public void userfVerifyTheResponseWithout() {

        Assert.assertEquals(400,response.statusCode());
    }

    @Given("UserF sends the post request\\(mail) without @ for the message")
    public void userfSendsThePostRequestMailWithoutForTheMessage() {
        //set the url
        spec.pathParams("first","contactMessages","second","save");
        //set the expected data
        expectedData = new Us03_ContactMessageDataPojo("farukmail.com","asdfghjklş","","LMS");
        //SEND THE REQUEST GET THE RESPONSE
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
    }

    @Then("UserF verify the response without  @alfa")
    public void userfVerifyTheResponseWithoutAlfa() {
        Assert.assertEquals(400,response.statusCode());
    }

    @Given("UserF sends the post request without subject")
    public void userfSendsThePostRequestWithoutSubject() {
        //set the url
        spec.pathParams("first","contactMessages","second","save");
        //set the expected data
        expectedData = new Us03_ContactMessageDataPojo(Faker.instance().internet().emailAddress(),"asdfghjklş","faruk","");
        //SEND THE REQUEST GET THE RESPONSE
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
    }


    @Then("UserF verify the response without  subject")
    public void userfVerifyTheResponseWithoutSubject() {
        Assert.assertEquals(400,response.getStatusCode());
    }



    @Then("UserF verify the status code should be {int}")
    public void userfVerifyTheStatusCodeShouldBe(int statusCode) {
        Assert.assertEquals(statusCode,response.statusCode());
    }



}
