package test.day10_jsExecutor_Upload_Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver09;

/*
TC #16: Hover Test
1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
 2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “You did great!”
 */
public class Task16_hover_6 {
    @Test
    public void test()throws InterruptedException{
        Driver09.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Driver09.getDriver().manage().window().maximize();
        WebElement drag=Driver09.getDriver().findElement(By.id("draggable"));
        WebElement drop=Driver09.getDriver().findElement(By.xpath("//div[.='Drag the small circle here.']"));
        Actions actions=new Actions(Driver09.getDriver());
        actions.moveToElement(Driver09.getDriver().findElement(By.xpath("//div[@class='demo-section k-content']")));
        Thread.sleep(1000);
        actions.moveToElement(drag).dragAndDrop(drag,drop).perform();
    }
}
