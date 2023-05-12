package stepdefinitions.database;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.JdbcUtils;

import java.sql.*;

public class AddTeacherDBStepDef {
    Statement statement;
    ResultSet resultSet;
    Connection connection;
    @Given("User connects to database")
    public void user_connects_to_database() throws SQLException {
       connection= JdbcUtils.connectToDataBase("164.92.252.42","school_management","select_user","43w5ijfso");
        statement= JdbcUtils.createStatement();
    }

    @When("UserNhl finds meet by MeetID")
    public void user_nhl_finds_meet_by_MeetID() throws SQLException {
        JdbcUtils.execute("select * from meet where id= 3;");
        resultSet= statement.executeQuery("select * from meet where id=3 ");
        resultSet.next();


    }

    @Then("UserNhl validates Data")
    public void user_nhl_validates_data() throws SQLException {
        Assert.assertEquals("2023-05-10",resultSet.getString("date"));
        Assert.assertEquals("Abwesenheit",resultSet.getString("description"));
        Assert.assertEquals("10:00:00",resultSet.getString("start_time"));
        Assert.assertEquals("11:00:00",resultSet.getString("stop_time"));
        Assert.assertEquals(8,resultSet.getInt("advisor_teacher_id"));
    }

}
