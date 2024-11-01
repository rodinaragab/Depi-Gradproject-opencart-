package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TermsandConditionspages {

    WebDriver driver;


    public TermsandConditionspages(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    By success=By.id("content");
    By select_terms_conditions = By.xpath("//a[@href=\"https://awesomeqa.com/ui/index.php?route=information/information&information_id=5\"]");


    //methods
    public  void clickon_termsandconditions () {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=information/information&information_id=5");
        driver.findElement(select_terms_conditions).click();
        WebElement successElement = driver.findElement(success);
        Assert.assertTrue(successElement.getText().contains("Terms & Conditions"),"this is display on page ");

    }

}

