package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
        By AddToCart1_button = By.xpath("//button[@onclick=\"cart.add('43');\"]");
        By AddToCart2_button = By.xpath("//button[@onclick=\"cart.add('40');\"]");
        By CartItems_button =  By.xpath("//div[@id='cart']/button[@data-toggle=\"dropdown\"]");
        By CartElement = By.xpath("//p[@class=\"text-right\"]/a[@href=\"https://awesomeqa.com/ui/index.php?route=checkout/cart\"]");

        By RemoveFromCart_button = By.xpath("//button[@title=\"Remove\"]");



        //methods
        public void navigateToHomePage(){
            driver.navigate()
                    .to("https://awesomeqa.com/ui/index.php?route=common/home");
        }
        public void navigateToProductPage(){
            driver.navigate()
                    .to("https://awesomeqa.com/ui/index.php?route=common/home");
        }
        public void addItem1ToCart(){

            driver.findElement(AddToCart1_button).click();
        }
      public void addItem2ToCart(){

        driver.findElement(AddToCart2_button).click();
          //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         // WebElement flashMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

    }


    public void viewCartElements(){
            driver.findElement(CartItems_button).click();
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // WebElement flashMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));



        }
        public void removeElementFromCart(){
            driver.findElement(RemoveFromCart_button).click();
        }
        public void wait(int duration){

            // Explicit wait - wait until the cart element is visible or clickable
           // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
           // wait.until(ExpectedConditions.visibilityOfElementLocated(CartElement));// Replace with actual element

        }
}
