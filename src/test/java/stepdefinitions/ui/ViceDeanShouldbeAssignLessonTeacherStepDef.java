package stepdefinitions.ui;

import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.ViceDineManagementPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class ViceDeanShouldbeAssignLessonTeacherStepDef {

    ViceDineManagementPage vicedean;

    @And("kullanici Choose Lessons basligina tiklar...")
    public void kullaniciChooseLessonsBasliginaTiklar() {
        vicedean = new ViceDineManagementPage();
        vicedean.chooseLessons.click();
    }

    @And("kullanici acilan listede olusturulan dersi gorur")
    public void kullaniciAcilanListedeOlusturulanDersiGorur() {
        vicedean = new ViceDineManagementPage();
        Actions action = new Actions(Driver.getDriver());
        ReusableMethods.waitFor(2);
        action.keyDown(Keys.ARROW_DOWN).sendKeys("CYPRESS", Keys.ENTER).perform();
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("Secilen Ders");
        Assert.assertTrue(vicedean.secilenDers.isDisplayed());

    }

    @And("kullanici Lesson Program Assigment basligini gorur")
    public void kullaniciLessonProgramAssigmentBasliginiGorur() {
        vicedean = new ViceDineManagementPage();
        ReusableMethods.scrollDownActions();
        ReusableMethods.scrollDownActions();
        ReusableMethods.waitFor(2);
        ReusableMethods.verifyElementDisplayed(vicedean.lessonProgramAssigmentTitle);
        ReusableMethods.getScreenshot("Baslik");
    }

    @And("kullanici olusturulan derste checkbox a tiklar")
    public void kullaniciOlusturulanDersteCheckboxATiklar() {
        vicedean = new ViceDineManagementPage();
        ReusableMethods.clickByJS(vicedean.lessonCheckbox);
        ReusableMethods.scrollEndJS();
        ReusableMethods.waitFor(2);
    }

    @And("kullanici Choose Teacher basligina tiklar")
    public void kullaniciChooseTeacherBasliginaTiklar() {
        vicedean = new ViceDineManagementPage();
        ReusableMethods.clickByJS(vicedean.lessonChooseTeacher);
    }

    @And("kullanici acilan listeden ders icin bir ogretmen secer")
    public void kullaniciAcilanListedenDersIcinBirOgretmenSecer() {
        vicedean = new ViceDineManagementPage();
        Select select = new Select(vicedean.lessonChooseTeacher);
        ReusableMethods.selectRandomTextFromDropdown(select);
    }

    @And("kullanici Submit butonuna tiklar..")
    public void kullaniciSubmitButonunaTiklar() {
        vicedean = new ViceDineManagementPage();
        ReusableMethods.clickByJS(vicedean.altSubmitButton);
    }

    @And("kullanici {string} mesajini gorur")
    public void kullaniciMesajiniGorur(String arg0) {
        ReusableMethods.waitFor(2);
        vicedean = new ViceDineManagementPage();
        ReusableMethods.getScreenshot("Added Message");
        Assert.assertTrue(vicedean.lessonAddedToTeacherMessage.getText().contains("Lesson added to Teacher"));
    }
}
