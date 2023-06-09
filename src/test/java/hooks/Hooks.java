package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import static base_url.SchoolManagement_BaseUrl.*;


public class Hooks {


    @Before("@admin")// @Before("@TC01_Api") boyle yazarsak sadece bir test case calisir
    public void beforeApiAdmin() {

        System.out.println("Before Method for admin");
        schoolsetupAdmin();
    }

    @Before("@teacher")

    public void beforeApiTeacher() {

        System.out.println("Before Method for teacher");
        schoolsetupTeacher();
    }

    @Before("@dean")

    public void beforeApiDean() {

        System.out.println("Before Method for dean");
        schoolsetupDean();
    }
    @Before("@vicedean")


    public void beforeApiViceDean() {
        System.out.println("Before Method for vicedean");
        schoolsetupViceDean();
    }

    @Before("@student")

    public void beforeApiStudent() {
        System.out.println("Before Method for student");
        schoolsetupStudent();
    }






    @After
    public void tearDownScenarios(Scenario scenario) {
        System.out.println("After Metotu");
//        Eger bir Scenario FAIL ederse, ekran goruntusunu al ve rapora ekle
        if (scenario.isFailed()) {
            final byte[] failedScreenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//                       ekran goruntusu    file tipi                  ekran goruntusunun adi
            scenario.attach(failedScreenshot, "image/png", "failed_scenario_"+scenario.getName());
             Driver.closeDriver();
        }
    }
    @Before("@run_second")
    public void runFirstScenario() {
        //Scenario scenario = null;
        // senaryo adı ve dosya yolu
        String[] argv = {"--name", "TC001 post save student request - positive", "classpath:features"};
        io.cucumber.core.cli.Main.run(argv, Thread.currentThread().getContextClassLoader());
    }


}
