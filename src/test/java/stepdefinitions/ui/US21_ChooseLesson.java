package stepdefinitions.ui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.StudentManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US21_ChooseLesson {


        StudentManagementPage studentManage = new StudentManagementPage();


        @When("Kullanicifatma ogrenci olarak login olur")
        public void kullanici_ogrenci_olarak_login_olur() {
                ReusableMethods.login(ConfigReader.getProperty("studentusername"), ConfigReader.getProperty("studentpass"));
                ReusableMethods.waitFor(2);
        }

        @Then("Ogrencifatma menu butonuna tiklar")
        public void ogrenci_menu_butonuna_tiklar() {

                studentManage.menuTikla.click();

        }

        @Then("Ogrencifatma menüden Choose Lesson'a tiklar")
        public void ogrenci_menüden_choose_lesson_a_tiklar() {


        }

        @Then("Ogrencifatma menüden Lesson Listesinde Teacher bilgisini gorur")
        public void ogrenci_menüden_lesson_listesinde_teacher_bilgisini_gorur() {

                Assert.assertTrue(studentManage.teacherBilgi.size() != 0);

        }

        @Then("Ogrencifatma menüden Lesson Listesinde Day bilgisini gorur")
        public void ogrenci_menüden_lesson_listesinde_day_bilgisini_gorur() {
                Assert.assertTrue(studentManage.dayBilgi.size() != 0);

        }

        @Then("Ogrencifatma menüden Lesson Listesinde Start Time bilgisini gorur")
        public void ogrenci_menüden_lesson_listesinde_start_time_bilgisini_gorur() {
                Assert.assertTrue(studentManage.startTimebilgi.size() != 0);
        }

        @Then("Ogrencifatma menüden Lesson Listesinde Stop Time  bilgisini gorur")
        public void ogrenci_menüden_lesson_listesinde_stop_time_bilgisini_gorur() {
                Assert.assertTrue(studentManage.stopTimebilgi.size() != 0);
        }


        @Then("Ogrencifatma sayfayi kapatir")
        public void ogrenci_sayfayi_kapatir() {

                ReusableMethods.waitFor(2);

                Driver.closeDriver();

        }


        @Then("Ogrencifatma listeden ayni gun ve saatte olmayan ders secer")
        public void ogrenci_listeden_ders_secer() {
                String secondTable = Driver.getDriver().findElement(By.xpath("(//table)[2]")).getText();
                for (int i = 0; i < studentManage.stopTimebilgi.size(); i++) {
                        if (secondTable.contains(studentManage.gunlerListi.get(i).getText())) {
                                if (!secondTable.contains(studentManage.baslangisSaatleriListi.get(i).getText())) {
                                        ReusableMethods.waitForClickablility(studentManage.chooseLessonsButons.get(i), 10);
                                        ReusableMethods.clickByJS(studentManage.chooseLessonsButons.get(i));
                                        break;
                                }
                        }
                }
                ReusableMethods.clickByJS(studentManage.submitButton);
        }


        @When("Ogrencifatma listeden ayni gun ve saat olan dersleri secer")
        public void ogrencifatma_listeden_ayni_gun_ve_saat_olan_dersleri_secer() {

                String secondTable = Driver.getDriver().findElement(By.xpath("(//table)[2]")).getText();
                for (int i = 0; i < studentManage.stopTimebilgi.size(); i++) {
                        if (secondTable.contains(studentManage.gunlerListi.get(i).getText())) {
                                if (secondTable.contains(studentManage.baslangisSaatleriListi.get(i).getText())) {
                                        ReusableMethods.waitForClickablility(studentManage.chooseLessonsButons.get(i), 10);
                                        ReusableMethods.clickByJS(studentManage.chooseLessonsButons.get(i));
                                        break;
                                }
                        }
                }
                ReusableMethods.clickByJS(studentManage.submitButton);
        }



        @When("Ogrencifatma hata mesaji alir")
        public void ogrencifatma_hata_mesaji_alir() {

                ReusableMethods.waitFor(2);

                assert studentManage.erroruyari.isDisplayed();

        }

        @Then("Ogrencifatma seçtiği dersi Lesson Program List’te gorur")
        public void ogrenci_seçtiği_dersi_lesson_program_list_te_gorur() {

                ReusableMethods.waitFor(2);

                Assert.assertTrue(studentManage.lessonlist.size() != 0);


        }

                @Then("Ogrencifatma menüden Grades et Announcement 'a tiklar")
                public void ogrenci_menüden_grades_et_announcement_a_tiklar () {

                        ReusableMethods.waitFor(2);

                        studentManage.grades.click();

                }

                @Then("Ogrencifatma Student Info List alaninda notlarini gorur")
                public void ogrenci_student_info_list_alaninda_notlarini_gorur () {

                        ReusableMethods.waitFor(2);

                        Assert.assertTrue(studentManage.StudentInfoListDavid.size() != 0);

                }

                @Then("Ogrencifatma Meet List alaninda toplantinlari gorur")
                public void ogrenci_meet_list_alaninda_toplantinlari_gorur () {

                        ReusableMethods.waitFor(2);

                        Assert.assertTrue(studentManage.MeetInfoListDavid.size() != 0);


                }

        }

