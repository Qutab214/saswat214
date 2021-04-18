package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    //screenshot,alerts,frames,windows,Sync issue,java script executor

    public static void captureScreenshot(WebDriver driver){

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(src,new File("./Screenshots/"+ get_current_date_time() +"LoginBox.png"));
            System.out.println("Screenshot captured successfully");
        } catch (IOException e) {
            System.out.println("Not able to take screenshot"+e.getMessage());
        }
    }

    public static String get_current_date_time(){
        DateFormat coustm_format = new SimpleDateFormat("mm_dd_yyyy_HH_mm_ss");
        Date current_date = new Date();
        return coustm_format.format(current_date);
    }
}
