package stepdefinitions.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.ViceDineManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
public class ViceDeanLessonProgramSeeStepDef {
    ViceDineManagementPage vicedean;

    @Given("kullanici anasayfaya gider")
    public void kullaniciAnasayfayaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("kullanici uygulamaya vicedean hesabiyla login olur")
    public void kullaniciUygulamayaVicedeanHesabiylaLoginOlur() {
        ReusableMethods.loginViceDean();
    }

    @And("kullanici Lesson program basligina tiklar")
    public void kullaniciLessonProgramBasliginaTiklar() {
        vicedean = new ViceDineManagementPage();
        ReusableMethods.clickByJS(vicedean.LessonProgram);
    }

    @Then("kullanici {string} basligi altinda olusturulan dersi gordugunu dogrular")
    public void kullaniciBasligiAltindaOlusturulanDersiGordugunuDogrular(String arg0) {
        vicedean = new ViceDineManagementPage();
        String ders = "CYPRESS SUNDAY 12:01:00 13:01:00";
        boolean iceriyor = false;

        ReusableMethods.scrollDownActions();

        while (!iceriyor) {
            for (WebElement w : vicedean.lessonProgramList) {
                System.out.println(w.getText());
                if (w.getText().contains(ders)) {
                    iceriyor = true;
                    ReusableMethods.getScreenshot("olusturulan ders");
                    break;
                }
            }
            if (!iceriyor) {
                ReusableMethods.waitFor(1);
                ReusableMethods.clickByJS(vicedean.pageLink);
            }
        }
        Assert.assertTrue(ders, iceriyor);
    }

    @Then("kullanici {string} basligi altinda olusturulan gunu gordugunu dogrular")
    public void kullaniciBasligiAltindaOlusturulanGunuGordugunuDogrular(String arg0) {
        //ilk dogrulamada toplu yapilmistir
    }

    @Then("kullanici {string} basligi altinda olusturulan baslangic zamanini gordugunu dogrular")
    public void kullaniciBasligiAltindaOlusturulanBaslangicZamaniniGordugunuDogrular(String arg0) {
        //ilk dogrulamada toplu yapilmistir
    }

    @Then("kullanici {string} basligi altinda olusturulan bitis zamanini gordugunu dogrular")
    public void kullaniciBasligiAltindaOlusturulanBitisZamaniniGordugunuDogrular(String arg0) {
        //ilk dogrulamada toplu yapilmistir
    }

    @Then("uygulamayi kapat")
    public void uygulamayiKapat() {
        Driver.closeDriver();
    }

    @Then("kullanici {string} basligi altinda olusturdugu dersin edit butonuna tiklar")
    public void kullaniciBasligiAltindaOlusturduguDersinEditButonunaTiklar(String arg0) {
        vicedean = new ViceDineManagementPage();
        Assert.assertTrue(false);
        //Edit butonu yok
    }

    @Then("kullanici {string} basligi altinda olusturdugu dersin delete butonuna tiklar")
    public void kullaniciLessonBasligiAltindaOlusturduguDersinDeleteButonunaTiklar(String arg0) {
        vicedean = new ViceDineManagementPage();
        Assert.assertTrue(false);
        //Delete butonu yok
    }
}
