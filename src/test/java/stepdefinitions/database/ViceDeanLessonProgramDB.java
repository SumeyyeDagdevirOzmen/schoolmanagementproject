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

public class ViceDeanLessonProgramDB {

    Statement statement;
    ResultSet resultset;
   Connection connection;

    @Given("user connects to database")
    public void user_connects_to_database() {
      connection=  JdbcUtils.connectToDataBase("164.92.252.42","school_management","select_user","43w5ijfso");
      statement =   JdbcUtils.createStatement();

    }
    @When("userHtc finds from Lesson program by id")
    public void userhtcFindsFromLessonProgramByLessonname() throws SQLException {
         JdbcUtils.execute("select * from lesson_program where id=401");
         resultset=statement.executeQuery("select *from lesson_program where id=401");
         resultset.next();
    }

    @Then("validate data")
    public void validateData() throws SQLException {
        Assert.assertEquals("MONDAY",resultset.getString("day"));
        Assert.assertEquals("12:30:00",resultset.getString("start_time"));
        Assert.assertEquals("18:30:00",resultset.getString("stop_time"));
        Assert.assertEquals("1",resultset.getString("education_term_id"));
    }
}
