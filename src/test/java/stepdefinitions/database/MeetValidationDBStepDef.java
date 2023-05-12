package stepdefinitions.database;

import io.cucumber.java.en.*;
import utilities.JdbcUtils;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class MeetValidationDBStepDef {
    ResultSet resultSet;
    Connection connection;
    Statement statement;

    @Given("usergul connect to database")
    public void usergul_connect_to_database() {
        connection= JdbcUtils.connectToDataBase("164.92.252.42","school_management","select_user","43w5ijfso");
        statement = JdbcUtils.createStatement();

    }
    @When("Usergul finds meet by MeetID")
    public void usergul_finds_meet_by_meet_id() throws SQLException {

        resultSet= statement.executeQuery("select * from meet where id=60");
        resultSet.next();

    }
    @Then("Usergul validates Data")
    public void usergul_validates_data() throws SQLException {
        assertEquals(60,resultSet.getInt("id"));
        assertEquals("2024-10-12",resultSet.getString("date"));
        assertEquals("Materyal",resultSet.getString("description"));
        assertEquals("17:30:00",resultSet.getString("start_time"));
        assertEquals("18:00:00",resultSet.getString("stop_time"));
        assertEquals(8,resultSet.getInt("advisor_teacher_id"));
        connection.close();
        statement.close();
        resultSet.close();



    }
}
