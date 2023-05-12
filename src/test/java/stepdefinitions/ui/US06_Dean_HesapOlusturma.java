package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.DeanManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.util.Date;

public class US06_Dean_HesapOlusturma {

    DeanManagementPage deanManagementPage = new DeanManagementPage();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();
    Date date = faker.date().birthday();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String formattedDate = dateFormat.format(date);


    @Given("Dean ysf Anasayfaya gider")
    public void deanYsfAnasayfayaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("Dean ysf Login olur")
    public void deanYsfLoginOlur() {
     ReusableMethods.login(ConfigReader.getProperty("deanYusufName"),ConfigReader.getProperty("deanYusufPassword"));
    }

    @And("Dean ysf Add Vice Dean List'deki tum bilgileri doldurur")
    public void deanYsfAddViceDeanListDekiTumBilgileriDoldurur() {
     actions.moveToElement(deanManagementPage.nameButton).click().sendKeys(faker.name().firstName(), Keys.TAB).
             sendKeys(faker.name().lastName(), Keys.TAB).
             sendKeys(faker.country().name(), Keys.TAB).
             sendKeys(Keys.SPACE, Keys.TAB).
             sendKeys(formattedDate, Keys.TAB).
             sendKeys(faker.numerify("###-###-####"), Keys.TAB)
             .sendKeys(faker.numerify("###-##-####"), Keys.TAB).
             sendKeys(faker.name().username(), Keys.TAB).
             sendKeys(faker.internet().password()).perform();
    }

    @And("Dean ysf Vice Dean hesabinin olusturuldugunu dogrular")
    public void deanYsfViceDeanHesabininOlusturuldugunuDogrular() {
        ReusableMethods.waitForVisibility(deanManagementPage.dogrulamaPozitif,5);
        Assert.assertTrue(deanManagementPage.dogrulamaPozitif.isDisplayed());
    }

    @And("Dean ysf Vice Dean bolumunde Name kismini bos birakir sonraki tum bilgileri doldurur")
    public void deanYsfViceDeanBolumundeNameKisminiBosBirakirSonrakiTumBilgileriDoldurur() {
        actions.moveToElement(deanManagementPage.nameButton).click().sendKeys( Keys.TAB).
                sendKeys(faker.name().lastName(), Keys.TAB).
                sendKeys(faker.country().name(), Keys.TAB).
                sendKeys(Keys.SPACE, Keys.TAB).
                sendKeys(formattedDate, Keys.TAB).
                sendKeys(faker.numerify("###-###-####"), Keys.TAB).
                sendKeys(faker.numerify("###-##-####"), Keys.TAB).
                sendKeys(faker.name().username(), Keys.TAB).
                sendKeys(faker.internet().password()).perform();
    }

    @And("Dean ysf Submit butonuna tiklar")
    public void deanYsfSubmitButonunaTiklar() {
        deanManagementPage.submitButton.click();
    }

    @And("Dean ysf Vice Dean bolumunde Surname kismini bos birakir sonraki tum bilgileri doldurur")
    public void deanYsfViceDeanBolumundeSurnameKisminiBosBirakirSonrakiTumBilgileriDoldurur() {
        actions.moveToElement(deanManagementPage.nameButton).click().sendKeys(faker.name().firstName(), Keys.TAB).
                sendKeys( Keys.TAB).
                sendKeys(faker.country().name(), Keys.TAB).
                sendKeys(Keys.SPACE, Keys.TAB).
                sendKeys(formattedDate, Keys.TAB).
                sendKeys(faker.numerify("###-###-####"), Keys.TAB).
                sendKeys(faker.numerify("###-##-####"), Keys.TAB).
                sendKeys(faker.name().username(), Keys.TAB).
                sendKeys(faker.internet().password()).perform();

    }

    @And("Dean ysf Vice Dean bolumunde Birth Place kismini bos birakir sonraki tum bilgileri doldurur")
    public void deanYsfViceDeanBolumundeBirthPlaceKisminiBosBirakirSonrakiTumBilgileriDoldurur() {
        actions.moveToElement(deanManagementPage.nameButton).click().sendKeys(faker.name().firstName(), Keys.TAB).
                sendKeys(faker.name().lastName(), Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.SPACE, Keys.TAB).
                sendKeys(formattedDate, Keys.TAB).
                sendKeys(faker.numerify("###-###-####"), Keys.TAB).
                sendKeys(faker.numerify("###-##-####"), Keys.TAB).
                sendKeys(faker.name().username(), Keys.TAB).
                sendKeys(faker.internet().password()).perform();

    }

