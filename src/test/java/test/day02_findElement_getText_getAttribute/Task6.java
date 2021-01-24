package test.day02_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #1: EtsyTitle Verification
1.Open Chrome browser
2.Go to https://www.etsy.com
3.Search for “wooden spoon”
4.Verify title: Expected: “Wooden spoon | Etsy”TC #

2: Zero Bankheader verification1.Open Chrome browser2.Go to http://zero.webappsecurity.com/login.html3.Verify header textExpected: “Log in to ZeroBank”
 */
public class Task6 {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.etsy.com");
Thread.sleep(2000);
        driver.findElement(By.name("search_query")).sendKeys("Wood spoon"+ Keys.ENTER);
        Thread.sleep(3000);
        driver.navigate().back();
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("shoes"+ Keys.ENTER);
        Thread.sleep(3000);
        driver.close();

        //how do doubicate?by press comand+D

    }
}

