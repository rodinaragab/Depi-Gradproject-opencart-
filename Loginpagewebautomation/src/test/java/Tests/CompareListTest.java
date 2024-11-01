package Tests;

import Pages.ComparePage;
import Pages.HomePage;
import Pages.Login;
import Pages.WhishPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CompareListTest {

    WebDriver driver;
    Login loginPage;
    HomePage homePage;
    WhishPage whishPage;
    ComparePage comparePage;

    @BeforeClass
    public void setup() {
        driver = new EdgeDriver();
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");
        driver.manage().window().maximize();
        loginPage = new Login(driver);
        homePage = new HomePage(driver);
        whishPage = new WhishPage(driver);
        comparePage = new ComparePage(driver);
    }

    @Test
    public void assertAddToCompareList()
    {
        homePage.navigateToHomePage();
        homePage.addItemToCompareList();
        comparePage.assertAddElementToCompareList();
    }

    @Test
    public void makeCompareListEmpty()
    {
        homePage.navigateToHomePage();
        homePage.addItemToCompareList();
        comparePage.assertAddElementToCompareList();
        comparePage.clearCompareList();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}