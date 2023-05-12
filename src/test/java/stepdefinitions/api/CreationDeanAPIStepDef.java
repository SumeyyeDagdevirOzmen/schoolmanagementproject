package stepdefinitions.api;


import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.US01_RegisterPojo;
import pojos.US04_DeanCreationResponsePojo;
import pojos.US04_ObjectPojo;
import utilities.ObjectMapperUtils;


import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CreationDeanAPIStepDef {
  Response response;
  US04_ObjectPojo object;
 static US01_RegisterPojo expecteddata;


  US04_DeanCreationResponsePojo responsedata;
  int num4 = Faker.instance().number().numberBetween(1000, 9999);

  @Given("user04_Set_the_url")
  public void user04_set_the_url() {

    spec.pathParams("first","dean","second","save");

  }
  @When("user04_send POST Request to the Url for empty name")
  public void user04_send_post_request_to_the_url() {
    expecteddata=new US01_RegisterPojo("2000-11-11","paris","FEMALE","","12345678","023-786-"+num4+"","484-54-"+num4+"","yalcin",num4+"yalcin");
    response=given(spec).when().body(expecteddata).post("/{first}/{second}");
    response.prettyPrint();

  }
  @Then("s.for user04 HTTP Status Code Should be {int}")
  public void s_for_user04_http_status_code_should_be(Integer int1) {

    response.then().statusCode(int1);
  }
  @When("s2.user04_send POST Request to the Url for empty surname")
  public void s2_user04_send_post_request_to_the_url() {
    expecteddata=new US01_RegisterPojo("2000-11-11","paris","FEMALE","Ayse","12345678","023-786-"+num4+"","484-54-"+num4+"","",num4+"yalcin");
    response=given(spec).when().body(expecteddata).post("/{first}/{second}");
    response.prettyPrint();
  }

  @When("s3.user04_send POST Request to the Url for empty birthPlace")
  public void s3_user04_send_post_request_to_the_url() {
    expecteddata=new US01_RegisterPojo("2000-11-11","","FEMALE","Ayse","12345678","023-786-"+num4+"","484-54-"+num4+"","yalcin",num4+"yalcin");
    response=given(spec).when().body(expecteddata).post("/{first}/{second}");

  }

  @When("s4.user04_send POST Request to the Url for unselected gender")
  public void s4_user04_send_post_request_to_the_url() {
    expecteddata=new US01_RegisterPojo("2000-11-11","Paris","","Ayse","12345678","023-786-"+num4+"","484-54-"+num4+"","yalcin",num4+"yalcin");
    response=given(spec).when().body(expecteddata).post("/{first}/{second}");

  }
  @When("s5.user04_send POST Request to the Url for empty date")
  public void s5_user04_send_post_request_to_the_url_for_empty_date() {
    expecteddata=new US01_RegisterPojo("","Paris","FEMALE","Ayse","12345678","023-786-"+num4+"","484-54-"+num4+"","yalcin",num4+"yalcin");
    response=given(spec).when().body(expecteddata).post("/{first}/{second}");

  }

  @When("s5.user04_send POST Request to the Url for invalid date")
  public void s5_user04_send_post_request_to_the_url_for_invalid_date() {
    expecteddata=new US01_RegisterPojo("1000-11-11","Paris","FEMALE","Ayse","12345678","023-786-"+num4+"","484-54-"+num4+"","yalcin",num4+"yalcin");
    response=given(spec).when().body(expecteddata).post("/{first}/{second}");
  }
  @When("s6.user04_send POST Request to the Url for empty phone")
  public void s5_user04_send_post_request_to_the_url_for_empty_phone() {
    expecteddata=new US01_RegisterPojo("2000-11-11","Paris","FEMALE","Ayse","12345678","","484-54-"+num4+"","yalcin",num4+"yalcin");
    response=given(spec).when().body(expecteddata).post("/{first}/{second}");

  }

  @When("s6.user04_send POST Request to the Url for invalid phone")
  public void s5_user04_send_post_request_to_the_url_for_invalid_phone() {
    expecteddata=new US01_RegisterPojo("2000-11-11","Paris","FEMALE","Ayse","12345678","023-76-"+num4+"","484-54-"+num4+"","yalcin",num4+"yalcin");
    response=given(spec).when().body(expecteddata).post("/{first}/{second}");


  }

  @When("s7.user04_send POST Request to the Url for empty ssn")
  public void s7_user04_send_post_request_to_the_url_for_empty_ssn() {
    expecteddata=new US01_RegisterPojo("2000-11-11","Paris","FEMALE","Ayse","12345678","023-786-"+num4+"","","yalcin",num4+"yalcin");
    response=given(spec).when().body(expecteddata).post("/{first}/{second}");

  }

  @When("s7.user04_send POST Request to the Url for invalid ssn without hyphens")
  public void s7_user04_send_post_request_to_the_url_for_invalid_ssn() {
    expecteddata=new US01_RegisterPojo("2000-11-11","Paris","FEMALE","Ayse","12345678","023-786-"+num4+"","48454"+num4+"","yalcin",num4+"yalcin");
    response=given(spec).when().body(expecteddata).post("/{first}/{second}");
  }

  @When("s7.user04_send POST Request to the Url for invalid ssn of eleven digits")
  public void s7_user04_send_post_request_to_the_url_for_invalid_ssn_of_digits() {
    expecteddata=new US01_RegisterPojo("2000-11-11","Paris","FEMALE","Ayse","12345678","023-786-"+num4+"","4846540"+num4+"","yalcin",num4+"yalcin");
    response=given(spec).when().body(expecteddata).post("/{first}/{second}");

  }

  @When("s8.user04_send POST Request to the Url for empty username")
  public void s8_user04_send_post_request_to_the_url_for_empty_username() {
    expecteddata=new US01_RegisterPojo("2000-11-11","Paris","FEMALE","Ayse","12345678","023-786-"+num4+"","484-54-"+num4+"","yalcin","");
    response=given(spec).when().body(expecteddata).post("/{first}/{second}");

  }
  @When("s9.user04_send POST Request to the Url for empty password")
  public void s9_user04_send_post_request_to_the_url_for_empty_password() {
    expecteddata=new US01_RegisterPojo("2000-11-11","Paris","FEMALE","Ayse","","023-786-"+num4+"","484-54-"+num4+"","yalcin",num4+"yalcin");
    response=given(spec).when().body(expecteddata).post("/{first}/{second}");
  }

  @When("s9.user04_send POST Request to the Url for invalid password of seven character")
  public void s9_user04_send_post_request_to_the_url_for_invalid_password_of_seven_character() {
    expecteddata=new US01_RegisterPojo("2000-11-11","Paris","FEMALE","Ayse","1234567","023-786-"+num4+"","484-54-"+num4+"","yalcin",num4+"yalcin");
    response=given(spec).when().body(expecteddata).post("/{first}/{second}");
  }
  @When("s10.user04_send POST Request to the Url for happy_path")
  public void s10_user04_send_post_request_to_the_url_for_empty_username() {

    expecteddata=new US01_RegisterPojo("2000-11-11","Paris","FEMALE","Ayse","12345678","023-786-"+num4+"","484-54-"+num4+"","yalcin",num4+"yalcin");
    response=given(spec).when().body(expecteddata).post("/{first}/{second}");
    response.prettyPrint();

  }

  @Then("s10.do assertion")
  public void do_assertion() {

    //1. yol
    responsedata=new US04_DeanCreationResponsePojo(object,"Dean Saved","CREATED");
    US04_DeanCreationResponsePojo actualdata= ObjectMapperUtils.convertJsonToJawa(response.asString(),US04_DeanCreationResponsePojo.class);
   assertEquals(expecteddata.getBirthDay(),actualdata.object.getBirthDay());
   assertEquals(expecteddata.getBirthPlace(),actualdata.object.getBirthPlace());
   assertEquals(expecteddata.getGender(),actualdata.object.getGender());
   assertEquals(expecteddata.getName(),actualdata.object.getName());
   assertEquals(expecteddata.getPhoneNumber(),actualdata.object.getPhoneNumber());
   assertEquals(expecteddata.getSsn(),actualdata.object.getSsn());
   assertEquals(expecteddata.getSurname(),actualdata.object.getSurname());
   assertEquals(expecteddata.getUsername(),actualdata.object.getUsername());
   assertEquals(responsedata.getMessage(),actualdata.getMessage());
   assertEquals(responsedata.getHttpStatus(),actualdata.getHttpStatus());
   
   int idDean=actualdata.object.getUserId();
    System.out.println("idDean = " + idDean);

   //2.yol






  }

}
