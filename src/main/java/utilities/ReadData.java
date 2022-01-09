package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadData {
    Properties pro;
    public  ReadData(){
        File file = new File("./configuration//userdata.properties");
        try {
            pro= new Properties();
            FileInputStream fis = new FileInputStream(file);
            pro.load(fis);

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public String getURL(){
        return  pro.getProperty("URL");
    }
    public String get_password(){
        return pro.getProperty("password");
    }
    public String get_browser(){
        return pro.getProperty("browser");
    }
    public String get_email(){
        return  pro.getProperty("email");
    }

}
