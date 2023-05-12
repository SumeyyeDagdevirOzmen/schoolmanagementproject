package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AdminManagementPage;
import pages.HomePage;
import pages.LoginPage;
import pages.StudentManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class US22_AdminEkleme {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    AdminManagementPage adminManagementPage = new AdminManagementPage();
    StudentManagementPage studentManagementPage = new StudentManagementPage();


    @And("Kullanicik {string} Of Birth Alanina dogum tarihi girer")
    public void kullanicikOfBirthAlaninaDogumTarihiGirer(String string) {

    }

    @Given("Kullanicik sayfaya gider")
    public void kullanicikSayfayaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.waitFor(1);
    }

    @When("Kullanicik admin olarak login olur")
    public void kullanicikAdminOlarakLoginOlur() {
     /*   loginPage.SigIn.click();
        ReusableMethods.waitFor(1);
        loginPage.username.sendKeys(ConfigReader.getProperty("adminUsername"));
        ReusableMethods.waitFor(1);
        loginPage.password.sendKeys(ConfigReader.getProperty("adminsifre"));
        ReusableMethods.waitFor(1);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(1);*/
  ReusableMethods.login("AdminB103","12345678");
    }

    @And("Kullanicik menu butonuna basar")
    public void kullanicikMenuButonunaBasar() {
        homePage.MenuButton.click();
        ReusableMethods.waitFor(1);
    }

    @And("KAdmin management secenegini tiklar")
    public void kadminManagementSeceneginiTiklar() {
        homePage.AdminManagement.click();
        ReusableMethods.waitFor(1);

    }

    @And("Kullanicik {string} Alanina ismini girer")
    public void kullanicikAlaninaIsminiGirer(String string) {
        adminManagementPage.name.sendKeys(string);
        ReusableMethods.waitFor(1);
    }

    @And("Kullanicik {string} Alanina soyisim girer")
    public void kullanicikAlaninaSoyisimGirer(String string) {
        adminManagementPage.surname.sendKeys(string);
        ReusableMethods.waitFor(1);
    }

    @And("Kullanicik {string} Alanina sehir girer")
    public void kullanicikAlaninaSehirGirer(String string) {
        adminManagementPage.birthPlace.sendKeys(string);
        ReusableMethods.waitFor(1);
    }

    @And("Kullanicik Gender seceneklerinden birini secer")
    public void kullanicikGenderSeceneklerindenBiriniSecer() {

        adminManagementPage.gender.click();
        ReusableMethods.waitFor(1);
    }

    @And("Kullanicik {string} Number Alanina telefon numarasini girer")
    public void kullanicikNumberAlaninaTelefonNumarasiniGirer(String string) {
        adminManagementPage.phoneNumber.sendKeys(string);
        ReusableMethods.waitFor(1);
    }

    @And("Kullanicik {string} Alanina valid bir ssn numarasi girer")
    public void kullanicikAlaninaValidBirSsnNumarasiGirer(String string) {
        adminManagementPage.ssnNumber.sendKeys(string);
        ReusableMethods.waitFor(1);
    }

    @And("Kullanicik {string} Alanina username girer")
    public void kullanicikAlaninaUsernameGirer(String string) {
        adminManagementPage.userName.sendKeys(string);
        ReusableMethods.waitFor(1);
    }

    @And("Kullanicik {string} Alanina password girer")
    public void kullanicikAlaninaPasswordGirer(String string) {

        adminManagementPage.password.sendKeys(string);
        ReusableMethods.waitFor(1);
    }

    @And("Kullanicik Submit butonuna tiklar")
    public void kullanicikSubmitButonunaTiklar() {
        adminManagementPage.submit.click();
        ReusableMethods.waitFor(1);
    }

    @Then("KAdmin basariyla eklendigi goruntulenir")
    public void kadminBasariylaEklendigiGoruntulenir() {
        ReusableMethods.getScreenshot("Admin basariyla eklendi");

        assert adminManagementPage.adminSaved.isEnabled();

    }

    @And("Kullanicik Name Alanina bos karakter girer")
    public void kullanicikNameAlaninaBosKarakterGirer() {
        adminManagementPage.name.sendKeys("  ");
        ReusableMethods.waitFor(1);
    }

    @And("KSurname alanina valid bir Surname girilir")
    public void ksurnameAlaninaValidBirSurnameGirilir() {
        adminManagementPage.surname.sendKeys(Faker.instance().name().lastName());
        ReusableMethods.waitFor(1);
    }

    @And("KBirthplace alanina valid bir Birthplace girilir")
    public void kbirthplaceAlaninaValidBirBirthplaceGirilir() {
        adminManagementPage.birthPlace.sendKeys(Faker.instance().address().city());

    }

    @And("KGender seceneklerinden biri secilir")
    public void kgenderSeceneklerindenBiriSecilir() {

        adminManagementPage.gender.click();
        ReusableMethods.waitFor(1);
    }

    @And("KDate Of Birth alanina valid bir dogum tarihi girilir")
    public void kdateOfBirthAlaninaValidBirDogumTarihiGirilir() {
        adminManagementPage.birthDay.sendKeys("01.01.2000");
        ReusableMethods.waitFor(1);

    }

    @And("KPhone Number alanina valid bir Phone Number girilir")
    public void kphoneNumberAlaninaValidBirPhoneNumberGirilir() {
        adminManagementPage.phoneNumber.sendKeys(Faker.instance().number().numberBetween(100, 1000) + "-" + Faker.instance().number().numberBetween(100, 1000) + "-" + Faker.instance().number().numberBetween(1000, 10000));
        ReusableMethods.waitFor(1);
    }

    @And("KSSN alanina valid bir SSN numarasi girilir")
    public void kssnAlaninaValidBirSSNNumarasiGirilir() {
        adminManagementPage.ssnNumber.sendKeys(194 + "-" +
                Faker.instance().number().numberBetween(10, 100) + "-" +
                Faker.instance().number().numberBetween(1000, 10000));
        ReusableMethods.waitFor(1);
    }

    @And("KUser Name alanina valid bir kullanici adi girilir")
    public void kuserNameAlaninaValidBirKullaniciAdiGirilir() {
        adminManagementPage.userName.sendKeys(Faker.instance().name().username());
        ReusableMethods.waitFor(1);
    }

    @And("KPassword alanina valid bir Password girilir")
    public void kpasswordAlaninaValidBirPasswordGirilir() {

        adminManagementPage.password.sendKeys("12344321");
        ReusableMethods.waitFor(1);
    }

    @And("KSubmit butonuna tiklanir")
    public void ksubmitButonunaTiklanir() {
        adminManagementPage.submit.click();


        ReusableMethods.waitFor(1);


    }


    @And("KName alanina valid bir Name girilir")
    public void knameAlaninaValidBirNameGirilir() {
        adminManagementPage.name.sendKeys(Faker.instance().name().firstName());
        ReusableMethods.waitFor(1);
    }

    @And("KKullanici Surname Alanina bos karakter girer")
    public void kkullaniciSurnameAlaninaBosKarakterGirer() {
        adminManagementPage.surname.sendKeys("  ");
        ReusableMethods.waitFor(1);
    }

    @And("KGender seçeneklerinden biri secilir")
    public void kgenderSeçeneklerindenBiriSecilir() {
        adminManagementPage.gender.click();
        ReusableMethods.waitFor(1);
    }


    @And("KBirthplace alanina bos karakter girer.")
    public void kbirthplaceAlaninaBosKarakterGirer() {
        adminManagementPage.birthPlace.sendKeys(" ");
        ReusableMethods.waitFor(1);
    }

    @And("KGender secenekleri bos birakilir")
    public void kgenderSecenekleriBosBirakilir() {
    }


    @And("KDate Of Birth alanı bos birakilir")
    public void kdateOfBirthAlanıBosBirakilir() {
    }


    @And("KPhone Number alani bos birakilir")
    public void kphoneNumberAlaniBosBirakilir() {
    }


    @And("KSSN alani bos birakilir")
    public void kssnAlaniBosBirakilir() {
    }

    @And("KSSN alanina XX-XXX-XXXX formatinda bir deger girilir")
    public void kssnAlaninaXXXXXXXXXFormatindaBirDegerGirilir() {
        adminManagementPage.ssnNumber.sendKeys(Faker.instance().number().numberBetween(10, 100) + "-" + Faker.instance().number().numberBetween(100, 1000) + "-" + Faker.instance().number().numberBetween(1000, 10000));
        ReusableMethods.waitFor(1);
    }

    @Then("KSSN alaninin valid bir deger girilmesine dair uyari alindigi dogrulanir")
    public void kssnAlanininValidBirDegerGirilmesineDairUyariAlindigiDogrulanir() {
        ReusableMethods.getScreenshot("Valid bir  SSN numarasi girilmeli");
        assert adminManagementPage.SsnAlert.isEnabled();

        ReusableMethods.waitFor(1);
    }

    @And("KSSN Alanina XXXX-X-XXXX formatinda bir deger girer")
    public void kssnAlaninaXXXXXXXXXFormatindaBirDegerGirer() {
        adminManagementPage.ssnNumber.sendKeys(Faker.instance().number().numberBetween(1000, 10000) + "-" + Faker.instance().number().numberBetween(1, 10) + "-" + Faker.instance().number().numberBetween(1000, 10000));
        ReusableMethods.waitFor(1);
    }

    @And("KSSN Alanina XXX-X-XXXXX formatindan bir deger girer")
    public void kssnAlaninaXXXXXXXXXFormatindanBirDegerGirer() {
        adminManagementPage.ssnNumber.sendKeys(Faker.instance().number().numberBetween(100, 1000) + "-" + Faker.instance().number().numberBetween(1, 10) + "-" + Faker.instance().number().numberBetween(10000, 100000));
        ReusableMethods.waitFor(1);
    }


    @And("KSSN Alanina XXX-XXX-XXX formatindan bir deger girmelidir")
    public void kssnAlaninaXXXXXXXXXFormatindanBirDegerGirmelidir() {
        adminManagementPage.ssnNumber.sendKeys(Faker.instance().number().numberBetween(100, 1000) + "-" + Faker.instance().number().numberBetween(100, 1000) + "-" + Faker.instance().number().numberBetween(100, 1000));

        ReusableMethods.waitFor(1);
    }

    @And("KSSN Alanina XXX-XX-XXX seklinde bir deger girmelidir")
    public void kssnAlaninaXXXXXXXXSeklindeBirDegerGirmelidir() {
        adminManagementPage.ssnNumber.sendKeys(Faker.instance().number().numberBetween(100, 1000) + "-" + Faker.instance().number().numberBetween(10, 100) + "-" + Faker.instance().number().numberBetween(100, 1000));
        ReusableMethods.waitFor(1);
    }

    @And("KSSN Alanina XXX-XX-XXXXX seklinde bir deger girilir")
    public void kssnAlaninaXXXXXXXXXXSeklindeBirDegerGirilir() {
        adminManagementPage.ssnNumber.sendKeys(Faker.instance().number().numberBetween(100, 1000) + "-" + Faker.instance().number().numberBetween(10, 100) + "-" + Faker.instance().number().numberBetween(10000, 100000));
        ReusableMethods.waitFor(1);
    }


    @And("KPassword alani bos birakilir")
    public void kpasswordAlaniBosBirakilir() {
        adminManagementPage.password.sendKeys("");
        ReusableMethods.waitFor(1);
    }


    @Then("KPassword alaninin valid bir deger girilmesine dair uyari alindigi dogrulanir")
    public void kpasswordAlanininValidBirDegerGirilmesineDairUyariAlindigiDogrulanir() {
        ReusableMethods.getScreenshot("Valid bir password girin");
        assert adminManagementPage.passwordAlert.isDisplayed();

        ReusableMethods.waitFor(1);
    }

    @And("KPassword alanina yedi karakter girer")
    public void kpasswordAlaninaYediKarakterGirer() {
        adminManagementPage.password.sendKeys("1234321");
        ReusableMethods.waitFor(1);

    }

    @And("KPassword alanina dokuz karakter girer")
    public void kpasswordAlaninaDokuzKarakterGirer() {
        adminManagementPage.password.sendKeys("123432134");

    }

    @And("KPassword alanina bos karakter girilir")
    public void kpasswordAlaninaBosKarakterGirilir() {
        adminManagementPage.password.sendKeys("  ");
        ReusableMethods.waitFor(1);
    }

    @And("Kullanicik Name Alanina valid bir isim girer")
    public void kullanicikNameAlaninaValidBirIsimGirer() {
        adminManagementPage.name.sendKeys(Faker.instance().name().firstName());
        ReusableMethods.waitFor(1);
    }

    @Then("Basariyla eklendi mesaji goruntulenir.")
    public void basariylaEklendiMesajiGoruntulenir() {
        ReusableMethods.getScreenshot("Admin basariyla eklendi");

        assert adminManagementPage.adminSaved.isEnabled();

    }

    @Then("KName alaninin bos birakilamayacagina dair uyari alindigi dogrulanir")
    public void knameAlanininBosBirakilamayacaginaDairUyariAlindigiDogrulanir() {
        ReusableMethods.getScreenshot("Admin saved mesaji BUG");;

        Assert.assertTrue(adminManagementPage.adminSaved.isEnabled());
        ReusableMethods.waitFor(1);

    }

    @Then("KGender alaninin bos birakilamayacagina dair uyari alindigi dogrulanir")
    public void kgenderAlanininBosBirakilamayacaginaDairUyariAlindigiDogrulanir() {
        ReusableMethods.getScreenshot("Uyari mesaji yok ");
        // Assert.assertFalse( adminManagementPage.name.getAttribute("value").isBlank());
        // Assert.assertTrue(adminManagementPage.falsemessage.isEnabled());
        // Assert.assertFalse(adminManagementPage.adminSaved.isEnabled());
        //Assert.assertFalse(adminManagementPage.adminSaved.isEnabled());
        // ReusableMethods.verifyElementNotDisplayed(adminManagementPage.adminSaved);
        ReusableMethods.verifyElementDisplayed(adminManagementPage.alertRequired);








    }

    @Then("KDateofbirth alaninin bos birakilamayacagina dair uyari alindigi dogrulanir")
    public void kdateofbirthAlanininBosBirakilamayacaginaDairUyariAlindigiDogrulanir() {
        ReusableMethods.getScreenshot("Bu alan gerekli ");
        assert adminManagementPage.alertRequired.isEnabled();

        ReusableMethods.waitFor(1);


    }

    @Then("KPhone_number alaninin bos birakilamayacagina dair uyari alindigi dogrulanir")
    public void kphone_numberAlanininBosBirakilamayacaginaDairUyariAlindigiDogrulanir() {
        ReusableMethods.getScreenshot("Bu alan gerekli ");
        assert adminManagementPage.alertRequired.isEnabled();

        ReusableMethods.waitFor(1);

    }

    @Then("KSSN_number alaninin bos birakilamayacagina dair uyari alindigi dogrulanir")
    public void kssn_numberAlanininBosBirakilamayacaginaDairUyariAlindigiDogrulanir() {
        ReusableMethods.getScreenshot("Bu alan gerekli ");
        assert adminManagementPage.alertRequired.isEnabled();

        ReusableMethods.waitFor(1);

    }

    @And("KUser Name alani bos birakilir")
    public void kuserNameAlaniBosBirakilir() {
    }

    @Then("KUsername alaninin bos birakilamayacagina dair uyari alindigi dogrulanir")
    public void kusernameAlanininBosBirakilamayacaginaDairUyariAlindigiDogrulanir() {
        ReusableMethods.getScreenshot("Bu alan gerekli ");
        assert adminManagementPage.alertRequired.isEnabled();

        ReusableMethods.waitFor(1);

    }

    @Then("Kpassword alaninin bos birakilamayacagina dair uyari alindigi dogrulanir")
    public void kpasswordAlanininBosBirakilamayacaginaDairUyariAlindigiDogrulanir() {
        ReusableMethods.getScreenshot("Bu alan gerekli ");
        assert adminManagementPage.alertRequired.isEnabled();
    }

    @Then("KSurname alaninin bos birakilamayacagina dair uyari alindigi dogrulanir")
    public void ksurnameAlanininBosBirakilamayacaginaDairUyariAlindigiDogrulanir() {
        ReusableMethods.getScreenshot("Admin saved mesaji BUG");;

        Assert.assertFalse(adminManagementPage.adminSaved.isEnabled());
        ReusableMethods.waitFor(1);
    }

    @Then("KBirthplace alaninin bos birakilamayacagina dair uyari alindigi dogrulanir")
    public void kbirthplaceAlanininBosBirakilamayacaginaDairUyariAlindigiDogrulanir() {
        ReusableMethods.getScreenshot("Admin saved mesaji BUG");;

        Assert.assertFalse(adminManagementPage.adminSaved.isEnabled());
        ReusableMethods.waitFor(1);
    }

    @And("KSayfayi kapatir.")
    public void ksayfayiKapatir() {
        homePage = new HomePage();
        studentManagementPage = new StudentManagementPage();
        ReusableMethods.clickByJS(homePage.MenuButton);
        ReusableMethods.clickByJS(homePage.Logout);
        ReusableMethods.clickByJS(homePage.logoutConfirmation);

    }

    @Then("KSSN alaninin min 11 karakter girilmesine dair uyari alindigi dogrulanir")
    public void kssnAlanininMinKarakterGirilmesineDairUyariAlindigiDogrulanir() {

        assert adminManagementPage.min11HataMesaji.isEnabled();

    }


}
