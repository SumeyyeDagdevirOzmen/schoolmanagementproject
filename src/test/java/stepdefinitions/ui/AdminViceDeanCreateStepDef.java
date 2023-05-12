package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.ViceDineManagementPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminViceDeanCreateStepDef {




    pages.ViceDineManagementPage vicelocaterpage= new ViceDineManagementPage();
    Actions action=new Actions(Driver.getDriver());
    ReusableMethods reusableMethods=new ReusableMethods();
    Faker faker=new Faker();

    Date date=faker.date().birthday();
    SimpleDateFormat dateFormat=new SimpleDateFormat("dd.MM.yyyy");
    String formatDate=dateFormat.format(date);



    @And("Admin acilan menuden Vice Dean buttonuna tiklar.")
    public void adminAcilanMenudenViceDeanButtonunaTiklar() {
        vicelocaterpage.ViceDean.click();
        ReusableMethods.waitFor(2);

    }

    @And("Admin tum alanlari doldurur.")
    public void adminTumAlanlariDoldurur() {
        action.moveToElement(vicelocaterpage.viceDeanName).click().sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName(), Keys.TAB).
                sendKeys(faker.country().name(), Keys.TAB).
                sendKeys(Keys.SPACE, Keys.TAB).
                sendKeys(formatDate, Keys.TAB).
                sendKeys(faker.numerify("###-###-####"), Keys.TAB)
                .sendKeys(faker.numerify("###-##-####"), Keys.TAB).
                sendKeys(faker.name().username(), Keys.TAB).
                sendKeys(faker.internet().password()).perform();

    }

    @And("Admin submit butonuna tiklar.")
    public void adminSubmitButonunaTiklar() {
        vicelocaterpage.Submit.click();
        ReusableMethods.waitFor(2);

    }

    @And("Admin Vice Dean olusturdugunu dogrular.")
    public void adminViceDeanOlusturdugunuDogrular() {
        Assert.assertTrue(vicelocaterpage.ViceDeanSuccess.isDisplayed());


    }

    @When("user{int}_send POST Request to the Url for happy_pat")
    public void user_sendPOSTRequestToTheUrlForHappy_pat(int arg0) {
    }
}
