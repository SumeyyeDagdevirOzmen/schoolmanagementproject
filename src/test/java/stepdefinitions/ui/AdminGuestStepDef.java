package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.ViceDineManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class AdminGuestStepDef {


    LoginPage loginPage = new LoginPage();

    pages.LoginPage locatersPage=new pages.LoginPage();
    pages.ViceDineManagementPage vicelocaterpage= new ViceDineManagementPage();
    Actions action=new Actions(Driver.getDriver());
    ReusableMethods reusableMethods=new ReusableMethods();
    Faker faker=new Faker();

    Date date=faker.date().birthday();
    SimpleDateFormat dateFormat=new SimpleDateFormat("dd.MM.yyyy");
    String formatDate=dateFormat.format(date);

    @Given("Admin managementonschools adresine gider")
    public void admin_managementonschools_adresine_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.waitFor(2);

    }


    @Then("Admin first Login butonuna tiklar.")
    public void adminFirstLoginButonunaTiklar() {
       locatersPage.firstLogin.click();
        //ReusableMethods.waitFor(2);



    }
    @Then("Admin User Name girer.")
    public void admin_user_name_girer() {
       locatersPage.UserName.sendKeys("Dean-Team03", Keys.ENTER);
        //ReusableMethods.waitFor(3);


    }
    @Then("Admin Password girer.")
    public void admin_password_girer() {
       locatersPage.Password.sendKeys("team03team", Keys.ENTER);
        // ReusableMethods.waitFor(3);

    }
    @Then("Admin Login butonuna tiklar.")
    public void admin_login_butonuna_tiklar() {
        locatersPage.Login.click();

    }
    @Then("Admin MENU butonuna tiklar.")
    public void admin_menu_butonuna_tiklar() {
        locatersPage.menu.click();
        ReusableMethods.waitFor(2);

    }
    @Then("Admin Main Menu Butonuna tiklar.")
    public void admin_main_menu_butonuna_tiklar() {

        locatersPage.GuestList.click();
    }


    @Then("Admin acilan sayfadan Name, Phone Number, SSN, User Name gorur.")
    public void admin_acilan_sayfadan_name_phone_number_ssn_user_name_gorur() {
        for (WebElement w : locatersPage.userInfo) {
            assertTrue(w.isDisplayed()); //false ile denendi hata veriyor yani doğru.
        }
    }

    @And("Admin ilgili User icin delete buttonina tiklar.")
    public void adminIlgiliUserIcinDeleteButtoninaTiklar() {
        locatersPage.DeleteButton.click();

    }

    @And("Admin Guest User Deleted Successful yazisini gorur.")
    public void adminGuestUserDeletedSuccessfulYazisiniGorur() {
        locatersPage.Success.isDisplayed();

    }


    @And("Kullanici acilan sayfadan Name, Phone Number, SSN, User Name görür.")
    public void kullaniciAcilanSayfadanNamePhoneNumberSSNUserNameGorur() {
    }

    @Then("AdminD sayfayi kapatir")
    public void admindSayfayiKapatir() {Driver.closeDriver();
    }
    }








