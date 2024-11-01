package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    //locators

    By FirstName_input = By.xpath("//input[@id='input-payment-firstname']");
    By LastName_input = By.xpath("//input[@name='lastname']");
    By  Address_input = By.xpath("//input[@id='input-payment-address-1']");
    By City_input = By.xpath("//input[@id='input-payment-city']");
    By PostalCode_input = By.xpath("//input[@id='input-payment-postcode']");
    By Country_input = By.xpath("//input[@id='input-payment-country']");
    @FindBy(id = "input-payment-zone")
    WebElement stateDropdown;

    By Continue_button =By.id("button-payment-address");
    @FindBy(id = "existing-address-radio")
    By Continue_Address= By.id("button-payment-address");

    private WebElement existingAddressRadioButton;

    // Method to select the "Use Existing Address" radio button
    public void selectExistingAddress() {
        existingAddressRadioButton.click();
    }


    public void selectState(String state){
        Select select = new Select(stateDropdown);
        select.selectByVisibleText(state);

    }
    public void EnterFirstName(String firstname){
        driver.findElement(FirstName_input).sendKeys(firstname);
    }

    public void EnterLastName(String lastname){
        driver.findElement(LastName_input).sendKeys(lastname);
    }
    public void EnterAddress(String address){
        driver.findElement(Address_input).sendKeys(address);
    }
    public void EnterCity(String city){
        driver.findElement(City_input).sendKeys(city);
    }
    public void EnterPostalCode(String postal){
        driver.findElement(PostalCode_input).sendKeys(postal);
    }
    public void EnterCountryName(String countryname){
        driver.findElement(Country_input).sendKeys(countryname);
    }
    public void clickContinue(){
        driver.findElement(Continue_button).click();
    }
    public void ContinueAdress(){
        driver.findElement(Continue_Address).click();
    }

}
