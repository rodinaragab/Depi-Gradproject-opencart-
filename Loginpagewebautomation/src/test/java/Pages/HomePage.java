package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;
    int numberOfWishelements;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By wish_buttons=By.xpath("//button[@data-original-title='Add to Wish List']");
    By wish_button=By.xpath("//button[@onclick=\"wishlist.add('43');\"]");
    By total_wish1=By.xpath("//a[@title='Wish List (0)']");
    By total_wish2=By.xpath("//a[@title='Wish List (4)']");
    By compare_element1=By.xpath("//button[@onclick=\"compare.add('43');\"]");
    By compare_element2=By.xpath("//button[@onclick=\"compare.add('30');\"]");
    By compare_element3=By.xpath("//button[@onclick=\"compare.add('40');\"]");
    By compare_element4=By.xpath("//button[@onclick=\"compare.add('42');\"]");
    By sucess_add=By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By asktologinmessage=By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By compare_list=By.xpath("//a[@href='https://awesomeqa.com/ui/index.php?route=product/compare']");
    By search_textbox=By.xpath("//input[@name='search']");
    By search_button=By.xpath("//i[@class=\"fa fa-search\"]");

    @BeforeClass
    public void navigateToHomePage() {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");
    }

    // Methods

    public int addItemsToWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate all wishlist buttons
        List<WebElement> wishlistButtons = driver.findElements(wish_buttons);
        numberOfWishelements = wishlistButtons.size();

        for (WebElement button : wishlistButtons) {
            try {
                // Scroll the button into view to ensure it's visible
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

                // Wait for the button to be clickable (prevent interception)
                wait.until(ExpectedConditions.elementToBeClickable(button));

                // Click the button using JavaScript to avoid interception issues
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

                // Optionally, add a small delay between clicks if needed
                Thread.sleep(500);  // 500 milliseconds delay
            } catch (ElementClickInterceptedException e) {
                System.out.println("Element click intercepted, retrying...");
                // You can attempt additional handling here, such as retrying or logging the error
            } catch (InterruptedException e) {
                e.printStackTrace();  // Handle InterruptedException from Thread.sleep
            }
        }

        return numberOfWishelements;
    }


    public void addItemToWishlist() {
        driver.findElement(wish_button).click();
    }

    public void assertAddToWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(sucess_add));
        Assert.assertTrue(successAlert.isDisplayed());
    }

    public void assertAddToWish() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(sucess_add));
        Assert.assertTrue(successAlert.getText().contains("Success: You have added MacBook to your wish list!"));
    }
    public void search()
    {
        driver.findElement(search_textbox).sendKeys("canon");
        driver.findElement(search_button).click();}

    public void addItemToCompareList() {
        driver.findElement(compare_element1).click();
    }

    public void addItemsToCompareList() {

        driver.findElement(compare_element1).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(compare_element2));
        driver.findElement(compare_element2).click();
        driver.findElement(compare_element3).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(compare_element4));
        driver.findElement(compare_element4).click();
    }

    public void addToWishlistwithoutlogin()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(asktologinmessage));
        Assert.assertTrue(successAlert.isDisplayed());
        Assert.assertTrue(successAlert.getText()
                .contains("You must login or create an account to save"));
    }

    public void assertaddtowishlistbeforelogin()
    {
        driver.findElement(total_wish1);
    }

    public void assertaddtowishlistafterlogin()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(total_wish2));
        driver.findElement(total_wish2);
    }

    public void diplaycomparelist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(compare_list));
        Assert.assertTrue(driver.findElement(compare_list).isDisplayed());
    }

}