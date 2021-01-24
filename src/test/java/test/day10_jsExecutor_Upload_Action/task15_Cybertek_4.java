package test.day10_jsExecutor_Upload_Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver09;

public class task15_Cybertek_4 {
    @Test
    public void test()throws InterruptedException{
        Driver09.getDriver().get("http://practice.cybertekschool.com/hovers");

        //2.Hover	over	to	first	image
        WebElement img1=Driver09.getDriver().findElement(By.xpath("//div[@class='figure'][1]"));
        WebElement img2=Driver09.getDriver().findElement(By.xpath("//div[@class='figure'][2]"));
        WebElement img3=Driver09.getDriver().findElement(By.xpath("//div[@class='figure'][3]"));

        WebElement name=Driver09.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement name2=Driver09.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement name3=Driver09.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        Actions actions=new Actions(Driver09.getDriver());
       // 2.Hover	over	to	first	image
        //3.Assert:	a.“name:	user1”	is	displayed
Thread.sleep(1000);
        actions.moveToElement(img1).perform();
        System.out.println(name.isDisplayed());

        Thread.sleep(1000);
        actions.moveToElement(img2).perform();
        System.out.println(name2.isDisplayed());

        Thread.sleep(1000);
        actions.moveToElement(img3).perform();
        System.out.println(name3.isDisplayed());
    }
}
