package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DeliveryInformationpage {
    WebDriver driver;


    public DeliveryInformationpage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    By success=By.id("content");
    By select_delivery_information = By.xpath("//a[@href=\"https://awesomeqa.com/ui/index.php?route=information/information&information_id=6\"]");

    //methods
    public  void clickon_deliveryinfo () {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/account");
        driver.findElement(select_delivery_information).click();
        WebElement successElement = driver.findElement(success);
        Assert.assertTrue(successElement.getText().contains("Delivery Information"),"this is display on page ");
    }
}
