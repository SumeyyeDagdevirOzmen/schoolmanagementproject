package stepdefinitions.database;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.*;

public class ContactMessageDBStepDefs {
    Statement statement;
    ResultSet resultset;
    Connection connection;
    @Given("user07 connects to database")
    public void user07_connects_to_database() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://164.92.252.42:5432/school_management", "select_user", "43w5ijfso");
        statement = connection.createStatement();
        resultset = statement.executeQuery("Select * From contact_message where id=484");
        resultset.next();
    }

    @Then("DeanHavaDb yazilan mesajlarin kime ait oldugunu gorur ve dogrular")
    public void dean_hava_db_yazilan_mesajlarin_kime_ait_oldugunu_gorur_ve_dogrular() throws SQLException {
        //JdbcUtils.execute("select * from lesson_program where id=401");

        String date = "2023-05-03";
        String email = "Evin21@gmail.com";
        String message = "En muchas paginas no hay el buton de borrar";
        String name = "Evin ";
        String subject = "Hay que mejorar ";
        Assert.assertEquals(date,resultset.getString("date"));
        Assert.assertEquals(email,resultset.getString("email"));
        Assert.assertEquals(message,resultset.getString("message"));
        Assert.assertEquals(name,resultset.getString("name"));
        Assert.assertEquals(subject,resultset.getString("subject"));

    }


}