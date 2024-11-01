package Tests;
import Pages.Login;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    public static WebDriver driver;
    ExtentReports extent;
    ExtentTest test;
    @BeforeSuite
    public void setUpExtent() {
        extent = ExtentManager.getInstance(); // Initialize Extent Reports

    }
    @BeforeMethod
    public void init(Method method) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Create a test node in Extent Report
        test = extent.createTest(method.getName());
        // Log test steps in Extent
        test.log(Status.INFO, "Filling in registration details");
    }

    @AfterMethod
    public void postconditions() {
        driver.close();
    }

    @AfterSuite
    public void flush()
    {
        extent.flush();
    }
}