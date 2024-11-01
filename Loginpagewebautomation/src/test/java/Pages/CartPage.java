package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    By quantity_input = By.xpath("//input[contains(@name, 'quantity')]");
    By Refresh_button = By.xpath("//button[@data-original-title='Update']");
    By Remove_button = By.xpath("//button[@data-original-title='Remove']");
    By Chechout_button = By.xpath("//a[contains(text() ,'Checkout')]");
    //methods
    public void navigateToCartPage(){
        driver.navigate()
                .to("https://awesomeqa.com/ui/index.php?route=checkout/cart");
    }
    public void updateQuantity(){
        driver.findElement(quantity_input).clear();
        driver.findElement(quantity_input).sendKeys("2");
        driver.findElement(Refresh_button).click();
    }
    public void removeItemFromCart(){

        driver.findElement(Remove_button).click();
    }
    public void checkout(){
        driver.findElement(Chechout_button).click();
    }





}
