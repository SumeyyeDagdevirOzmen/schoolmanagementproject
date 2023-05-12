package stepdefinitions.database;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.interactions.Actions;
import pages.DeanManagementPage;
import pojos.US06_DeanViceDeanRequestPojo;
import utilities.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Us06_DeanCreateViceDean {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    List<Object> vicebirtdaylist = new ArrayList<>();
    List<Object> viceNamelist = new ArrayList<>();
    List<Object> viceSurnamelist = new ArrayList<>();
    List<Object> vicePhonelist = new ArrayList<>();
    List<Object> viceSsnlist = new ArrayList<>();
    List<Object> viceUsernamelist = new ArrayList<>();
    List<Object> vicePasswordlist = new ArrayList<>();
    List<Object> viceBirthPlacelist = new ArrayList<>();
    Faker faker = new Faker();
    String ssn = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(10, 99) + "-" + faker.number().numberBetween(1000, 9999);
    String username = faker.name().username();
    List<Object> myDynamicQuery = new ArrayList<>();
    Response response;
    String phoneNumber = faker.number().digits(3) + "-" + faker.number().digits(3) + "-" + faker.number().digits(4) + "";
    US06_DeanViceDeanRequestPojo expectedData;
    String bday;
    String birthPlace;
    String name;
    String surname;
    String userName;
    String ssN;
    String phonenumbeR;

    @Given("Kullanici_yusuf Vice Dean ekler")
    public void kullanici_vice_dean_ekler() {
        spec.pathParams("first", "vicedean", "second", "save");
        expectedData = new US06_DeanViceDeanRequestPojo("1990-04-17", "Paris", "MALE", "Natalia", "12345678", phoneNumber, ssn,
                "Karima", username);
        response = given(spec).body(expectedData).contentType(ContentType.JSON).when().post("/{first}/{second}");
        response.prettyPrint();
        bday=expectedData.getBirthDay();
        birthPlace=expectedData.getBirthPlace();
        name=expectedData.getName();
        surname=expectedData.getSurname();
        userName=expectedData.getUsername();
        ssN=expectedData.getSsn();
        phonenumbeR=expectedData.getPhoneNumber();


    }

    @When("Databaseden_yusuf olusturulan vice dean bilgileri sorgulanir")
    public void databaseden_olusturulan_vice_dean_bilgileri_sorgulanir() throws SQLException {
        vicebirtdaylist = Collections.singletonList(JdbcUtils.getQueryResultMap("select birth_day from vice_dean"));
        viceBirthPlacelist = Collections.singletonList(JdbcUtils.getQueryResultMap("select birth_place from vice_dean"));
        viceNamelist = Collections.singletonList(JdbcUtils.getQueryResultMap("select name from vice_dean"));
        viceUsernamelist = Collections.singletonList(JdbcUtils.getQueryResultMap("select username from vice_dean"));
        viceSurnamelist = Collections.singletonList(JdbcUtils.getQueryResultMap("select surname from vice_dean"));
        viceSsnlist = Collections.singletonList(JdbcUtils.getQueryResultMap("select ssn from vice_dean"));
        vicePasswordlist = Collections.singletonList(JdbcUtils.getQueryResultMap("select password from vice_dean"));
        vicePhonelist = Collections.singletonList(JdbcUtils.getQueryResultMap("select phone_number from vice_dean;"));
        System.out.println("vicebirtdaylist = " + vicebirtdaylist.toString());

    }

    @Then("Databasede_yusuf deanin ekledigi vice deanin goruldugu dogrulanir.")
    public void databasede_deanin_ekledigi_vice_deanin_goruldugu_dogrulanir() {
     assertTrue(vicebirtdaylist.get(0).toString().contains(bday));
     assertTrue(viceNamelist.get(0).toString().contains(name));
     assertTrue(viceSurnamelist.get(0).toString().contains(surname));
     assertTrue(viceBirthPlacelist.get(0).toString().contains(birthPlace));
     assertTrue(viceUsernamelist.get(0).toString().contains(userName));
     assertTrue(viceSsnlist.get(0).toString().contains(ssN));
     assertTrue(vicePhonelist.get(0).toString().contains(phonenumbeR));

    }

    @When("Databaseden_yusuf olusturulan {string} icin {string} ozellikli sorgu yapilir.")
    public void databaseden_olusturulan_icin_ozellikli_sorgu_yapilir(String column, String data) throws SQLException {
        myDynamicQuery = Collections.singletonList(JdbcUtils.getQueryResultMap("select * from vice_dean where " + column + "=" + data));

    }

    @Then("Olusturulan_yusuf {string} icin {string} ozellikli verinin dogrulamasi yapilir")
    public void olusturulan_icin_ozellikli_verinin_dogrulamasi_yapilir(String column, String data) throws SQLException {
        assert myDynamicQuery.toString().contains(data);
        connection.close();
        statement.close();
        resultSet.close();

    }
    @When("Database_yusuf icin connect saglanir")
    public void database_yusufIcinConnectSaglanir() {
        connection= JdbcUtils.connectToDataBase("164.92.252.42","school_management","select_user","43w5ijfso");
        statement = JdbcUtils.createStatement();
    }


}
