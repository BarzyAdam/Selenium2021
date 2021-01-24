package test.day10_jsExecutor_Upload_Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver09;

/*
ACTIONS

    Actions selenium documentation:
    https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/interactions/Actions.html
    -> Is a class coming from SELENIUM
    -> Allows us to handle advanced mouse and keyboard actions
    -> Actions class can do:
        -> hover over
        -> double click
        -> context click (right click)
        -> drag and drop
        -> keydown : to simulate that pressing a key and holding it down
    TO USE :
    -> 1- We need to create an object of the ACTIONS class
    -> 2- We need to pass the current driver instance into the constructor
 */
public class Actions3 {
    @Test
    public void Test1() throws InterruptedException{
        //if we wanna move mouse over something without click we gonna use action
        Driver09.getDriver().get("https://www.amazon.com");
        //1- Create the instance of actions class
        //2-pass The current driver instance
        Actions actions=new Actions(Driver09.getDriver());
        //3-Locate the web element to hover over
        Thread.sleep(1000);
        WebElement languageoption=Driver09.getDriver().findElement(By.xpath("//span[@class='nav-icon nav-arrow']"));
        actions.moveToElement(languageoption).perform();
        //4-using actions,hover over to the language options


    }
}
