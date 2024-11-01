package Tests;

import Pages.HomePage;
import Pages.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeTest {
    WebDriver driver;
    Login loginPage;
    HomePage homePage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");
        loginPage = new Login(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void testAddItemsToWishlist() {
        loginPage.enterEmail("ayayehya045@gmail.com");
        loginPage.enterPassword("Ayayehya#28");
        loginPage.clickLoginButton();
        homePage.navigateToHomePage();
        homePage.addItemsToWishlist();
        homePage.assertAddToWishlist();
    }

    @Test
    public void testAddItemToWishlist() {
        loginPage.enterEmail("ayayehya045@gmail.com");
        loginPage.enterPassword("Ayayehya#28");
        loginPage.clickLoginButton();
        homePage.navigateToHomePage();
        homePage.addItemToWishlist();
        homePage.assertAddToWish();
    }

    @Test
    public void assertAddTowWHISHListWithoutLogin()
    {
        homePage.navigateToHomePage();
        homePage.addItemsToWishlist();
        homePage.addToWishlistwithoutlogin();
    }

    @Test
    public void addTowWHISHListWithouttloginthenLogin()
    {
        homePage.navigateToHomePage();
        homePage.addItemsToWishlist();
        homePage.addToWishlistwithoutlogin();
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");
        loginPage.enterEmail("ayayehya045@gmail.com");
        loginPage.enterPassword("Ayayehya#28");
        loginPage.clickLoginButton();
        homePage.navigateToHomePage();
        homePage.assertaddtowishlistafterlogin();
    }

    @Test
    public void assertAddTowWHISHList()
    {
        homePage.navigateToHomePage();
        homePage.assertaddtowishlistbeforelogin();
        homePage.addItemsToWishlist();
        homePage.assertaddtowishlistafterlogin();
    }

    @Test
    public void assertAddToCompareList()
    {
        homePage.navigateToHomePage();
        homePage.addItemToCompareList();
    }

    @Test
    public void assertdAddToCompareList()
    {
        homePage.navigateToHomePage();
        homePage.addItemsToCompareList();
        homePage.diplaycomparelist();
    }

    @Test
    public void AddToCompareListwithlogin() {
        loginPage.enterEmail("ayayehya045@gmail.com");
        loginPage.enterPassword("Ayayehya#28");
        loginPage.clickLoginButton();
        homePage.navigateToHomePage();
        homePage.addItemToCompareList();
        homePage.diplaycomparelist();
    }
   @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
