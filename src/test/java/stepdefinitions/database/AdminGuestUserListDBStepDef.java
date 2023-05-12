package stepdefinitions.database;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.*;

import static org.junit.Assert.assertEquals;
public class AdminGuestUserListDBStepDef {

    Connection connection ;
    Statement statement ;
    ResultSet resultSet ;
    @Given("Find Guest User Info")
    public void findGuestUserInfo() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://164.92.252.42:5432/school_management", "select_user", "43w5ijfso");
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM guest_user WHERE id = 192");
        resultSet.next();


    }

    @Then("Validate data US_02 id_192")
    public void validateDataUSId() throws SQLException {
        assertEquals("2001-01-01",resultSet.getString("birth_day"));
        assertEquals("Ankara",resultSet.getString("birth_place"));
        assertEquals("MALE",resultSet.getString("gender"));
        assertEquals("710-116-8468",resultSet.getString("phone_number"));
        assertEquals("746-40-7462",resultSet.getString("ssn"));
        assertEquals("AlphonsoTromp",resultSet.getString("username"));
        assertEquals("Adan",resultSet.getString("name"));
        assertEquals("Kilback",resultSet.getString("surname"));

        connection.close();
        statement.close();
        resultSet.close();

    }
}
/*
 "id": 192,
            "username": "AlphonsoTromp",
            "ssn": "746-40-7462",
            "name": "Adan",
            "surname": "Kilback",
            "birthDay": "2001-01-01",
            "birthPlace": "Ankara",
            "phoneNumber": "710-116-8468",
            "gender": "MALE"
        },
 */



