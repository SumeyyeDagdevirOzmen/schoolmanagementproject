package stepdefinitions.database;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.*;

public class StudentInfoLessonDBStepDef {


    Statement statement;
    ResultSet resultset;
    Connection connection;

    @Given("User21 connect to database")
    public void user21_connect_to_database() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://164.92.252.42:5432/school_management", "select_user", "43w5ijfso");
        statement = connection.createStatement();

    }
    @When("User21 send query for lesson name")
    public void user21_send_query_for_lesson_name() throws SQLException {
        resultset = statement.executeQuery("select lesson_name from lesson where lesson_id=2");
        resultset.next();
    }
    @Then("User21 valide the lesson name")
    public void user21_valide_the_lesson_name() throws SQLException {

        Assert.assertEquals("CALCULUS",resultset.getString("lesson_name"));


    }
    @When("User21 see which lesson_program_id matches lesson_id")
    public void user21_see_which_lesson_program_id_matches_lesson_id() throws SQLException {
        resultset = statement.executeQuery("select * from lesson_program_lesson where lesson_lesson_id=2 and lesson_program_id=2");
        resultset.next();
    }
    @Then("User21 valide lesson_program_id")
    public void user21_valide_lesson_program_id() throws SQLException {
        Assert.assertEquals(2,resultset.getInt("lesson_lesson_id"));
        Assert.assertEquals(2,resultset.getInt("lesson_program_id"));
    }

    @When("user21  send query for start_time,stop_time")
    public void user21_send_query_for_start_time_stop_time() throws SQLException {

        resultset = statement.executeQuery("select start_time,stop_time from lesson_program where id=2");
        resultset.next();

    }
    @Then("user21 valide start_time,stop_time")
    public void user21_valide_start_time_stop_time() throws SQLException {

        Assert.assertEquals("10:00:00",resultset.getString("start_time"));
        Assert.assertEquals("12:00:00",resultset.getString("stop_time"));
    }
    @When("user21 send query to see teacher id in the choose Lesson")
    public void user21_send_query_to_see_teacher_id_in_the_choose_lesson() throws SQLException {

        resultset = statement.executeQuery("SELECT * FROM teacher_lessonprogram WHERE teacher_id=9 and lesson_program_id=2");
        resultset.next();

    }
    @Then("user21 valide the data")
    public void user21_valide_the_data() throws SQLException {
        Assert.assertEquals(9,resultset.getInt("teacher_id"));
        Assert.assertEquals(2,resultset.getInt("lesson_program_id"));
    }
    @When("user21 send query to see teacher name")
    public void user21_send_query_to_see_teacher_name() throws SQLException {

        resultset = statement.executeQuery("select name from teacher where id=9");
        resultset.next();
    }
    @Then("user21 valide teacher name")
    public void user21_valide_teacher_name() throws SQLException {

        Assert.assertEquals("Nihal",resultset.getString("name"));
    }

    @When("User21 send query to see meeting information")
    public void user21_send_query_to_see_meeting_information() throws SQLException {
        resultset = statement.executeQuery("select date,description,start_time,stop_time from meet where id=6");
        resultset.next();
    }
    @Then("User21 validation meeting information")
    public void user21_validation_meeting_information() throws SQLException {

        Assert.assertEquals("2023-10-16",resultset.getString("date"));
        Assert.assertEquals("TezKonusu",resultset.getString("description"));
        Assert.assertEquals("14:00:00",resultset.getString("start_time"));
        Assert.assertEquals("15:00:00",resultset.getString("stop_time"));

    }


    @When("User21 sends query to see student grades")
    public void user21_sends_query_to_see_student_grades() throws SQLException {
        resultset = statement.executeQuery("select absentee,final_exam,info_note,midterm_exam,exam_average from student_info where student_id=6 and lesson_lesson_id=2");
        resultset.next();
    }
    @Then("User21 validation see student grades")
    public void user21_validation_see_student_grades() throws SQLException {
        int absentee =5;
        int final_exam=65;
        String info_note="iyi gidiyorsun";
        int midterm_exam=55;
        int exam_average=61;
        Assert.assertEquals(absentee,resultset.getInt("absentee"));
        Assert.assertEquals(final_exam,resultset.getInt("final_exam"));
        Assert.assertEquals(info_note,resultset.getString("info_note"));
        Assert.assertEquals(midterm_exam,resultset.getInt("midterm_exam"));
        Assert.assertEquals(exam_average,resultset.getInt("exam_average"));

    }

      /*
    select lesson_name from lesson where lesson_id=2  ==> ders ismi CALCULUS
    select start_time,stop_time from lesson_program where id=2  ==> start_time stop_time
      SELECT * FROM teacher_lessonprogram WHERE teacher_id=9 and lesson_program_id=2  ogretmen
     select name from teacher where id=9  ismi
    select date,description,start_time,stop_time from meet where id=6  ==> toplamti bilgileri
    select * from student_info where student_id=6   ==>ogrenci notlari
    select * from lesson_program_lesson where lesson_program_id=1  ==> lessonid
     */


}
