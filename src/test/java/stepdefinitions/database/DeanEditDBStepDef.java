package stepdefinitions.database;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

import static junit.framework.TestCase.assertEquals;

public class DeanEditDBStepDef {


    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("{string} ile dean al")
    public void ile_dean_al(String username) throws SQLException {

        connection = DriverManager.getConnection("jdbc:postgresql://164.92.252.42:5432/school_management", "select_user", "43w5ijfso");
        statement = connection.createStatement();

        resultSet = statement.executeQuery("SELECT * FROM dean WHERE username = '"+username+"';");
        resultSet.next();

    }
    @Then("resultSet bodyi dogrula: userId={string}, username={string}, name={string}, surname={string}, birthDay={string}, ssn={string}, birthPlace={string}, phoneNumber={string}, gender={string}")
    public void result_set_bodyi_dogrula_user_id_username_name_surname_birth_day_ssn_birth_place_phone_number_gender(String userId, String username, String name, String surname, String birthDay, String ssn, String birthPlace, String phoneNumber, String gender) throws SQLException {

        String actUserId = resultSet.getString("id");
        String actUsername = resultSet.getString("username");
        String actName = resultSet.getString("name");
        String actSurname = resultSet.getString("surname");
        String actBirthDay = resultSet.getString("birth_day");
        String actSsn = resultSet.getString("ssn");
        String actBirthPlace = resultSet.getString("birth_place");
        String actPhoneNumber = resultSet.getString("phone_number");
        String actGender =  resultSet.getString("gender");

        assertEquals(userId, actUserId);
        assertEquals(username,actUsername);
        assertEquals(name,actName);
        assertEquals(surname,actSurname);
        assertEquals(birthDay,actBirthDay);
        assertEquals(ssn,actSsn);
        assertEquals(birthPlace,actBirthPlace);
        assertEquals(phoneNumber,actPhoneNumber);
        assertEquals(gender,actGender);
    }

}
