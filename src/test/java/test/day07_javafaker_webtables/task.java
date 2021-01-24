package test.day07_javafaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;
/*
TC#3: Smartbear software order verification
1.Open browser and login to Smartbear software
2.Click on View all orders
3.Verify Susan McLaren has order on date “01/05/2010”
 */
public class task {
    WebDriver driver;
   @BeforeMethod
    public void setup(){
      driver= WebDriverFactory.getDriver("chrome") ;
      driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
       SmartBearUtilities.login(driver);
    }

    @Test
    public void method(){

        //2.Click on View all orders
        //3.Verify Susan McLaren has order on date “01/05/2010”
        WebElement date=driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));
        String actual=date.getText();
        String expect="01/05/2010";

        Assert.assertEquals(actual,expect);


    }
}
