package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TeacherManagementPage {
    public TeacherManagementPage () {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@id='react-select-3-input']")
    public WebElement ChooseStudentsBox;
    @FindBy(xpath = "//input[@id='date']")
    public WebElement DateOfMeetBox;
    @FindBy(xpath = "//input[@id='startTime']")
    public WebElement startTimeBox;
    @FindBy(xpath = "//input[@id='stopTime']")
    public WebElement stopTimeBox;
    @FindBy(xpath = "//input[@id='description']")
    public WebElement descriptionBox;
    @FindBy(xpath = "//button[@class='fw-semibold btn btn-primary btn-lg']")
    public WebElement submitButton;
    @FindBy(xpath = "//div[text()='Meet Saved Successfully']")
    public WebElement toplantiOlusturulduMesaji;
    @FindBy(xpath = "//div[text()='ileri bir tarih olmalı")
    public WebElement ileriTarihUyarisi;
    @FindBy(xpath = "//body[@wfd-invisible='true']")
    public WebElement ileriTarihUyarisi2;
    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public List<WebElement> requiredUyarilari;
    @FindBy(xpath = "//*[@id='react-select-3-input']")
    public WebElement chooseLessons2;
    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameBox;
    @FindBy(xpath = "//input[@id='surname']")
    public WebElement surnameBox;
    @FindBy(xpath = "//input[@id='birthPlace']")
    public WebElement birthPlaceBox;
    @FindBy(xpath = "//input[@id='email']")
    public  WebElement emailBox;
    @FindBy(xpath = "//input[@id='phoneNumber']")
    public WebElement phoneNumberBox;
    @FindBy(xpath = "//input[@id='isAdvisorTeacher']")
    public WebElement isAdvisorCheckBox;
    @FindBy(xpath = "//input[@name='gender']")
    public List<WebElement> genderList;
    @FindBy(xpath = "//input[@id='birthDay']")
    public WebElement birthDayBox;
    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement ssnBox;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement userNameBox;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;
    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement submitButon;
    @FindBy(xpath = "(//*[.='Teacher saved successfully'])[1]")
    public WebElement ogretmenEklendiUyarisi;
    @FindBy(xpath = "(//i[@class='fa-solid fa-trash'])[1]")
    public WebElement deleteNihal;



    //dila hanim(70-120)

    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']//thead//tr//th[1]")
    public WebElement date;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']//thead//tr//th[2]")
    public WebElement startTime;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']//thead//tr//th[3]")
    public WebElement stopTime;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']//thead//tr//th[4]")
    public WebElement description;
    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']//tbody//td[5]//button")
    public WebElement edit;
    @FindBy(xpath = "(//input[@id='date'])[2]")
    public WebElement editDate;
    //(//table[@class='table table-striped table-bordered table-hover']//tbody//span)[1]
    @FindBy(xpath = "(//input[@id='startTime'])[2]")
    public WebElement Starttimeedit;
    @FindBy(xpath = "(//input[@id='stopTime'])[2]")
    public WebElement Stoptimeedit;
    @FindBy(xpath = "(//input[@id='description'])[2]")
    public WebElement descriptionedit;

    @FindBy(xpath = "(//button[@class='fw-semibold btn btn-primary btn-lg'])[2]")
    public WebElement submit;
    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']//tbody//td[6]//button")
    public WebElement delete;

    @FindBy(xpath = "//div[@class='Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']")
    public WebElement alert;
   @FindBy(xpath = "//div[text()='Meet deleted successfully ']")
    public WebElement deleteSuccesMesaj;
  /*  @FindBy(xpath = "//div[@role='alert']")
    public WebElement deleteSuccesMesaj;*/














    //faruk bey(120-170)

















































//fatma hanim(170-220)

















































//Firuzan hanim(220-270)

















































    //zehra hanim(270-320)
@FindBy(xpath="(//div[@class=' css-1xc3v61-indicatorContainer'])[2]")
public WebElement teacherEditChooseLessons;

//
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]")
    public WebElement teacherEditName;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/input[1]")
    public WebElement teacherEditSurname;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/input[1]")
    public WebElement teacherEditBirthPlace;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]")
    public WebElement teacherEditEmail;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/input[1]")
    public WebElement teacherEditPhone;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[3]/div[1]/input[1]")
    public WebElement teacherEditSSn;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[4]/div[1]/input[1]")
    public WebElement teacherEditIsAdvisorTeacher;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[5]/div[1]/div[1]/div[1]/input[1]")
    public WebElement teacherEditFamele;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/input[1]")
    public WebElement teacherEditDateOfBirth;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/input[1]")
    public WebElement teacherEditUserName;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[3]/div[1]/input[1]")
    public WebElement teacherEditPassword;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[2]/div[2]/button[1]")
    public WebElement teacherEditSubmit;





















    //hatice hanim(320-370)
   @FindBy(xpath = "//tbody//tr[3]//td")
    public List<WebElement> StudentInfoList;















































    //havva hanim(370-420)

    @FindBy(xpath = "//h5[contains(text(),'Teacher List')]")
    public  WebElement teacherList;
    @FindBy(xpath = "//tbody[1]/tr[1]/td[1]/span[1]")
    public List<WebElement >teacherNameSurname;
    @FindBy(xpath = "//tbody//tr//td[2]")
    public List<WebElement > teacherPhoneNum;
    @FindBy(xpath = "//tbody/tr[1]/td[3]")
    public List<WebElement >teacherSSN;
    @FindBy(xpath = "//tbody/tr[1]/td[4]/span[1]")
    public List<WebElement >teacherUserName;
    @FindBy(xpath = "//tbody/tr[14]/td[5]/span[1]/button[1]")
    public WebElement  Edit;
    @FindBy(xpath = "//div[contains(text(),'Teacher updated Successful')]")
    public WebElement  teacherEditsuccesfully;
    @FindBy(xpath = "//div[text()='Required']")
    public WebElement  requiredz;


    @FindBy(xpath = "//div[contains(text(),'JSON parse error: Cannot coerce empty String (\"\") ')]")
    public WebElement  hataMesaji;

    @FindBy(xpath = "//div[contains(text(),'lessons must not empty')]")
    public WebElement  LessonMstNotEmtyMsj;

























    //kubra hanim(420-470)

















































