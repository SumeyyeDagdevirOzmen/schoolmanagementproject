package stepdefinitions.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.ViceDineManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class LessonProgramStepDef {
    ViceDineManagementPage vicedean;

    @Given("kullanici siteye gider...")
    public void kullanici_siteye_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }

    @And("kullanici uygulamaya Vice Dean olarak {string} adi ile ve {string} login olur.")
    public void kullaniciUygulamayaViceDeanOlarakAdiIleVeLoginOlur(String username, String password) {
        ReusableMethods.waitFor(2);
        ReusableMethods.login(username, password);
    }

    @And("kullanici Lesson Program secenegine tiklar..")
    public void kullaniciLessonProgramSecenegineTiklar() {
        vicedean = new ViceDineManagementPage();
        ReusableMethods.waitFor(2);
        ReusableMethods.clickByJS(vicedean.LessonProgram);
    }

    @And("kullanici valid bir Ders adi secer")
    public void kullaniciValidBirDersAdiSecer() {
        ReusableMethods.waitFor(2);
        vicedean = new ViceDineManagementPage();
        vicedean.ChooseLesson.sendKeys("Statik", Keys.ENTER);
    }

    @And("kullanici valid bir Semester secer.")
    public void kullaniciValidBirSemesterSecer() {
        vicedean = new ViceDineManagementPage();
        ReusableMethods.waitFor(2);
        Select select = new Select(vicedean.ChooseEducationTerm);
        select.selectByVisibleText("SPRING_SEMESTER");
    }

    @And("kullanici valid bir Gun girer")
    public void kullaniciValidBirGunGirer() {
        vicedean = new ViceDineManagementPage();
        ReusableMethods.waitFor(2);
        //  new Faker((Random)vicedean.gun);
        Select select = new Select(vicedean.gun);
        select.selectByVisibleText("MONDAY");
    }

    @Given("kullanici valid bir Baslama Saati girer")
    public void kullaniciValidBirBaslamaSaatiGirer() {
        ReusableMethods.waitFor(2);
        vicedean = new ViceDineManagementPage();
        vicedean.startTime.sendKeys("12:30");
    }

    @And("kullanici valid bir Bitis Saati girer")
    public void kullaniciValidBirBitisSaatiGirer() {
        ReusableMethods.waitFor(2);
        vicedean = new ViceDineManagementPage();
        vicedean.stopTime.sendKeys("18:30");
    }

    @And("kullanici submit butonuna tiklar.")
    public void kullaniciSubmitButonunaTiklar() {
        ReusableMethods.waitFor(2);
        vicedean = new ViceDineManagementPage();
        ReusableMethods.clickByJS(vicedean.SubmitButton);

    }

    @Then("kullanici basari mesajini dogrular")
    public void kullaniciBasariMesajiniDogrular() throws IOException {
        ReusableMethods.waitFor(2);
        vicedean = new ViceDineManagementPage();
        ReusableMethods.getScreenshot("basari mesaji");
        Assert.assertTrue(vicedean.basariMesaji.getText().contains("Created Lesson Program"));
    }

    @Then("kullanici sayfayi kapatir..")
    public void kullaniciSayfayiKapatir() {
        ReusableMethods.waitFor(2);
        Driver.closeDriver();
    }

    @Given("kullanici baslama saatini bos birakir")
    public void kullaniciBaslamaSaatiniBosBirakir() {
        ReusableMethods.waitFor(2);
        vicedean = new ViceDineManagementPage();
        vicedean.startTime.sendKeys("");

    }

    @Then("kullanici uyari mesajini dogrular.")
    public void kullaniciUyariMesajiniDogrular() {
        ReusableMethods.waitFor(2);
        vicedean = new ViceDineManagementPage();
        Assert.assertTrue(vicedean.startStopUyariMessage.isDisplayed());
    }

    @And("kullanici bitis saatini bos birakir")
    public void kullaniciBitisSaatiniBosBirakir() {
        ReusableMethods.waitFor(2);
        vicedean = new ViceDineManagementPage();
        vicedean.stopTime.sendKeys("");
    }

    @And("kullanici ders alanini bos birakir")
    public void kullaniciDersAlaniniBosBirakir() {
        ReusableMethods.waitFor(2);
        vicedean = new ViceDineManagementPage();
        vicedean.ChooseLesson.sendKeys("");
    }

    @And("kullanici semester alanini bos birakir")
    public void kullaniciSemesterAlaniniBosBirakir() {
        ReusableMethods.waitFor(2);
        vicedean = new ViceDineManagementPage();
        vicedean.ChooseEducationTerm.sendKeys("");
    }

    @And("kullanici error  mesaji alir")
    public void kullaniciErrorMesajiAlir() {
        ReusableMethods.waitFor(2);
        Assert.assertFalse(vicedean.ChooselessonAndSemesterErrormessage.isDisplayed());
        ReusableMethods.getScreenshot("Choose Lesson Error");
    }
}


