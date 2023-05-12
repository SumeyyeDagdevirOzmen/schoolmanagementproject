package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;
import java.util.Objects;

public class StudentManagementPage {
    public StudentManagementPage () {
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//select[@id='advisorTeacherId']")
    public WebElement chooseTeacher;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement name;

    @FindBy(xpath = "//input[@id='surname']")
    public WebElement surname;

    @FindBy(xpath = "//input[@id='birthPlace']")
    public WebElement birthPlace;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='phoneNumber']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//input[@value='FEMALE']")
    public WebElement femaleButton;

    @FindBy(xpath = "//input[@value='MALE']")
    public WebElement maleButton;

    @FindBy(xpath = "//input[@id='birthDay']")
    public WebElement birthDay;

    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement ssn;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='fatherName']")
    public WebElement fatherName;
    @FindBy(xpath = "//input[@id='motherName']")
    public WebElement motherName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement submitButton;












    //dila hanim(70-120)

















































//faruk bey(120-170)

















































//fatma hanim(170-220)

    @FindBy(xpath = "//input[@value='3']")
    public WebElement chooseMath;

    @FindBy(xpath = "//span[normalize-space()='m']")
    public WebElement teacherGorunum;

    @FindBy(xpath = "//span[@xpath='1']")
    public WebElement lessonGorunum;
    @FindBy(xpath = "//button[contains(text(),'Menu')]")
    public WebElement menuTikla;
    @FindBy(xpath = "//a[contains(text(),'Grades and Announcements')]")
    public WebElement grades;
    @FindBy(xpath = "//th[contains(text(),'Lesson Name')]")
    public List<WebElement> StudentInfoListDavid;
    @FindBy(xpath = "//span[contains(text(),'2023-04-19')]")
    public List<WebElement> MeetInfoListDavid;
    @FindBy(xpath = "//tbody//tr/td[3]")
    public List<WebElement> teacherBilgi;
    @FindBy(xpath = "//tbody//tr/td[4]")
    public List<WebElement> dayBilgi;
    @FindBy(xpath = "//tbody//tr/td[5]")
    public List<WebElement> startTimebilgi;
    @FindBy(xpath = "//tbody//tr/td[6]")
    public List<WebElement> stopTimebilgi;
    @FindBy(xpath = "//body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
    public List<WebElement> lessonlist;
    @FindBy(xpath = "//div[text()='Error: Course schedule cannot be selected for the same hour and day']")
    public WebElement erroruyari;
    @FindBy(xpath = "(//table[@class='table table-striped table-bordered table-hover'])[1]//td[2]")
    public List<WebElement>derslerListi;
    @FindBy(xpath = "(//table[@class='table table-striped table-bordered table-hover'])[1]//td[4]")
    public List<WebElement>gunlerListi;
    @FindBy(xpath = "(//table[@class='table table-striped table-bordered table-hover'])[1]//td[5]")
    public List<WebElement>baslangisSaatleriListi;

    @FindBy(xpath = "(//table[1])//tr//td[1]//input")
    public List<WebElement> chooseLessonsButons;

    @FindBy(xpath = "(//table[@class='table table-striped table-bordered table-hover'])[1]//tr//td[4]")
    public List<WebElement>chooseLesson_Day;

    @FindBy(xpath = "(//table[@class='table table-striped table-bordered table-hover'])[1]//tr//td[5]")
    public List<WebElement>chooseLesson_StartTime;





    //Firuzan hanim(220-270)

    @FindBy(xpath = "//a[@class='header_link me-2']")
    public WebElement registerButton;


    @FindBy(xpath = "//*[@class='fw-semibold btn btn-primary']")
    public WebElement register1Button;

    @FindBy(xpath ="//*[text()='Guest User registered.']" )
    public WebElement GuestUserRegistered;

    @FindBy(xpath = "//input[@id='phoneNumber']")
    public WebElement phone;

    @FindBy(xpath = "//input[@id='birthDay']")
    public WebElement dateOfBirth;

































    //zehra hanim(270-320)

















































    //hatice hanim(320-370)
//    @FindBy(xpath = "(//span[text()='Ayse03'])[2]")
//    public WebElement editname;
    @FindBy(xpath = "(//button[@class='text-dark btn btn-outline-info'])[3]")
    public WebElement editButton;
  @FindBy(xpath = "(//select[@id='lessonId'])[2]")
  public WebElement editChooseLesson;
  @FindBy(xpath = "(//select[@id='educationTermId'])[2]")
  public WebElement editChooseEducationTerm;
  @FindBy(xpath = "(//input[@id='absentee'])[2]")
  public WebElement editAbsentee;
  @FindBy(xpath = "(//input[@id='midtermExam'])[2]")
  public WebElement editMitdernExam;
  @FindBy(xpath = "(//input[@id='finalExam'])[2]")
  public WebElement editFinalExam;
  @FindBy(xpath = "(//input[@id='infoNote'])[2]")
  public WebElement editInfoNote;
  @FindBy(xpath = "(//button[@class='fw-semibold btn btn-primary btn-lg'])[2]")
  public WebElement editSubmit;

  @FindBy(xpath = "//div[@id='48']")
  public WebElement chooseEducationTermErrorMessage;

  @FindBy(xpath = "(//div[text()='Please enter midterm exam'])[1]")
  public WebElement MitdernExamUyariMessage;
  @FindBy(xpath = "(//div[text()='Please enter absentee '])[2]")
  public WebElement AbsenTeeUyariMesssage;

  @FindBy(xpath = "(//div[text()='Please select lesson '])[1]")
  public WebElement LessonUyariMessage;

  @FindBy(xpath = "//div[text()='Please select education term ']")
  public WebElement ChooseEducationTermUyariMessage;
  @FindBy(xpath = "(//div[text()='Please enter final exam  '])[1]")
  public WebElement FinalExamUyariMessage;
  @FindBy(xpath = "(//i[@class='fa-solid fa-trash'])[1]")
  public WebElement StudentInfodelete;
  @FindBy(xpath = "(//div[text()='Student Info deleted Successfully'])[1]")
  public WebElement DeleteBasariMessage;
  @FindBy(xpath = "(//div[text()='Please select lesson '])[1]")
  public WebElement chooseLessonUyariMessage;

  @FindBy(xpath = "//div[text()='Student Info updated Successfully']")
   public WebElement GuncellemeBasarimessage;

  @FindBy(xpath = "(//div[@class='Toastify__toast-body'])[2]")
  public WebElement maxMitdernExam;

@FindBy(xpath = "(//div[text()='Info must consist of the characters .'])[2]")
public WebElement infonoteuyarimessage;


  //havva hanim(370-420)
  @FindBy(xpath = "//select[@id='lessonId']")
  public WebElement chooseLessonHava;
  @FindBy(xpath = "//select[@id='studentId']")
  public WebElement chooseStudentHava;
  @FindBy(xpath = "//select[@id='educationTermId']")
  public WebElement chooseEducationTermHava;
  @FindBy(xpath = "//input[@id='absentee']")
  public WebElement absenteeHava;
  @FindBy(xpath = "//input[@id='midtermExam']")
  public WebElement midtermExamHava;
  @FindBy(xpath = "//input[@id='finalExam']")
  public WebElement finalExamHava;
  @FindBy(xpath = "//input[@id='infoNote']")
  public WebElement infoNoteHava;
  @FindBy(xpath = "//button[text()='Submit']")
  public WebElement submitHava;
  @FindBy(xpath = "//h5[text()='Add Student Info']")
  public WebElement addStudentInfoHava;
  @FindBy(xpath = "//div[text()='Student Info saved Successfully']")
  public WebElement onayMessageHava;
  @FindBy(xpath = "//div[text()='must be less than or equal to 100.0']")
  public WebElement notHataMesajiHava;
  @FindBy(xpath = "//div[@class='Toastify__toast-body']")
  public WebElement chooseHataMesajHava;
  @FindBy(xpath = "//button[@class='btn btn-danger']")
  public WebElement deleteHava;























  //kubra hanim(420-470)
    @FindBy(xpath = "//div[text()='Student saved Successfully']")
    public WebElement studentSaved;















































    //nihal hanim(470-520)

















































//sevim hanim(520-570)
@FindBy(xpath = "//div[@role='alert']")
    public WebElement alertUyari;
@FindBy(xpath = "//div[@id='18']")
    public WebElement chooseTeacherAlert;

@FindBy(xpath = "//div[text()='Please enter valid email']")
public WebElement invalidEmailAlert;

@FindBy(xpath = "(//div[@role='alert']/div[contains(text(),'')])[2]")
public WebElement uyariMesaji;

@FindBy(xpath = "//div[contains(text(),'Full authentication is required to access this res')]")
    public WebElement fullAuthenticationIsRequired;

@FindBy(xpath = "//div[text()='Please enter valid phone number']")
    public WebElement invalidPhoneNumber;
@FindBy(xpath = "(//div[@role='alert']/div)[2]")
   public String alertGetText;















//sumeyye hanim(570-620)

















































//yusuf bey(620-670)

















































    //ayhan bey(670-720)

















































    //gul hanim(720- )






}
