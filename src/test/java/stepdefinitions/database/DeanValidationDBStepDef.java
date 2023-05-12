package stepdefinitions.database;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertTrue;

public class DeanValidationDBStepDef {
    ResultSet resultSet;
    Connection connection;
    Statement statement;

    @Given("usergul connects to database")
    public void user_connects_to_database() {
        connection=JdbcUtils.connectToDataBase("164.92.252.42","school_management","select_user","43w5ijfso");
         statement = JdbcUtils.createStatement();
    }

    @When("usergul Find dean by ssn")
    public void find_dean_by_ssn() throws SQLException {
        resultSet= statement.executeQuery("select * from dean where id=141");
        resultSet.next();

    }


    @Then("usergul Validate data")
    public void validate_data() throws SQLException {



       Assert.assertEquals("2000-11-11", resultSet.getString("birth_day"));
        Assert.assertEquals("Paris", resultSet.getString("birth_place"));
        Assert.assertEquals("FEMALE", resultSet.getString("gender"));
        Assert.assertEquals("Ayse", resultSet.getString("name"));
        Assert.assertEquals("023-786-4184", resultSet.getString("phone_number"));
        Assert.assertEquals("484-54-4184", resultSet.getString("ssn"));
        Assert.assertEquals("yalcin", resultSet.getString("surname"));
        Assert.assertEquals("4184yalcin", resultSet.getString("username"));

        Assert.assertEquals(2, resultSet.getInt("user_role_id"));
        Assert.assertEquals(141, resultSet.getInt("id"));
        connection.close();
        statement.close();
        resultSet.close();

    }
}
