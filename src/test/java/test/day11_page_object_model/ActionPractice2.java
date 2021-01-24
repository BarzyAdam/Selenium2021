package test.day11_page_object_model;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver09;




public class ActionPractice2 {

Actions actions;
    @Test
    public void task16_double()throws InterruptedException{
        Driver09.getDriver().get(" https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
//switch to iframe by three way
        //index,id or name,locate as a webelement
        Driver09.getDriver().switchTo().frame(0);

        WebElement doubl=Driver09.getDriver().findElement(By.id("demo"));
        actions=new Actions(Driver09.getDriver());
        Thread.sleep(1000);
        actions.doubleClick(doubl).perform();

        //4. Assert: Text's "style" attribute value contains "red".
        //what should I do?i should check if there is a red inside the color
        String actual=doubl.getAttribute("style");
        System.out.println(actual);
        String expected="color: red;";
        Assert.assertTrue(actual.equals(expected));
        //or we can do like that
        //Assert.assertTrue(actual.contains("red"));
    }

    //drag and drop
    /*
 TC #16: Hover Test
1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index 2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “You did great!”
     */
    @Test
    public void drag_drop()throws InterruptedException{
        Driver09.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement small=Driver09.getDriver().findElement(By.id("draggable"));
        WebElement big=Driver09.getDriver().findElement(By.id("droptarget"));
        actions=new Actions(Driver09.getDriver());
        actions.clickAndHold(small).moveToElement(big).release().perform();
        //another way
        actions.clickAndHold(small).moveToElement(big).perform();

        String expectedWhileHover = "Now drop...";
        String actualWhileHover = big.getText();

        Assert.assertEquals(actualWhileHover, expectedWhileHover);

        Thread.sleep(2000);

        actions.release().perform();

        //actions.dragAndDrop(smallCircle, bigCircle).perform();

        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String actual = big.getText();
        String expected = "You did great!";

        Assert.assertEquals(actual, expected);




    }
    @Test
    public void tc18_right_click_test(){
        //1. Go to https://the-internet.herokuapp.com/context_menu
        Driver09.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        //2. Right click to the box.
        WebElement box = Driver09.getDriver().findElement(By.id("hot-spot"));

        actions = new Actions(Driver09.getDriver());
//context click is same as double click
        actions.contextClick(box).perform();


        //3. Alert will open.
        Alert alert = Driver09.getDriver().switchTo().alert();

        //4. Accept alert
        alert.accept();

        //No assertion needed for this practice.
    }



}

