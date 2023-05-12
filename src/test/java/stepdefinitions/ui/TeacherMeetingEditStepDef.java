package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.LoginPage;
import pages.TeacherManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TeacherMeetingEditStepDef {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TeacherManagementPage teacherManagementPage = new TeacherManagementPage();
    Faker faker = new Faker();

    @Given("Kullanicigul ansayfaya gider")
    public void kullanicigul_ansayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }

    @When("Kullanicigul teacher olarak login olur")
    public void kullanicigul_teacher_olarak_login_olur() {

        homePage.Loginn.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("teacherUsername"));
        loginPage.password.sendKeys(ConfigReader.getProperty("teachersifre"));
        ReusableMethods.waitFor(2);

        ReusableMethods.clickByJS(loginPage.logbuton);
        ReusableMethods.waitFor(1);

    }

    @When("Kullanicigul menu butonuna tiklar")
    public void kullanicigul_menu_butonuna_tiklar() {
        ReusableMethods.waitFor(1);
        ReusableMethods.clickByJS(homePage.MenuButton);


    }

    @When("Kullanicigul menüden Meet Management'a tiklar")
    public void kullanicigul_menüden_meet_management_a_tiklar() {
        homePage.MeetManagement.click();

    }

    @Then("Kullanicigul Date bolumunu gorebilmelidir")
    public void kullanicigul_date_bolumunu_gorebilmelidir() {
        ReusableMethods.waitFor(2);
        assert teacherManagementPage.date.isDisplayed();


    }

    @Then("Kullanicigul Start Time alanini gorebilmelidir")
    public void kullanicigul_start_time_alanini_gorebilmelidir() {
        assert teacherManagementPage.startTime.isDisplayed();

    }

    @Then("Kullanicigul Stop Time alanini gorebilmelidir")
    public void kullanicigul_stop_time_alanini_gorebilmelidir() {
        assert teacherManagementPage.stopTime.isDisplayed();

    }

    @Then("Kullanicigul Description alanini gorebilmelidir")
    public void kullanicigul_description_alanini_gorebilmelidir() {
        assert teacherManagementPage.description.isDisplayed();

    }

    @When("Kullanicigul Edit alanina tiklar")
    public void kullanicigul_edit_alanina_tiklar() {
        ReusableMethods.waitFor(1);
        ReusableMethods.clickByJS(teacherManagementPage.edit);
        ReusableMethods.waitFor(1);

    }

    @When("s2.Kulanicigul Date Of Meet alanini valid bir tarih ile degistirir")
    public void kulanicigul_date_of_meet_alanini_valid_bir_tarih_ile_degistirir() {
        ReusableMethods.waitFor(1);
        //teacherManagementPage.dateedit.sendKeys("2023-04-28");

        int gun = faker.number().numberBetween(1, 30);
        int ay = faker.number().numberBetween(4, 8);
        ReusableMethods.waitFor(2);
        teacherManagementPage.editDate.sendKeys(gun + "-" + ay + "-2023", Keys.ENTER);
        ReusableMethods.clickByJS(teacherManagementPage.submit);


    }

    @Then("Kullanicigul {string} mesaji gorebilmelidir")
    public void kullanicigul_mesaji_gorebilmelidir(String basari) {
        ReusableMethods.waitFor(1);
        assert teacherManagementPage.alert.getText().contains(basari);
    }

    @Then("s2.Kulanicigul Date Of Meet alanini invalid gecmis tarih ile degistirir")
    public void Kulanicigul_date_of_meet_alanini_invalid_gecmis_tarih_ile_degistirir() {
        ReusableMethods.waitFor(1);
        int gun = faker.number().numberBetween(1, 30);
        int ay = faker.number().numberBetween(1, 4);
        ReusableMethods.waitFor(2);
        teacherManagementPage.editDate.sendKeys(gun + "-" + ay + "-2023", Keys.ENTER);
        ReusableMethods.clickByJS(teacherManagementPage.submit);


    }

    @Then("s2.Kullanicigul {string} mesajini gormelidir")
    public void kullanicigul_mesajini_gormelidir(String ileritarih) {
        ReusableMethods.waitFor(2);
        assert teacherManagementPage.alert.getText().contains(ileritarih);


    }

    @Then("s2.Kulanicigul Date Of Meet alanini invalid ileri tarih ile degistirir")
    public void kulanicigul_date_of_meet_alanini_invalid_ileri_tarih_ile_degistirir() {

    }

    @Then("s2.Kullanicigul {string} mesaji almalidir")
    public void kullanicigul_mesaji_almalidir(String gecerlitarih) {



    }

    @Then("s.3Kulanicigul Start Time alanini valid bir saat ile degistirir")
    public void s_3kulanicigul_start_time_alanini_valid_bir_saat_ile_degistirir() {
        ReusableMethods.waitFor(1);

        teacherManagementPage.Starttimeedit.sendKeys("01:00", Keys.TAB);

        ReusableMethods.waitFor(2);
        ReusableMethods.clickByJS(teacherManagementPage.submit);

    }
    @Then("s.4Kulanicigul St0p Time alanini valid bir saat ile degistirir")
    public void s_4kulanicigul_st0p_time_alanini_valid_bir_saat_ile_degistirir() {
        ReusableMethods.waitFor(1);

        teacherManagementPage.Stoptimeedit.sendKeys("04:00", Keys.TAB);
        ReusableMethods.waitFor(2);

        ReusableMethods.clickByJS(teacherManagementPage.submit);


    }
    @Then("s.5Kulanicigul St0p Time alanini valid bir saat ile degistirir")
    public void s_5kulanicigul_st0p_time_alanini_valid_bir_saat_ile_degistirir() {
        ReusableMethods.waitFor(1);
        Actions actions=new Actions(Driver.getDriver());
        actions.doubleClick(teacherManagementPage.descriptionedit).sendKeys(Keys.BACK_SPACE).perform();

        teacherManagementPage.descriptionedit.sendKeys(faker.animal().name());
        ReusableMethods.waitFor(2);

        ReusableMethods.clickByJS(teacherManagementPage.submit);


    }






    @When("s6.Kullanicigul delete alanina tiklar")
    public void kullanicigul_delete_alanina_tiklar() {
        // teacherManagementPage.delete.click();


        ReusableMethods.clickByJS(teacherManagementPage.delete);

    }

    @Then("kullanicigul  {string} mesaji gormelidir")
    public void kullanicigul_mesaji_gormelidir(String deletemesji) {
        ReusableMethods.waitFor(1);

        assert teacherManagementPage.deleteSuccesMesaj.isDisplayed();


    }


}
