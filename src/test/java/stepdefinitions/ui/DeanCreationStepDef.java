package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AdminManagementPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.login;

public class DeanCreationStepDef {
    HomePage homePage = new HomePage();
    AdminManagementPage adminManagementPage = new AdminManagementPage();

    static Faker faker = new Faker();
    static int num4 = faker.number().numberBetween(1000, 9999);
   static  int num3 = faker.number().numberBetween(100, 999);
    static int num2 = faker.number().numberBetween(10, 99);
   public static String ssnguldean=num3 + "-" + num2 + "-" + num4;

    @When("Kullanicigul Admin olarak login olur")
    public void kullanicigul_admin_olarak_login_olur() {

        login(ConfigReader.getProperty("adminUsername"), ConfigReader.getProperty("adminsifre"));

    }

    @When("Kullanicigul Dean Management a tiklar")
    public void kullanicigul_dean_management_a_tiklar() {
       ReusableMethods.waitFor(1);
        homePage.DeanManagement.click();


    }

    @When("s1.Kullanicigul name textbox, ini bos birakir")
    public void s1_kullanicigul_name_textbox_ini_bos_birakir() {
        //adminManagementPage.name.click();
        adminManagementPage.name.sendKeys("");

    }

    @Then("s1.Kullanicigul {string}  uyari sini gorebilmelidir")
    public void s1_kullanicigul_uyari_sini_gorebilmelidir(String required) {
        ReusableMethods.waitFor(1);
        assert adminManagementPage.nameRequired.isDisplayed();


    }

    @Then("s1.Kullanicigul name textbox, ina space  girer")
    public void s1_kullanicigul_name_textbox_ina_space_girer() {
        adminManagementPage.name.sendKeys("    ");

    }

    @Then("kullanicigul onaylanmis mavi renkli textbox gormemelidir")
    public void s1_kullanicigul_onaylanmis_mavi_renkli_textbox_gormemelidir() {
        ReusableMethods.waitFor(1);
        Assert.assertFalse(adminManagementPage.validbox.isDisplayed());

    }
    @Then("kullanicigul logaut yapar")
    public void kullanicigul_logaut_yapar() {
        ReusableMethods.clickByJS(homePage.MenuButton);
        ReusableMethods.waitFor(1);
        homePage.Logout.click();
    }
    @Then("Kullanicigul sayfayi kapatir")
    public void kullanici_gul_sayfayi_kapatir() {
        Driver.closeDriver();
    }

    @Then("s2.Kullanici surname textbox, ini bos birakir")
    public void s2_kullanici_surname_textbox_ini_bos_birakir() {
        adminManagementPage.surname.sendKeys("");

    }

    @Then("s2.Kullanicigul {string}  uyari sini gorebilmelidir")
    public void s2_kullanicigul_uyari_sini_gorebilmelidir(String required2) {
        ReusableMethods.waitFor(2);
        assert adminManagementPage.surnameRequired.isDisplayed();


    }

    @Then("s2.Kullanici surname textbox, ina space  girer")
    public void s2_kullanici_surname_textbox_ina_space_girer() {
        adminManagementPage.surname.sendKeys("   ");
    }

    @Then("s3.Kullanici Birth place textbox, ini bos birakir")
    public void s3_kullanici_birth_place_textbox_ini_bos_birakir() {
        adminManagementPage.birthPlace.sendKeys("");

    }

    @Then("s3.Kullanici {string}  uyari sini gorebilmelidir")
    public void s3_kullanici_uyari_sini_gorebilmelidir(String required3) {
        ReusableMethods.waitFor(1);
        assert adminManagementPage.birthplaceRequired.isDisplayed();

    }

    @Then("s3.Kullanici Birth place textbox, ina space  girer")
    public void s3_kullanici_birth_place_textbox_ina_space_girer() {
        adminManagementPage.birthPlace.sendKeys("   ");

    }

