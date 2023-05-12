package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.TeacherManagementPage;
import pages.ViceDineManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.generateRandomUsername;

public class US13_ViceDeanAddTeacher {
    TeacherManagementPage teacherManagementPage; 
    ViceDineManagementPage viceDineManagementPage;
    HomePage homePage;
    @Given("Kullanici  sayfaya gider uygulamaya Vice Dean hesabiyla login olur")
    public void kullaniciSayfayaGiderUygulamayaViceDeanHesabiylaLoginOlur() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.login(ConfigReader.getProperty("viceDeanusername"),ConfigReader.getProperty("viceDeansifre"));
        ReusableMethods.waitFor(2);
    }
    @And("Kullanici menu butonuna tiklar")
    public void kullaniciMenuButonunaTiklar() {
        homePage=new HomePage();
        homePage.MenuButton.click();
        ReusableMethods.waitFor(2);
    }
    @And("Kullanici Teacher Management secenegine tiklar")
    public void kullaniciTeacherManagementSecenegineTiklar() {
        homePage=new HomePage();
        ReusableMethods.clickByJS(homePage.TeacherManagement);
        ReusableMethods.waitFor(2);
    }
    @And("Kullanici Choose Lessons dropdowna tiklar ve bir ders secer")
    public void kullaniciChooseLessonsDropdownaTiklarVeBirDersSecer()  {
        String lesson="Math";
        viceDineManagementPage = new ViceDineManagementPage();
        viceDineManagementPage.chooseLessons.click();
        ReusableMethods.waitFor(4);
        Actions action=new Actions(Driver.getDriver());
        action.keyDown(Keys.ARROW_DOWN).sendKeys(lesson,Keys.ENTER,Keys.TAB).perform();
        ReusableMethods.waitFor(4);
//        teacherManagementPage= new TeacherManagementPage();
//        teacherManagementPage.teacherchooseLessons.click();
//        ReusableMethods.waitFor(4);
//        Actions action = new Actions(Driver.getDriver());
//        action.sendKeys("Math", Keys.ENTER).perform();
//        ReusableMethods.waitFor(2);
    }
    @And("Kullanici Name alanina name girer")
    public void kullaniciNameAlaninaNameGirer() {
        String firstName = Faker.instance().name().firstName();
        viceDineManagementPage=new ViceDineManagementPage();
        viceDineManagementPage.name.sendKeys(firstName);
    }
    @And("Kullanici Surname alanina surname girer")
    public void kullaniciSurnameAlaninaSurnameGirer() {
        String lastName = Faker.instance().name().lastName();
        viceDineManagementPage=new ViceDineManagementPage();
        viceDineManagementPage.surName.sendKeys(lastName);
    }
    @And("Kullanici BirthPlace alanina birth_place degerini girer")
    public void kullaniciBirthPlaceAlaninaBirth_placeDegeriniGirer() {
        String birth_place=Faker.instance().address().cityName();
        viceDineManagementPage=new ViceDineManagementPage();
        viceDineManagementPage.birthPlace.sendKeys(birth_place);
    }
    @And("Kullanici Email alanina valid bir email girer")
    public void kullaniciEmailAlaninaValidBirEmailGirer() {
        String email = Faker.instance().name().firstName()+"@gmail.com";
        viceDineManagementPage=new ViceDineManagementPage();
        viceDineManagementPage.email.sendKeys(email);
    }
    @And("Kullanici Phone alanina valid bir phone girer")
    public void kullaniciPhoneAlaninaGecerliBirPhoneGirer() {
        String phone = Faker.instance().number().numberBetween(100,1000)+"-"+
                Faker.instance().number().numberBetween(100,1000)+"-"+
                Faker.instance().number().numberBetween(1000,10000);
        viceDineManagementPage=new ViceDineManagementPage();
        viceDineManagementPage.phone.sendKeys(phone);
    }
    @And("Kullanici Is Advisor Teacher checkbox'ina tiklar")
    public void kullaniciIsAdvisorTeacherCheckboxInaTiklar() {
        viceDineManagementPage=new ViceDineManagementPage();
        viceDineManagementPage.isAdvisorTeacher.click();
    }
    @And("KullaniciS Gender seceneklerinden birini secer")
    public void kullaniciSGenderSeceneklerindenBiriniSecer() {
        viceDineManagementPage=new ViceDineManagementPage();
        ReusableMethods.gender();
    }
    @And("Kullanici Date Of Birth alanina dogum tarihini girer")
    public void kullaniciDateOfBirthAlaninaDogumTarihiniGirer() {
        String date_of_birth=Faker.instance().number().numberBetween(0,13)+""+
                Faker.instance().number().numberBetween(1,30)+""+
                Faker.instance().number().numberBetween(1960,2023);
        viceDineManagementPage=new ViceDineManagementPage();
        viceDineManagementPage.dateOfBirth.sendKeys(date_of_birth);
    }
    @And("Kullanici SSN alanina ssn girer")
    public void kullaniciSSNAlaninaSsnGirer() {
        String ssn = Faker.instance().number().digits(9).substring(0, 3) +
                "-" + Faker.instance().number().digits(9).substring(3, 5) +
                "-" + Faker.instance().number().digits(9).substring(5);
        viceDineManagementPage=new ViceDineManagementPage();
        viceDineManagementPage.ssn.sendKeys(ssn);
    }
    @And("Kullanici UserName alanina gecerli bir username girer")
    public void kullaniciUserNameAlaninaGecerliBirUsernameGirer() {
        String username = Faker.instance().name().firstName()+"team03";
        viceDineManagementPage=new ViceDineManagementPage();
        viceDineManagementPage.userName.sendKeys(username);
    }
    @And("Kullanici Password alanina gecerli bir password girer")
    public void kullaniciPasswordAlaninaGecerliBirPasswordGirer() {
        String password = Faker.instance().internet().password();
        viceDineManagementPage=new ViceDineManagementPage();
        viceDineManagementPage.password.sendKeys(password);
    }
    @And("KullaniciS Submit butonuna tiklar")
    public void kullaniciSSubmitButonunaTiklar() {
        viceDineManagementPage=new ViceDineManagementPage();
        ReusableMethods.waitFor(1);
        viceDineManagementPage.submitButton.click();
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("Space karakter girilemez");
    }
    @Then("Kullanici ogretmen olusturdugunu dogrular")
    public void kullanıcıOgretmenOlusturdugunuDogrular() {
        teacherManagementPage= new TeacherManagementPage();
        Driver.waitForVisibility(teacherManagementPage.teacherSuccessfully,5);
        ReusableMethods.getScreenshot("Success Alert Goruntulendi");
    }
    @Then("Kullanici uygulamayi kapatir")
    public void kullaniciUygulamayiKapatir() {
        homePage=new HomePage();
        ReusableMethods.clickByJS(homePage.MenuButton);
        ReusableMethods.clickByJS(homePage.Logout);
        ReusableMethods.clickByJS(homePage.logoutConfirmation);
        Driver.closeDriver();
    }
    @And("Kullanici Choose Lessons dropdowni bos birakir")
    public void kullaniciChooseLessonsDropdowniBosBirakir() {
        viceDineManagementPage=new ViceDineManagementPage();
        viceDineManagementPage.chooseLessons.click();
        ReusableMethods.getScreenshot("Lesson can not be empty");
    }
    @And("Kullanici {string} uyari mesajini aldigini dogrular")
    public void kullaniciUyariMesajiniAldiginiDogrular(String str) {
        teacherManagementPage= new TeacherManagementPage();

        Assert.assertTrue(teacherManagementPage.generalAlert.getText().contains(str));
        ReusableMethods.waitFor(2);
    }
    @And("Kullanici Name alanini bos birakir")
    public void kullaniciNameAlaniniBosBirakir() {
        viceDineManagementPage=new ViceDineManagementPage();
        viceDineManagementPage.name.sendKeys(Keys.TAB);
        ReusableMethods.getScreenshot("Required text is displayed!");
    }
    @And("Kullanici {string} uyari mesaji goruntulendigini dogrular")
    public void kullaniciUyariMesajiGoruntulendiginiDogrular(String str) {
        TeacherManagementPage teacherManagementPage=new TeacherManagementPage();
        Assert.assertTrue(teacherManagementPage.requiredText.getText().contains(str));
    }
    @And("Kullanici Name alanina space karakter girer")
    public void kullaniciNameAlaninaSpaceKarakterGirer() {
        viceDineManagementPage=new ViceDineManagementPage();
        viceDineManagementPage.name.sendKeys(Keys.TAB);
        viceDineManagementPage.name.sendKeys(" ");
    }
    @Then("Kullanici invalid uyari mesaji aldigini dogrular")
    public void kullaniciInvalidUyariMesajiAldiginiDogrular() {
        teacherManagementPage= new TeacherManagementPage();

        Assert.assertTrue("Aslinda bu test kalmasi gerekirken gecti",teacherManagementPage.generalAlert.getText().contains("name"));


    }
    @And("Kullanici Surname alanini bos birakir")
    public void kullaniciSurnameAlaniniBosBirakir() {
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.surName.sendKeys(Keys.TAB);
    }
    @And("Kullanici Surname alanina space karakter girer")
    public void kullaniciSurnameAlaninaSpaceKarakterGirer() {
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.surName.sendKeys(" ");
        ReusableMethods.waitFor(3);
        ReusableMethods.getScreenshot("Surname can not have space characters");
    }
    @And("Kullanici BirthPlace alanini bos birakir")
    public void kullaniciBirthPlaceAlaniniBosBirakir() {
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.birthPlace.sendKeys(Keys.TAB);
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("Birthplace can not be empty");
    }
    @And("Kullanici BirthPlace alanina space karakter girer")
    public void kullaniciBirthPlaceAlaninaSpaceKarakterGirer() {
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.birthPlace.sendKeys("  ");
        ReusableMethods.waitFor(3);
        ReusableMethods.getScreenshot("Birthplace can not have space characters");
    }
    @And("Kullanici Email alanini bos birakir")
    public void kullaniciEmailAlaniniBosBirakir() {
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.email.sendKeys(Keys.TAB);
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("Email field can not be empty");
    }
    @And("Kullanici Email alanina invalid bir email girer")
    public void kullaniciEmailAlaninaInvalidBirEmailGirer() {
        String invalidEmail=Faker.instance().name().firstName()+"@gmail";
        //xxx@gmail
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.email.sendKeys(invalidEmail);
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("Email should be valid email formatted");
    }
    @Then("Kullanici {string} mesajini gordugunu dogrular")
    public void kullaniciMesajiniGordugunuDogrular(String str) {
        teacherManagementPage= new TeacherManagementPage();
        Assert.assertTrue(teacherManagementPage.generalAlert.getText().contains(str));
    }
    @And("Kullanici Email alanina invalid olan bir email girer")
    public void kullaniciEmailAlaninaInvalidOlanBirEmailGirer() {
        String invalidEmail2=Faker.instance().name().firstName()+""+Faker.instance().number().numberBetween(1,10)+".com";
        //sumeyye123.com
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.email.sendKeys(invalidEmail2);
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("Email should be valid email formatted");
    }
    @And("Kullanici Phone alanini bos birakir")
    public void kullaniciPhoneAlaniniBosBirakir() {
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.phone.sendKeys(Keys.TAB);
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("Phonenumber can not be empty");
    }
    @And("Kullanici Phone alanina invalid bir deger girer")
    public void kullaniciPhoneAlaninaInvalidBirDegerGirer() {
        String invalidPhone = Faker.instance().number().digits(12);

        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.phone.sendKeys(invalidPhone);
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("Phone can not be invalid phonenumber");

    }

    @Then("Kullanici {string} uyari mesaji aldigini dogrular")
    public void kullaniciUyariMesajiAldiginiDogrular(String str) {
        teacherManagementPage= new TeacherManagementPage();
        Assert.assertTrue(teacherManagementPage.PhoneAlert.getText().contains(str));
        ReusableMethods.getScreenshot("Phone can not be invalid phonenumber");

    }
    @And("Kullanici Phone alanina onbir karakter girer")
    public void kullaniciPhoneAlaninaOnbirKarakterGirer() {
        String invalidPhone2 = Faker.instance().number().digits(11);
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.phone.sendKeys(invalidPhone2);
        ReusableMethods.waitFor(2);

    }


    @Then("Kullanici {string} uyari yazisi aldigini dogrular")
    public void kullaniciUyariYazisiAldiginiDogrular(String str) {
        teacherManagementPage= new TeacherManagementPage();
        assert teacherManagementPage.PhoneAlert2.getText().contains(str);
        ReusableMethods.getScreenshot("Phone field should have at least 12 characters");
    }


    @And("KullaniciS Gender seceneklerinden birini secmez")
    public void kullanicisGenderSeceneklerindenBiriniSecmez() {

    }

    @And("Kullanici Date Of Birth alanini bos birakir")
    public void kullaniciDateOfBirthAlaniniBosBirakir() {
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.dateOfBirth.sendKeys(Keys.TAB);
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("DateofBirth can not be empty");
    }

    @And("Kullanici Ssn alanini bos birakir")
    public void kullaniciSsnAlaniniBosBirakir() {
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.ssn.sendKeys(Keys.TAB);
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("SSN field can not be empty");

    }

    @And("Kullanici Ssn alanina tiresiz invalid deger girer")
    public void kullaniciSsnAlaninaTiresizInvalidDegerGirer() {
        String invalidSsn = Faker.instance().number().digits(10);
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.ssn.sendKeys(invalidSsn);
        ReusableMethods.getScreenshot("Invalid SSN");

    }

    @Then("Kullanici {string} uyari mesaji gordugunu dogrular")
    public void kullaniciUyariMesajiGordugunuDogrular(String str) {
        teacherManagementPage= new TeacherManagementPage();
        assert teacherManagementPage.ssnAlert.getText().contains(str);
        ReusableMethods.getScreenshot("SSN field must be at least 11 characters");

    }

    @And("Kullanici Ssn formatinda olmayan invalid deger girer")
    public void kullaniciSsnFormatindaOlmayanInvalidDegerGirer() {
        String invalidSsn2 = Faker.instance().number().digits(9).substring(0, 2) +
                "-" + Faker.instance().number().digits(9).substring(2, 4) +
                "-" + Faker.instance().number().digits(9).substring(4);
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.ssn.sendKeys(invalidSsn2);
        ReusableMethods.getScreenshot("Invalid SSN");


    }

    @Then("KullaniciS {string} uyari mesaji goruntulendigini dogrular")
    public void kullanicisUyariMesajiGoruntulendiginiDogrular(String str) {
        teacherManagementPage= new TeacherManagementPage();
        assert teacherManagementPage.ssnAlert2.getText().contains(str);
        ReusableMethods.getScreenshot("Invalid SSN number");
    }


    @And("KullaniciS Ssn formatinda olmayan invalid deger girer")
    public void kullanicisSsnFormatindaOlmayanInvalidDegerGirer() {
        String invalidSsn3 = Faker.instance().number().digits(9).substring(0, 3) +
                "-" + Faker.instance().number().digits(9).substring(3, 6) +
                "-" + Faker.instance().number().digits(9).substring(6);
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.ssn.sendKeys(invalidSsn3);
        ReusableMethods.getScreenshot("Invalid SSN3");

    }

    @And("KullaniciS Ssn alaninina invalid bir deger girer")
    public void kullanicisSsnAlanininaInvalidBirDegerGirer() {
        String invalidSsn4 = Faker.instance().number().digits(10).substring(0, 3) +
                "-" + Faker.instance().number().digits(10).substring(3, 5) +
                "-" + Faker.instance().number().digits(10).substring(5);
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.ssn.sendKeys(invalidSsn4);
        ReusableMethods.getScreenshot("Invalid SSN4");

    }

    @And("Kullanici UserName alanini bos birakir")
    public void kullaniciUserNameAlaniniBosBirakir() {
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.userName.sendKeys(Keys.TAB);
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("Username must not be empty");
    }

    @And("Kullanici UserName alanina space karakterler girer")
    public void kullaniciUserNameAlaninaSpaceKarakterlerGirer() {
        String username2 = generateRandomUsername();
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.userName.sendKeys(username2);
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("Username must not have space characters");

    }

    @And("Kullanici Password alanini bos birakir")
    public void kullaniciPasswordAlaniniBosBirakir() {
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.password.sendKeys(Keys.TAB);
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("Password must not be empty");
    }

    @And("KullaniciS Password alanina invalid bir deger girer")
    public void kullanicisPasswordAlaninaInvalidBirDegerGirer() {
        String password2= Faker.instance().number().digits(7);
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.password.sendKeys(password2);
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("Password must be min 8 characters");
        System.out.println("password2 = " + password2);

    }


    @And("KullaniciS {string} uyari mesaji aldigini dogrular")
    public void kullanicisUyariMesajiAldiginiDogrular(String str) {
        teacherManagementPage= new TeacherManagementPage();
        assert teacherManagementPage.passwordAlert.getText().contains(str);
        ReusableMethods.getScreenshot("Username has to be min 8 characters");
    }

    @And("KullaniciS Password alanina invalid bir data girer")
    public void kullanicisPasswordAlaninaInvalidBirDataGirer() {

        String password3="        ";
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.password.sendKeys(password3);
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("Password can not have space characters");
        System.out.println("password2 = " + password3);

    }


    @And("Kullanici Date Of Birth alanina invalid bir dogum tarihi girer")
    public void kullaniciDateOfBirthAlaninaInvalidBirDogumTarihiGirer() {

        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.dateOfBirth.sendKeys("06-12-2025");
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("DateOfBirth must be pass date");


    }

    @Then("Kullanici {string} invalid uyari mesaji aldigini dogrular")
    public void kullaniciInvalidUyariMesajiAldiginiDogrular(String str) {
        teacherManagementPage= new TeacherManagementPage();
        Assert.assertTrue(teacherManagementPage.dateAlert.getText().contains(str));
        ReusableMethods.getScreenshot("DateOfBirth must be past date");
    }

    @And("KullaniciS Date Of Birth alanina invalid bir dogum tarihi girer")
    public void kullanicisDateOfBirthAlaninaInvalidBirDogumTarihiGirer() {
        viceDineManagementPage= new ViceDineManagementPage();
        viceDineManagementPage.dateOfBirth.sendKeys("01-01-1000");
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("Invalid BirthOfDate");
    }

    @And("LogoutS yapilir")
    public void logoutsYapilir() {
        ReusableMethods.waitFor(2);
        homePage=new HomePage();
        ReusableMethods.clickByJS(homePage.MenuButton);
        ReusableMethods.clickByJS(homePage.Logout);
        ReusableMethods.clickByJS(homePage.logoutConfirmation);
        Driver.closeDriver();
    }

    @Then("Kullanici invalid surname uyari mesaji aldigini dogrular")
    public void kullaniciInvalidSurnameUyariMesajiAldiginiDogrular() {
        teacherManagementPage= new TeacherManagementPage();
        Assert.assertTrue("Aslinda bu test kalmasi gerekirken gecti",teacherManagementPage.generalAlert.getText().contains("Surname"));
        ReusableMethods.waitFor(2);

    }

    @Then("Kullanici invalid birthplace uyari mesaji aldigini dogrular")
    public void kullaniciInvalidBirthplaceUyariMesajiAldiginiDogrular() {
        teacherManagementPage= new TeacherManagementPage();
        Assert.assertTrue(teacherManagementPage.birthPlaceWarningMessage.isDisplayed());
        ReusableMethods.waitFor(2);

    }

    @Then("Kullanici invalid gender uyari mesaji aldigini dogrular")
    public void kullaniciInvalidGenderUyariMesajiAldiginiDogrular() {
        teacherManagementPage= new TeacherManagementPage();
        Assert.assertTrue("Aslinda bu test kalmasi gerekirken gecti",teacherManagementPage.generalAlert.getText().contains("Please enter valid gender"));
    }

    @Then("Kullanici invalid username uyari mesaji aldigini dogrular")
    public void kullaniciInvalidUsernameUyariMesajiAldiginiDogrular() {
        teacherManagementPage= new TeacherManagementPage();
        Assert.assertTrue("BirthPlace Alert Message is displayed: ",teacherManagementPage.userNameAlertMessage.getText().contains("Your username should be at least 4 characters"));
    }

    @Then("Kullanici invalid password uyari mesaji aldigini dogrular")
    public void kullaniciInvalidPasswordUyariMesajiAldiginiDogrular() {
        teacherManagementPage= new TeacherManagementPage();
        Assert.assertTrue("Aslinda bu test kalmasi gerekirken gecti",teacherManagementPage.generalAlert.getText().contains("Please enter valid password"));
    }

    @And("Kullanici invalid birthdate uyari mesaji aldigini dogrular")
    public void kullaniciInvalidBirthdateUyariMesajiAldiginiDogrular() {
        teacherManagementPage= new TeacherManagementPage();
        Assert.assertTrue("Aslinda bu test kalmasi gerekirken gecti",teacherManagementPage.generalAlert.getText().contains("Please enter valid birthdate"));
    }



//    @Then("Kullanici {string} mesajini aldigini dogrular")
//    public void kullaniciMesajiniAldiginiDogrular(String str) {
//        teacherManagementPage= new TeacherManagementPage();
//        Assert.assertEquals(str,teacherManagementPage.successAlert.getText());
//    }
}



        
    

