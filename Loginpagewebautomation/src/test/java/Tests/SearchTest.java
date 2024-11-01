package Tests;

import Pages.HomePage;
import Pages.Login;
import Pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest {
    WebDriver driver;
    Login loginPage;
    HomePage homePage;
    SearchPage searchPage;

    @BeforeClass
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");
        loginPage = new Login(driver);
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test
    public void search() {
        homePage.search();
        searchPage.assertSearch();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}