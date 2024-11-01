package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PrivacyPolicypage {
    WebDriver driver;


    public PrivacyPolicypage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    By select_Privacy_Policy = By.xpath("//a[@href=\"https://awesomeqa.com/ui/index.php?route=information/information&information_id=3\"]");
    By success=By.id("content");


    //Methods
    public  void clickon_Privacy_Policy () {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/account");
        driver.findElement(select_Privacy_Policy).click();
        WebElement successElement = driver.findElement(success);
        Assert.assertTrue(successElement.getText().contains("Privacy Policy"),"this is display on page ");
    }
}
