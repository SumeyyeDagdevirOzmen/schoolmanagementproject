package stepdefinitions.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.ViceDineManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class VicedeanContactMessageUIStepDef {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    ViceDineManagementPage viceDeanPage = new ViceDineManagementPage();
    @And("Kullanici SignIn butonuna tiklar")
    public void kullaniciLoginSagüstButonunaTiklar() {
      ReusableMethods.clickByJS(loginPage.SigIn);
    }

    @And("Kullanici  User Name textboxa valid bir deger girer")
    public void kullaniciUserNameTextboxaValidBirDegerGirer() {
   loginPage.username.sendKeys("Vicedean03");
    }

    @And("Kullanici Password textboxa valid bir deger girer")
    public void kullaniciPasswordTextboxaValidBirDegerGirer() {
      loginPage.password.sendKeys("Team03team");
    }

    @And("KullaniciF Login butonuna tiklar")
    public void kullanicifLoginButonunaTiklar() {
     ReusableMethods.clickByJS(loginPage.loginButton);

    }

    @And("Kullanic acilan sayfada Menu butonuna tiklar")
    public void kullanicAcilanSayfadaMenuButonunaTiklar() {
    homePage.MenuButton.click();
    }


    @And("Kullanici solda acilan Contact Get All sekmesine tiklar")
    public void kullaniciSoldaAcilanContactGetAllSekmesineTiklar() {
    homePage.ContactGetAll.click();
    }


    @Then("Kullanici Mesajlarin in gorunur oldugunu dogrular")
    public void kullaniciMesajlarinInGorunurOldugunuDogrular() {
        Assert.assertTrue(viceDeanPage.dataTableMessageList.size()!=0);
    }

    @Then("Kullanici Subjectlerin gorunur oldugunu dogrular")
    public void kullaniciSubjectlerinGorunurOldugunuDogrular() {
        Assert.assertTrue(viceDeanPage.dataTableSubjectList.size()!=0);
    }

    @Then("Kullanici Datelerin gorunur oldugunu dogrular")
    public void kullaniciDatelerinGorunurOldugunuDogrular() {
        Assert.assertTrue(viceDeanPage.dataTableDateList.size()!=0);
    }


    @Then("Kullanici Emaillerin gorunur oldugunu dogrular")
    public void kullaniciEmaillerinGorunurOldugunuDogrular() {
        Assert.assertTrue(viceDeanPage.dataTableEmailList.size()!=0);
    }

    @Then("Kullanici Namelerin gorunur oldugunu dogrular")
    public void kullaniciNamelerinGorunurOldugunuDogrular() {
     Assert.assertTrue( viceDeanPage.dataTableNameList.size()!=0);
    }

    @Then("Kullanici herhangi bir mesaji silindigini dogrular")
    public void kullaniciHerhangiBirMesajiSilindiginiDogrular() {
        Assert.assertTrue(false);
    }

    @Given("KullaniciF sayfaya gider")
    public void kullanicifSayfayaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
}
