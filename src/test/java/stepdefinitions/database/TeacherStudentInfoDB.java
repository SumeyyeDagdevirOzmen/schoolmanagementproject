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

public class TeacherStudentInfoDB {

    Statement statement;
    ResultSet resultset;
    Connection connection;



    @Given("user connects to database..")
    public void userConnectsToDatabase() {
        connection=  JdbcUtils.connectToDataBase("164.92.252.42","school_management","select_user","43w5ijfso");
        statement =   JdbcUtils.createStatement();

    }


    @When("find studentinfo by studentId")
    public void find_studentinfo_by_student_ıd() throws SQLException {
     //   JdbcUtils.execute("select *from student_info where student_id=42");
        resultset=statement.executeQuery("select * from student_info where education_term_id=4");
        resultset.next();

    }
    @Then("validate data student")
    public void validate_data_student() throws SQLException {
        Assert.assertEquals(24,resultset.getInt("id"));
        Assert.assertEquals(3,resultset.getInt("absentee"));
        Assert.assertEquals(30,resultset.getInt("exam_average"));
        Assert.assertEquals(30,resultset.getInt("final_exam"));
        Assert.assertEquals("cok calismak gerek",resultset.getString("info_note"));
        Assert.assertEquals("FF",resultset.getString("letter_grade"));
        Assert.assertEquals(30,resultset.getInt("midterm_exam"));
        Assert.assertEquals(4,resultset.getInt("education_term_id"));
        Assert.assertEquals(7,resultset.getInt("lesson_lesson_id"));
        Assert.assertEquals(4,resultset.getInt("student_id"));
        Assert.assertEquals(9,resultset.getInt("teacher_id"));


    }

}
