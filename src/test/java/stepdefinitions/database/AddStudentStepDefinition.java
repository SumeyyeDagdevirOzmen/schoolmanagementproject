package stepdefinitions.database;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static stepdefinitions.api.AddStudentAPI.*;

public class AddStudentStepDefinition {

    ResultSet resultSet;
    Connection connection;
    Statement statement;


    @Given("User Sevim connects to DataBase")
    public void user_sevim_connects_to_data_base() {
        connection= JdbcUtils.connectToDataBase("164.92.252.42","school_management","select_user","43w5ijfso");
        statement = JdbcUtils.createStatement();
    }
    @When("User Sevim finds studentinfo by {string}")
    public void user_sevim_finds_studentinfo_by(String string) throws SQLException {
        resultSet= statement.executeQuery("select * from student where '"+string+"'");
        resultSet.next();
    }

    @Then("User Sevim validates data student")
    public void user_sevim_validates_data_student() throws SQLException {

              assertEquals(userName,resultSet.getString("username"));
              assertEquals(name,resultSet.getString("name"));
              assertEquals(surName,resultSet.getString("surname"));
              assertEquals(fatherName,resultSet.getString("father_name"));
              assertEquals(motherName,resultSet.getString("mother_name"));
              assertEquals(email,resultSet.getString("email"));

        connection.close();
        statement.close();
        resultSet.close();
    }

    @When("User Sevim finds studentinfo by id")
    public void userSevimFindsStudentinfoById() throws SQLException {


        //resultSet= statement.executeQuery("select * from student where id='95'");

        resultSet= statement.executeQuery("select * from student where id='"+userId+"'");
        resultSet.next();
        System.out.println("resultSet = " + resultSet);
    }


}
