package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.Keys;

import pages.ViceDineManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class ViceDeanAddLessonStepDef {



    ViceDineManagementPage viceDineManagementPage;



    @Given("Kullanici ana sayfaya gider.")
    public void kullanici_ana_sayfaya_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));}
    @When("Kullanici Vice dean hesabi ile login olur")
    public void kullanici_vice_dean_hesabi_ile_login_olur() {
        ReusableMethods.loginViceDean();}



    @When("Kullanici Lessons butonunu tiklar.")
    public void kullanici_lessons_butonunu_tiklar() throws InterruptedException {
        ReusableMethods.waitFor(2);
        viceDineManagementPage = new ViceDineManagementPage();
        viceDineManagementPage.lessons.click();

    }

    @And("KullaniciV Lesson Name alanina valid bir deger girer")
    public void kullanıcı_LessonName_alanına_valid_bir_deger_girer() throws InterruptedException {


        viceDineManagementPage   = new ViceDineManagementPage();
        ViceDineManagementPage.lessonName.sendKeys(Faker.instance().name().name(),Keys.TAB);
        ReusableMethods.waitFor(2);

    }


    @And("KullaniciV Compulsory alanina tiklar")
    public void kullanici_Compulsory_Alanina_Tiklar() throws InterruptedException {
        viceDineManagementPage = new ViceDineManagementPage();
        viceDineManagementPage.compulsory.click();

        Thread.sleep(2000);

    }


    @And("KullaniciV Credit Score alanina tiklar")
    public void kullanici_credit_score_alanina_tiklar(){
        viceDineManagementPage.creditScore.click();

    }


    @And("KullaniciV Credit Score alanina valid deger girer")
    public void kullanıcı_CreditScore_Alanına_valid_bir_deger_Girer()  {

         viceDineManagementPage = new ViceDineManagementPage();
         String creditscr =Faker.instance().number().numberBetween(1,10)+"";
         viceDineManagementPage.creditScore.sendKeys(creditscr);
         viceDineManagementPage.creditScore.sendKeys(Keys.TAB);
         ReusableMethods.waitFor(2);

    }


    @When("KullaniciV Submit butonuna tiklar")
    public void kullanıcı_Submit_Butonunu_Tıklar()  {
        ReusableMethods.waitFor(2);
        viceDineManagementPage = new ViceDineManagementPage();
        viceDineManagementPage.submit.click();


    }

    @And ("KullaniciV Lesson Created yazisini gorur")
    public void kullanici_Lesson_Created_yazisini_gorur() throws InterruptedException {
        ReusableMethods.waitFor(2);
        viceDineManagementPage =new ViceDineManagementPage();
      Assert.assertTrue(viceDineManagementPage.LessonCreated.isDisplayed());


    }


    @And("KullaniciV Lesson Name alanini bos birakir")
    public void kullanici_Lesson_Name_alanini_bos_birakir () {
        ReusableMethods.waitFor(2);
        viceDineManagementPage =new ViceDineManagementPage();
        ViceDineManagementPage.lessonName.sendKeys("",Keys.TAB);



    }
    @And("KullaniciV Credit Score alnini bos birakir")
    public void kullanici_Credit_Score_alanini_bos_birakir(){
        ReusableMethods.waitFor(2);
        viceDineManagementPage =new ViceDineManagementPage();
        viceDineManagementPage.creditScore.sendKeys("",Keys.TAB);


    }

    @And("KullaniciV Required uyari yazisini gorur")
    public void kullanici_Required_uyari_yazisini_gorur(){
        ReusableMethods.waitFor(2);
        viceDineManagementPage =new ViceDineManagementPage();
        Assert.assertTrue(viceDineManagementPage.Required.isDisplayed());


    }

    @Then("KullaniciV sayfayi kapatir")
    public void kullanici_sayfayi_kapatir(){
        ReusableMethods.waitFor(2);
        Driver.closeDriver();




    }







}


