    @Then("s4.kullanicigul gender alanini bos birakarak diger alanlari valid sekilde doldurur")
    public void s4_kullanicigul_gender_alanini_bos_birakarak_diger_alnlari_valid_sekilde_doldurur() {
        int num4 = faker.number().numberBetween(1000, 9999);
        int num3 = faker.number().numberBetween(100, 999);
        int num2 = faker.number().numberBetween(10, 99);


        adminManagementPage.name.sendKeys(faker.name().firstName(), Keys.TAB, faker.name().lastName(),
                Keys.TAB, faker.address().cityName(), Keys.TAB, Keys.TAB, "12122000", Keys.TAB, Keys.TAB,
                "066-789-" + num4, Keys.TAB, num3 + "-" + num2 + "-" + num4, Keys.TAB, faker.name().firstName(), Keys.TAB, "12345678");

    }

    @Then("Kullanicigul submit butonuna tiklar")
    public void kullanicigul_submit_butonuna_tiklar() {
        ReusableMethods.waitFor(1);
        ReusableMethods.clickByJS(adminManagementPage.submit);
    }

    @Then("Kullanicigul hata mesaji almali")
    public void kullanicigul_hata_mesaji_almali() {
    ReusableMethods.waitFor(1);
        assert adminManagementPage.hatamesaji.isDisplayed();


    }

    @Then("s5.Kullanicigul Date of birth textbox, ini bos birakir")
    public void s5_kullanicigul_date_of_birth_textbox_ini_bos_birakir() {
        adminManagementPage.birthDay.sendKeys("");
    }

    @Then("s5.Kullanicigul {string}  uyari sini gorebilmelidir")
    public void s5_kullanicigul_uyari_sini_gorebilmelidir(String required5) {
        ReusableMethods.waitFor(1);
        assert adminManagementPage.birtdateRequired.isDisplayed();

    }

    @Then("s5.Kullanicigul Date of birth alanina invalid yil girer")
    public void s5_kullanicigul_date_of_birth_alanina_invalid_yil_girer() {
        adminManagementPage.birthDay.sendKeys("12123000");
    }

    @Then("s6.Kullanicigu phone textbox, ini bos birakir")
    public void s6_kullanicigul_phone_textbox_ini_bos_birakir() {
        adminManagementPage.phoneNumber.sendKeys("");

    }

    @Then("s6.Kullanicigul {string}  uyari sini gorebilmelidir")
    public void s6_kullanicigul_uyari_sini_gorebilmelidir(String required6) {
        ReusableMethods.waitFor(1);
        assert adminManagementPage.phonerequired.isDisplayed();

    }


    @Then("s6.Kullanicigul phone textbox, in'a {string} karakter girer")
    public void s6_kullanicigul_phone_textbox_in_a_karakter_girer(String no) {
        adminManagementPage.phoneNumber.sendKeys(no);
    }

    @Then("s6. Kullanicigul {string} mesji almalidir")
    public void s6_kullanicigul_mesji_almalidir(String min12) {
        ReusableMethods.waitFor(1);
        Assert.assertEquals(min12, adminManagementPage.min12HataMesaji.getText());

    }

    @Then("s7.Kullanicigul Ssn textbox, ini bos birakir")
    public void s7_kullanicigul_ssn_textbox_ini_bos_birakir() {
        adminManagementPage.ssnNumber.sendKeys("");
    }

    @Then("s7.Kullanicigul {string}  uyari sini gorebilmelidir")
    public void s7_kullanicigul_uyari_sini_gorebilmelidir(String required7) {
        ReusableMethods.waitFor(1);
        adminManagementPage.Ssnrequired.isDisplayed();

    }

    @Then("s7.Kullanicigul Ssn textbox, ina tiresiz invalid deger girer")
    public void s7_kullanicigul_ssn_textbox_ina_tiresiz_invalid_deger_girer() {
        adminManagementPage.ssnNumber.sendKeys(ConfigReader.getProperty("ssnfalse"));


    }

    @Then("s.7Kullanicigul {string} uyari sini gorebilmelidir")
    public void s_7kullanicigul_uyari_sini_gorebilmelidir(String min11) {
        ReusableMethods.waitFor(1);
        Assert.assertEquals(min11, adminManagementPage.min11HataMesaji.getText());

    }

