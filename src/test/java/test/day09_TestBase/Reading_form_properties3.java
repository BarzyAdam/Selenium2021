package test.day09_TestBase;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Reading_form_properties3 {
    //we created configuration.proprties under package name.and putted some key and value there

    @Test
    public void read_pro() throws IOException {
        //properties class object allows us to read from configuration.properties

        Properties properties=new Properties();

        //we need to show where the file is stored.
        //we need the path of the file
        String path="configuration.properties";

        //we need to open this configuration.pro file in java memory
        FileInputStream file=new FileInputStream(path);


        //we need to load the opened file into the properties object
        properties.load(file);// it needs exception

        //we can read the configuration.properties file using properties object
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));
        System.out.println("properties.getProperty(\"password\") = " + properties.getProperty("password"));
  //if you are getting any null ,you should check speling
    }
}
