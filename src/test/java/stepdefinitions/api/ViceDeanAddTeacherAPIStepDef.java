package stepdefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.US13TeacherActualPojo;
import pojos.US13TeacherObjectPojo;
import pojos.US13TeacherExpectedData;
import java.util.ArrayList;
import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.ReusableMethods.generateRandomUsername;

public class ViceDeanAddTeacherAPIStepDef {

    ArrayList<Integer> lessonsIdList;
    US13TeacherExpectedData expectedData;
    US13TeacherExpectedData lessonid;
    US13TeacherObjectPojo object;
    US13TeacherActualPojo actualData;
    Response response;

   String mail =Faker.instance().name().firstName()+"@gmail.com";
    Faker faker= new Faker();
    String invalidEmail= Faker.instance().name().firstName()+"@gmail";

    int num4 = Faker.instance().number().numberBetween(1000, 9999);
    int num5=Faker.instance().number().numberBetween(10000,99999);
    String num6;
    String ssn = Faker.instance().number().digits(9).substring(0, 3) +
            "-" + Faker.instance().number().digits(9).substring(3, 5) +
            "-" + Faker.instance().number().digits(9).substring(5);

    @When("Vice DeanS sends post for adding teacher")
    public void viceDeanSSendsPostForAddingTeacher() {

       lessonid=new US13TeacherExpectedData();


        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);