    @Then("s8.kullanicigul ssn alanina {string} onbir rakam girerek diger alanlari doldurur")
    public void s8_kullanicigul_ssn_alanina_onbir_rakam_girerek_diger_alanlari_doldurur(String onbirrakam) {

        int num4 = faker.number().numberBetween(1000, 9999);

        adminManagementPage.name.sendKeys(faker.name().firstName(), Keys.TAB, faker.name().lastName(),
                Keys.TAB, faker.address().cityName(), Keys.TAB, Keys.SPACE, Keys.TAB, "12122000", Keys.TAB, Keys.TAB,
                "066-789-" + num4, Keys.TAB, onbirrakam, Keys.TAB, faker.name().firstName(), Keys.TAB, "12345678");

    }

    @Then("s.8Kullanicigul {string} mesaji alir")
    public void s_8kullanicigul_mesaji_alir(String ssnInvalidmesaji) {

       ReusableMethods.waitFor(1);
        assert adminManagementPage.hatamesaji.isDisplayed();
    }

    @Then("s.9Kullanicigul username, alanini bos birakir")
    public void s_9kullanicigul_username_alanini_bos_birakir() {
        adminManagementPage.userName.sendKeys("");
    }

    @Then("s.9Kullanicigul {string}  uyari sini gorebilmelidir")
    public void s_9kullanicigul_uyari_sini_gorebilmelidir(String required9) {
        ReusableMethods.waitFor(1);
        assert adminManagementPage.usernamerequired.isDisplayed();


    }

    @Then("s10.Kullanicigul pasword, ini bos birakir")
    public void s10_kullanici_pasword_ini_bos_birakir() {
        adminManagementPage.password.sendKeys("");

    }


    @Then("s10.Kullanicigul {string}  uyarisini gorebilmelidir")
    public void s10_kullanici_uyarisini_gorebilmelidir(String required10) {
        ReusableMethods.waitFor(1);
        assert adminManagementPage.paswordrequired.isDisplayed();
    }

    @Then("s10.Kullanicigul password alanina {int} karakter girer")
    public void s10_kullanici_password_alanina_karakter_girer(Integer int1) {
        adminManagementPage.password.sendKeys(int1 + "");


    }

    @Then("s10.Kullanicigul {string} uyari sini gorebilmelidir")
    public void s10_kullanici_uyari_sini_gorebilmelidir(String min8) {
        ReusableMethods.waitFor(1);
        Assert.assertEquals(min8, adminManagementPage.min8HataMesaji.getText());

    }
    @Then("Kullanicigul {int} saniye bekler")
    public void kullanicigul_saniye_bekler(Integer int1) {
       ReusableMethods.waitFor(int1);
    }


    @Then("s.11Kullanicigul tum textboxlara valid degerler girerek doldurur")
    public void s_11kullanicigul_tum_textboxlara_valid_degerler_girerek_doldurur() {
         num4 = faker.number().numberBetween(1000, 9999);
         num3 = faker.number().numberBetween(100, 999);
         num2 = faker.number().numberBetween(10, 99);
        int gun = faker.number().numberBetween(10, 30);
        int sifre =faker.number().numberBetween(100000000,923456780);
        ReusableMethods.waitFor(1);

        adminManagementPage.name.sendKeys(faker.name().firstName(), Keys.TAB, faker.name().lastName(),
                Keys.TAB, "Perpignan", Keys.TAB, Keys.SPACE, Keys.TAB, "12" + gun + "2000", Keys.TAB, Keys.TAB,
                "066-789-" + num4, Keys.TAB, ssnguldean, Keys.TAB,

                faker.name().firstName()+num4);
        ReusableMethods.waitFor(1);
adminManagementPage.password.sendKeys(sifre+"");




}

    @Then("s11Kullanicigul {string} mesaji gormelidir")
    public void s11kullanicigul_msaji_gormelidir(String deansavedmesaji) {
       ReusableMethods.waitFor(2);
        assert adminManagementPage.hatamesaji.isDisplayed();


    }


}
