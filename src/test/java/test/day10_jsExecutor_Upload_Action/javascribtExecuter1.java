package test.day10_jsExecutor_Upload_Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver09;

public class javascribtExecuter1 {
    /*
    --> JavaScriptExecutor :
    -> is just an interface with 2 methods.
    -> This interface allows us to execute JavaScript code in our Selenium code.
    -> We pass the javascript scripts as strings into the methods we call from JavaScriptExecutor.
    -> If we are using WebDriver interface reference, we must cast our driver type to JavaScriptExecutor.
sometime we gonna stuck and selenium cant do it ,so at that time we gonna use javascript
     */
    @Test
    public void jsExecutor() throws InterruptedException{
        Driver09.getDriver().get("http://practice.cybertekschool.com/");

        WebElement cyberLink=Driver09.getDriver().findElement(By.linkText("Cybertek School"));
        JavascriptExecutor jsExecutor=(JavascriptExecutor)Driver09.getDriver();

Thread.sleep(4000);

jsExecutor.executeScript( "arguments[0].scrollIntoView(true);",cyberLink);//that step gonna scroll down the page

        /*
        I,Q :how many way do you know for scrolling down in selenium?
        you should remember that (JavascriptExecuter
         */
    }
}
