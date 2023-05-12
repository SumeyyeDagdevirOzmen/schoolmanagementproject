package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class ContactMessageUIStepDef {
     LoginPage loginPage = new LoginPage();
     Faker faker = new Faker();
    @Given("Kullanici anasayfaya {string} gider")
    public void kullaniciAnasayfayaGider(String string) {
        Driver.getDriver().get(string);
    }

    @When("Kullanici Contact butonuna tıklar")
    public void kullaniciContactButonunaTıklar() {
        loginPage.contactButton.click();
        ReusableMethods.waitFor(1);

    }
    @When("Kullanici Your Name textboxa valid {string} bir deger girer")
    public void kullanici_your_name_textbox_a_valid_bir_deger_girer(String string) {
        loginPage.contactYourName.sendKeys(string);
        ReusableMethods.waitFor(1);

    }
    @When("Kullanici Your Mail textboxa valid {string} bir deger girer")
    public void kullanici_your_mail_textbox_a_valid_bir_deger_girer(String string) {
    loginPage.contactYourMail.sendKeys(string+faker.internet().emailAddress());
        ReusableMethods.waitFor(1);

    }
    @When("Kullanici Subject  textboxina valid {string} bir deger girer")
    public void kullanici_subject_textbox_ina_valid_bir_deger_girer(String string) {
    loginPage.contactSubject.sendKeys(string);
        ReusableMethods.waitFor(1);
    }
    @When("Kullanici Massage textboxina valid {string} bir deger girer")
    public void kullanici_massage_textbox_ina_valid_bir_deger_girer(String string) {
    loginPage.contactMessage.sendKeys(string);
        ReusableMethods.waitFor(1);
        ReusableMethods.scrollIntoViewJS(loginPage.sendMessageButton);
    }
    @When("Kullanici Send Message butonuna tıklar")
    public void kullanici_send_message_butonuna_tıklar() {
        ReusableMethods.clickByJS(loginPage.sendMessageButton);
    }
    @Then("Kullanici mesajin gönderildigini dogrular")
    public void kullanici_mesajin_gönderildigini_dogrular() {
      //  ReusableMethods.waitForVisibility(loginPage.createdMessage,1);
       //  String validateMessage= loginPage.createdMessage.getText();
      //  ReusableMethods.waitFor(2);
        System.out.println("text mesaji= "+loginPage.createdMessage.getText());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(loginPage.createdMessage.isDisplayed());
    }


    @And("Kullanici Your Name textboxa invalid {string} bir deger girer")
    public void kullaniciYourNameTextboxAInvalidBirDegerGirer(String string) {
        loginPage.contactYourName.sendKeys(string);
    }



    @Then("Kullanici hata mesaji alindigini dogrular")
    public void kullaniciHataMesajiAlindiginiDogrular() {
    ReusableMethods.waitFor(1);
    Assert.assertTrue(loginPage.contactErrorMessage.isDisplayed());
    }

    @And("Kullanici Your Mail textboxa invalid {string} bir deger girer")
    public void kullaniciYourMailTextboxaInvalidBirDegerGirer(String mail) {
        loginPage.contactYourMail.sendKeys(mail);
    }

    @And("Kullanici Subject  textboxina invalid {string} bir deger girer")
    public void kullaniciSubjectTextboxinaInvalidBirDegerGirer(String subject) {
        loginPage.contactSubject.sendKeys(subject);
    }

    @And("Kullanici Massage textboxina invalid {string} bir deger girer")
    public void kullaniciMassageTextboxinaInvalidBirDegerGirer(String message) {
        loginPage.contactMessage.sendKeys(message);
    }

    @Then("KullanicF sayfayi kapatir")
    public void kullanicfSayfayiKapatir() {
        Driver.closeDriver();
    }


}
