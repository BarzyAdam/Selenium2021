package utilities;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configurationReader {
    //1- we created properties object
    private static Properties properties = new Properties();


    static {


        //2- get the path and store in String, or directly pass into fileInputStream obj
        String path = "configuration.properties";

        //3- we need to open the file
        try {


            FileInputStream file = new FileInputStream(path);

            //4- we need to load the file
            properties.load(file);
            //5- close.file
            file.close();

        }catch (IOException e){
            System.out.println("Properties file not found.");
        }


    }
    public static String getproperty(String keyword){
        return properties.getProperty(keyword);//that .getProperty come frome java.utilities and we used same name for it

    }

    @Test
    public void using_configuration_reader_utilities(){
        String browser= configurationReader.getproperty("browser");
        System.out.println("browser= "+browser);

        String username=configurationReader.getproperty("username");
        System.out.println("username = "+username);
    }
}
