package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.ViceDineManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class ViceDeanLessonsEditStepDef {

    ViceDineManagementPage viceDineManagementPage;
    @Given("Kullaniciz sayfaya gider")
    public void kullanici_sayfaya_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));}
    @When("Kullaniciz Vice dean olarak login olur")
    public void kullanici_vice_dean_olarak_login_olur() {
        ReusableMethods.waitFor(2);
        ReusableMethods.loginViceDean();}
    @When("Kullaniciz Lessons butonuna tiklar.")
    public void kullanici_lessons_butonuna_tiklar() {
        ReusableMethods.waitFor(1);
        viceDineManagementPage = new ViceDineManagementPage();
       ReusableMethods.clickByJS(viceDineManagementPage.lessons); }
    @When("Kullaniciz Lesson List yazisini gorur.")
    public void kullanici_lesson_list_yazisini_gorur() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(viceDineManagementPage.lessonList.isDisplayed());}
    @When("Kullaniciz Lesson Name alanini gorur.")
    public void kullanici_lesson_name_alanini_gorur() {
        ReusableMethods.waitFor(2);
      Assert.assertTrue(viceDineManagementPage.lessonNameList.size()!=0);
    }
    @When("Kullaniciz Compulsory alanini  gorur.")
    public void kullanici_compulsory_alanini_gorur() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(viceDineManagementPage.compulsoryList.size()!=0);
    }
    @When("Kullaniciz Credit Score alanini gorur.")
    public void kullanici_credit_score_alanini_gorur() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(viceDineManagementPage.creditScoreList.size()!=0);}








    @When("Kullaniciz Lesson Name alanina deger girer")
    public void kullaniciz_lesson_name_alanina_girer() {
        ReusableMethods.waitFor(1);
        viceDineManagementPage=new ViceDineManagementPage();
        viceDineManagementPage.lessonNameKutusu.sendKeys( Faker.instance().name().lastName(),Keys.ENTER);

    }
    @When("Kulllaniciz Compulsory alanini isaretler")
    public void kulllaniciz_compulsory_alanini_isaretler() {
        ReusableMethods.waitFor(2);
        viceDineManagementPage=new ViceDineManagementPage();
        viceDineManagementPage.compulsory.click();
    }
    @When("Kullaniciz Credit score alanina {string} girer")
    public void kullaniciz_credit_score_alanina_girer(String string) {
        ReusableMethods.waitFor(2);
        viceDineManagementPage=new ViceDineManagementPage();
        viceDineManagementPage.creditScoreKutusu.sendKeys("4",Keys.ENTER);
    }
    @When("Kullaniciz submit butonuna tiklar")
    public void kullaniciz_submit_butonuna_tiklar() {
        ReusableMethods.waitFor(1);
        viceDineManagementPage=new ViceDineManagementPage();
        viceDineManagementPage.submitlesson.click();
    }

    @When("Kullaniciz sayfanin sonuna gider")
    public void kullaniciz_sayfanin_sonuna_gider() {
        viceDineManagementPage = new ViceDineManagementPage();
        ReusableMethods.waitFor(2);
        Actions actions= new Actions(Driver.getDriver());
        actions.moveToElement(viceDineManagementPage.sayfaDegistirme);
        ReusableMethods.waitFor(1);
        ReusableMethods.clickByJS(viceDineManagementPage.sayfaDegistirme);

    }

    @When("Kullaniciz olusturdugu dersi siler")
    public void kullaniciz_olusturdugu_dersi_siler() {
        viceDineManagementPage=new ViceDineManagementPage();
        ReusableMethods.waitFor(2);
//        Actions actions= new Actions(Driver.getDriver());
//        ReusableMethods.clickByJS(viceDineManagementPage.klimaat);
//                actions.sendKeys(Keys.TAB,Keys.ENTER).perform();
        Actions actions= new Actions(Driver.getDriver());
        actions.moveToElement(viceDineManagementPage.deletelesson);
        ReusableMethods.clickByJS(viceDineManagementPage.deletelesson);



        }






    @Then("Kullaniciz lesson deleted uyari mesajini alir.")
    public void kullanici_lesson_deleted_uyari_mesajini_alir() throws IOException {
       ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("basarili silme mesaji");
        Assert.assertTrue(viceDineManagementPage.basariMesajiDelete.isEnabled());
    }

    @Then("Kullaniciz sayfayi kapatir.")
    public void kullanici_sayfayi_kapatir() {
        ReusableMethods.waitFor(1);
        Driver.closeDriver();
    }


}