    @And("Dean ysf Vice Dean bolumunde Gender kismini bos birakir sonraki tum bilgileri doldurur")
    public void deanYsfViceDeanBolumundeGenderKisminiBosBirakirSonrakiTumBilgileriDoldurur() {
        actions.moveToElement(deanManagementPage.nameButton).click().sendKeys(faker.name().firstName(), Keys.TAB).
                sendKeys(faker.name().lastName(), Keys.TAB).
                sendKeys(faker.country().name(), Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(formattedDate, Keys.TAB).
                sendKeys(faker.numerify("###-###-####"), Keys.TAB).
                sendKeys(faker.numerify("###-##-####"), Keys.TAB).
                sendKeys(faker.name().username(), Keys.TAB).
                sendKeys(faker.internet().password()).perform();
    }

    @And("Dean ysf Vice Dean hesabinin olusturulmadigini dogrular")
    public void deanYsfViceDeanHesabininOlusturulmadiginiDogrular() {
      Assert.assertTrue(deanManagementPage.submitButton.isEnabled());


    }

    @And("Dean ysf Vice Dean bolumunde Date Of Birth  kismini bos birakir sonraki tum bilgileri doldurur")
    public void deanYsfViceDeanBolumundeDateOfBirthKisminiBosBirakirSonrakiTumBilgileriDoldurur() {
        actions.moveToElement(deanManagementPage.nameButton).click().sendKeys(faker.name().firstName(), Keys.TAB).
                sendKeys(faker.name().lastName(), Keys.TAB).
                sendKeys(faker.country().name(), Keys.TAB).
                sendKeys(Keys.SPACE, Keys.TAB).
                sendKeys(Keys.TAB, Keys.TAB, Keys.TAB).
                sendKeys(faker.numerify("###-###-####"), Keys.TAB).
                sendKeys(faker.numerify("###-##-####"), Keys.TAB).
                sendKeys(faker.name().username(), Keys.TAB).
                sendKeys(faker.internet().password()).perform();
    }

    @And("Dean ysf Vice Dean bolumunde Phone   kismini bos birakir sonraki tum bilgileri doldurur")
    public void deanYsfViceDeanBolumundePhoneKisminiBosBirakirSonrakiTumBilgileriDoldurur() {
        actions.moveToElement(deanManagementPage.nameButton).click().sendKeys(faker.name().firstName(), Keys.TAB).
                sendKeys(faker.name().lastName(), Keys.TAB).
                sendKeys(faker.country().name(), Keys.TAB).
                sendKeys(Keys.SPACE, Keys.TAB).
                sendKeys(formattedDate, Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(faker.numerify("###-##-####"), Keys.TAB).
                sendKeys(faker.name().username(), Keys.TAB).
                sendKeys(faker.internet().password()).perform();
    }

    @And("Dean ysf Vice Dean bolumunde Ssn kismini bos birakir sonraki tum bilgileri doldurur")
    public void deanYsfViceDeanBolumundeSsnKisminiBosBirakirSonrakiTumBilgileriDoldurur() {
        actions.moveToElement(deanManagementPage.nameButton).click().sendKeys(faker.name().firstName(), Keys.TAB).
                sendKeys(faker.name().lastName(), Keys.TAB).
                sendKeys(faker.country().name(), Keys.TAB).
                sendKeys(Keys.SPACE, Keys.TAB).
                sendKeys(formattedDate, Keys.TAB).
                sendKeys(faker.numerify("###-###-####"), Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().username(), Keys.TAB).
                sendKeys(faker.internet().password()).perform();
    }

    @And("Dean ysf Vice Dean bolumunde Username kismini bos birakir sonraki tum bilgileri doldurur")
    public void deanYsfViceDeanBolumundeUsernameKisminiBosBirakirSonrakiTumBilgileriDoldurur() {
        actions.moveToElement(deanManagementPage.nameButton).click().sendKeys(faker.name().firstName(), Keys.TAB).
                sendKeys(faker.name().lastName(), Keys.TAB).
                sendKeys(faker.country().name(), Keys.TAB).
                sendKeys(Keys.SPACE, Keys.TAB).
                sendKeys(formattedDate, Keys.TAB).
                sendKeys(faker.numerify("###-###-####"), Keys.TAB).
                sendKeys(faker.numerify("###-##-####"), Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).perform();
    }

    @And("Dean ysf Vice Dean bolumunde Password kismini bos birakir sonraki tum bilgileri doldurur")
    public void deanYsfViceDeanBolumundePasswordKisminiBosBirakirSonrakiTumBilgileriDoldurur() {
        actions.moveToElement(deanManagementPage.nameButton).click().sendKeys(faker.name().firstName(), Keys.TAB).
                sendKeys(faker.name().lastName(), Keys.TAB).
                sendKeys(faker.country().name(), Keys.TAB).
                sendKeys(Keys.SPACE, Keys.TAB).
                sendKeys(formattedDate, Keys.TAB).
                sendKeys(faker.numerify("###-###-####"), Keys.TAB).
                sendKeys(faker.numerify("###-##-####"), Keys.TAB).
                sendKeys(faker.name().username(), Keys.TAB).
                sendKeys(Keys.TAB).perform();
    }

    @And("Dean ysf Vice Dean bolumunde Name kismina space karekter girilir ve sonraki tum bilgileri doldurur")
    public void deanYsfViceDeanBolumundeNameKisminaSpaceKarekterGirilirVeSonrakiTumBilgileriDoldurur() {
        actions.moveToElement(deanManagementPage.nameButton).click().sendKeys(Keys.SPACE, Keys.TAB).
                sendKeys(faker.name().lastName(), Keys.TAB).
                sendKeys(faker.country().name(), Keys.TAB).
                sendKeys(Keys.SPACE, Keys.TAB).
                sendKeys(formattedDate, Keys.TAB).
                sendKeys(faker.numerify("###-###-####"), Keys.TAB).
                sendKeys(faker.numerify("###-##-####"), Keys.TAB).
                sendKeys(faker.name().username(), Keys.TAB).
                sendKeys(faker.internet().password()).perform();
    }

    @And("Dean ysf Vice Dean bolumunde Surname kismina space karekter girilir ve sonraki tum bilgileri doldurur")
    public void deanYsfViceDeanBolumundeSurnameKisminaSpaceKarekterGirilirVeSonrakiTumBilgileriDoldurur() {
        actions.moveToElement(deanManagementPage.nameButton).click().sendKeys(faker.name().firstName(), Keys.TAB).
                sendKeys(Keys.SPACE, Keys.TAB).
                sendKeys(faker.country().name(), Keys.TAB).
                sendKeys(Keys.SPACE, Keys.TAB).
                sendKeys(formattedDate, Keys.TAB).
                sendKeys(faker.numerify("###-###-####"), Keys.TAB).
                sendKeys(faker.numerify("###-##-####"), Keys.TAB).
                sendKeys(faker.name().username(), Keys.TAB).
                sendKeys(faker.internet().password()).perform();
    }

    @And("Dean Vice Dean bolumunde Birth Place kismina space karekter girilir ve sonraki tum bilgileri doldurur")
    public void deanViceDeanBolumundeBirthPlaceKisminaSpaceKarekterGirilirVeSonrakiTumBilgileriDoldurur() {
        actions.moveToElement(deanManagementPage.nameButton).click().sendKeys(faker.name().firstName(), Keys.TAB).
                sendKeys(faker.name().lastName(), Keys.TAB).
                sendKeys(Keys.SPACE, Keys.TAB).
                sendKeys(Keys.SPACE, Keys.TAB).
                sendKeys(formattedDate, Keys.TAB).
                sendKeys(faker.numerify("###-###-####"), Keys.TAB).
                sendKeys(faker.numerify("###-##-####"), Keys.TAB).
                sendKeys(faker.name().username(), Keys.TAB).
                sendKeys(faker.internet().password()).perform();
    }
}
