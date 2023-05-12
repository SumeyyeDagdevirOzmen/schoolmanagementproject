package stepdefinitions.database;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.JdbcUtils;

import java.util.List;

public class VicedeanContactMessageDBStepDef {

    @Then("userFrk asserts this data in database\\(message)")
    public void user_frk_asserts_this_data_in_database_message() {
      List<String> messageList = JdbcUtils.getColumnListString("message","contact_message");
      List<String> dateList = JdbcUtils.getColumnListString("date","contact_message");
      List<String> emailList = JdbcUtils.getColumnListString("email","contact_message");
      List<String> nameList = JdbcUtils.getColumnListString("name","contact_message");
      List<String> subjectList = JdbcUtils.getColumnListString("subject","contact_message");

        Assert.assertTrue(messageList.size()!=0);
        Assert.assertTrue(dateList.size()!=0);
        Assert.assertTrue(emailList.size()!=0);
        Assert.assertTrue(nameList.size()!=0);
        Assert.assertTrue(subjectList.size()!=0);


    }


}
