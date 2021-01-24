package test.day07_javafaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/*
TC #3: Selecting date on dropdown and verifying
1.Open Chrome browser
2.Go to http://practice.cybertekschool.com/dropdown
3.Select “December 1st, 1921” and verify it is selected.
Select year using: visible textSelect month using : value attributeSelect day using: index number
 */
public class A_Task3 {
    WebDriver driver;
     @BeforeMethod
    public void setup(){
         driver= WebDriverFactory.getDriver("chrome");
         driver.get("http://practice.cybertekschool.com/dropdown");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
     }

     @Test
    public void method1(){
       //3.Select “December 1st, 1921” and verify it is selected.
         //Select year using: visible textSelect month using : value attributeSelect day using: index number
         Select year=new Select(driver.findElement(By.xpath("//select[@id='year']")));
         year.selectByVisibleText("1921");

         String yearacrual=year.getFirstSelectedOption().getText();
         String expected="1921";

         Assert.assertEquals(yearacrual,expected);

         Select month=new Select(driver.findElement(By.xpath("//select[@id='month']")));
         month.selectByValue("11");

         String actualmonth=month.getFirstSelectedOption().getText();
         String expectmonth="December";
         Assert.assertEquals(actualmonth,expectmonth);

         Select day=new Select(driver.findElement(By.xpath("//select[@id='day']")));
         day.selectByIndex(0);

         String dayActual=day.getFirstSelectedOption().getText();
         String dayexp="1";
         Assert.assertEquals(dayActual,dayexp);
     }
}
