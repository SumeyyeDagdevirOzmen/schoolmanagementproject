package stepdefinitions.database;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.*;

public class ViceDeanLessonSeeDBStepDef {

    Statement statement;
    ResultSet resultset;
    Connection connection;


    @Given("UserA connect to database")
    public void user_a_connect_to_database() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://164.92.252.42:5432/school_management", "select_user", "43w5ijfso");
        statement = connection.createStatement();

    }
    @When("UserA send query for lesson pronram id")
    public void user_a_send_query_for_lesson_pronram_id() throws SQLException {
        resultset = statement.executeQuery("SELECT * FROM lesson_program where id=469;");
        resultset.next();


    }
    @Then("UserA validate data")
    public void user_a_validate_data() throws SQLException {
        Assert.assertEquals(469,resultset.getInt("id"));
        Assert.assertEquals("MONDAY",resultset.getString("day"));
        Assert.assertEquals("15:00:00",resultset.getString("start_time"));
        Assert.assertEquals("16:00:00",resultset.getString("stop_time"));
        Assert.assertEquals(1,resultset.getInt("education_term_id"));

    }


    @When("UserA send query to see teacher in the choose Lesson")
    public void user_a_send_query_to_see_teacher_in_the_choose_lesson() throws SQLException {
        resultset = statement.executeQuery("SELECT * FROM teacher_lessonprogram WHERE teacher_id=9 and lesson_program_id=469;");
        resultset.next();


    }
    @Then("UserA validation data")
    public void user_a_validation_data() throws SQLException {
        Assert.assertEquals(9,resultset.getInt("teacher_id"));
        Assert.assertEquals(469,resultset.getInt("lesson_program_id"));

    }
}
