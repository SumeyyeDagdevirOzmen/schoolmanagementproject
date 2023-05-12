package stepdefinitions.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DeanManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Dean_Mesaj_GorurStepDef {
    DeanManagementPage deanManagementPage;
    @Given("DeanHava siteye gider")
    public void dean_hava_siteye_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }
    @When("DeanHava login olur")
    public void dean_hava_login_olur() {
        ReusableMethods.login(ConfigReader.getProperty("viceDeanusername"),ConfigReader.getProperty("viceDeansifre"));
    }
    @When("DeanHava Menu secenegine tiklar")
    public void dean_hava_menu_secenegine_tiklar() {
        deanManagementPage = new DeanManagementPage();
        deanManagementPage.menuButonHava.click();

    }
    @When("DeanHava Contact Get all a tiklar")
    public void dean_hava_contact_get_all_a_tiklar() {
        deanManagementPage = new DeanManagementPage();
        deanManagementPage.contactGetAllHava.click();

    }
    @When("DeanHava Contact Message sayfasina gelir")
    public void dean_hava_contact_message_sayfasina_gelir() {
        deanManagementPage = new DeanManagementPage();
        deanManagementPage.contactMessageSayfasiHava.isDisplayed();

    }
    @Then("DeanHava bu sayfada mesajlari gorur")
    public void dean_hava_bu_sayfada_mesajlari_gorur() {
        deanManagementPage = new DeanManagementPage();
        Assert.assertTrue(deanManagementPage.messageHava.size()!=0);


    }
    @Then("DeanHava yazilan mesajlarin kime ait oldugunu gorur")
    public void dean_hava_yazilan_mesajlarin_kime_ait_oldugunu_gorur() {
        deanManagementPage = new DeanManagementPage();
        Assert.assertTrue(deanManagementPage.nameHava.size()!=0);

    }
    @Then("DeanHava yazan kisinin emailini gorur")
    public void dean_hava_yazan_kisinin_emailini_gorur() {
        deanManagementPage = new DeanManagementPage();
        Assert.assertTrue(deanManagementPage.emailHava.size()!=0);

    }
    @Then("DeanHava mesajlarin hangi tarihte yazildigini gorur")
    public void dean_hava_mesajlarin_hangi_tarihte_yazildigini_gorur() {
        deanManagementPage = new DeanManagementPage();
        Assert.assertTrue(deanManagementPage.dateHava.size()!=0);

    }
    @Then("DeanHava yazilan mesajlarin  hangi ders icin oldugunu gorur")
    public void dean_hava_yazilan_mesajlarin_hangi_ders_icin_oldugunu_gorur() {
        deanManagementPage = new DeanManagementPage();
        Assert.assertTrue(deanManagementPage.subjectHava.size()!=0);

    }


}