//nihal hanim(470-520)

















































//sevim hanim(520-570)

















































    //sumeyye hanim(570-620)


    @FindBy(xpath = "//div[text()='Required']")
    public WebElement requiredText;

    //Alerts
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement Alert;

    @FindBy(xpath = "//div[text()='Teacher saved successfully']")
    public WebElement successAlert;
    @FindBy(xpath = "//div[text()='Please enter valid email']")
    public WebElement emailAlert;
    @FindBy(xpath = "//div[text()='Please enter valid phone number']")
    public WebElement PhoneAlert;

    @FindBy(xpath = "//div[text()='Minimum 12 character (XXX-XXX-XXXX)']")
    public WebElement PhoneAlert2;

    @FindBy(xpath = "//div[text()='Minimum 11 character (XXX-XX-XXXX)']")
    public WebElement ssnAlert;

    @FindBy(xpath = "//div[text()='Please enter valid SSN number']")
    public WebElement ssnAlert2;

    @FindBy(xpath = "//div[text()='Minimum 8 character']")
    public WebElement passwordAlert;

    @FindBy(xpath = "//div[text()='must be a past date']")
    public WebElement dateAlert;

    @FindBy(xpath = "(//*[.='Teacher saved successfully'])[1]")
    public WebElement teacherSuccessfully;
    @FindBy(xpath = "(//div[@role='alert']/div[contains(text(),'')])[2]")
    public WebElement generalAlert;

    @FindBy(xpath = "(//*[.='lessons must not empty'])[2]")
    public WebElement lessonsMustNotEmptyMesaji;


    @FindBy (xpath = "//*[@class=\" css-19bb58m\"]")
    public WebElement teacherchooseLessons;

    @FindBy(xpath="//div[text()='Your birth place must consist of the characters .']")
    public WebElement birthPlaceWarningMessage;

    @FindBy(xpath="//div[text()='Your username should be at least 4 characters']")
    public WebElement userNameAlertMessage;







//yusuf bey(620-670)

















































    //ayhan bey(670-720)

















































    //gul hanim(720- )



}








