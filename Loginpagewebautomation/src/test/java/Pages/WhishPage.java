package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WhishPage {

    WebDriver driver;

    public WhishPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By wish_button=By.xpath("//a[@href='https://awesomeqa.com/ui/index.php?route=account/wishlist']");
    By wish_listbuttons=By.xpath("//td[@class='text-center']");
    By empty_message=By.xpath("//p[text()='Your wish list is empty.']");

    //Methods
    public int numberofelements() {
        driver.findElement(wish_button).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(wish_listbuttons));
        List<WebElement> wishlistButtons = driver.findElements(wish_listbuttons);
        int numberOfWishelements = wishlistButtons.size();
        return numberOfWishelements - 1;
    }

    public WhishPage navigateToWhishList() {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/wishlist");
        return this;
    }

    public void emptywishlist()
    {
        driver.findElement(empty_message);
    }

    public void assertelement()
    {
        Assert.assertTrue(driver.findElement(wish_button).isDisplayed());
    }

}