        //Set the expected data
        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),
                "Ayse","Aysemm1234",
                "124-856-"+num4+"","154-29-"+num4+"","Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        System.out.println("mail = " + mail);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }
    @Then("Vice Dean gets the data and verify")
    public void vice_dean_gets_the_data_and_verify() {

        object = new US13TeacherObjectPojo(1883,num4+"Ayseteam03","Ayse","Yilmaz","1991-06-08",
                "154-29-"+num4+"","Istanbul","124-856-"+num4+"","FEMALE",mail);

         actualData=new US13TeacherActualPojo(object,"Teacher saved successfully","CREATED");

        System.out.println("actualdata = " + actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getUsername(), actualData.getObject().getUsername());
        assertEquals(expectedData.getName(), actualData.getObject().getName());
        assertEquals(expectedData.getSurname(), actualData.getObject().getSurname());
        assertEquals(expectedData.getBirthDay(),actualData.getObject().getBirthDay());
        assertEquals(expectedData.getSsn(), actualData.getObject().getSsn());
        assertEquals(expectedData.getBirthPlace(), actualData.getObject().getBirthPlace());
        assertEquals(expectedData.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        assertEquals(expectedData.getGender(), actualData.getObject().getGender());
        assertEquals(expectedData.getEmail(),actualData.getObject().getEmail());
        assertEquals("Teacher saved successfully",actualData.getMessage());
        assertEquals("CREATED",actualData.getHttpStatus());




    }


    @When("Vice DeanS sends post request without choose lessons dropdown")
    public void viceDeanSSendsPostRequestWithoutChooseLessonsDropdown() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());

        //Set the expected data

        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "124-856-"+num4+"","154-29-"+num4+"","Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @Then("Vice DeanS verify the status code should be {int}")
    public void viceDeanSVerifyTheStatusCodeShouldBe(int statusCode) {
        Assert.assertEquals(400,response.statusCode());
    }

    @When("Vice DeanS sends post request without name")
    public void viceDeanSSendsPostRequestWithoutName() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);


        //Set the expected data
        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"","Aysemm1234",
                "124-856-"+num4+"","154-29-"+num4+"","Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @When("Vice Dean sends the post request with the space characters to the name field")
    public void viceDeanSendsThePostRequestWithTheSpaceCharactersToTheNameField() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);


        //Set the expected data

        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"    ","Aysemm1234",
                "124-856-"+num4+"","154-29-"+num4+"","Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @When("Vice Dean sends the post request without surname")
    public void viceDeanSendsThePostRequestWithoutSurname() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);



        //Set the expected data

        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "124-856-"+num4+"","154-29-"+num4+"","",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }

    @When("Vice Dean sends the post request with the space characters to the surname field")
    public void viceDeanSendsThePostRequestWithTheSpaceCharactersToTheSurnameField() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);



        //Set the expected data

        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "124-856-"+num4+"","154-29-"+num4+"","      ",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }

    @When("Vice Dean sends the post request without birthplace")
    public void viceDeanSendsThePostRequestWithoutBirthplace() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);


        //Set the expected data
        expectedData=new US13TeacherExpectedData("1991-06-08","",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "124-856-"+num4+"","154-29-"+num4+"","      ",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }

    @When("Vice Dean sends the post request with the space characters to the birthplace field")
    public void viceDeanSendsThePostRequestWithTheSpaceCharactersToTheBirthplaceField() {

            lessonid=new US13TeacherExpectedData();
            lessonid.setLessonsIdList(new ArrayList<>());
            lessonid.getLessonsIdList().add(0,5);
            lessonid.getLessonsIdList().add(1,3);
            lessonid.getLessonsIdList().add(2,8);



            //Set the expected data
            expectedData=new US13TeacherExpectedData("1991-06-08","    ",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                    "124-856-"+num4+"","154-29-"+num4+"","Yilmaz",num4+"Ayseteam03");
            System.out.println("expectedData = " + expectedData);
            //send the request get the response
            response= given(spec).when().body(expectedData).post("/{first}/{second}");
            response.prettyPrint();

        }

    @When("Vice Dean sends the post request without email")
    public void viceDeanSendsThePostRequestWithoutEmail() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);


        //Set the expected data

        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul","","FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "124-856-"+num4+"","154-29-"+num4+"","Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }

    @When("Vice Dean sends the post request without .com for the email")
    public void viceDeanSendsThePostRequestWithoutComEmail() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);



        //Set the expected data

        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",invalidEmail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "124-856-"+num4+"",ssn,"Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
        System.out.println("invalidEmail = " + invalidEmail);

    }


    @When("Vice Dean sends the post request without @ character for the email")
    public void viceDeanSendsThePostRequestWithoutCharacterForTheEmail() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);



        //Set the expected data
        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul","hadjjka.com","FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "124-856-"+num4+"","154-29-"+num4+"","Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }

    @When("Vice Dean sends the post request without phoneNumber")
    public void viceDeanSendsThePostRequestWithoutPhoneNumber() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);


        //Set the expected data
        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "","154-29-"+num4+"","Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }

    @When("Vice Dean sends the post request with twelve digits without hyphen for the invalid phone number")
    public void viceDeanSendsThePostRequestWithTwelveDigitsForTheInvalidPhoneNumber() {
        String invalidPhone = Faker.instance().number().digits(12);
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);



        //Set the expected data
        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                invalidPhone,"154-29-"+num4+"","Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @When("Vice Dean sends the post request with eleven digits for the invalid phone number")
    public void viceDeanSendsThePostRequestWithElevenDigitsForTheInvalidPhoneNumber() {
        String invalidPhone2 = Faker.instance().number().digits(11);
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);


        //Set the expected data
        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                invalidPhone2,"154-29-"+num4+"","Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @When("Vice Dean sends the post request without gender options")
    public void viceDeanSendsThePostRequestWithoutGenderOptions() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);



        //Set the expected data
        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "124-856"+"-"+num4,"154-29-"+num4+"","Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }

    @When("Vice Dean sends the post request without dateOfBirth field")
    public void viceDeanSendsThePostRequestWithoutDateOfBirthField() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);


        //Set the expected data
        expectedData=new US13TeacherExpectedData("","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "124-856"+"-"+num4,"154-29-"+num4+"","Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }

    @When("Vice Dean sends the post request without SSN field")
    public void viceDeanSendsThePostRequestWithoutSSNField() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);

        //Set the expected data
        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "124-856"+"-"+num4,"","Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @When("Vice Dean sends the post request without hyphen SSN number for the invalid SSN number")
    public void viceDeanSendsThePostRequestWithoutHyphenSSNNumberForTheInvalidSSNNumber() {
        String invalidSsn = Faker.instance().number().digits(10);
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);

        //Set the expected data

        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "124-856"+"-"+num4,invalidSsn,"Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @When("Vice Dean sends the post request with hyphen after second and fourth numbers for the invalid SSN number")
    public void viceDeanSendsThePostRequestWithHyphenAfterSecondAndFourthNumbersForTheInvalidSSNNumber() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);



        //Set the expected data
        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "124-856"+"-"+num4,"15-42-"+num5+"","Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @When("Vice Dean sends the post request with hyphen after third and sixth numbers for the invalid SSN number")
    public void viceDeanSendsThePostRequestWithHyphenAfterThirdAndSixthNumbersForTheInvalidSSNNumber() {

        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);

        //Set the expected data
         num6= Faker.instance().number().digits(3);
        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "124-856"+"-"+num4,"153-425-"+num6,"Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @When("Vice Dean sends the post request with invalid formatted SSN number")
    public void viceDeanSendsThePostRequestWithInvalidFormattedSSNNumber() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);


        //Set the expected data
        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "124-856"+"-"+num4,"153-42-"+num5,"Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @When("Vice Dean sends the post request without UserName field")
    public void viceDeanSendsThePostRequestWithoutUserNameField() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);


        //Set the expected data
        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "124-856"+"-"+num4,"154-29-"+num4+"","Yilmaz","");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @When("Vice Dean sends the post request with the space characters to the username field")
    public void viceDeanSendsThePostRequestWithTheSpaceCharactersToTheUsernameField() {
        String username2 = generateRandomUsername();
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);


        //Set the expected data
        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "124-856"+"-"+num4,"154-29-"+num4+"","Yilmaz",username2);
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();
    }

    @When("Vice Dean sends the post request without password field")
    public void viceDeanSendsThePostRequestWithoutPasswordField() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);


        //Set the expected data
        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","",
                "124-856"+"-"+num4,"154-29-"+num4+"","Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }

    @When("Vice Dean sends the post request with invalid formatted password")
    public void viceDeanSendsThePostRequestWithInvalidFormattedPassword() {
        String invalidPassword= Faker.instance().number().digits(7);
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);



        //Set the expected data
        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse",invalidPassword,
                "124-856"+"-"+num4,"154-29-"+num4+"","Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();


    }

    @When("Vice Dean sends the post request with space characters for the invalid password")
    public void viceDeanSendsThePostRequestWithSpaceCharactersForTheInvalidPassword() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);
        String invalidPassword2="        ";

        //Set the expected data
        expectedData=new US13TeacherExpectedData("1991-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse",invalidPassword2,
                "124-856"+"-"+num4,"154-29-"+num4+"","Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }

    @When("Vice Dean sends the post request with invalid formatted dateOfBirth")
    public void viceDeanSendsThePostRequestWithInvalidFormattedDateOfBirth() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);


        //Set the expected data
        expectedData=new US13TeacherExpectedData("2025-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "124-856"+"-"+num4,"154-29-"+num4+"","Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();


    }

    @When("Vice DeanS sends the post request with invalid formatted dateOfBirth")
    public void viceDeanSSendsThePostRequestWithInvalidFormattedDateOfBirth() {
        lessonid=new US13TeacherExpectedData();
        lessonid.setLessonsIdList(new ArrayList<>());
        lessonid.getLessonsIdList().add(0,5);
        lessonid.getLessonsIdList().add(1,3);
        lessonid.getLessonsIdList().add(2,8);


        //Set the expected data

        expectedData=new US13TeacherExpectedData("1000-06-08","Istanbul",mail,"FEMALE",true,lessonid.getLessonsIdList(),"Ayse","Aysemm1234",
                "124-856"+"-"+num4,"154-29-"+num4+"","Yilmaz",num4+"Ayseteam03");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
        response= given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

    }

    @Given("Vice DeanS sets the URL")
    public void viceDeanSSetsTheURL() {

        //Set the URL
        spec.pathParams("first","teachers","second","save");
    }
}

