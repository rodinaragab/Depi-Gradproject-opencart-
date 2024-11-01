package Tests;

import Pages.TermsandConditionspages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Termsandconditions {
    WebDriver driver;
    TermsandConditionspages termsandConditionspages;

    @BeforeClass
    public void preconditions() {
        // Initialize EdgeDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        // Initialize the page objects
        termsandConditionspages = new TermsandConditionspages(driver);
    }

    @Test
    public void Open_terms_and_condition_page() {
        termsandConditionspages.clickon_termsandconditions();
    }

    @AfterClass
    public void tearDown() {
        // Close the browser after the tests are done
        if (driver != null) {
            driver.quit();
        }

    }
        }

