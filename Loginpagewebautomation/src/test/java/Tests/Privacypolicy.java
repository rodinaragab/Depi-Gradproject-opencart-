package Tests;

import Pages.PrivacyPolicypage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Privacypolicy {
    WebDriver driver;
    PrivacyPolicypage privacyPolicypage;

    @BeforeClass
    public void preconditions() {
        // Initialize EdgeDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        // Initialize the page object
        privacyPolicypage = new PrivacyPolicypage(driver);
    }

    @Test
    public void Open_Privacy_Policy_page() {
        // Ensure the page is loaded before interacting with the Privacy Policy link
        privacyPolicypage.clickon_Privacy_Policy();
    }

    @AfterClass
    public void tearDown() {
        // Close the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }
}
