package Tests;

import Pages.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    Login loginPage;


    @BeforeMethod
    public void preconditions()
    {
        loginPage = new Login(driver);
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");
    }

    @Test(priority = 0)
    public void testLoginWithValidCredentials() {

        loginPage.enterEmail("doaa.fahmi@gmail.com");
        loginPage.enterPassword("Asd@101094");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isAccountDisplayed(), "My Account");
    }

    //Verify that login fails with an unregistered email
    @Test(priority = 1)
    public void testLoginWithInvalidCredentials() {
        loginPage.enterEmail("basma.fahmi@gmail.com");
        loginPage.enterPassword("Asd@101094");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isWarningMessageDisplayed(), "Warning: No match for E-Mail Address and/or Password.");
    }

    @Test(priority = 2)
// Verify login fails with a valid email and incorrect password
    public void testLoginWithInvalidCredentials2() {
        // Enter invalid credentials
        loginPage.enterEmail("doaa.fahmi@gmail.com"); /* Valid email */
        loginPage.enterPassword("Bsd@101094"); // Invalid password

        // Click the login button
        loginPage.clickLoginButton();

        // Assert that the warning message is displayed
        Assert.assertTrue(loginPage.isWarningMessageDisplayed(), "Warning: No match for E-Mail Address and/or Password.");
    }

    @Test(priority = 3)
// Verify that login fails if no password is entered
    public void testLoginWithInvalidCredentials3() {
        // Enter the email
        loginPage.enterEmail("doaa.fahmi@gmail.com"); // Valid email
        // Click the login button
        loginPage.clickLoginButton();

        // Assert that the warning message is displayed
        Assert.assertTrue(loginPage.isWarningMessageDisplayed(), "Warning: No match for E-Mail Address and/or Password.");
    }

    @Test(priority = 4)
// Verify that the account is locked after several failed login attempts
    public void testLoginWithInvalidCredentials4() {
        // Attempt to log in with invalid credentials 5 times
        // Clear the input fields before each attempt
        loginPage.clearEmailField();
        loginPage.clearPasswordField();

        // Enter valid email and incorrect password
        loginPage.enterEmail("doaa.fahmi@gmail.com");
        loginPage.enterPassword("Bsd@101094"); // Use incorrect password
// Click the login button
        loginPage.clickLoginButton();

        // Assert that the warning message is displayed after each attempt
        Assert.assertTrue(loginPage.isWarningMessageDisplayed(),
                "Attempt " + (0 + 1) + ": Warning: No match for E-Mail Address and/or Password.");
        // Clear the input fields before each attempt
        loginPage.clearEmailField();
        loginPage.clearPasswordField();

        // Enter valid email and incorrect password
        loginPage.enterEmail("doaa.fahmi@gmail.com");
        loginPage.enterPassword("Bsd@101094"); // Use incorrect password
// Click the login button
        loginPage.clickLoginButton();

        // Assert that the warning message is displayed after each attempt
        Assert.assertTrue(loginPage.isWarningMessageDisplayed(),
                "Attempt " + (1 + 1) + ": Warning: No match for E-Mail Address and/or Password.");
        // Clear the input fields before each attempt
        loginPage.clearEmailField();
        loginPage.clearPasswordField();

        // Enter valid email and incorrect password
        loginPage.enterEmail("doaa.fahmi@gmail.com");
        loginPage.enterPassword("Bsd@101094"); // Use incorrect password
// Click the login button
        loginPage.clickLoginButton();

        // Assert that the warning message is displayed after each attempt
        Assert.assertTrue(loginPage.isWarningMessageDisplayed(),
                "Attempt " + (2 + 1) + ": Warning: No match for E-Mail Address and/or Password.");
        // Clear the input fields before each attempt
        loginPage.clearEmailField();
        loginPage.clearPasswordField();

        // Enter valid email and incorrect password
        loginPage.enterEmail("doaa.fahmi@gmail.com");
        loginPage.enterPassword("Bsd@101094"); // Use incorrect password
// Click the login button
        loginPage.clickLoginButton();

        // Assert that the warning message is displayed after each attempt
        Assert.assertTrue(loginPage.isWarningMessageDisplayed(),
                "Attempt " + (3 + 1) + ": Warning: No match for E-Mail Address and/or Password.");
        // Clear the input fields before each attempt
        loginPage.clearEmailField();
        loginPage.clearPasswordField();

        // Enter valid email and incorrect password
        loginPage.enterEmail("doaa.fahmi@gmail.com");
        loginPage.enterPassword("Bsd@101094"); // Use incorrect password
// Click the login button
        loginPage.clickLoginButton();

        // Assert that the warning message is displayed after each attempt
        Assert.assertTrue(loginPage.isWarningMessageDisplayed(),
                "Attempt " + (4 + 1) + ": Warning: No match for E-Mail Address and/or Password.");

        // Check if the account lock message is displayed after the 5th failed attempt
        Assert.assertTrue(loginPage.isAccountLockMessageDisplayed(),
                "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.");
    }

}
