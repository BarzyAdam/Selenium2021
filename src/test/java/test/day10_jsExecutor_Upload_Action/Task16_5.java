package test.day10_jsExecutor_Upload_Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver09;

/*
TC #16: Double Click Test
1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2 2. Switch to iframe.
3. Double click on the text “Double-click me to change my text color.”
4. Assert: Text’s “style” attribute value contains “red”.
 */
public class Task16_5 {
    @Test
    public void test()throws InterruptedException{
        Driver09.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        Driver09.getDriver().switchTo().frame("iframeResult");
        WebElement doubl=Driver09.getDriver().findElement(By.id("demo"));
      Actions actions=new Actions(Driver09.getDriver());
      Thread.sleep(1000);
      actions.moveToElement(doubl).doubleClick().perform();
        //  4.Assert: Text’s “style” attribute value contains "red".
        // locate the webelement , then Assert
        WebElement sytleText = Driver09.getDriver().findElement(By.cssSelector("p[style = 'color: red;']"));
        Assert.assertTrue(sytleText.getAttribute("style").contains("red"));

    }
}
