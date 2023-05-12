package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.TeacherManagementPage;
import pages.ViceDineManagementPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class AdminCreateTeacherStepDef {
    HomePage homePage;
    TeacherManagementPage teacherManagementPage;
    ViceDineManagementPage viceDineManagementPage;
    String firstName = Faker.instance().name().firstName();
    String lastName = Faker.instance().name().lastName();
    String birth_place=Faker.instance().address().city();
    String email = Faker.instance().name().firstName()+ "@gmail.com";

    String phone = Faker.instance().number().numberBetween(100,1000)+"-"+
            Faker.instance().number().numberBetween(100,1000)+"-"+
            Faker.instance().number().numberBetween(1000,10000);
    String date_of_birth=Faker.instance().number().numberBetween(10,30)+"."+
            Faker.instance().number().numberBetween(10,12)+"."+
            Faker.instance().number().numberBetween(1996,2023);

    String username = firstName + "0303";

    String password = Faker.instance().internet().password();

    public static String ssnNhl = Faker.instance().number().digits(9).substring(0, 3) + "-" + Faker.instance().number().digits(9).substring(3, 5) + "-" + Faker.instance().number().digits(9).substring(5);

    @When("kullaniciNihal Teacher Management'a tiklar")
    public void kullanici_nihal_teacher_management_a_tiklar() {
        homePage = new HomePage();
        ReusableMethods.waitFor(2);
        homePage.TeacherManagement.click();
    }


    @When("kullaniciNihal IsAdvisor butonunu secer")
    public void kullanici_nihal_is_advisor_butonunu_secer() {
        teacherManagementPage = new TeacherManagementPage();
        ReusableMethods.waitFor(2);
        teacherManagementPage.isAdvisorCheckBox.click();
    }

    @When("kullaniciNihal Gender'i secer")
    public void kullanici_nihal_gender_i_secer() {
        teacherManagementPage = new TeacherManagementPage();
        ReusableMethods.waitFor(2);
        teacherManagementPage.genderList.get(0).click();
    }


    @When("kullaniciNihal Submit'e tiklar")
    public void kullanici_nihal_submit_e_tiklar() {
        teacherManagementPage = new TeacherManagementPage();
        ReusableMethods.waitFor(2);
        teacherManagementPage.submitButon.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("ekrangoruntusu");
    }

    @Then("kullaniciNihal ogretmen olusturabildigini dogrular")
    public void kullanici_nihal_ogretmen_olusturabildigini_dogrular() {
        teacherManagementPage = new TeacherManagementPage();

        //Assert.assertTrue(teacherManagementPage.ogretmenEklendiUyarisi.isDisplayed());

        //Assert.assertEquals(teacherManagementPage.ogretmenEklendiUyarisi.getText(), "Teacher saved successfully");

        Driver.waitForVisibility(teacherManagementPage.ogretmenEklendiUyarisi,5);

    }

    @And("kullaniciNihal Surname alanina valid bir deger girer")
    public void kullanicinihalSurnameAlaninaValidBirDegerGirer() {
        teacherManagementPage = new TeacherManagementPage();
        ReusableMethods.waitFor(2);
        teacherManagementPage.surnameBox.sendKeys(lastName);
    }
    @When("kullaniciNihal ChooseLessons'tan ders secer")
    public void kullanici_nihal_choose_lessons_tan_ders_secer() {
        teacherManagementPage = new TeacherManagementPage();
        ReusableMethods.waitFor(6);
        teacherManagementPage.chooseLessons2.click();
        ReusableMethods.waitFor(1);
        Actions action=new Actions(Driver.getDriver());
        action.keyDown(Keys.ENTER).sendKeys(Keys.TAB).perform();

    }
    @When("kullaniciNihal Name alanina valid bir deger yazar")
    public void kullanici_nihal_name_alanina_valid_bir_deger_yazar() {
        ReusableMethods.waitFor(2);
        teacherManagementPage = new TeacherManagementPage();
        teacherManagementPage.nameBox.sendKeys(firstName);
    }
    @When("kullaniciNihal BirthPlace alanina valid bir deger girer")
    public void kullanici_nihal_birth_place_alanina_valid_bir_deger_girer() {
        teacherManagementPage = new TeacherManagementPage();
        ReusableMethods.waitFor(2);
        teacherManagementPage.birthPlaceBox.sendKeys(birth_place);
    }
    @When("kullaniciNihal Email alanina valid bir deger girer")
    public void kullanici_nihal_email_alanina_valid_bir_deger_girer() {
        teacherManagementPage = new TeacherManagementPage();
        ReusableMethods.waitFor(2);
        teacherManagementPage.emailBox.sendKeys(email);
    }
    @When("kullaniciNihal PhoneNumber alanina valid bir deger girer")
    public void kullanici_nihal_phone_number_alanina_valid_bir_deger_girer() {
        teacherManagementPage = new TeacherManagementPage();
        ReusableMethods.waitFor(2);
        teacherManagementPage.phoneNumberBox.sendKeys(phone);
    }
    @When("kullaniciNihal Date Of Birth alanina valid bir deger girer")
    public void kullanici_nihal_date_of_birth_alanina_valid_bir_deger_girer() {
        teacherManagementPage = new TeacherManagementPage();
        ReusableMethods.waitFor(2);
        teacherManagementPage.birthDayBox.sendKeys(date_of_birth);
    }
    @When("kullaniciNihal SSN alanina valid bir deger girer")
    public void kullanici_nihal_ssn_alanina_valid_bir_deger_girer() {
        teacherManagementPage = new TeacherManagementPage();
        ReusableMethods.waitFor(2);
        teacherManagementPage.ssnBox.sendKeys(ssnNhl);
    }
    @When("kullaniciNihal Username alanina valid bir deger girer")
    public void kullanici_nihal_username_alanina_valid_bir_deger_girer() {
        teacherManagementPage = new TeacherManagementPage();
        ReusableMethods.waitFor(2);
        teacherManagementPage.userNameBox.sendKeys(username);
    }
    @When("kullaniciNihal Password alanina valid bir deger girer")
    public void kullanici_nihal_password_alanina_valid_bir_deger_girer() {
        teacherManagementPage = new TeacherManagementPage();
        ReusableMethods.waitFor(2);
        teacherManagementPage.passwordBox.sendKeys(password);
    }

}
