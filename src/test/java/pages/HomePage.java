package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HomePage {

    WebDriver driver ;
    public HomePage(WebDriver driver){this.driver = driver ;}
    @FindBy(css="li[data-cy= 'oneWayTrip']") WebElement trip_type_ONEWAY;
    @FindBy(css = "li[data-cy='account']") WebElement home_login_button;
    @FindBy(xpath = "//body" )WebElement blank_space;
//    @FindBy(xpath = "//ul[@class='specialFare']") WebElement fare_type_ul ;



    public String fare_type(){
       WebElement fare_type_ul = driver.findElement(By.xpath("//ul[@class='specialFare']"));
        //new WebDriverWait(driver,12).until(ExpectedConditions.visibilityOf(fare_type_ul));
        List<WebElement> fare_type_list = fare_type_ul.findElements(By.tagName("li"));
        String active_fare_type = "";
        for (WebElement fare_type:fare_type_list) {
//            System.out.println(fare_type.getText());
//            System.out.println(fare_type.getAttribute("class"));
                if (fare_type.getAttribute("class").contains("activeItem")){
                    active_fare_type = active_fare_type.concat(fare_type.getText()) ;
                    System.out.println(active_fare_type);
                }


        }

        return active_fare_type ;


    }



    public void select_trip_type(){


        trip_type_ONEWAY.click();

    }
    public boolean oneWay_is_selected_or_not(){
        //new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(trip_type_ONEWAY));
        return trip_type_ONEWAY.isEnabled();
    }
    public void blank_Click(){
        blank_space.click();

    }

    public void click_on_login(){
        window_handler("main");
        home_login_button.click();
    }

    public void window_handler(String window){
        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        if(window=="sub"){
            driver.switchTo().window(subWindowHandler); // switch to popup window
        }

// Now you are in the popup window, perform necessary actions here

        if (window=="main"){
            driver.switchTo().window(parentWindowHandler);  // switch back to parent window
        }
    }




}
