package stepdefinitions.database;

import io.cucumber.java.en.*;

import java.sql.*;

import static org.junit.Assert.assertEquals;

public class GuestUserDBStepDef {
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("Sendfrz query to get guest user by id {string}")
    public void send_query_to_get_guest_user_by_id(String id) throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://164.92.252.42:5432/school_management", "select_user", "43w5ijfso");
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM guest_user WHERE id = 33");

        resultSet.next();

    }

    @Then("bodys should be like: username={string} ssn={string} name={string} surname={string} birthDay={string} birthPlace={string} phoneNumber={string} gender={string}")
    public void body_should_be_like_username_ssn_name_surname_birth_day_birth_place_phone_number_gender(String username, String ssn, String name, String surname, String birthDay, String birthPlace, String phoneNumber, String gender) throws SQLException {

        String actUsername = resultSet.getString("username");
        String actSsn = resultSet.getString("ssn");
        String actName = resultSet.getString("name");
        String actSurname = resultSet.getString("surname");
        String actBirthDay = resultSet.getString("birth_day");
        String actBirthPlace = resultSet.getString("birth_place");
        String actPhoneNumber = resultSet.getString("phone_number");
        String actGender = resultSet.getString("gender");

        assertEquals(username, actUsername);
        assertEquals(ssn, actSsn);
        assertEquals(name, actName);
        assertEquals(surname, actSurname);
        assertEquals(birthDay, actBirthDay);
        assertEquals(birthPlace, actBirthPlace);
        assertEquals(phoneNumber, actPhoneNumber);
        assertEquals(gender, actGender);


    }
}
