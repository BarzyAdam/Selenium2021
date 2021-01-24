package test.day02_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
TC #3: Back and forth navigation
1-Open a chrome browser
2-Go to: https://google.com
3-Click to Gmail from top right.
4-Verify title contains:Expected: Gmail
5-Go back to Google by using the .back();
6-Verify title equals:Expected: Google
 */
public class Task3_linkTextLocator {
    public static void main(String[] args) throws Exception {
        //1-Open a chrome browser
        //2-Go to: https://google.com
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        //3-Click to Gmail from top right.
    //first of all we should know that link gonna write inside <a>
        Thread.sleep(2000);
        driver.findElement(By.linkText("Gmail")).click();

        //4-Verify title contains:Expected: Gmail
        String actualGmailTitle=driver.getTitle();
        String expectedTitle="Gmail";
        if(actualGmailTitle.startsWith(expectedTitle)){
            System.out.println("Gmail title verification pass");
        }else {
            System.out.println("Gmail title verification fail");
        }

       // 5-Go back to Google by using the .back();
        Thread.sleep(2000);
       driver.navigate().back();

       //6-Verify title equals:Expected: Google
        String actualTitle=driver.getTitle();
        String expTitle="Google";
        if(actualGmailTitle.startsWith(expectedTitle)){
            System.out.println("Google title verification pass");
        }else {
            System.out.println("Google title verification fail");
        }
        //what is different between click and Key.Enter?
        //click use for linck and Key.enter use when you put the word
        //by anither way click it just like mouse click,and Enter like keyboard enter
        //Key.Enter most time use with sendkeys and its like keyboard enter

    }
}
