package test.day11_page_object_model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver09;
import org.openqa.selenium.By;

import java.sql.Driver;


public class action_Practice1 {
    @Test
    public void scrolling()throws InterruptedException{



                //get our page
                Driver09.getDriver().get("http://practice.cybertekschool.com/");

                //creating actions instance to be able to use its methods
                Actions actions = new Actions(Driver09.getDriver());

                //locating the web element we want to scroll to
                WebElement cybertekSchoolLink = Driver09.getDriver().findElement(By.linkText("Cybertek School"));
                WebElement inputs = Driver09.getDriver().findElement(By.linkText("Inputs"));

                Thread.sleep(3000);
                //using actions instance we use moveToElement method
                actions.moveToElement(cybertekSchoolLink).perform();

                Thread.sleep(3000);
                actions.moveToElement(inputs).click().perform();

            }
        }