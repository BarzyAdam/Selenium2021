package test.day07_javafaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
TC #1: Smartbear software link verification
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: "Tester"
4. Enter password: "test"
5. Click to Login button
6. Print out count of all the links on landing page
7. Print out each link text on this page
 */
public class C_TAsk_SmartBear {
    WebDriver driver;
    @BeforeMethod
    public void Setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
    }
    @Test
    public void method1() throws InterruptedException{
        Thread.sleep(2000);
        WebElement user=driver.findElement(By.xpath("//input[@type='text']"));
        user.sendKeys("Tester");
        Thread.sleep(2000);
        WebElement pass=driver.findElement(By.xpath("//input[@type='password']"));
        pass.sendKeys("test");
        WebElement login=driver.findElement(By.xpath("//input[@value='Login']"));
        login.click();

        //6. Print out count of all the links on landing page
        List<WebElement>alllinks=driver.findElements(By.xpath("//body//a"));//its finfElements if we put findelement it gonna give us erro

        //int expectednum=6;
        int actualnum=alllinks.size();
        Assert.assertEquals(actualnum,6);

        //7. Print out each link text on this page
        for(WebElement each:alllinks){
            System.out.println(each.getText());//we need just text coz this we used .gettext
        }
    }
}
