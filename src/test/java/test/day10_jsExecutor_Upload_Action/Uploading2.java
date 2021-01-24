package test.day10_jsExecutor_Upload_Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver09;

public class Uploading2 {

    //we created sublime file on the desktop
    @Test
    public void uploding_test()throws InterruptedException{
        Driver09.getDriver().get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile=Driver09.getDriver().findElement(By.id("file-upload"));
        //what we did?First of all we selected (Choose file)then we didnt click because if we were click
        //it gonna go to another page that we couldnt work on it by selenium because it was ging to anothere page
        //so we just selected,then we used sendKey and putted the copy path of the file in desktop then uploaded
        Thread.sleep(2000);
        chooseFile.sendKeys("/Users/barzyadam/Desktop/zip.csv");

        WebElement upload=Driver09.getDriver().findElement(By.id("file-submit"));
        upload.click();

        WebElement message=Driver09.getDriver().findElement(By.xpath("//div[@class='example']/h3"));
        Assert.assertTrue(message.isDisplayed());
    }

}
