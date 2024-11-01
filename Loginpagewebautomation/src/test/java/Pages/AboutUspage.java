package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AboutUspage {

        WebDriver driver;
        public AboutUspage(WebDriver driver) {
            this.driver = driver;
        }


        //LOCATORS
         private By select_about_us = By.xpath("//a[@href=\"https://awesomeqa.com/ui/index.php?route=information/information&information_id=4\"]");
        private By success=By.id("content");


    //methods
    public  void clickon_aboutus (){
        driver.findElement(select_about_us).click();
        WebElement successElement = driver.findElement(success);
        Assert.assertTrue(successElement.getText().contains("About Us"),"this is display on page ");
    }
}
