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

public class Us22_AdminCreate {
    ResultSet resultSet;
    Connection connection;
    Statement statement;
    @Given("User22 connects to database")
    public void userConnectsToDatabase() {
        connection= JdbcUtils.connectToDataBase("164.92.252.42","school_management","select_user","43w5ijfso");
        statement = JdbcUtils.createStatement();

    }

    @When("User22 Find admin by id")
    public void userFindAdminById() throws SQLException {
        resultSet= statement.executeQuery("select * from admins where id='11'");
        resultSet.next();
        System.out.println("resultSet = " + resultSet);


    }

    @Then("User22 validate the datas")
    public void userValidateTheDatas() throws SQLException {
        Assert.assertEquals("2001-03-03", resultSet.getString("birth_day"));
        Assert.assertEquals("istanbul", resultSet.getString("birth_place"));
        Assert.assertEquals("MALE", resultSet.getString("gender"));
        Assert.assertEquals("alican", resultSet.getString("name"));
        Assert.assertEquals("023-886-3899", resultSet.getString("phone_number"));
        Assert.assertEquals("884-54-3899", resultSet.getString("ssn"));
        Assert.assertEquals("Tan", resultSet.getString("surname"));
        Assert.assertEquals("3899kubra", resultSet.getString("username"));

        Assert.assertEquals(1, resultSet.getInt("user_role_id"));

        connection.close();
        statement.close();
        resultSet.close();


    }
}
