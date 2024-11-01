package Tests;

import Pages.AboutUspage;
import Pages.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Aboutus {
    WebDriver driver;
    AboutUspage aboutUspage;
    Login loginPage;

    @BeforeClass
    public void preconditions() {
        // Initialize EdgeDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        // Initialize the page objects
        aboutUspage = new AboutUspage(driver);
        loginPage = new Login(driver);
    }

    // Test with login
    @Test
    public void Open_aboutus_page() {
        // Login and navigate to the About Us page
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");
        loginPage.enterEmail("doaa.fahmi@gmail.com");
        loginPage.enterPassword("Asd@101094");
        loginPage.clickLoginButton();
        aboutUspage.clickon_aboutus();
    }

    // Test without login
    @Test
    public void Open_aboutus_page_without_login() {
        // Navigate directly to the About Us page without logging in
        aboutUspage.clickon_aboutus();
    }

    @AfterClass
    public void tearDown() {
        // Close the browser after the tests are done
        if (driver != null) {
            driver.quit();
        }
    }
}
