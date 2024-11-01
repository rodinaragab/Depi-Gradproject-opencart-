package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ComparePage {

    WebDriver driver;

    // Constructor
    public ComparePage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By compare_list=By.xpath("//a[@href='https://awesomeqa.com/ui/index.php?route=product/compare']");
    By compare_element=By.xpath("//a[@href='https://awesomeqa.com/ui/index.php?route=product/product&product_id=43']");
    By delete_element=By.xpath("//a[@class='btn btn-danger btn-block']");

    //Methods
    public void assertAddElementToCompareList() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(compare_list));
        driver.findElement(compare_list).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(compare_element));
        Assert.assertTrue(driver.findElement(compare_element).isDisplayed());
    }

    public void clearCompareList()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(delete_element));
        driver.findElement(delete_element).click();
    }
}
