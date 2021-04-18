package testCases;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import org.testng.annotations.Test;
import pages.BaseClass;
import pages.HomePage;
import pages.LoginBox;
import utility.ExcelDataProvider;

public class HomePageTest extends BaseClass {
    private HomePage homePage ;


    @Test
    public void selectOneWay(){
        ExcelDataProvider excelDataProvider = new ExcelDataProvider();
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        //homePage.window_handler("sub");
        homePage.click_on_login();
        homePage.oneWay_is_selected_or_not();
        Assert.assertEquals("REGULAR FARE",homePage.fare_type());
        System.out.println("Regular Fare Selected");
        Assert.assertEquals(true,homePage.oneWay_is_selected_or_not());
        System.out.println("One Way is Selected");


    }
}
