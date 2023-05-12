package stepdefinitions.EndToEndStepDefs;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.ui.DeanCreationStepDef.ssnguldean;

public class DeanValidationStepDeefsApiDB {
    Response response;
    ResultSet resultSet;
    Connection connection;
    Statement statement;

    @Given("user sends get request for deanAll")
    public void user_sends_get_request_for_dean_all() {
        spec.pathParams("first","dean","second","getAll");

      response=given(spec).when().get("/{first}/{second}");
        response.prettyPrint();

    }
    @Then("user validate ssn number")
    public void user_validate_ssn_number() {

        JsonPath jsonPath=response.jsonPath();
       List<String> ssnNumbers=jsonPath.getList("ssn");
        System.out.println("ssnNumbers = " + ssnNumbers);
        assertEquals(200,response.getStatusCode());
        assertTrue(ssnNumbers.contains(ssnguldean));


    }

    @When("Usergul finds dean by ssn")
    public void usergul_finds_dean_by_ssn() throws SQLException {
        connection= JdbcUtils.connectToDataBase("164.92.252.42","school_management","select_user","43w5ijfso");
        statement = JdbcUtils.createStatement();
        resultSet= statement.executeQuery("select * from dean where ssn='"+ssnguldean+"'");
        resultSet.next();

    }
    @Then("Usergul validates DeanData")
    public void usergul_validates_dean_data() throws SQLException {

        Assert.assertEquals(ssnguldean, resultSet.getString("ssn"));
        connection.close();
        statement.close();
        resultSet.close();



    }



}
