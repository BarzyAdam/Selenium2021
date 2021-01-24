package test.Day08_Alerts_iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/*
TC #4: Iframe practice
1.Create a new class called: IframePractice
2.Create new test and make set ups
3.Go to: http://practice.cybertekschool.com/iframe
4.Assert: “Your content goes here.” Text is displayed.
5.Assert: “An iFrame containing the TinyMCEWYSIWYG Editor
 */
public class Iframe5 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/iframe");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void iframePrac(){
        //1-Locating iframe as web element,
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));//here we are just located iframe
        //we switched to iframe by usning web element
        driver.switchTo().frame(iframe);

        //we can go to index we want by
        //driver.switchTo().frame(0);

        //we can use id or name by
        //  driver.switchTo().frame("id")

        //4.Assert: “Your content goes here.” Text is displayed.

        WebElement paragraph=driver.findElement(By.xpath("//p"));//we searched that paragraph inside iframe
        //by using switch ,we searched that paragraph inside iframe

        Assert.assertTrue(paragraph.isDisplayed());
        //after we switched to iframe we have to switch back to default
        //is we dont it will check onley inside iframe
        driver.switchTo().defaultContent();
                    //what is the difference between parentFrame and deffaultContent?
                                    //defaultContent gonna go to the veryfirst parent ,default one
                                   //but parentFrame gonna go to the previous parent

        //5.Assert: “An iFrame containing the TinyMCEWYSIWYG Editor
        WebElement h3Text=driver.findElement(By.xpath("//h3"));

    }

}
