package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Contactuspage {
    WebDriver driver;


    public Contactuspage(WebDriver driver) {
        this.driver = driver;
    }

    public Contactuspage navigate(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=information/contact/success");
        return new Contactuspage(driver);
    }
//locators
    By select_contact_us= By.xpath("//a[@href=\"https://awesomeqa.com/ui/index.php?route=information/contact\"]");
    By success=By.id("content");
    By your_name = By.id("input-name");
    By EMail_Address=By.id("input-email");
    By Enquiry = By.id("input-enquiry");
    By submit= By.xpath("//input[@class=\"btn btn-primary\"]");

    //methods
    public  void clickon_contactus () {
        driver.findElement(select_contact_us).click();
    }

    public void Enteryourname (String yourname) {
        driver.findElement(your_name).sendKeys(yourname);
    }
    public void EnterEmail (String email){
        driver.findElement(EMail_Address).sendKeys(email);
    }
    public void EnterEnquiry (String enquiry){
        driver.findElement(Enquiry).sendKeys(enquiry);
    }

    public void ClicksubmitButton (){
        driver.findElement(submit).click();
        WebElement successElement = driver.findElement(success);
        Assert.assertTrue(successElement.getText().contains("Your enquiry has been successfully sent to the store owner!"),"this is display on page ");
    }




}
