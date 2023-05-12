package stepdefinitions.database;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Us03_ContactMessageDataPojo;
import utilities.JdbcUtils;
import java.util.List;
import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class ContactMessageDBStepDef {
    Us03_ContactMessageDataPojo expectedData;
    Response response;
    String email="frkdrm2828@gmail.com";
    String message="Database kontrolu yapiyoruz";
    String name ="Faruk";
    String subject ="Database testleri";

    @When("userFrk creates a message  by api.")
    public void userfrkCreatesAMessageByApi() {

        spec.pathParams("first","contactMessages","second","save");

        expectedData = new Us03_ContactMessageDataPojo(email,message,name,subject);

        response= given(spec).when().body(expectedData).post("/{first}/{second}");

    }

    @Then("userFrk asserts this data in databas")
    public void user_frk_asserts_this_data_in_databas() {

      List<String> emailList = JdbcUtils.getColumnListString("email","contact_message");
      List<String> messageList = JdbcUtils.getColumnListString("message","contact_message");
      List<String> nameList = JdbcUtils.getColumnListString("name","contact_message");
      List<String> subjectList = JdbcUtils.getColumnListString("subject","contact_message");
      Assert.assertTrue(emailList.contains(email));
      Assert.assertTrue(messageList.contains(message));
      Assert.assertTrue(nameList.contains(name));
      Assert.assertTrue(subjectList.contains(subject));

    }



}
