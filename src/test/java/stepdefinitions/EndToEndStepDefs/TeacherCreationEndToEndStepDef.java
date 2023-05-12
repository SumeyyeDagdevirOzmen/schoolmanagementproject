package stepdefinitions.EndToEndStepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.TeacherManagementPage;
import utilities.JdbcUtils;
import utilities.ReusableMethods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.ui.AdminCreateTeacherStepDef.ssnNhl;
import static stepdefinitions.ui.DeanCreationStepDef.ssnguldean;

public class TeacherCreationEndToEndStepDef {
   static Response rs;
    Statement statement;
    ResultSet resultSet;
    Connection connection;

    //{{baseUrl}}/teachers/getAll
    @Given("UserNhl sets the url and sends get request")
    public void user_nhl_sets_the_url_and_sends_get_request() {
       spec.pathParams("first","teachers","second","getAll");
       rs= given(spec).when().get("/{first}/{second}");
       rs.prettyPrint();
    }

    @Then("UserNhl verifys response body")
    public void user_nhl_verifys_response_body() {

        JsonPath jsonPath=rs.jsonPath();
        List<String> ssnNumbers=jsonPath.getList("ssn");
        assertEquals(200,rs.getStatusCode());
        assertTrue(ssnNumbers.contains(ssnNhl));
    }

    @Given("UserNhl connect to DataBase")
    public void user_nhl_connect_to_data_base() {
        connection= JdbcUtils.connectToDataBase("164.92.252.42","school_management","select_user","43w5ijfso");
        statement= JdbcUtils.createStatement();
    }
    @When("UserNhl finds teacher by ssn")
    public void user_nhl_finds_teacher_by_ssn() throws SQLException {
        resultSet= statement.executeQuery("select ssn from teacher where ssn='"+ ssnNhl+ "'");
        resultSet.next();
        System.out.println(resultSet.getString("ssn"));
    }
    @Then("UserNhl verifys Data")
    public void user_nhl_verifys_data() throws SQLException {

        Assert.assertEquals(ssnNhl,resultSet.getString("ssn"));

        connection.close();
        statement.close();
        resultSet.close();

    }


}
