package Tests;

import Pages.DeliveryInformationpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Deliveryinformationpage {
    WebDriver driver;
    DeliveryInformationpage deliveryInformationpage;

    @BeforeClass
    public void preconditions() {
        // Initialize EdgeDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        deliveryInformationpage = new DeliveryInformationpage(driver);
    }
    @Test
    public void Open_delivery_information_page(){

        deliveryInformationpage.clickon_deliveryinfo();

    }
    @AfterClass
    public void tearDown() {
        // Close the browser after the tests are done
        if (driver != null) {
            driver.quit();
        }

    }
}
