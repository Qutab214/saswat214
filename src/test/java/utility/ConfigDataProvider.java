package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
    Properties properties ;

    public ConfigDataProvider() {
        File src = new File("./Config/Config.properties");

        FileInputStream fileInputStream ;
        try {
            fileInputStream = new FileInputStream(src);
            properties = new Properties();
            properties.load(fileInputStream);

        } catch (Exception e) {
            System.out.println("Not able to load config file"+ e.getMessage());

        }



    }

   /* public String getDataFromConfig(String key){
        return properties.getProperty(key);
    }*/

    /*public String getBrowser(){
        return properties.getProperty("Browser");
    }*/
    public String getStagingURL(){
        return properties.getProperty("qaurl");
    }
}
