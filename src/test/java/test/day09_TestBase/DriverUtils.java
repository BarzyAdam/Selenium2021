package test.day09_TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver09;
import utilities.configurationReader;


public class DriverUtils {

    @Test
    public void driver_prac(){
        Driver09.getDriver().get("https://www.google.com");

        WebElement googleSearch=Driver09.getDriver().findElement(By.name("q"));
        googleSearch.sendKeys(configurationReader.getproperty("testdata") + Keys.ENTER);
   //why we created those steps just for writing apple?if I wanna change the browser or apple anything
        //we can just change from configuration.properties file ,so we dont need change from 100 place
    }
}
