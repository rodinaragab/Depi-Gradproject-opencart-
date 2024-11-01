package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    public WebDriver   driver;

    // Constructor to initialize the WebDriver
    public Login(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the email input field
    public By emailInput = By.id("input-email");

    // Locator for the password input field
    public By passwordInput = By.id("input-password");

    // Locator for the login button
    public By loginButton = By.xpath("//*[@id='content']/div/div[2]/div/form/input");

    // Locator for the warning message
    public By warningMessage = By.xpath("//*[@id='account-login']/div[1]/i");

    // Locator for the account element
    public By accountElement = By.xpath("//*[@id='column-right']/div/a[1]");

    // Method to enter email
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    // Method to enter password
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    // Method to click the login button
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Method to check if the account element is displayed
    public boolean isAccountDisplayed() {
        return driver.findElement(accountElement).isDisplayed();
    }

    // Method to check for the warning message
    public boolean isWarningMessageDisplayed() {
        return driver.findElement(warningMessage).isDisplayed();
    }

    // Method to clear input fields
    public void clearInputs() {
        driver.findElement(emailInput).clear();
        driver.findElement(passwordInput).clear();
    }
    
    public void clearEmailField() {
        driver.findElement(By.id("input-email")).clear();
    }

    public void clearPasswordField() {
        driver.findElement(By.id("input-password")).clear();
    }

    public boolean isAccountLockMessageDisplayed() {
        try {
            // Locate the account lock message element
            WebElement accountLockMessage = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]"));
            // Return true if the message is displayed
            return accountLockMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            // If the message is not found, return false
            return false;
        }
    }
}
