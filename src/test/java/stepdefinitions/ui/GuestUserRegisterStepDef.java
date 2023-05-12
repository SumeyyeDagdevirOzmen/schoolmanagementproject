package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.StudentManagementPage;
import pages.ViceDineManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class GuestUserRegisterStepDef {



    ViceDineManagementPage viceDineManagementPage;
    StudentManagementPage studentManagementPage;




    @Given("Kullanici ana sayfaya gider")
    public void kullanici_ana_sayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }



    @When("Kullanici Register butonuna tiklar")
     public void kullanici_register01_butonuna_tiklar() throws InterruptedException {

        studentManagementPage = new StudentManagementPage();
        studentManagementPage.registerButton.click();
        Thread.sleep(2000);
    }


    @And("kullaniciF name alanina valid bir isim girer")
    public void kullanici_name_alanina_valid_bir_isim_girer() throws InterruptedException {
        studentManagementPage=new StudentManagementPage();
        studentManagementPage.name.sendKeys(Faker.instance().name().name());
        Thread.sleep(2000);
    }

    @And ("kullaniciF surname alanina valid bir soyisim girer")
    public void kullanici_surname_alanina_valid_bir_soyisim_girer() throws InterruptedException {

        studentManagementPage=new StudentManagementPage();
        studentManagementPage.surname.sendKeys(Faker.instance().name().lastName());
        Thread.sleep(2000);

    }
    @And ("kullaniciF birthplace alanina valid bir dogum yeri girer")
    public void kullanici_birthplace_alanina_valid_bir_dogum_yeri_girer() throws InterruptedException {

        studentManagementPage=new StudentManagementPage();
        studentManagementPage.birthPlace.sendKeys(Faker.instance().country().capital());
        Thread.sleep(2000);


    }
    @And ("kullaniciF phone  alanina valid bir telefon numarasi girer")
    public void kullanici_phone_alanina_valid_bir_telefon_numarasi_girer() throws InterruptedException {

        studentManagementPage=new StudentManagementPage();
        studentManagementPage.phoneNumber.sendKeys(Faker.instance().number().numberBetween(100,1000)+"-"+
                Faker.instance().number().numberBetween(100,1000)+"-"+
                Faker.instance().number().numberBetween(1000,10000));
        Thread.sleep(2000);


    }
    @And ("kullaniciF gender kutularindan birini secer")
    public void kullanici_gender_seceneginden_birini_secer()  {


        viceDineManagementPage=new ViceDineManagementPage();
        ReusableMethods.gender();


    }

    @And ("kullaniciF Date Of Birth alanina valid bir dogum tarihi girer")
    public void kullanici_Date_of_birth_alanina_valid_bir_dogum_tarihi_girer() throws InterruptedException {

        String birthday=Faker.instance().number().numberBetween(0,13)+""+
                Faker.instance().number().numberBetween(0,30)+""+
                Faker.instance().number().numberBetween(1996,2023);
        System.out.println(birthday);
        studentManagementPage.birthDay.sendKeys(birthday);
        Thread.sleep(2000);




    }
    @And ("kullaniciF SSN alanina valid bir SSN numarasi girer")
    public void kullanici_SSN_alanina_valid_bir_SSN_numarasi_girer() throws InterruptedException {

        String SSN=188+"-"+
                Faker.instance().number().numberBetween(10,100)+"-"+
                Faker.instance().number().numberBetween(1000,10000);
        System.out.println(SSN);
        studentManagementPage.ssn.sendKeys(SSN);
        Thread.sleep(2000);



    }
    @And("kullaniciF User Name alanina valid bir kullanici adi girer")
    public void kullanici_user_name_alanina_valid_bir_kullanici_adi_girer() throws InterruptedException {

        studentManagementPage=new StudentManagementPage();
        studentManagementPage.userName.sendKeys(Faker.instance().name().username());
        Thread.sleep(2000);


    }
   @And("kullaniciF Password alanina valid bir sifre girer")
    public void kullanici_password_alanina_valid_bir_sifre_girer() throws InterruptedException {

       studentManagementPage=new StudentManagementPage();
       studentManagementPage.password.sendKeys("ps234567");
       Thread.sleep(2000);


   }
    @And ("kullaniciF Register1 butonuna tiklar")
    public void kullanici_register_butonuna_tiklar() throws InterruptedException {

        studentManagementPage=new StudentManagementPage();
        ReusableMethods.clickByJS(studentManagementPage.register1Button);
        Thread.sleep(2000);

    }

    @Then("kullaniciF Guest user registered yazisini gorur")
    public void kullanici_Guest_user_registered_yazisini_gorur() throws InterruptedException {

        studentManagementPage=new StudentManagementPage();
        Assert.assertTrue(studentManagementPage.GuestUserRegistered.isDisplayed());
        Thread.sleep(2000);



    }

        @And ("kullaniciF name  alanini bos birakir")
    public void kullanici_name_alanini_bos_birakir(){

            ReusableMethods.waitFor(2);
            studentManagementPage =new StudentManagementPage();
            studentManagementPage.name.sendKeys("");



    }

    @And ("kullaniciF surname alanini bos birakir")
    public void kullanici_surname_alanini_bos_birakir()  {
        ReusableMethods.waitFor(2);
        studentManagementPage =new StudentManagementPage();
        studentManagementPage.surname.sendKeys("");




    }

    @And ("kullaniciF birthplace alani bos birakir")
    public void kullanici_birthplace_alanini_bos_birakir()  {

        ReusableMethods.waitFor(2);
        studentManagementPage =new StudentManagementPage();
        studentManagementPage.birthPlace.sendKeys("");


    }

    @And ("kullaniciF phone  alanini bos birakir")
    public void kullanici_phone_alanini_bos_birakir()  {
        ReusableMethods.waitFor(2);
        studentManagementPage =new StudentManagementPage();
        studentManagementPage.phone.sendKeys("");



    }

    @And ("kullaniciF Date Of Birth alanini bos birakir")
    public void kullanici_date_of_birth_alanini_bos_birakir()  {
        ReusableMethods.waitFor(2);
        studentManagementPage =new StudentManagementPage();
        studentManagementPage.dateOfBirth.sendKeys("");




    }

    @And ("kullaniciF SSN alanini alanini bos birakir")
    public void kullanici_SSN_alanini_bos_birakir()  {
        ReusableMethods.waitFor(2);
        studentManagementPage =new StudentManagementPage();
        studentManagementPage.ssn.sendKeys("");



    }

    @And ("kullaniciF User Name alanini bos birakir")
    public void kullanici_user_name_alanini_bos_birakir()  {
        ReusableMethods.waitFor(2);
        studentManagementPage =new StudentManagementPage();
        studentManagementPage.userName.sendKeys("");




    }

    @And ("kullaniciF Password alanini bos birakir")
    public void kullanici_password_alanini_bos_birakir()  {

        ReusableMethods.waitFor(2);
        studentManagementPage =new StudentManagementPage();
        studentManagementPage.password.sendKeys("");




    }

    @And ("kullaniciF Required uyari yazisini gorur")
    public void kullanici_required_uyari_yazisini_gorur()  {
        ReusableMethods.waitFor(2);
        viceDineManagementPage =new ViceDineManagementPage();
        Assert.assertTrue(viceDineManagementPage.Required.isDisplayed());



    }


    @Then ("KullaniciF uygulamayi kapatir")
    public void kullanici_uygulamayi_kapatir(){

        ReusableMethods.waitFor(2);
        Driver.closeDriver();



    }











}
