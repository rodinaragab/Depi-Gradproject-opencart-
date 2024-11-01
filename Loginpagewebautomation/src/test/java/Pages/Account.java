package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Account {
    WebDriver driver;


    public Account(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
   private By choose_currency = By.xpath("//span[@class='hidden-xs hidden-sm hidden-md']");  // Locator for dropdown click
    private By euroOption = By.xpath("//button[@name='EUR']");  // Locator for Euro option
    private By dollarOption = By.xpath("//button[@name='USD']");  // Locator for Dollar option
    private By poundsterlingOption = By.xpath("//button[@name='GBP']");  // Locator for Pound Sterling option
    private By choose_desktop = By.xpath("//a[@href='https://awesomeqa.com/ui/index.php?route=product/category&path=20']");
    private By choose_subcatrgory_pc =By.xpath("//a[@href='https://awesomeqa.com/ui/index.php?route=product/category&path=20_26']");
    private By choose_subcatrgory_mac =By.xpath("//a[@href=\"https://awesomeqa.com/ui/index.php?route=product/category&path=20_27\"]");
    private By suceessdollarsign = By.xpath("//span[@class=\"price-tax\"]");
    private By successpoundsterlingsign= By.xpath("//span[@class=\"price-tax\"]");
    private By successeurosign= By.xpath("//span[@class=\"price-tax\"]");





    // Method
    public void clickOnCurrency() {
        // Wait until the currency dropdown is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7020));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(choose_currency));
        dropdown.click();  // Click the dropdown to reveal options
        // Click the dropdown to reveal options

        try {
            // Pause for 20 seconds to allow you to visually inspect the dropdown
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void selectEuro() {
        clickOnCurrency();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7020));
        wait.until(ExpectedConditions.elementToBeClickable(euroOption)).click();  // Click on Euro option
    }

    public void selectDollar() {
        clickOnCurrency();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7020));
        wait.until(ExpectedConditions.elementToBeClickable(dollarOption)).click();  // Click on Dollar option
    }

    public void selectPoundSterling() {
        clickOnCurrency();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7020));
        wait.until(ExpectedConditions.elementToBeClickable(poundsterlingOption)).click();  // Click on Pound Sterling option
    }


    // asseration by taxprice
    public void virefydollarsignonanyproduct(){
        WebElement priceElement = driver.findElement(suceessdollarsign);

        Assert.assertTrue(priceElement.getText().contains("Ex Tax: $100.00"),"this is dollar sign");

    }
    public void virefypoundsterlingsignonanyproduct(){
        WebElement priceElement = driver.findElement(successpoundsterlingsign);

        Assert.assertTrue(priceElement.getText().contains("Ex Tax: £61.25"),"this is poundsterling sign");

    }

    public void virefyeurosignonanyproduct(){
        WebElement priceElement = driver.findElement(successeurosign);

        Assert.assertTrue(priceElement.getText().contains("Ex Tax: 78.46€"),"this is euro sign");

    }

    public void Clickoncategorydesktop(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/account");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7888));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(choose_desktop));
        dropdown.click();  // Click the dropdown to reveal options
        // Click the dropdown to reveal options

        try {
            // Pause for 20 seconds to allow you to visually inspect the dropdown
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void pc_subcategory (){

        Clickoncategorydesktop();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7020));
        wait.until(ExpectedConditions.elementToBeClickable(choose_subcatrgory_pc)).click();
    }

    public void mac_subcategory (){

        Clickoncategorydesktop();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7020));
        wait.until(ExpectedConditions.elementToBeClickable(choose_subcatrgory_mac)).click();
    }


}
