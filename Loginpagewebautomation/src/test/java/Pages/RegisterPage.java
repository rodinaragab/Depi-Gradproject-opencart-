package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;

    // Constructor to initialize WebElements
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements
    @FindBy(id = "input-firstname")
    WebElement firstName;

    @FindBy(id = "input-lastname")
    WebElement lastName;

    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(id = "input-telephone")
    WebElement phone;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(id = "input-confirm")
    WebElement passwordConfirm;

    @FindBy(name = "agree")
    WebElement privacyPolicyCheckbox;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    public RegisterPage() {

    }

    // Methods for interactions
    public void enterFirstName(String fname) {
        firstName.sendKeys(fname);
    }

    public void enterLastName(String lname) {
        lastName.sendKeys(lname);
    }

    public void enterEmail(String emailInput) {
        email.sendKeys(emailInput);
    }

    public void enterPhone(String phoneInput) {
        phone.sendKeys(phoneInput);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void confirmPassword(String confirmPass) {
        passwordConfirm.sendKeys(confirmPass);
    }

    public void agreeToPrivacyPolicy() {
        privacyPolicyCheckbox.click();
    }

    public void clickContinue() {
        continueButton.click();
    }
}
