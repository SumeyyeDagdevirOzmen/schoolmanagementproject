package stepdefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import org.junit.Assert;
import pojos.US25_StudentDataPojo;
import pojos.US25_StudentResponsePojo;
import utilities.JdbcUtils;
import utilities.ObjectMapperUtils;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class Us25_StudentCreate_Admin_ {
    ResultSet resultSet;
    Connection connection;
    Statement statement;


    static Response response;

    US25_StudentDataPojo expectedData = new US25_StudentDataPojo();

    @Given("User25 sets the Url")
    public void user25_sets_the_url() {
        //set the url
        spec.pathParams("first", "students", "second", "save");


    }


    @Then("User25 gets the student data and assert")
    public void userGetsTheStudentDataAndAssert() {

        US25_StudentResponsePojo actueldata = ObjectMapperUtils.convertJsonToJawa(response.asString(),US25_StudentResponsePojo.class);
        System.out.println("actueldata = " + actueldata);


        assertEquals(expectedData.getGender(), actueldata.getObject().getGender());
        assertEquals(expectedData.getName(), actueldata.getObject().getName());
        assertEquals(expectedData.getSurname(), actueldata.getObject().getSurname());
        assertEquals(expectedData.getPhoneNumber(), actueldata.getObject().getPhoneNumber());
        assertEquals(expectedData.getMotherName(), actueldata.getObject().getMotherName());
        assertEquals(expectedData.getFatherName(), actueldata.getObject().getFatherName());
        assertEquals(expectedData.getEmail(), actueldata.getObject().getEmail());
        assertEquals(expectedData.getUsername(), actueldata.getObject().getUsername());


        assertEquals("Student saved Successfully", actueldata.getMessage());






        /*
        {
    "object": {
        "userId": 55,
        "username": "234567kubra",
        "name": "kubra",
        "surname": "tan",
        "birthDay": "2000-03-03",
        "birthPlace": "istanbul",
        "phoneNumber": "223-456-5555",
        "gender": "FEMALE",
        "studentNumber": 1053,
        "motherName": "emel",
        "fatherName": "ali",
        "email": "abc@gmail.com",
        "active": true
    },
    "message": "Student saved Successfully"
}
         */


        //   }
    }

    @When("User25 send_post request for student")
    public void userSend_postRequestForStudent() {
        int num20 = Faker.instance().number().numberBetween(1000, 9999);

        expectedData = new US25_StudentDataPojo(""+num20+"kub", "kubra", "tan", "2000-03-03", "istanbul", "450-345-"+num20+"" , "FEMALE", "emel", "ali",  ""+num20+"abc@gmail.com", "2", "204-32-"+num20+"","12345678");
        spec.pathParams("first", "students", "second", "save");
        response = given(spec).header("Accept", "*/*").body(expectedData).post("/{first}/{second}");

//(String username, String name, String surname, String birthDay, String birthPlace, String phoneNumber, String gender, String motherName, String fatherName, String email, Boolean active, String advisorTeacherId, String ssn, String password)
    }


    @And("UserKubra_25 verifys that Status code is 200")
    public void userkubra_VerifysThatStatusCodeIs() {
        assertEquals(200,response.statusCode());
    }
    @Given("User25 connects to database")
    public void user25_connects_to_database() {
        connection= JdbcUtils.connectToDataBase("164.92.252.42","school_management","select_user","43w5ijfso");
        statement = JdbcUtils.createStatement();


    }
    @When("User25 Find student by id")
    public void user25_find_student_by_username() throws SQLException {
        resultSet= statement.executeQuery("select * from student where id='95'");
        resultSet.next();
        System.out.println("resultSet = " + resultSet);


    }
    @Then("User25 validate the datas")
    public void user25_validate_the_datas() throws SQLException {
        Assert.assertEquals("2000-03-03", resultSet.getString("birth_day"));
        Assert.assertEquals("istanbul", resultSet.getString("birth_place"));
        Assert.assertEquals("FEMALE", resultSet.getString("gender"));
        Assert.assertEquals("kubra", resultSet.getString("name"));
        Assert.assertEquals("450-345-3566", resultSet.getString("phone_number"));
        Assert.assertEquals("204-32-3566", resultSet.getString("ssn"));
        Assert.assertEquals("tan", resultSet.getString("surname"));
        Assert.assertEquals("3566kub", resultSet.getString("username"));
        Assert.assertEquals("3566abc@gmail.com",resultSet.getString("email"));
        Assert.assertEquals("ali",resultSet.getString("father_name"));
        Assert.assertEquals("emel",resultSet.getString("mother_name"));
        Assert.assertEquals(true,resultSet.getBoolean("is_active"));
        Assert.assertEquals(95,resultSet.getInt("id"));
        Assert.assertEquals(1093,resultSet.getInt("student_number"));
        Assert.assertEquals("2",resultSet.getString("advisor_teacher_id"));
        Assert.assertEquals(5, resultSet.getInt("user_role_id"));

        connection.close();
        statement.close();
        resultSet.close();


    }


}

