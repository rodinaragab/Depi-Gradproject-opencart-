package Tests;

import Pages.Login;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AddToCartTest {
    WebDriver driver;
    Login loginPage;
    ProductsPage productsPage;


    @BeforeClass
    public void preconditions(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage =new Login(driver);
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");
        loginPage.enterEmail("pusizi@mailinator.com");
        loginPage.enterPassword("123456789");
        loginPage.clickLoginButton();
        productsPage = new ProductsPage(driver);



    }
    @Test
    public void validateVisitorAddProduct(){
        productsPage.navigateToHomePage();
        productsPage.addItem1ToCart();

    }
    @Test
    public void validateAddMultipleProduct(){
        productsPage.navigateToHomePage();
        productsPage.addItem1ToCart();
        productsPage.addItem2ToCart();
        productsPage.viewCartElements();
    }
    @Test
    public void validateVisitorRemoveProductsFromCart(){
        productsPage.removeElementFromCart();
    }

}
