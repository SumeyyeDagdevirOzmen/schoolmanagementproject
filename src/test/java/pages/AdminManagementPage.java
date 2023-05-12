package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminManagementPage {
    public AdminManagementPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@placeholder='Name']")
    public WebElement name;
    @FindBy(xpath = "//*[@placeholder='Surname']")
    public WebElement surname;
    @FindBy(xpath = "//*[@placeholder='Birth Place']")
    public WebElement birthPlace;
    @FindBy(xpath = "//*[@id='birthDay']")
    public WebElement birthDay;
    @FindBy(xpath = "//*[@id='phoneNumber']")
    public WebElement phoneNumber;
    @FindBy(xpath = "//*[@placeholder='ssn']")
    public WebElement ssnNumber;
    @FindBy(xpath = "//*[@placeholder='username']")
    public WebElement userName;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;
    @FindBy(xpath = "//*[@value='FEMALE']")
    public WebElement gender;

    @FindBy(xpath = "//*[@class='fw-semibold btn btn-primary btn-lg']")
    public WebElement submit;




































    //dila hanim(70-120)

















































//faruk bey(120-170)
@FindBy(xpath = "(//*[text()='Required'])[1]")
    public WebElement nameRequired;
    @FindBy(xpath = "//*[@class='form-control']")
    public WebElement validbox;

    @FindBy(xpath = "(//*[text()='Required'])[2]")
    public WebElement surnameRequired;

    @FindBy(xpath = "(//*[text()='Required'])[3]")
    public WebElement birthplaceRequired;
    @FindBy(xpath = "(//*[text()='Required'])[4]")
    public WebElement birtdateRequired;

    @FindBy(xpath = "(//*[text()='Required'])[5]")
    public WebElement phonerequired;
    @FindBy(xpath = "(//*[text()='Required'])[6]")
    public WebElement Ssnrequired;
    @FindBy(xpath = "(//*[text()='Required'])[7]")
    public WebElement usernamerequired;
    @FindBy(xpath = "(//*[text()='Required'])[8]")
    public WebElement paswordrequired;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement hatamesaji;
    @FindBy(xpath = "//div[@class='Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']")
    public WebElement alert;
    @FindBy(xpath = "//div[text()='Minimum 12 character (XXX-XXX-XXXX)']")
    public WebElement min12HataMesaji;

    @FindBy(xpath = "//div[text()='Minimum 11 character (XXX-XX-XXXX)']")
    public WebElement min11HataMesaji;

    @FindBy(xpath = "//div[text()='Minimum 8 character']")
    public WebElement min8HataMesaji;

    @FindBy(xpath = "//div[contains(text(),'Please enter valid SSN number')]")
    public WebElement invalidSSNAlert;
    @FindBy(xpath = "//div[contains(text(),'Dean Saved')]")
    public WebElement deanSavedmessaji;

    @FindBy(xpath = "//span[.='3 January 2022']")
    public WebElement falsemessage;








    //fatma hanim(170-220)

















































//Firuzan hanim(220-270)

















































//zehra hanim(270-320)

















































//hatice hanim(320-370)

















































//havva hanim(370-420)

















































//kubra hanim(420-470)
@FindBy(xpath = "//*[text()='Required']")
   public WebElement alertRequired;
@FindBy(xpath = "//*[text()='Minimum 11 character (XXX-XX-XXXX)']")
    public WebElement ssnAlert;
@FindBy(xpath = "//*[text()='Minimum 8 character']")
    public WebElement passwordAlert;
@FindBy(xpath = "//div[text()='Admin Saved']")
    public WebElement adminSaved;
@FindBy(xpath = "//div[text()='Please enter valid SSN number']")
    public WebElement SsnAlert;
@FindBy(xpath = "(//*[@class='invalid-feedback'])[2]")
    public WebElement SurnameAlert;





































//nihal hanim(470-520)

















































//sevim hanim(520-570)

















































//sumeyye hanim(570-620)

















































//yusuf bey(620-670)

















































 //ayhan bey(670-720)

















































    //gul hanim(720- )


















}
