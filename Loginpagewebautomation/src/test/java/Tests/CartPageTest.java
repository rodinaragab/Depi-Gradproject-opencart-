package Tests;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.Login;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CartPageTest {
    WebDriver driver;
    CartPage cartPage;
    Login loginPage;
    CheckoutPage checkoutPage;
    ProductsPage productsPage;


        @BeforeClass
        public void preconditions(){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            loginPage =new Login(driver);
            cartPage = new CartPage(driver);
            driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");
            loginPage.enterEmail("pusizi@mailinator.com");
            loginPage.enterPassword("123456789");
            loginPage.clickLoginButton();
            cartPage.navigateToCartPage();
            checkoutPage = new CheckoutPage(driver);
            productsPage = new ProductsPage(driver);

        }
    @Test
    public void validateAddProduct(){
        productsPage.navigateToHomePage();
        productsPage.addItem1ToCart();
        productsPage.viewCartElements();
    }
    @Test
    public void validateaddMultipleProduct(){
        productsPage.navigateToHomePage();
        productsPage.addItem1ToCart();
        productsPage.addItem2ToCart();
        productsPage.viewCartElements();
    }
    @Test
    public void validateRemoveProductsFromCart(){
        productsPage.removeElementFromCart();
    }

    @Test
        public void validatechangequantity(){

            cartPage.updateQuantity();
        }
        @Test
    public void validateRemoveItem(){

            cartPage.removeItemFromCart();
        }
        @Test
    public void checkout(){
            cartPage.checkout();
        }






}
