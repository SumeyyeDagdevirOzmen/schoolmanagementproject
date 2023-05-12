package stepdefinitions.database;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.JdbcUtils;

import java.sql.*;

import static org.junit.Assert.assertEquals;

public class ViceDeanLessonProgramSeeDBStepDef {

    Statement statement;
    ResultSet resultset;
    Connection connection;


    @When("userAy finds from Lesson program by id")
    public void user_ay_finds_from_lesson_program_by_id() throws SQLException {

        //JdbcUtils.execute("select * from lesson_program where id=13");
        resultset=statement.executeQuery("select *from lesson_program where id=7");
        resultset.next();

    }

    @Given("UserAy connect to database")
    public void user_ay_connect_to_database() {

        connection=  JdbcUtils.connectToDataBase("164.92.252.42","school_management","select_user","43w5ijfso");
        statement =   JdbcUtils.createStatement();

    }
    @When("Send query to get guest user by lessonProgramId {string}")
    public void send_query_to_get_guest_user_by_lesson_program_ıd(String id) throws SQLException {

        resultset=statement.executeQuery("select *from lesson_program where id="+id+"");
        System.out.println("veri"+resultset.next());


    }
    @Then("body should be like: day={string} start_time={string} stop_time={string} education_term_id={string}")
    public void body_should_be_like_day_start_time_stop_time_education_term_id(String day, String start_time, String stop_time, String education_term_id) throws SQLException {

        String actDay = resultset.getString("day");
        String actStartTime = resultset.getString("start_time");
        String actStopTime = resultset.getString("stop_time");
        String actEducation_term_id = resultset.getString("education_term_id");


        assertEquals(day, actDay);
        assertEquals(start_time, actStartTime);
        assertEquals(stop_time, actStopTime);
        assertEquals(education_term_id, actEducation_term_id);


    }

}
