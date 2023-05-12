package stepdefinitions.database;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.*;

import static org.junit.Assert.*;

public class ViceDeanAddTeacherValidationDBStepDef {
    ResultSet resultSet;
    Connection connection;
    Statement statement;


    @Given("ViceDeanS connects to database")
    public void vice_dean_s_connects_to_database() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://164.92.252.42:5432/school_management", "select_user", "43w5ijfso");


    }

    @When("ViceDeansS finds teacher by ID")
    public void vicedeanssFindsTeacherByID() throws SQLException {
        statement= connection.createStatement();
      //  resultSet= statement.executeQuery("select * from teacher where id=330");
        resultSet= statement.executeQuery("select * from teacher where id=343");
        resultSet.next();
        //330,"SumeyyeCanan","Sumeyye","Canan","2000-02-12","125-45-7892","Rize","222-911-4444","FEMALE","sumeyyecan@gmail.com";
    }

    @Then("ViceDeanS validates data")
    public void vicedeansValidatesData() throws SQLException {
//        assertEquals("2000-02-12",resultSet.getString("birth_day"));
//        assertEquals("Rize",resultSet.getString("birth_place"));
//        assertEquals("FEMALE",resultSet.getString("gender"));
//        assertEquals("Sumeyye",resultSet.getString("name"));
//        assertEquals("222-911-4444",resultSet.getString("phone_number"));
//        assertEquals("125-45-7892",resultSet.getString("ssn"));
//        assertEquals("Canan",resultSet.getString("surname"));
//        assertEquals("SumeyyeCanan1",resultSet.getString("username"));
//        assertEquals("sumeyyecan@gmail.com",resultSet.getString("email"));
//        assertTrue(resultSet.getBoolean("is_advisor"));
//        assertEquals(4,resultSet.getInt("user_role_id"));

        assertEquals("1991-06-08",resultSet.getString("birth_day"));
        assertEquals("Istanbul",resultSet.getString("birth_place"));
        assertEquals("FEMALE",resultSet.getString("gender"));
        assertEquals("Ayse",resultSet.getString("name"));
        assertEquals("124-856-8138",resultSet.getString("phone_number"));
        assertEquals("154-29-8138",resultSet.getString("ssn"));
        assertEquals("Yilmaz",resultSet.getString("surname"));
        assertEquals("8138Ayseteam03",resultSet.getString("username"));
        assertEquals("Flor@gmail.com",resultSet.getString("email"));
        assertFalse(resultSet.getBoolean("is_advisor"));
        assertEquals(4,resultSet.getInt("user_role_id"));

        connection.close();
        statement.close();
        resultSet.close();
    }
}
