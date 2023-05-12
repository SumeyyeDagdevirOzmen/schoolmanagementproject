package stepdefinitions.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.StudentManagementPage;
import pages.TeacherManagementPage;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;

public class TeacherStudentInfoStepDef {
    TeacherManagementPage teacher;
    StudentManagementPage student;
    Action action;

    @And("kullanici ogrenci ismini {string}  gorur.")
    public void kullaniciOgrenciIsminiGorur(String NameSurname) {
        ReusableMethods.waitFor(2);
        teacher = new TeacherManagementPage();
        Assert.assertEquals(teacher.StudentInfoList.get(0).getText(), NameSurname);

    }

    @And("kullanici ders adini {string} gorur.")
    public void kullaniciDersAdiniGorur(String LessonName) {
        ReusableMethods.waitFor(2);
        teacher = new TeacherManagementPage();
        Assert.assertEquals(teacher.StudentInfoList.get(1).getText(), LessonName);

    }

    @And("kullanici Absentee alanini {string} gorur")
    public void kullaniciAbsenteeAlaniniGorur(String Absentee) {
        ReusableMethods.waitFor(2);
        teacher = new TeacherManagementPage();
        Assert.assertEquals(teacher.StudentInfoList.get(2).getText(), Absentee);
    }

    @And("kullanici Mitdern Exam alanini {string}  gorur")
    public void kullaniciMitdernExamAlaniniGorur(String MitdermExam) {
        ReusableMethods.waitFor(2);
        teacher = new TeacherManagementPage();
        Assert.assertEquals(teacher.StudentInfoList.get(3).getText(), MitdermExam);
    }

    @And("kullanici Final exam alanini {string} gorur")
    public void kullaniciFinalExamAlaniniGorur(String FinalExam) {
        ReusableMethods.waitFor(2);
        teacher = new TeacherManagementPage();
        Assert.assertEquals(teacher.StudentInfoList.get(4).getText(), FinalExam);

    }

    @And("kullanici Note alanini {string} gorur")
    public void kullaniciNoteAlaniniGorur(String Note) {
        ReusableMethods.waitFor(2);
        teacher = new TeacherManagementPage();
        Assert.assertEquals(teacher.StudentInfoList.get(5).getText(), Note);
    }

    @And("kullanici InfoNote alanindaki degeri {string} gorur.")
    public void kullaniciInfoNoteAlanindakiDegeriGorur(String InfoNote) {
        ReusableMethods.waitFor(2);
        teacher = new TeacherManagementPage();
        Assert.assertEquals(teacher.StudentInfoList.get(6).getText(), InfoNote);
    }

    @And("kullanici Average alanini {string} gorur.")
    public void kullaniciAverageAlaniniGorur(String averagete) {
        ReusableMethods.waitFor(2);
        teacher = new TeacherManagementPage();
        Assert.assertEquals(teacher.StudentInfoList.get(7).getText(), averagete);
    }

    @Then("kullanici edit butonuna tiklar")
    public void kullaniciEditButonunaTiklar() {
        student = new StudentManagementPage();
        ReusableMethods.clickByJS(student.editButton);

    }

    @And("kullanici ders adini {string} secer")
    public void kullaniciDersAdiniSecer(String chooseLesson) {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        student.editChooseLesson.sendKeys(chooseLesson);
    }


    @And("kullanici valid bir {string} secer")
    public void kullaniciValidBirSecer(String chooseEducationTerm) {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        student.editChooseEducationTerm.sendKeys(chooseEducationTerm);
    }

    @And("kullanici Absentee secenegini {string} gunceller")
    public void kullaniciAbsenteeSeceneginiGunceller(String absentee) {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(student.editAbsentee).sendKeys(Keys.BACK_SPACE).perform();
        student.editAbsentee.sendKeys(absentee);

    }

    @And("kullanici Mitdern Exam secenegini {string} gunceller")
    public void kullaniciMitdernExamSeceneginiGunceller(String MitdernExam) {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(student.editMitdernExam).sendKeys(Keys.BACK_SPACE).perform();
        student.editMitdernExam.sendKeys(MitdernExam);

    }

    @And("kullanici Final Exam secenegini {string} gunceller")
    public void kullaniciFinalExamSeceneginiGunceller(String finalExam) {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(student.editFinalExam).sendKeys(Keys.BACK_SPACE).perform();
        student.editFinalExam.sendKeys(finalExam);
    }

    @And("kullanici Info Note  secenegini {string} gunceller")
    public void kullaniciInfoNoteSeceneginiGunceller(String infoNote) {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(student.editInfoNote).sendKeys(Keys.BACK_SPACE).perform();
        student.editInfoNote.sendKeys(infoNote);
    }

