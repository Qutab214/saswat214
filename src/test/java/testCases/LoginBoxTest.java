package testCases;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.HomePage;
import pages.LoginBox;

import java.util.concurrent.TimeUnit;

public class LoginBoxTest extends BaseClass {


    @Ignore
    public void login(){

        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        LoginBox loginBox = PageFactory.initElements(driver,LoginBox.class);
        homePage.window_handler("main");


        homePage.click_on_login();


        loginBox.enter_username(excelDataProvider.getStringData("Login",0,0));
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        Assert.assertEquals(true,loginBox.continue_button_enabled_or_not());


    }
}
