package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class ViceDineManagementPage {
    public ViceDineManagementPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//button[@id='controlled-tab-example-tab-lessonProgram']")
    public WebElement LessonProgram;

    @FindBy(xpath = "//select[@id='educationTermId']")
    public WebElement ChooseEducationTerm;

    @FindBy(xpath ="//input[@id='react-select-2-input']")
    public WebElement ChooseLesson;

    @FindBy(xpath = "//select[@id='day']")
    public WebElement gun;

    @FindBy(xpath = "//input[@id='startTime']")
    public WebElement startTime;

    @FindBy(xpath = "//input[@id='stopTime']")
    public WebElement stopTime;

    @FindBy(xpath = "(//button[@class='fw-semibold btn btn-primary btn-lg'])[3]")
    public WebElement SubmitButton;

    @FindBy(xpath = "//div[text()='Created Lesson Program']")
    public WebElement basariMesaji;

    @FindBy(xpath ="//div[text()='Required']")
    public WebElement startStopUyariMessage;

    @FindBy(xpath = "//table//tbody//tr//td[2]")
    public List<WebElement> dataTableEmailList;
    @FindBy(xpath = "//*[@id='controlled-tab-example-tab-lessonsList']")
    public WebElement lessons;

    @FindBy(xpath = "//h5[contains(text(),'Lesson List')]")
    public WebElement lessonList;
    @FindBy(xpath = "//tbody//tr//td[1]")
    public List<WebElement> lessonNameList;

    @FindBy(xpath = "//tbody//tr/td[2]")
    public List< WebElement> compulsoryList;

    @FindBy(xpath = "//tbody//tr/td[3]")
    public List<WebElement> creditScoreList;

    @FindBy(xpath = "//tbody//tr//td[4]")
    public List <WebElement> lessonDeleteList;






    //dila hanim(70-120)

    @FindBy(xpath = "//*[text()='Vice Dean Management']")
    public WebElement ViceDean;


    @FindBy(css = "#name")
    public WebElement viceDeanName;

    @FindBy(css = "[class='fw-semibold btn btn-primary btn-lg']")
    public WebElement Submit;

    @FindBy(xpath = "//div[contains(text(),'Vice dean Saved')]")
    public WebElement ViceDeanSuccess;




































    //faruk bey(120-170)
//    @FindBy(xpath = "//table//tbody//tr//td[2]")
//    public List<WebElement> dataTableEmailList;
 @FindBy(xpath = "//tbody//tr//td[5]")
 public  List<WebElement> dataTableMessageList;
 @FindBy(xpath = "//tbody//tr//td[4]")
 public List<WebElement> dataTableSubjectList;
 @FindBy(xpath = "//tbody//tr//td[3]")
 public  List<WebElement> dataTableDateList;
 @FindBy(xpath = "//tbody//tr//td[1]")
 public  List<WebElement> dataTableNameList;







































//fatma hanim(170-220)

















































//Firuzan hanim(220-270)

    @FindBy(xpath = "//input[@id='lessonName']")
    public static WebElement lessonName;

    @FindBy(xpath = "//input[@id='creditScore']")
    public WebElement creditScore;

    @FindBy (xpath = "(//*[text()='Submit'])[2]")
    public WebElement submit;

    @FindBy(xpath = "//div[text()='Lesson Created']")
    public WebElement LessonCreated;

    @FindBy(xpath = "//*[text()='Required']")
    public WebElement Required;
































    //zehra hanim(270-320)
@FindBy(xpath = "//div[contains(text(),'Lesson Deleted')]")
public WebElement basariMesajiDelete;
@FindBy(xpath = "(//a[@class='page-link'])[8]")
    public WebElement sayfaDegistirme;
    @FindBy(xpath = "//body/div[@id='root']/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/button[1]")
    public WebElement submitlesson;

    @FindBy(xpath = "//input[@id='lessonName']")
    public WebElement lessonNameKutusu;

    @FindBy(xpath = "//input[@id='compulsory']")
    public WebElement compulsory;

    @FindBy(xpath = "//input[@id='creditScore']")
    public WebElement creditScoreKutusu;

    @FindBy(xpath = "//i[@class='fa-solid fa-trash']")
    public WebElement deletelesson;

    @FindBy(xpath = "//span[contains(text(),'Klimaat')]")
    public WebElement klimaat;




























    //hatice hanim(320-370)
@FindBy(xpath = "//div[@class='Toastify__toast-body']")
public WebElement ChooselessonAndSemesterErrormessage;


















































//havva hanim(370-420)

















































//kubra hanim(420-470)

















































//nihal hanim(470-520)

















































//sevim hanim(520-570)

















































//sumeyye hanim(570-620)

    @FindBy(xpath="//button[text()='Menu']")
    public WebElement menuButton;
    @FindBy(xpath="//a[text()='Teacher Management']")
    public WebElement teacherManagement;
    @FindBy(xpath="//div[@class=' css-1xc3v61-indicatorContainer']")
    public WebElement chooseLessons;
    @FindBy(xpath="//*[@id='name']")
    public WebElement name;
    @FindBy(xpath="//input[@id='surname']")
    public WebElement surName;
    @FindBy(xpath="//input[@id='birthPlace']")
    public WebElement birthPlace;
    @FindBy(xpath="//input[@id='email']")
    public WebElement email;

    @FindBy(xpath="//input[@id='phoneNumber']")
    public WebElement phone;
    @FindBy(xpath="//input[@id='isAdvisorTeacher']")
    public WebElement isAdvisorTeacher;

    @FindBy(xpath="//input[@value='FEMALE']")
    public WebElement femaleCheckbox;

    @FindBy(xpath="//input[@value='MALE']")
    public WebElement maleCheckbox;

    @FindBy(xpath="//input[@id='birthDay']")
    public WebElement dateOfBirth;

    @FindBy(xpath="//input[@id='ssn']")
    public WebElement ssn;
    @FindBy(xpath="//input[@id='username']")
    public WebElement userName;

    @FindBy(xpath="//input[@id='password']")
    public WebElement password;
    @FindBy(xpath="//button[text()='Submit']")
    public WebElement submitButton;











    //yusuf bey(620-670)

















































    //ayhan bey(670-720)

    @FindBy(xpath = "(//table[@class='table table-striped table-bordered table-hover'])[3]//tbody//tr")
    public List<WebElement> lessonProgramList;

    @FindBy(xpath = "(//a[@class='page-link'])[11]")
    public WebElement pageLink;

    @FindBy(xpath = "//tbody/tr[334]/td[1]/span[1]/div[1]/input[1]")
    public WebElement lessonCheckbox;

    @FindBy(xpath = "//select[@id='teacherId']")
    public WebElement lessonChooseTeacher;

    @FindBy(xpath = "(//button[@class='fw-semibold btn btn-primary btn-lg'])[4]")
    public WebElement altSubmitButton;

    @FindBy(xpath = "//h5[text()='Lesson Program Assignment']")
    public WebElement lessonProgramAssigmentTitle;

    @FindBy(xpath = "//div[text()='Lesson added to Teacher']")
    public WebElement lessonAddedToTeacherMessage;

    @FindBy(xpath = "//div[text()='CYPRESS']")
    public WebElement secilenDers;

























    //gul hanim(720- )













}

