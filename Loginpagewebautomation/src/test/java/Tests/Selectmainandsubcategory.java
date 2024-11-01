package Tests;

import Pages.Account;
import Pages.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Selectmainandsubcategory {

        WebDriver driver;
        Account account;
        Login loginPage;

    @BeforeClass
    public void preconditions() {
        // Initialize EdgeDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        // Initialize the page objects
        account = new Account(driver);
        loginPage = new Login(driver);

    }
    @Test
    public void selectcategoryandsubcategory (){
        account.Clickoncategorydesktop();
        account.pc_subcategory();
        }

    @Test
    public void selectcategoryandanothersubcategory (){

        account.Clickoncategorydesktop();
        account.mac_subcategory();
    }

    @Test
    public void selectcategoryandsubcategorywithlogin (){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");
        loginPage.enterEmail("doaa.fahmi@gmail.com");
        loginPage.enterPassword("Asd@101094");
        loginPage.clickLoginButton();
        account.Clickoncategorydesktop();
        account.pc_subcategory();
    }

    @Test
    public void selectcategoryandanothersubcategorywithlogin (){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");
        loginPage.enterEmail("doaa.fahmi@gmail.com");
        loginPage.enterPassword("Asd@101094");
        loginPage.clickLoginButton();
        account.Clickoncategorydesktop();
        account.mac_subcategory();
    }

    @AfterClass
    public void tearDown() {
        // Close the browser after the tests are done
        if (driver != null) {
            driver.quit();
        }

    }

}
