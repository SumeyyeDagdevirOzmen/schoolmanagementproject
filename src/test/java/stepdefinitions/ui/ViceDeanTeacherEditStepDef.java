package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.TeacherManagementPage;
import pages.ViceDineManagementPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class ViceDeanTeacherEditStepDef {

    HomePage homepage;
    ViceDineManagementPage viceDineManagementPage;
    TeacherManagementPage teacherManagementPage;


    @When("Kullaniciz Menu butonuna tiklar")
    public void kullanici_menu_butonuna_tiklar() {
        homepage = new HomePage();
        ReusableMethods.waitFor(1);
        ReusableMethods.clickByJS(homepage.MenuButton);
    }

    @When("Kullaniciz Teacher Management secenegine tiklar")
    public void kullanici_teacher_management_secenegine_tiklar() {

        ReusableMethods.waitFor(1);
        homepage.TeacherManagement.click();
        ReusableMethods.scrollDownActions();
    }

    @When("Kullaniciz Teacher List yazisini gorur")
    public void kullanici_teacher_list_yazisini_gorur() {
        teacherManagementPage = new TeacherManagementPage();

        ReusableMethods.waitFor(1);
        Assert.assertTrue(teacherManagementPage.teacherList.getText().contains("Teacher List"));
        ReusableMethods.getScreenshot("teacher list alani");
    }

    @When("Kullaniciz Name Surname alanini gorur")
    public void kullanici_name_surname_alanini_gorur() {
        teacherManagementPage = new TeacherManagementPage();

        ReusableMethods.waitFor(2);
        Assert.assertTrue(teacherManagementPage.teacherNameSurname.size() != 0);
    }

    @When("Kullaniciz Phone number alanini gorur")
    public void kullanici_phone_number_alanini_gorur() {
        teacherManagementPage = new TeacherManagementPage();

        ReusableMethods.waitFor(2);
        Assert.assertTrue(teacherManagementPage.teacherPhoneNum.size() != 0);
    }

    @When("Kullaniciz SSN alanini gorur")
    public void kullanici_ssn_alanini_gorur() {
        teacherManagementPage = new TeacherManagementPage();

        ReusableMethods.waitFor(2);
        Assert.assertTrue(teacherManagementPage.teacherSSN.size() != 0);
    }

    @When("Kullaniciz User Name alanini gorur")
    public void kullanici_user_name_alanini_gorur() {
        teacherManagementPage = new TeacherManagementPage();

        ReusableMethods.waitFor(2);
        Assert.assertTrue(teacherManagementPage.teacherUserName.size() != 0);
    }

    @When("Kullaniciz listeden guncellenecek  ogretmeni secer.")
    public void kullanici_listeden_guncellenecek_ogretmeni_secer() {
        ReusableMethods.waitFor(2);
        viceDineManagementPage = new ViceDineManagementPage();
        viceDineManagementPage.lessonNameList.get(12).isDisplayed();
    }


    @When("Kullaniciz guncelleyecegi ogretmenin hizasindaki edit butonuna basar.")
    public void kullanici_guncelleyecegi_ogretmenin_hizasindaki_edit_butonuna_basar() {
        teacherManagementPage = new TeacherManagementPage();

        ReusableMethods.waitFor(2);
ReusableMethods.clickByJS(teacherManagementPage.Edit);
    }

    @When("Kullaniciz cikan ekranda Chosose lessons alanina valid bir deger girer.")
    public void kullanici_cikan_ekranda_chosose_lessons_alanina_valid_bir_deger_girer()  {
        teacherManagementPage=new TeacherManagementPage();
        teacherManagementPage.teacherEditChooseLessons.click();
        ReusableMethods.waitFor(1);
        Actions action=new Actions(Driver.getDriver());
        action.keyDown(Keys.ENTER).sendKeys(Keys.TAB).perform();


    }

    @When("Kullaniciz name alanini gunceller.")
    public void kullanici_name_alanini_gunceller() {
        teacherManagementPage = new TeacherManagementPage();

        ReusableMethods.waitFor(2);
        Actions action = new Actions(Driver.getDriver());

        action.doubleClick(teacherManagementPage.teacherEditName).sendKeys(Keys.BACK_SPACE,"yaa",Keys.TAB).perform();

    }

    @When("Kullaniciz surname alanini gunceller.")
    public void kullanici_surname_alanini_gunceller() {
        teacherManagementPage = new TeacherManagementPage();
        ReusableMethods.waitFor(2);
        teacherManagementPage.teacherEditSurname.sendKeys("Durdane",Keys.TAB);
    }

    @When("Kullaniciz Birth Place alanini gunceller.")
    public void kullanici_birth_place_alanini_gunceller() {
        teacherManagementPage = new TeacherManagementPage();

        ReusableMethods.waitFor(2);

        teacherManagementPage.teacherEditBirthPlace.sendKeys(Faker.instance().country().capital(),Keys.TAB);
    }

    @When("Kullaniciz Email alanini gunceller.")
    public void kullanici_email_alanini_gunceller() {
        teacherManagementPage = new TeacherManagementPage();

        ReusableMethods.waitFor(2);
Actions actions=new Actions(Driver.getDriver());
actions.moveToElement(teacherManagementPage.teacherEditEmail);
        teacherManagementPage.teacherEditEmail.sendKeys("abcd@gmail.com",Keys.TAB);
    }

    @When("Kullaniciz Phone alanini gunceller.")
    public void kullanici_phone_alanini_gunceller() {
        teacherManagementPage = new TeacherManagementPage();

        ReusableMethods.waitFor(2);

//        String phone=  Faker.instance().number().numberBetween(100,999)+"-"+
//                Faker.instance().number().numberBetween(100,999)+"-"+
//                Faker.instance().number().numberBetween(1000,9999);
        teacherManagementPage.teacherEditPhone.sendKeys("876-569-5931",Keys.TAB);

    }

    @When("Kullaniciz SSN alanini gunceller.")
    public void kullanici_ssn_alanini_gunceller() {
        teacherManagementPage = new TeacherManagementPage();

        ReusableMethods.waitFor(2);

//        String SSN=Faker.instance().number().numberBetween(100,999)+"-"+
//                Faker.instance().number().numberBetween(10,99)+"-"+
//                Faker.instance().number().numberBetween(1000,9999);
       teacherManagementPage.teacherEditSSn.sendKeys("104-23-8345",Keys.TAB);

    }

    @When("Kullaniciz Gender alanini gunceller")
    public void kullanici_gender_alanini_gunceller() {
        teacherManagementPage = new TeacherManagementPage();

        ReusableMethods.waitFor(2);
       ReusableMethods.clickByJS(teacherManagementPage.teacherEditFamele);


    }

    @When("Kullaniciz Date of birth alanini gunceller")
    public void kullanici_date_of_birth_alanini_gunceller() {
        teacherManagementPage = new TeacherManagementPage();

        ReusableMethods.waitFor(2);

        teacherManagementPage.teacherEditDateOfBirth.sendKeys("13-09-2008",Keys.ENTER);
    }

    @When("Kullaniciz User name alanini gunceler")
    public void kullanici_user_name_alanini_gunceler() {
        teacherManagementPage = new TeacherManagementPage();

        ReusableMethods.waitFor(2);
        teacherManagementPage.teacherEditUserName.sendKeys(Keys.BACK_SPACE,"sakin",Keys.ENTER,Keys.TAB);
    }

    @When("Kullaniciz password alanina vice dean passwordunu girer")
    public void kullanici_password_alanina_vice_dean_passwordunu_girer() {
        teacherManagementPage = new TeacherManagementPage();

        ReusableMethods.waitFor(2);
        teacherManagementPage.teacherEditPassword.sendKeys("Team03team",Keys.TAB);
    }

    @When("Kullaniciz submit butonuna tiklar.")
    public void kullanici_submit_butonuna_tiklar() {
        teacherManagementPage = new TeacherManagementPage();

        ReusableMethods.waitFor(2);
        ReusableMethods.clickByJS(teacherManagementPage.teacherEditSubmit);
    }

    @When("Kullaniciz Teacher updated succesful masajini gorur.")
    public void kullanici_teacher_updated_succesful_masajini_gorur() {
        ReusableMethods.waitFor(2);
        teacherManagementPage=new TeacherManagementPage();
        ReusableMethods.getScreenshot("edit basarili");
        Assert.assertTrue(teacherManagementPage.teacherEditsuccesfully.isEnabled());

    }

    @When("Kullaniciz choose lesson alanini bos birakir")
    public void kullaniciz_choose_lesson_alanini_bos_birakir() {
        teacherManagementPage=new TeacherManagementPage();
        ReusableMethods.waitFor(1);
        teacherManagementPage.teacherEditChooseLessons.click();
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(teacherManagementPage.teacherEditName).sendKeys(Keys.SPACE);}


    @When("Kullaniciz name alanini bos birakir.")
    public void kullanici_name_alanini_bos_birakir() {
        teacherManagementPage=new TeacherManagementPage();
        ReusableMethods.waitFor(1);
        teacherManagementPage.teacherEditName.sendKeys(Keys.SPACE,Keys.ENTER,Keys.TAB);
    }

    @When("Name kutusu alrinda Required yazisis gorur.")
    public void name_kutusu_alrinda_required_yazisis_gorur() {
        teacherManagementPage=new TeacherManagementPage();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(teacherManagementPage.requiredz.isDisplayed());
    }
    @When("Password kutusu altinda required yazisi gorur.")
    public void password_kutusu_altinda_required_yazisi_gorur() {
        teacherManagementPage=new TeacherManagementPage();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(teacherManagementPage.requiredz.isDisplayed());
    }
    @When("Name kutusuna valid bir guncelleme yapar.")
    public void name_kutusuna_valid_bir_guncelleme_yapar() {
        teacherManagementPage=new TeacherManagementPage();
        ReusableMethods.waitFor(1);

        teacherManagementPage.teacherEditName.sendKeys("aaa",Keys.TAB);
    }

    @When("Gender alanini bos birakir")
    public void gender_alanini_bos_birakir() {
        teacherManagementPage=new TeacherManagementPage();
        ReusableMethods.waitFor(1);
       Assert.assertFalse(teacherManagementPage.teacherEditFamele.isSelected()); ;

    }
    @When("Kullaniciz hata mesaji alir.")
    public void kullanici_hata_mesaji_alir() {
        teacherManagementPage=new TeacherManagementPage();
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("hata mesaji");
        Assert.assertTrue(teacherManagementPage.hataMesaji.isEnabled());
    }
    @When("Is Advisor Teacher kismini günceller")
    public void is_advisor_teacher_kismini_günceller() {
        teacherManagementPage=new TeacherManagementPage();
        ReusableMethods.waitFor(1);
        ReusableMethods.selectCheckBox(teacherManagementPage.teacherEditIsAdvisorTeacher,true);
    }







    @When("Kullanici choose lesson alanini bos birakir")
    public void kullanici_choose_lesson_alanini_bos_birakir() {
        teacherManagementPage=new TeacherManagementPage();
        ReusableMethods.waitFor(1);
        teacherManagementPage.teacherEditChooseLessons.click();
        Actions action = new Actions(Driver.getDriver());
        action.keyDown(Keys.ARROW_DOWN).sendKeys("", Keys.TAB,Keys.SPACE).perform();
    action.contextClick(teacherManagementPage.teacherEditName).sendKeys(Keys.SPACE);
     }



    @When("Kullanici Lesson must not empty masajini gorur.")
    public void kullanici_lesson_must_not_empty_masajini_gorur() {
        teacherManagementPage=new TeacherManagementPage();
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("lesson bos olmamali mesaji");
        Assert.assertTrue(teacherManagementPage.LessonMstNotEmtyMsj.isEnabled());
    }


}
