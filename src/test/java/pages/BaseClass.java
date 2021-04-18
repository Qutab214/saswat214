package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utility.ConfigDataProvider;
import utility.DriverFactory;
import utility.ExcelDataProvider;
import utility.Helper;

import java.io.IOException;

public class BaseClass  {

    public WebDriver driver;
    public ExcelDataProvider excelDataProvider;
    public ConfigDataProvider configDataProvider ;


    @BeforeSuite
    public void setUpSite() {


        excelDataProvider = new ExcelDataProvider();

    }

    @BeforeClass
    public void setup() {
        configDataProvider = new ConfigDataProvider();
        driver = DriverFactory.startApplication(driver, configDataProvider.getStagingURL());


    }

    @AfterClass
    public void tearDown() {
        DriverFactory.closeDriver(driver);
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Helper.captureScreenshot(driver);
        }
    }
}
