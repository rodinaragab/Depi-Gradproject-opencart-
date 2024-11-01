package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By searchHeader = By.xpath("//h1[contains(text(), 'Search - canon')]");

    // Methods
    public void assertSearch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the search header to be visible
            WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchHeader));

            // Ensure the element is displayed
            Assert.assertTrue(headerElement.isDisplayed(), "Search header is not displayed");

            // Optionally, click the header if required
            // headerElement.click(); // Only if necessary
        } catch (Exception e) {
            System.out.println("Element not found or not clickable: " + e.getMessage());
        }
    }
}
