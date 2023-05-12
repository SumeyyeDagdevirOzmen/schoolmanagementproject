package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.LoginPage;
import pages.StudentManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class AddStudent {

    HomePage homePage;
    LoginPage loginPage;
    StudentManagementPage studentManagementPage;
    @Given("Kullanici sayfaya gider ve ViceDean olarak login olur")
    public void kullanici_sayfaya_gider_ve_vice_dean_olarak_login_olur() {
        ReusableMethods.waitFor(1);
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.login(ConfigReader.getProperty("viceDeanusername"),ConfigReader.getProperty("viceDeansifre"));

    }

    @When("Name alanina valid bir Name girilir")
    public void name_alanina_valid_bir_name_girilir() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.name.sendKeys(Faker.instance().name().name());
    }
    @When("Surname alanina valid bir Surname girilir")
    public void surname_alanına_valid_bir_surname_girilir() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.surname.sendKeys(Faker.instance().name().lastName());
    }
    @When("Birthplace alanina valid bir Birthplace girilir")
    public void birthplace_alanına_valid_bir_birthplace_girilir() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.birthPlace.sendKeys(Faker.instance().country().capital());

    }
    @When("Email alanina valid bir Email girilir")
    public void email_alanına_valid_bir_email_girilir() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.email.sendKeys(Faker.instance().witcher().monster().replaceAll(" ","")+"@hotmail.com");
    }
    @When("Phone Number alanina valid bir Phone Number girilir")
    public void phone_number_alanına_valid_bir_phone_number_girilir() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.phoneNumber.sendKeys(Faker.instance().number().numberBetween(100,1000)+"-"+
                Faker.instance().number().numberBetween(100,1000)+"-"+
                Faker.instance().number().numberBetween(1000,10000));
    }


    @When("SSN alanina valid bir SSN numarasi girilir")
    public void ssn_alanına_valid_bir_ssn_numarası_girilir() {
        String SSN=194+"-"+
                Faker.instance().number().numberBetween(10,100)+"-"+
                Faker.instance().number().numberBetween(1000,10000);
        System.out.println(SSN);
        studentManagementPage.ssn.sendKeys(SSN);
    }
    @When("User Name alanina valid bir kullanici adi girilir")
    public void user_name_alanina_valid_bir_kullaniciı_adi_girilir() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.userName.sendKeys(Faker.instance().name().username());
    }
    @When("Father Name alanina valid bir Father Name girilir")
    public void father_name_alanina_valid_bir_father_name_girilir() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.fatherName.sendKeys(Faker.instance().name().firstName());
    }
    @When("Mother Name alanina valid bir Mother Name girilir")
    public void mother_name_alanina_valid_bir_mother_name_girilir() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.motherName.sendKeys(Faker.instance().name().firstName());
    }
    @When("Password alanina valid bir Password girilir")
    public void password_alanina_valid_bir_password_girilir() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.password.sendKeys("pass1234");
    }
    @When("Submit butonuna tiklanir")
    public void submit_butonuna_tiklanir(){
        studentManagementPage=new StudentManagementPage();
        ReusableMethods.clickByJS(studentManagementPage.submitButton);
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("Mesaj");



    }



    @And("Choose Teacher alani bos birakilir")
    public void chooseTeacherAlaniBosBirakilir() {

    }


    @Then("Choose Teacher alaninin bos birakilamayacagina dair uyari alindigi dogrulanir")
    public void chooseTeacherAlanininBosBirakilamayacaginaDairUyariAlindigiDogrulanir() {
     studentManagementPage=new StudentManagementPage();
     assertTrue(studentManagementPage.uyariMesaji.getText().contains("select advisor teacher"));
    }

    @When("Name alani bos birakilir")
    public void name_alani_bos_birakilir() {

    }

    @When("Surname alani bos birakilir")
    public void surname_alani_bos_birakilir() {

    }

    @When("Birthplace alani bos birakilir")
    public void birthplace_alani_bos_birakilir() {

    }

    @Then("Invalid Email girildigine dair {string} alindigi dogrulanir")
    public void invalid_email_girildigine_dair_alindigi_dogrulanir(String string) {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.invalidEmailAlert.isEnabled());
    }

    @Then("Logout yapilir")
    public void logout_yapilir() {
        ReusableMethods.waitFor(2);
        homePage=new HomePage();
        ReusableMethods.clickByJS(homePage.MenuButton);
        ReusableMethods.clickByJS(homePage.Logout);
        ReusableMethods.clickByJS(homePage.logoutConfirmation);

    }

    @When("Email alanina @ ve .com icermeyen bir email girilir")
    public void email_alanina_ve_com_icermeyen_bir_email_girilir() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.email.sendKeys(Faker.instance().howIMetYourMother().character());

    }
    @Then("Invalid Email girildigine dair mesaj alindigi dogrulanir")
    public void invalid_email_girildigine_dair_mesaj_alindigi_dogrulanir() {
        studentManagementPage=new StudentManagementPage();
        System.out.println(studentManagementPage.uyariMesaji.getText());
        assertTrue(studentManagementPage.uyariMesaji.getText().contains("Please enter valid email"));
    }

    @When("Phone Number alani bos birakilir")
    public void phone_number_alani_bos_birakilir() {

    }



    @And("Phone Number alanina invalid bir Phone Number girilir")
    public void phoneNumberAlaninaInvalidBirPhoneNumberGirilir() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.phoneNumber.sendKeys(Faker.instance().number().numberBetween(1000,100000)+""+
                Faker.instance().number().numberBetween(1000,10000)+""+
                Faker.instance().number().numberBetween(1000,10000));

    }


    @Then("Invalid Phone Number uyarisi alinmalidir")
    public void invalidPhoneNumberUyarisiAlinmalidir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.uyariMesaji.getText().contains("hone number"));
       //hone number dememin sebebi : iki farkli uyari tipi var ortak olan kisim bu bunu icerdigini verify etmek yeterli
    }

    @And("Date Of Birth alani bos birakilir")
    public void dateOfBirthAlaniBosBirakilir() {

    }

    @Then("Date Of Birth alaninin altinda required uyarisinin görüntülendigi dogrulanir")
    public void dateOfBirthAlanininAltindaRequiredUyarisininGörüntülendigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.birthDay.getAttribute("class").contains("invalid"));
    }



    @And("Choose Teacher dropdown'una tiklanir ve bir ogretmen secilir")
    public void chooseTeacherDropdownUnaTiklanirVeBirOgretmenSecilir() {
        int num=Faker.instance().number().numberBetween(1,15);
        studentManagementPage=new StudentManagementPage();
        ReusableMethods.waitFor(1);
        Select select=new Select(studentManagementPage.chooseTeacher);
        ReusableMethods.waitFor(2);
        select.selectByIndex(num);
    }

    @And("Gender seceneklerinden biri secilir")
    public void genderSeceneklerindenBiriSecilir() { studentManagementPage=new StudentManagementPage();
        int rasgele= Faker.instance().number().numberBetween(1,100);
        if (rasgele/2==0){
            ReusableMethods.clickByJS(studentManagementPage.maleButton);
        }
        else {
            ReusableMethods.clickByJS(studentManagementPage.femaleButton);}
    }

    @And("Date Of Birth alanina makul olmayan bir dogum tarihi girilir")
    public void dateOfBirthAlaninaMakulOlmayanBirDogumTarihiGirilir() {
        String bday=Faker.instance().number().numberBetween(0,13)+""+
                Faker.instance().number().numberBetween(0,30)+""+
                Faker.instance().number().numberBetween(0,100);
        studentManagementPage.birthDay.sendKeys(bday);
    }

    @Then("Invalid Date of Birth uyarisi goruntulenmelidir")
    public void invalidDateOfBirthUyarisiGoruntulenmelidir() {
        LocalDate date= LocalDate.now();
        ReusableMethods.getScreenshot("DateOfBirth_InvalidValue"+date+"SONUC");
        studentManagementPage=new StudentManagementPage();
        System.out.println(studentManagementPage.uyariMesaji.getText());
        assertTrue(studentManagementPage.uyariMesaji.getText().contains("Please enter valid date"));

    }

    @And("Date Of Birth alanina valid bir dogum tarihi girilir")
    public void dateOfBirthAlaninaValidBirDogumTarihiGirilir() {
        String bday=Faker.instance().number().numberBetween(0,13)+""+
                Faker.instance().number().numberBetween(0,30)+""+
                Faker.instance().number().numberBetween(1996,2023);
        System.out.println(bday);
        studentManagementPage.birthDay.sendKeys(bday);
    }

    @Then("Phone alaninin altinda required uyarisinin goruntulendigi dogrulanir")
    public void phoneAlanininAltindaRequiredUyarisininGoruntulendigiDogrulanir() {
                studentManagementPage=new StudentManagementPage();
                assertTrue(studentManagementPage.phoneNumber.getAttribute("class").contains("invalid"));

    }


    @And("Email alanina @ icermeyen bir email girilir")
    public void emailAlaninaIcermeyenBirEmailGirilir() {
    studentManagementPage=new StudentManagementPage();
    studentManagementPage.email.sendKeys(Faker.instance().hobbit().character()+ Faker.instance().number().numberBetween(12,1200)+"");
    }

    @Then("Birth Place alaninin altinda required uyarisinin goruntulendigi dogrulanir")
    public void birthPlaceAlanininAltindaRequiredUyarisininGoruntulendigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.birthPlace.getAttribute("class").contains("form-control is-invalid"));
    }

    @Then("SurName alaninin altinda required uyarisinin goruntulendigi dogrulanir")
    public void surnameAlanininAltindaRequiredUyarisininGoruntulendigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.surname.getAttribute("class").contains("form-control is-invalid"));
    }

    @Then("Name alaninin altinda required uyarisinin goruntulendigi dogrulanir")
    public void nameAlanininAltindaRequiredUyarisininGoruntulendigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.name.getAttribute("class").contains("form-control is-invalid"));

    }

    @And("Date Of Birth alanina valid bir doğum tarihi girilir")
    public void dateOfBirthAlaninaValidBirDoğumTarihiGirilir() {
        String bday=Faker.instance().number().numberBetween(0,13)+""+
                Faker.instance().number().numberBetween(0,30)+""+
                Faker.instance().number().numberBetween(1900,2023);
        studentManagementPage.birthDay.sendKeys(bday);
    }

    @Then("Ogrencinin eklendigi dogrulanir")
    public void ogrencininEklendigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.alertUyari.isEnabled());
    }

    @When("Menu butonuna tiklanir")
    public void menuButonunaTiklanir() {
        ReusableMethods.waitFor(3);
        homePage=new HomePage();
        ReusableMethods.clickByJS(homePage.MenuButton);

    }

    @And("Student Management secenegi secilir")
    public void studentManagementSecenegiSecilir() {
        homePage=new HomePage();
        ReusableMethods.clickByJS(homePage.StudentManagement);
    }

    @Then("Date Of Birth alaninin altinda required uyarisinin goruntulendigi dogrulanir")
    public void dateOfBirthAlanininAltindaRequiredUyarisininGoruntulendigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.birthDay.getAttribute("class").contains("form-control is-invalid"));
    }


    @And("Email alanina .com icermeyen bir email girilir")
    public void emailAlaninaComIcermeyenBirEmailGirilir() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.email.sendKeys(Faker.instance().hobbit().character()+""+ Faker.instance().number().numberBetween(12,1200)+"@"+Faker.instance().witcher().monster());
    }


    @And("Date Of Birth alanina makul olmayan gelecek yillardan bir dogum tarihi girilir")
    public void dateOfBirthAlaninaMakulOlmayanGelecekYillardanBirDogumTarihiGirilir() {
        String bday=Faker.instance().number().numberBetween(0,13)+""+
                Faker.instance().number().numberBetween(0,30)+""+
                Faker.instance().number().numberBetween(20230,30000);
        studentManagementPage.birthDay.sendKeys(bday);
        LocalDate date= LocalDate.now();
        ReusableMethods.getScreenshot("DateOfBirth_InvalidValue"+date);

    }

    @Then("SSN alaninin altinda required uyarisi alindigi dogrulanir")
    public void ssnAlanininAltindaRequiredUyarisiAlindigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.ssn.getAttribute("class").contains("invalid"));
    }

    @And("sevimSSN Alanina XX-XXX-XXXXX seklinde bir deger girilir1")
    public void sevimssnAlaninaXXXXXXXXXXSeklindeBirDegerGirilir1() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.ssn.sendKeys(Faker.instance().number().numberBetween(10, 100) + "-" + Faker.instance().number().numberBetween(100, 1000) + "-" + Faker.instance().number().numberBetween(10000, 100000));

    }


    @And("sevimSSN Alanina XXX-XX-XXXXX seklinde bir deger girilir2")
    public void sevimssnAlaninaXXXXXXXXXXSeklindeBirDegerGirilir2() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.ssn.sendKeys(Faker.instance().number().numberBetween(100, 1000) + "-" + Faker.instance().number().numberBetween(10, 100) + "-" + Faker.instance().number().numberBetween(10000, 100000));
    }

    @And("sevimSSN alani bos birakilir")
    public void sevimssnAlaniBosBirakilir() {
    }

    @Then("sevimSSN alanina invalid bir deger girildigine dair uyari alindigi dogrulanir")
    public void sevimssnAlaninaInvalidBirDegerGirildigineDairUyariAlindigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.uyariMesaji.getText().contains("Please enter valid SSN number"));
    }

    @And("User Name alanini bos birakilir")
    public void userNameAlaniniBosBirakilir() {

    }

    @Then("User Name alani altinda required uyarisinin goruntulendigi dogrulanir")
    public void userNameAlaniAltindaRequiredUyarisininGoruntulendigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.userName.getAttribute("class").contains("invalid"));
    }

    @And("Father Name alanibos birakilir")
    public void fatherNameAlanibosBirakilir() {

    }

    @Then("Father Name alani altinda required uyarisinin goruntulendigi dogrulanir")
    public void fatherNameAlaniAltindaRequiredUyarisininGoruntulendigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.fatherName.getAttribute("class").contains("invalid"));

    }

    @And("Mother Name alanibos birakilir")
    public void motherNameAlanibosBirakilir() {

    }

    @Then("Mother Name alani altinda required uyarisinin goruntulendigi dogrulanir")
    public void motherNameAlaniAltindaRequiredUyarisininGoruntulendigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.motherName.getAttribute("class").contains("invalid"));
    }

    @And("Password Alanini bos birakilir")
    public void passwordAlaniniBosBirakilir() {

    }

    @Then("Password alaninin altinda required uyarisi goruntulendigi dogrulanir")
    public void passwordAlanininAltindaRequiredUyarisiGoruntulendigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.password.getAttribute("class").contains("invalid"));
    }

    @And("Password alanina yedi karakterden olusan bir password girer")
    public void passwordAlaninaYediKarakterdenOlusanBirPasswordGirer() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.password.sendKeys("1234567");
    }

    @Then("Password alaninin altinda min sekiz karakter uyarisi goruntulendigi dogrulanir")
    public void passwordAlanininAltindaMinSekizKarakterUyarisiGoruntulendigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.password.getAttribute("class").contains("invalid"));
    }


    @And("Password alanina bosluk iceren bir Password girilir")
    public void passwordAlaninaBoslukIcerenBirPasswordGirilir() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.password.sendKeys("12 34567");

    }

    @Then("Invalid email uyarisi alindigi dogrulanir")
    public void invalidEmailUyarisiAlindigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.uyariMesaji.getText().contains("nvalid email"));
    }

    @And("Name alanina sadece spacelerden olusan bir Name girilir")
    public void nameAlaninaSadeceSpacelerdenOlusanBirNameGirilir() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.name.sendKeys("       ");

    }

    @Then("Invalid Name girildigine dair uyari mesaji alindigi dogrulanir")
    public void invalidNameGirildigineDairUyariMesajiAlindigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.uyariMesaji.getText().contains("Please enter valid name"));
    }

    @And("Surname alanina sadece spacelerden olusan bir SurName girilir")
    public void surnameAlaninaSadeceSpacelerdenOlusanBirSurNameGirilir() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.surname.sendKeys("          ");
    }

    @Then("Invalid SurName girildigine dair uyari mesaji alindigi dogrulanir")
    public void invalidSurNameGirildigineDairUyariMesajiAlindigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.uyariMesaji.getText().contains("Please enter valid surname"));
    }

    @And("Father Name alanina sadece spacelerden olusan bir Father Name girilir")
    public void fatherNameAlaninaSadeceSpacelerdenOlusanBirFatherNameGirilir() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.fatherName.sendKeys("          ");
    }

    @Then("Invalid FatherName girildigine dair uyari mesaji alindigi dogrulanir")
    public void invalidFatherNameGirildigineDairUyariMesajiAlindigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.uyariMesaji.getText().contains("Please enter valid father name"));
    }

    @And("Mother Name alanina sadece spacelerden olusan bir Mother Name girilir")
    public void motherNameAlaninaSadeceSpacelerdenOlusanBirMotherNameGirilir() {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.motherName.sendKeys("          ");
    }

    @Then("Invalid MotherName girildigine dair uyari mesaji alindigi dogrulanir")
    public void invalidMotherNameGirildigineDairUyariMesajiAlindigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.uyariMesaji.getText().contains("Please enter valid mother name"));
    }

    @And("Gender secenekleri bos birakilir")
    public void genderSecenekleriBosBirakilir() {
        
    }

    @Then("Sevim-Gender alaninin bos birakilamayacagina dair uyari alindigi dogrulanir")
    public void sevimGenderAlanininBosBirakilamayacaginaDairUyariAlindigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.uyariMesaji.getText().contains("Please select a gender"));
    }

    @Then("Invalid password uyarisi alindigi dogrulanir")
    public void invalidPasswordUyarisiAlindigiDogrulanir() {
        studentManagementPage=new StudentManagementPage();
        assertTrue(studentManagementPage.uyariMesaji.getText().contains("Please enter valid email"));
    }


}





