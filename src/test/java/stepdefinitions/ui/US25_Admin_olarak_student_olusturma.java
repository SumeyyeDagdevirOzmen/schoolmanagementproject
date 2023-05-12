package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import pages.AdminManagementPage;
import pages.HomePage;
import pages.LoginPage;
import pages.StudentManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class US25_Admin_olarak_student_olusturma {
    LoginPage loginPage=new LoginPage();
    AdminManagementPage adminManagementPage=new AdminManagementPage();
    HomePage homePage=new HomePage();
    StudentManagementPage studentManagementPage= new StudentManagementPage();
    @Given("KKullanıcı sayfaya gider")
    public void kkullanıcıSayfayaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("KKullanıcı uygulamaya Admin olarak login olur")
    public void kkullanıcıUygulamayaAdminOlarakLoginOlur() {
        loginPage.SigIn.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("adminUsername"));
        loginPage.password.sendKeys(ConfigReader.getProperty("adminsifre"));
        loginPage.loginButton.click();
        ReusableMethods.waitFor(1);
    }

    @And("KKullanici Menu butonuna tiklar")
    public void kkullaniciMenuButonunaTiklar() {
        homePage.MenuButton.click();
        ReusableMethods.waitFor(1);
    }

    @And("KKullanici Student Management secegine tiklar")
    public void kkullaniciStudentManagementSecegineTiklar() {
        homePage=new HomePage();
        ReusableMethods.clickByJS(homePage.StudentManagement);
    }

    @And("KKullanici dropdown menusunden ogretmen secimini yapar")
    public void kkullaniciDropdownMenusundenOgretmenSeciminiYapar() {
        int num=Faker.instance().number().numberBetween(1,15);
        studentManagementPage=new StudentManagementPage();
        ReusableMethods.waitFor(1);
        Select select=new Select(studentManagementPage.chooseTeacher);
        ReusableMethods.waitFor(1);
        select.selectByIndex(num);
    }

    @And("KKullanici valid bir email adresini girer")
    public void kkullaniciValidBirEmailAdresiniGirer() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.email.sendKeys(Faker.instance().witcher().monster().replaceAll(" ","")+Faker.instance().number().numberBetween(1,100)+"@html.com");
    }

    @And("KKullanici Father name girer")
    public void kkullaniciFatherNameGirer() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.fatherName.sendKeys(Faker.instance().name().fullName());
    }

    @And("KKullanici Mother name girer")
    public void kkullaniciMotherNameGirer() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.motherName.sendKeys(Faker.instance().name().nameWithMiddle());
    }

    @Then("Ogrenci basariyla eklendi mesaji goruntulenir.")
    public void ogrenciBasariylaEklendiMesajiGoruntulenir() {
        ReusableMethods.getScreenshot("Student saved Successfully ");
        assert studentManagementPage.studentSaved.isEnabled();


    }

}




