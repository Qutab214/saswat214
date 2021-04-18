package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginBox  {
    WebDriver driver ;
    public LoginBox(WebDriver driver){
        this.driver = driver ;
    }

    @FindBy(id="username") WebElement username_input ;
    @FindBy(css="button[data-cy='continueBtn']") WebElement continue_button ;


    public String username_input_box_placeholder(){
        return username_input.getAttribute("placeholder");
    }

    public void enter_username(String username){
        //new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(username_input));


        username_input.sendKeys(username);

    }



    public boolean continue_button_enabled_or_not(){
//        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-cy='continueBtn']")));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        if (continue_button.isEnabled()){
            return true ;
        }
        else {
            return false ;
        }
    }

    public void click_on_continue(){
        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-cy='continueBtn']")));
            continue_button.click();

    }
}
