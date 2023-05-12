package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.AdminManagementPage;
import pages.DeanManagementPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.openqa.selenium.Keys.ENTER;

public class US05_DeanEdit {

    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();
    AdminManagementPage adminManagementPage=new AdminManagementPage();
    DeanManagementPage deanManagementPage=new DeanManagementPage();

    String ussname = Faker.instance().name().username();

    String sssnumb = Faker.instance().number().digits(9).substring(0, 3) + "-" + Faker.instance().number().digits(9).substring(3, 5) + "-" + Faker.instance().number().digits(9).substring(5);




    @Given("Kullanici anasayfaya gider")
    public void kullanici_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.waitFor(2);
    }


    @When("Kullanici Admin olarak login olur")
    public void kullanici_admin_olarak_login_olur() {
        ReusableMethods.login(ConfigReader.getProperty("adminUsername"),ConfigReader.getProperty("adminsifre"));
        ReusableMethods.waitFor(2);
    }
    @Then("Admin menu butonuna tiklar")
    public void admin_menu_butonuna_tiklar() {


        homePage.MenuButton.click();
        ReusableMethods.waitFor(2);
    }
    @Then("Admin menüden Dean Management'a tiklar")
    public void admin_menüden_dean_management_a_tiklar() {

        homePage.DeanManagement.click();
        ReusableMethods.waitFor(2);

    }
    @Then("Admin Dean List'deki name Surname gorur")
    public void admin_dean_list_deki_name_surname_gorur() {

        ReusableMethods.scrollDownActions();

        assert deanManagementPage.Surname.isDisplayed();
        ReusableMethods.waitFor(2);
    }
    @Then("Admin Dean List'deki gender gorur")
    public void admin_dean_list_deki_gender_gorur() {

        assert deanManagementPage.gender.isDisplayed();
        ReusableMethods.waitFor(2);
    }
    @Then("Admin Dean List'deki phone name gorur")
    public void admin_dean_list_deki_phone_name_gorur() {
        assert deanManagementPage.phoneNumber.isDisplayed();
        ReusableMethods.waitFor(2);
    }
    @Then("Admin Dean List'deki SSN gorur")
    public void admin_dean_list_deki_ssn_gorur() {

        assert deanManagementPage.Ssn.isDisplayed();
        ReusableMethods.waitFor(2);
    }
    @Then("Admin Dean List'deki User name gorur")
    public void admin_dean_list_deki_user_name_gorur() {
        assert deanManagementPage.Username.isDisplayed();
        ReusableMethods.waitFor(2);
    }


    @Then("Admin List alanini gordugunu dogrular")
    public void admin_list_alanini_gordugunu_dogrular() {

        assert deanManagementPage.DeanList.isDisplayed();
        ReusableMethods.waitFor(4);

    }

    @Then("Admin sayfayi kapatir")
    public void admin_sayfayi_kapatir() {
        Driver.closeDriver();
    }

    @Then("KullaniciF edit butonuna tiklar")
    public void kullanici_edit_butonuna_tiklar() {


        ReusableMethods.scrollDownActions();
        ReusableMethods.scrollDownActions();

        ReusableMethods.waitFor(2);
        deanManagementPage.ilkedit.click();

    }

    @Then("KullaniciF {string} Alanina ismini girer")
    public void kullanici_alanina_ismini_girer(String dean) {

        deanManagementPage.namespace.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);

        ReusableMethods.waitFor(2);

        deanManagementPage.namespace.sendKeys(dean,Keys.ENTER);




    }
    @Then("KullaniciF {string} Alanina soyisim girer")
    public void kullanici_alanina_soyisim_girer(String soy) {

        deanManagementPage.surnamespace.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);

        ReusableMethods.waitFor(2);

        deanManagementPage.surnamespace.sendKeys(soy,Keys.ENTER);



    }
    @Then("KullaniciF {string} Alanina sehir girer")
    public void kullanici_alanina_sehir_girer(String sehir) {

        deanManagementPage.birthplace.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);

        ReusableMethods.waitFor(2);

        deanManagementPage.birthplace.sendKeys(sehir,Keys.ENTER);

    }
    @Then("KullaniciF Genderfemale seceneklerinden birini secer")
    public void kullanici_gender_seceneklerinden_birini_secer() {

        deanManagementPage.genderFemale.click();
        // ReusableMethods.clickByJS(deanManagementPage.genderFemale);

    }
    @Then("KullaniciF {string} Of Birth Alanina dogum tarihi girer")
    public void kullanici_of_birth_alanina_dogum_tarihi_girer(String tarih) {

        deanManagementPage.birthday.sendKeys(tarih, ENTER);



    }
    @Then("KullaniciF {string} Number Alanina telefon numarasini girer")
    public void kullanici_number_alanina_telefon_numarasini_girer(String phone) {
        deanManagementPage.phonenum.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);

        ReusableMethods.waitFor(2);

        deanManagementPage.phonenum.sendKeys(phone, ENTER);


    }
    @Then("KullaniciF {string} Alanina valid bir ssn numarasi girer")
    public void kullanici_alanina_valid_bir_ssn_numarasi_girer(String ssn) {

        deanManagementPage.ssnnum.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);

        ReusableMethods.waitFor(2);

        // deanManagementPage.ssnnum.sendKeys(ssn, ENTER);
        deanManagementPage.ssnnum.sendKeys(sssnumb);


    }
    @Then("KullaniciF {string} Alanina username girer")
    public void kullanici_alanina_username_girer(String usernam) {

        deanManagementPage.usname.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);

        ReusableMethods.waitFor(2);

        //deanManagementPage.usname.sendKeys(usernam, ENTER);

        deanManagementPage.usname.sendKeys(ussname);

    }
    @Then("KullaniciF {string} Alanina password girer")
    public void kullanici_alanina_password_girer(String pass) {

        deanManagementPage.psswrd.sendKeys(pass, ENTER);
        ReusableMethods.waitFor(2);

    }
    @Then("KullaniciF submitbuton butonuna tiklar")
    public void kullanici_submit_butonuna_tiklar() {

       ReusableMethods.clickByJS( deanManagementPage.subbuton);
       ReusableMethods.waitFor(2);

    }
    @Then("KullaniciF basariyla eklendigi goruntulenir")
    public void admin_basariyla_eklendigi_goruntulenir() {

        assert deanManagementPage.basarimesaj.isDisplayed();
        ReusableMethods.waitFor(4);

    }

    @Then("KullaniciF edit sayfasini kapatir")
    public void admin_edit_sayfasini_kapatir() {

        ReusableMethods.clickByJS(deanManagementPage.closebutton);
    }



    @Then("AdminF Gender seceneklerinden birini secmez")
    public void kullanici_gender_seceneklerinden_birini_secmez() {



    }
    @Then("AdminF password alanini bos birakir")
    public void kullanici_password_alanini_bos_birakir() {

        //deanManagementPage.psswrd.sendKeys("", ENTER);

    }

    @Then("AdminF submit butonuna tiklar")
    public void admin_submit_butonuna_tiklar() {

        deanManagementPage.subbuton.click();

    }
    @Then("AdminF tekrardan Dean password girmedigi icin uyari mesaji alir")
    public void admin_tekrardan_dean_password_girmedigi_icin_uyari_mesaji_alir() {

        ReusableMethods.waitFor(2);

        assert deanManagementPage.passuyari.isDisplayed();


    }

    @Then("AdminF {string} Alanina password girer")
    public void admin_alanina_password_girer(String sifre) {
        deanManagementPage.psswrd.sendKeys(sifre, ENTER);
        ReusableMethods.waitFor(2);
    }

    @Then("AdminF Gender alaninda secim yapmadigi icin anlasilir uyari mesaji alir")
    public void admin_gender_alaninda_secim_yapmadigi_icin_anlasilir_uyari_mesaji_alir() {

        ReusableMethods.waitFor(2);

        //Assert.assertTrue();daha sonra bak

        assert deanManagementPage.genderuyari.isDisplayed();



    }

}

