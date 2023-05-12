package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DeanManagementPage {
    public DeanManagementPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a [text()='Dean Management']")
    public WebElement DeanManagement;
     @FindBy(xpath= "//h5[text()='Dean List']")
    public WebElement DeanList;
    @FindBy (xpath = "//table[@class='table table-striped table-bordered table-hover']//thead//tr//th[1]")
    public WebElement Surname;
    @FindBy (xpath = "//table[@class='table table-striped table-bordered table-hover']//thead//tr//th[2]")
    public WebElement gender;
    @FindBy (xpath = "//table[@class='table table-striped table-bordered table-hover']//thead//tr//th[3]")
    public WebElement phoneNumber;
    @FindBy (xpath = "//table[@class='table table-striped table-bordered table-hover']//thead//tr//th[4]")
    public WebElement Ssn;
    @FindBy (xpath = "//table[@class='table table-striped table-bordered table-hover']//thead//tr//th[5]")
    public WebElement Username;
    @FindBy (xpath = "//button[@class='text-dark btn btn-outline-info']")
    public WebElement ilkEdit;
    @FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[15]/td[6]/span[1]/button[1]")
    public  WebElement edit;
    @FindBy(xpath = "//td//span[text()='JoeFeld']/following-sibling:://button[@xpath='1']")
    public WebElement JoEdit;
    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']//tbody//td//span[text()='JoeFeld']")
    public WebElement JoFeld;
    @FindBy(xpath = "//tbody/tr[1]/td[5]/span[1]")
    public WebElement ilkUserName;
    @FindBy(xpath = "//tbody/tr[1]/td[6]/span[1]/button[1]")
    public WebElement ilkedit;
    @FindBy(xpath = "//body/div[3]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]")
    public WebElement namespace;
    @FindBy(xpath = "//body/div[3]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]")
    public WebElement surnamespace;
    @FindBy(xpath = "//body/div[3]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/input[1]")
    public WebElement birthplace;
    @FindBy(xpath = "//body/div[3]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/input[1]")
    public WebElement genderFemale;
    @FindBy(xpath = "//div[@class='text-center border border-3 card border-warning']//input[@id='birthDay']")
    public WebElement birthday;
    @FindBy(xpath = "//body/div[3]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/input[1]")
    public WebElement phonenum;
    @FindBy(xpath = "//body/div[3]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/div[1]/input[1]")
    public WebElement ssnnum;
    @FindBy(xpath = "//body/div[3]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/input[1]")
    public WebElement usname;
    @FindBy(xpath = "//body/div[3]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[9]/div[1]/input[1]")
    public WebElement psswrd;
    @FindBy(xpath = "//body/div[3]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[10]/div[1]/button[1]")
    public WebElement subbuton;
    @FindBy(xpath = "//div[@id='2']")
    public WebElement basarimesaj;
    @FindBy(xpath = "//div[contains(@class,'text-center border border-3 card border-warning')]//div[contains(@class,'invalid-feedback')][normalize-space()='Required']")
    public WebElement passuyari;
    @FindBy(xpath = "//body/div[3]/div[1]/button[1]")
    public WebElement closebutton;
    @FindBy(xpath = "//body[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")
    public WebElement genderuyari;


    //dila hanim(70-120)

















































//faruk bey(120-170)

















































//fatma hanim(170-220)

















































//Firuzan hanim(220-270)

















































//zehra hanim(270-320)

















































//hatice hanim(320-370)

















































//havva hanim(370-420)
    @FindBy(xpath = "//button[text()='Menu']")
    public WebElement menuButonHava;
    @FindBy(xpath = "//a[text()='Contact Get All']")
    public WebElement contactGetAllHava;
    @FindBy(xpath = "(//table//tbody//tr//td[1])")
    public List<WebElement> nameHava;
    @FindBy(xpath = "(//table//tbody//tr//td[2])")
    public List<WebElement> emailHava;
    @FindBy(xpath = "(//table//tbody//tr//td[3])")
    public List<WebElement> dateHava;
    @FindBy(xpath = "(//table//tbody//tr//td[4])")
    public List<WebElement> subjectHava;
    @FindBy(xpath = "(//table//tbody//tr//td[5])")
    public List<WebElement> messageHava;
    @FindBy(xpath = "//h5[text()='Contact Message']")
    public WebElement contactMessageSayfasiHava;

































    //kubra hanim(420-470)

















































//nihal hanim(470-520)

















































//sevim hanim(520-570)

















































//sumeyye hanim(570-620)

















































//yusuf bey(620-670)
// Login Page bolumu

    @FindBy(css = "[class='header_link ms-2']")
    public WebElement homePaceLoginButton;   //Anasayfadaki login butonu

    @FindBy(css="[id='username']")
    public WebElement usernameBox;           //Anasayfadaki username kutusu

    @FindBy(css="[id='password']")
    public WebElement passwordBox;           //Anasayfadaki username kutusu

    @FindBy(css = "[class='fw-semibold btn btn-primary']")
    public WebElement loginButton;           //Giris bolumu Login butonu

    // Vice Dean bolumu

    @FindBy(css = "[class='fw-semibold text-white bg-primary navbar-toggler collapsed']")
    public WebElement viceDeanMenuButton;    //Vice Dean menu buttonu

    @FindBy(xpath = "(//*[@class='nav-link'])[6]")
    public WebElement viceDeanButton;        //Vice Dean butonu

    @FindBy(css = "[id='name']")
    public WebElement nameButton;          // Name butonu ve digerlerinin giris kismi

    @FindBy(css = "[class='fw-semibold btn btn-primary btn-lg']")
    public WebElement submitButton;        //Submit butonu

    //Olusturulamadigini Dogrulama
    @FindBy(xpath = "//div[contains(text(),'Guest User deleted Successful')] ")
    public WebElement dogrulamaBolumuNegatif;

    //Olusturuldugunu dogrulama
    @FindBy(xpath = "//div[text()='Vice dean Saved'] ")
    public WebElement dogrulamaPozitif;














//ayhan bey(670-720)

















































        //gul hanim(720- )


















    }


