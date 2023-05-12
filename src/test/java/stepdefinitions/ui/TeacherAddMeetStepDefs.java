package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.HomePage;
import pages.TeacherManagementPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class TeacherAddMeetStepDefs {
Faker faker;
HomePage homePage;
TeacherManagementPage teacherManagementPage;
    @When("kullanici {string} ismi ve {string} sifresi ile login olur")
    public void kullaniciIsmiVeSifresiIleLoginOlur(String username, String password) {
        ReusableMethods.login(username,password);
    }

    @When("kullanici Menu butonuna tiklar")
    public void kullanici_menu_butonuna_tiklar() {
        homePage= new HomePage();
        ReusableMethods.waitFor(2);
        ReusableMethods.clickByJS(homePage.MenuButton);
    }
    @When("kullanici Meet Management'a tiklar")
    public void kullanici_meet_management_a_tiklar() {
        homePage= new HomePage();
        ReusableMethods.waitFor(2);
        ReusableMethods.clickByJS(homePage.MeetManagement);
    }

    @And("kullanici {string} secer")
    public void kullaniciSecer(String ogrenci) {
        teacherManagementPage=new TeacherManagementPage();
        ReusableMethods.waitFor(2);
        teacherManagementPage.ChooseStudentsBox.sendKeys(ogrenci, Keys.ENTER);
    }

    @When("kullanici zorunlu alanlari doldurur")
    public void kullanici_zorunlu_alanlari_doldurur() {
        teacherManagementPage=new TeacherManagementPage();
        faker=new Faker();
        int gun =faker.number().numberBetween(16,30);
        int ay = faker.number().numberBetween(5,12);
        ReusableMethods.waitFor(2);
        teacherManagementPage.DateOfMeetBox.sendKeys(ay +"."+ gun+ ".2023",Keys.ENTER);
        ReusableMethods.waitFor(2);
        teacherManagementPage.startTimeBox.sendKeys("14:00",Keys.ENTER);
        ReusableMethods.waitFor(2);
        teacherManagementPage.stopTimeBox.sendKeys("15:00",Keys.ENTER);
        ReusableMethods.waitFor(2);
        teacherManagementPage.descriptionBox.sendKeys(ConfigReader.getProperty("description"),Keys.ENTER);
    }
    @When("kullanici Submit'e tiklar")
    public void kullanici_submit_e_tiklar() {
      teacherManagementPage=new TeacherManagementPage();
        ReusableMethods.waitFor(2);
      ReusableMethods.clickByJS(teacherManagementPage.submitButton);
    }
    @Then("kullanici toplanti olusturabildigini dogrular")
    public void kullanici_toplanti_olusturabildigini_dogrular() {
        teacherManagementPage=new TeacherManagementPage();
        ReusableMethods.waitFor(2);
        Assert.assertEquals(teacherManagementPage.toplantiOlusturulduMesaji.getText(),"Meet Saved Successfully");

        ReusableMethods.clickByJS(teacherManagementPage.deleteNihal);
    }


    @And("kullanici ogrenci secer")
    public void kullaniciOgrenciSecer() {
        teacherManagementPage=new TeacherManagementPage();
        ReusableMethods.waitFor(2);
        teacherManagementPage.ChooseStudentsBox.sendKeys(ConfigReader.getProperty("ogrenciNihal"), Keys.ENTER);
    }

    @And("kullanici tarih alanina gecmis bir tarih girer")
    public void kullaniciTarihAlaninaGecmisBirTarihGirer() {
        teacherManagementPage=new TeacherManagementPage();
        faker=new Faker();
        int gun =faker.number().numberBetween(1,30);
        int ay = faker.number().numberBetween(1,3);
        ReusableMethods.waitFor(2);
        teacherManagementPage.DateOfMeetBox.sendKeys(ay +"."+ gun+ ".2023",Keys.ENTER);
    }

    @And("kullanici diger zorunlu alanlari girer")
    public void kullaniciDigerZorunluAlanlariGirer() {
        teacherManagementPage=new TeacherManagementPage();
        ReusableMethods.waitFor(2);
        teacherManagementPage.startTimeBox.sendKeys("10:00",Keys.ENTER);
        ReusableMethods.waitFor(2);
        teacherManagementPage.stopTimeBox.sendKeys("11:00",Keys.ENTER);
        ReusableMethods.waitFor(2);
        teacherManagementPage.descriptionBox.sendKeys(ConfigReader.getProperty("description"),Keys.ENTER);
        ReusableMethods.waitFor(2);
    }

    @Then("kullanici toplanti olusturamadigini dogrular")
    public void kullaniciToplantiOlusturamadiginiDogrular() {
        teacherManagementPage=new TeacherManagementPage();
        ReusableMethods.waitFor(2);
        //Assert.assertEquals(teacherManagementPage.ileriTarihUyarisi.getText(),"ileri bir tarih olmalı");
        Assert.assertTrue(teacherManagementPage.ileriTarihUyarisi2.isDisplayed());


    }

    @And("kullanici tüm zorunlu alanlari bos birakir")
    public void kullaniciTümZorunluAlanlariBosBirakir() {

    }

    @Then("Kullanici Date Of Meet,StartTime,StopTime ve Description alanlarinin zorunlu oldugunu dogrular")
    public void kullaniciDateOfMeetStartTimeStopTimeVeDescriptionAlanlarininZorunluOldugunuDogrular() {
    teacherManagementPage=new TeacherManagementPage();
    for(int i=0; i<teacherManagementPage.requiredUyarilari.size(); i++){
        assert teacherManagementPage.requiredUyarilari.get(i).isDisplayed();
    }
    }


}