    @And("kullanici submit butonuna tiklar")
    public void kullaniciSubmitButonunaTiklar() {
        student = new StudentManagementPage();
        ReusableMethods.clickByJS(student.editSubmit);
    }

    @And("kullanici Absentee uyari mesajini dogrular.")
    public void kullaniciAbsenteeUyariMesajiniDogrular() {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        Assert.assertTrue(student.AbsenTeeUyariMesssage.isDisplayed());
        ReusableMethods.getScreenshot("AbsenTee");
    }

    @And("kullanici Mitdern Exam uyari mesajini dogrular.")
    public void kullaniciMitdernExamUyariMesajiniDogrular() {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        assert student.MitdernExamUyariMessage.isDisplayed();
        ReusableMethods.getScreenshot("MitdernExam");
    }

    @And("kullanici Final Exam uyari mesajini dogrular.")
    public void kullaniciFinalExamUyariMesajiniDogrular() {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        assert student.FinalExamUyariMessage.isDisplayed();
        ReusableMethods.getScreenshot("FinalExam");

    }

    @And("kullanici LeesonEducationTerm uyari mesajini alir ve dogrular")
    public void kullaniciLeesonEducationTermUyariMesajiniAlirVeDogrular() {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        Assert.assertTrue(student.ChooseEducationTermUyariMessage.isDisplayed());
        ReusableMethods.getScreenshot("ChooseEducatinTerm");

    }

    @When("kullanici delete butonuna tiklar")
    public void kullaniciDeleteButonunaTiklar() {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        ReusableMethods.clickByJS(student.StudentInfodelete);
    }

    @And("kullanici basari mesaj alir")
    public void kullaniciBasariMesajAlir() {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        assert student.DeleteBasariMessage.isDisplayed();
        ReusableMethods.getScreenshot("DeleteBasari");
    }

    @Then("kullanici ogrenci ismini {string}  secer")
    public void kullaniciOgrenciIsminiSecer(String ogrenciismi) {
        ReusableMethods.waitFor(2);
        teacher = new TeacherManagementPage();
        teacher.StudentInfoList.get(0).sendKeys(ogrenciismi);

    }

    @And("kullanici ders adini bos birakir")
    public void kullaniciDersAdiniBosBirakir() {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        Select select = new Select(student.editChooseLesson);
        select.selectByVisibleText("Choose Lesson");
    }
//
//    @And("kullanici CooseLesson uyari mesajini dogrular.")
//    public void kullaniciCooseLessonUyariMesajiniDogrular() {
//    }

    @And("kullanici Semester secenegini bos birakir")
    public void kullaniciSemesterSeceneginiBosBirakir() {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        Select select = new Select(student.editChooseEducationTerm);
        select.selectByVisibleText("Choose Education Term");
//        Actions actions=new Actions(Driver.getDriver());
//        actions.sendKeys(Keys.SPACE).perform();
    }


    @And("kullanici Absentee secenegini bos birakir")
    public void kullaniciAbsenteeSeceneginiBosBirakir() {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(student.editAbsentee).sendKeys(Keys.BACK_SPACE).perform();

    }

    @And("kullanici Mitdern Exam secenegini  bos birakir")
    public void kullaniciMitdernExamSeceneginiBosBirakir() {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(student.editMitdernExam).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE).perform();
    }

    @And("kullanici Final Exam secenegini  bos birakir")
    public void kullaniciFinalExamSeceneginiBosBirakir() {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(student.editFinalExam).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE).perform();
    }

    @And("kullanici CooseLesson uyari mesajini dogrular.")
    public void kullaniciCooseLessonUyariMesajiniDogrular() {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        assert student.chooseLessonUyariMessage.isDisplayed();
        ReusableMethods.getScreenshot("ChooseLesson");
    }

    @And("kullanici Info Note  secenegini bos birakir")
    public void kullaniciInfoNoteSeceneginiBosBirakir() {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(student.editInfoNote).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE).perform();
    }

    @And("kullanici max sinir uyarisi alir")
    public void kullaniciMaxSinirUyarisiAlir() {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        Assert.assertTrue(student.maxMitdernExam.isDisplayed());
        ReusableMethods.getScreenshot("maxsinir mitdernExam");
    }

    @And("kullanici edit basari mesaji alir.")
    public void kullaniciEditBasariMesajiAlir() {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        Assert.assertTrue(student.GuncellemeBasarimessage.isDisplayed());
        ReusableMethods.getScreenshot("Guncelleme basari message");

    }

    @And("kullanici infonoteuyari mesaji alir.")
    public void kullaniciInfonoteuyariMesajiAlir() {
        ReusableMethods.waitFor(2);
        student = new StudentManagementPage();
        Assert.assertTrue(student.infonoteuyarimessage.isDisplayed());
        ReusableMethods.getScreenshot("infonote uyari message");


    }
}