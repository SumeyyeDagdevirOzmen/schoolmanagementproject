package stepdefinitions.database;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.*;

import static org.junit.Assert.*;

public class TeacherUpdateDBStepDef {
    ResultSet resultSet;
    Connection connection;
    Statement statement;

    @Given("Find teacher by ID")
    public void find_teacher_by_id() throws SQLException {
        //SELECT * FROM teacher WHERE id = 35;
        connection = DriverManager.getConnection("jdbc:postgresql://164.92.252.42:5432/school_management", "select_user", "43w5ijfso");
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM teacher WHERE id = 21");
        resultSet.next();

    }

    @Then("Validate data teacher")
    public void validate_data_teacher() throws SQLException {



//21	"2000-12-12"	"istanbul"	"FEMALE"	"Mina"	"$2a$10$EJ4YQ8LYRnoI12JNAQRot.zkZ0PhnUt3DZsW8K.82agmbni/lJruW"
// "786-666-4538"	"554-87-6079"	"Unsal"	"Misal"	"mina@hotmail.com"	false	421	"2000-12-12"	"istanbul"	"FEMALE"
// "Mina"	"786-666-4538"	"554-87-6079"	"Unsal"	"Misal"	"mina@hotmail.com"	false	4

            assertEquals("2000-12-12", resultSet.getString("birth_day"));
            assertEquals("istanbul", resultSet.getString("birth_place"));
            assertEquals("FEMALE", resultSet.getString("gender"));
            assertEquals("Mina", resultSet.getString("name"));
            assertEquals("786-666-4538", resultSet.getString("phone_number"));
            assertEquals("554-87-6079", resultSet.getString("ssn"));
            assertEquals("Unsal", resultSet.getString("surname"));
            assertEquals("Misal", resultSet.getString("username"));
            assertEquals("mina@hotmail.com", resultSet.getString("email"));
            assertFalse(resultSet.getBoolean("is_advisor"));
            assertEquals(4, resultSet.getInt("user_role_id"));

            connection.close();
            statement.close();
            resultSet.close();


        }


    }
