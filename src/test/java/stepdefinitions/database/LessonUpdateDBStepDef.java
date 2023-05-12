package stepdefinitions.database;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LessonUpdateDBStepDef {
    ResultSet resultSet;
    Connection connection;
    Statement statement;
    @Given("Find lesson by ID")
    public void find_lesson_by_id() throws SQLException {
        //SELECT * FROM teacher WHERE id = 35;
        connection = DriverManager.getConnection("jdbc:postgresql://164.92.252.42:5432/school_management", "select_user", "43w5ijfso");
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM lesson where lesson_id=6");


        resultSet.next();
    }
    @Then("Validate data lessson")
    public void validate_data_lessson() throws SQLException {
       // 6	5	true	"Math"
        assertEquals(5, resultSet.getInt("credit_score"));
        assertTrue( resultSet.getBoolean("is_compulsory"));
        assertEquals("Math", resultSet.getString("lesson_name"));

        connection.close();
        statement.close();
        resultSet.close();
    }

}
