package stepdefinitions.database;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.*;

public class TecherStudentInfoDBStepDefs {
    Statement statement;
    ResultSet resultset;
    Connection connection;
    @Given("User17 DataBaseye baglanir")
    public void user17_data_baseye_baglanir() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://164.92.252.42:5432/school_management", "select_user", "43w5ijfso");
        statement = connection.createStatement();
        resultset = statement.executeQuery("Select * From student_info where id=1120");
        resultset.next();
    }
    @Then("TeacherHavaDB not verdigi ogrenciyi dogrular")
    public void teacher_hava_db_not_verdigi_ogrenciyi_dogrular() throws SQLException {
        int id = 1120;
        int absentee = -7;
        String info_note = "esta todo muy bien";
        int education_term_id= 3;
        int lesson_lesson_id =5;
        int student_id=8;
        int teacher_id=9;
        Assert.assertEquals(id,resultset.getInt("id"));
        Assert.assertEquals(absentee,resultset.getInt("absentee"));
        Assert.assertEquals(info_note,resultset.getString("info_note"));
        Assert.assertEquals(education_term_id,resultset.getInt("education_term_id"));
        Assert.assertEquals(lesson_lesson_id,resultset.getInt("lesson_lesson_id"));
        Assert.assertEquals(student_id,resultset.getInt("student_id"));
        Assert.assertEquals(teacher_id,resultset.getInt("teacher_id"));




    }



}
