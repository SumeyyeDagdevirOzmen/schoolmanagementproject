package stepdefinitions.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.StudentManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class AddStudentInfoStepDef {
    StudentManagementPage studentManagementPage;

    @Given("Teacher siteye gider")
    public void teacher_siteye_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @When("Teacher login olur")
    public void teacher_login_olur() {
        ReusableMethods.login(ConfigReader.getProperty("teacherUsername"),ConfigReader.getProperty("teachersifre"));

    }
    @And("Teacher Add Student Info sayfasini gorur")
    public void teacher_add_student_info_sayfasini_gorur() {
        studentManagementPage = new StudentManagementPage();
        Assert.assertTrue(studentManagementPage.addStudentInfoHava.isDisplayed());

    }
    @And("Teacher Choose Lesson dan {string} secer")
    public void teacher_choose_lesson_dan_secer(String string) {
        studentManagementPage = new StudentManagementPage();
        Select select=new Select(studentManagementPage.chooseLessonHava);
        select.selectByVisibleText(string);
        studentManagementPage.chooseLessonHava.sendKeys(Keys.TAB);


    }
    @And("Teacher Choose Student den {string} secer")
    public void teacher_choose_student_den_secer(String string) {
        studentManagementPage = new StudentManagementPage();
        Select select=new Select(studentManagementPage.chooseStudentHava);
        select.selectByVisibleText(string);
        studentManagementPage.chooseStudentHava.sendKeys(Keys.TAB);

    }
    @And("Teacher Choose Education Term den {string} secer")
    public void teacher_choose_education_term_den_secer(String string) {
        studentManagementPage = new StudentManagementPage();
        Select select=new Select(studentManagementPage.chooseEducationTermHava);
        select.selectByVisibleText(string);
        studentManagementPage.chooseEducationTermHava.sendKeys(Keys.TAB);

    }
    @And("Teacher Absentee e {string} gun devamsizlik girer")
    public void teacher_absentee_e_gun_devamsizlik_girer(String string) {
        studentManagementPage = new StudentManagementPage();
        studentManagementPage.absenteeHava.sendKeys(string);

    }
    @And("Teacher Midterm Exam kismina ogrencinin notunu {string} girer")
    public void teacher_midterm_exam_kismina_ogrencinin_notunu_girer(String string) {
        studentManagementPage = new StudentManagementPage();
        studentManagementPage.midtermExamHava.sendKeys(string);

    }
    @And("Teacher Final Exam kismina ogrencinin final notunu {string} girer")
    public void teacher_final_exam_kismina_ogrencinin_final_notunu_girer(String string) {
        studentManagementPage = new StudentManagementPage();
        studentManagementPage.finalExamHava.sendKeys(string);

    }
    @And("Teacher Info Note kismina ogrenci hakkindaki notu {string} olarak girer")
    public void teacher_info_note_kismina_ogrenci_hakkindaki_notu_olarak_girer(String string) {
        studentManagementPage = new StudentManagementPage();
        studentManagementPage.infoNoteHava.sendKeys(string);

    }
    @And("Teacher Submit butonuna basar")
    public void teacher_submit_butonuna_basar() {
        studentManagementPage = new StudentManagementPage();
        studentManagementPage.submitHava.click();
        ReusableMethods.waitFor(2);

    }
    @Then("Teacher Islemin onaylandigi mesajini gorur")
    public void teacher_islemin_onaylandigi_mesajini_gorur() {
        studentManagementPage = new StudentManagementPage();
        Assert.assertTrue(studentManagementPage.onayMessageHava.isDisplayed());
        ReusableMethods.waitFor(2);
        ReusableMethods.clickByJS(studentManagementPage.deleteHava);
        ReusableMethods.waitFor(2);


    }
    @Then("Teacher Not ile ilgili hata mesaji alir")
    public void teacher_not_ile_ilgili_hata_mesaji_alir() {
        studentManagementPage = new StudentManagementPage();
        Assert.assertTrue(studentManagementPage.notHataMesajiHava.isDisplayed());

    }
    @Then("Teacher Choose secmedigi icin hata mesaji gorur")
    public void teacher_choose_secmedigi_icin_hata_mesaji_gorur() {
        studentManagementPage = new StudentManagementPage();
        Assert.assertTrue(studentManagementPage.chooseHataMesajHava.isDisplayed());

    }


    @And("Teacher sayfayi kapatir")
    public void teacher_sayfayi_kapatir() {
        Driver.closeDriver();

    }


}
