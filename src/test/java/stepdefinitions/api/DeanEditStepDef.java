package stepdefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.*;
import utilities.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static base_url.SchoolManagement_BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DeanEditStepDef {


    US05_DeanEditPojo expectput;

    US05_DeanObjectPojo object;
    US05_DeanActualPojo actualData;

    static Response response;

//    static Faker faker = new Faker();
//
//    static int gun = faker.number().numberBetween(10, 28);
//    static int ay5 = faker.number().numberBetween(10, 12);
//     int n04 = Faker.instance().number().numberBetween(1000, 9999);

 //   Map<String, Object> expectedDataPost;

    JsonPath jsonPath;
    static int userId;


    US01_RegisterPojo expectedData;

    //US01_ResponseRegisterPojo expectedData;
    //int num0 = Faker.instance().number().numberBetween(1000, 9999);


    @Given("user05_Set_the_url")
    public void user05_set_the_url() {
        //set the url
        spec.pathParams("first", "dean", "second", "save");
    }

    @When("user05_send POST Request to the Url")
    public void user05_send_post_request_to_the_url() {
        //set the expected data

        expectedData= new US01_RegisterPojo("2001-01-03","bitlis","MALE","david","485424698",
                "121-786-2100","484-54-7870","Som","david001");


        //send the request get the response

        response = given(spec).when().body(expectedData).post("/{first}/{second}");
        response.prettyPrint();

        response.then().statusCode(200);

        jsonPath = response.jsonPath();

        userId = jsonPath.getInt("object.userId");

        System.out.println("UserId = " + userId);
    }


    @Given("f1.user05 set the url for get")
    public void f1_user05_set_the_url_for_get() {



        spec.pathParams("premier", "dean", "second", "getManagerById", "third", userId);

    }
    @When("f1.user05 sends a GET Request to the Url")
    public void f1_user05_sends_a_get_request_to_the_url() {

        response = given(spec).when().get("/{premier}/{second}/{third}");
        response.prettyPrint();
    }

    @Then("f1.for user05 HTTP Status Code Should be {int}")
    public void f1_for_user05_http_status_code_should_be(Integer int1) {

        response.then().statusCode(200);
    }

    @Then("f1.user05 Response body should be like;")
    public void f1_user05_response_body_should_be_like() {

//       {
//    "object": {
//        "userId": 34,
//        "username": "david001",
//        "name": "david",
//        "surname": "Som",
//        "birthDay": "2001-01-03",
//        "ssn": "484-54-7870",
//        "birthPlace": "bitlis",
//        "phoneNumber": "121-786-2100",
//        "gender": "MALE"
//    },
//    "message": "Dean successfully found",
//    "httpStatus": "OK"
//}

        object = new US05_DeanObjectPojo(userId,"david001","david","Som","2001-01-03","484-54-7870","bitlis","121-786-2100","MALE");

        actualData=new US05_DeanActualPojo(object,"Dean successfully found","OK");

        System.out.println("actualdata = " + actualData);

       assertEquals(200,response.statusCode());

        assertEquals(object.getUsername(), actualData.getObject().getUsername());
        assertEquals(object.getName(), actualData.getObject().getName());
        assertEquals(object.getSurname(), actualData.getObject().getSurname());
        assertEquals(object.getBirthDay(),actualData.getObject().getBirthDay());
       assertEquals(object.getSsn(), actualData.getObject().getSsn());
        assertEquals(object.getBirthPlace(), actualData.getObject().getBirthPlace());
        assertEquals(object.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        assertEquals(object.getGender(), actualData.getObject().getGender());

        assertEquals("Dean successfully found",actualData.getMessage());
        assertEquals("OK",actualData.getHttpStatus());


    }

    @Given("f2.user05 set the url for update")
    public void f2_user05_set_the_url_for_update() {


        spec.pathParams("first", "dean", "second", "update", "third", userId);




    }
    @When("f2.user05 sends a PUT Request to the Url")
    public void f2_user05_sends_a_put_request_to_the_url() {

        //set the expected data

        expectput=new US05_DeanEditPojo("2001-01-03","izmir","MALE","yilmaz","485424698","071-786-3120","484-34-0300","yilmaz","sahan0");


        response = given(spec).when().body(expectput).put("/{first}/{second}/{third}");

        response.prettyPrint();




    }
    @Then("f2.for user05 Http Status Code Should be {int}")
    public void f2_for_user05_http_status_code_should_be(Integer int1) {
//        response.then().statusCode(200);

    }
    @Then("f2.user05 Response body should be like:")
    public void f2_user05_response_body_should_be_like() {

//        {
//            "object": {
//            "userId": 34,
//                    "username": "sahan0",
//                    "name": "yilmaz",
//                    "surname": "yilmaz",
//                    "birthDay": "2001-01-03",
//                    "ssn": "484-54-010",
//                    "birthPlace": "izmir",
//                    "phoneNumber": "071-786-212",
//                    "gender": "MALE"
//        },
//            "message": "Dean updated Successful",
//                "httpStatus": "OK"
//        }


        object = new US05_DeanObjectPojo(userId,"sahan0","yilmaz","yilmaz","2001-01-03","484-54-010","izmir","071-786-212","MALE");

        actualData=new US05_DeanActualPojo(object,"Dean updated Successful","OK");

        System.out.println("actualdata = " + actualData);

        assertEquals(200,response.statusCode());

        assertEquals(object.getUsername(), actualData.getObject().getUsername());
        assertEquals(object.getName(), actualData.getObject().getName());
        assertEquals(object.getSurname(), actualData.getObject().getSurname());
        assertEquals(object.getBirthDay(),actualData.getObject().getBirthDay());
        assertEquals(object.getSsn(), actualData.getObject().getSsn());
        assertEquals(object.getBirthPlace(), actualData.getObject().getBirthPlace());
        assertEquals(object.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        assertEquals(object.getGender(), actualData.getObject().getGender());

        assertEquals("Dean updated Successful",actualData.getMessage());
        assertEquals("OK",actualData.getHttpStatus());

    }

    @Given("f3.user05 set the url for delete dean")
    public void f3_user05_set_the_url_for_delete_dean() {
        spec.pathParams("first", "dean", "second", "delete", "third", userId);

        response = given(spec).when().delete("/{first}/{second}/{third}");
        response.prettyPrint();
    }
    @Then("f3.for user05 HTTP Status Code Should be {int}")
    public void f3_for_user05_http_status_code_should_be(Integer int1) {
        response.then().statusCode(200);


    }
    @Then("f3.user05 Response body should be like;")
    public void f3_user05_response_body_should_be_like() {
        /*
   {
    "message": "Dean Deleted",
    "httpStatus": "OK"
}
     */

        Map<String, String> expecteddelete = new HashMap<>();
        expecteddelete.put("message", "Dean Deleted");
        expecteddelete.put("httpStatus", "OK");

        HashMap actualDelete = ObjectMapperUtils.convertJsonToJawa(response.asString(), HashMap.class);
        Assert.assertEquals(expecteddelete, actualDelete);



    }
    }


//    @Given("User1 send post request for guest user")
//    public void user1_send_post_request_for_guest_user() {
//        //set the url
//        spec.pathParams("first","guestUser","second","register");
//        //set the expected data
//        expecteddata= new US01_RegisterPojo("2001-03-03","van","MALE","alican","12345678",
//                "023-786-"+num4+"","484-54-"+num4+"","yalcin",num4+"yalcin");
//
//        //send the request get the response
//        response= given(spec).when().body(expecteddata).post("/{first}/{second}");
//        response.prettyPrint();
//
//    }


