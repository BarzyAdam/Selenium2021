package test.day01_Selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC	#1:	Google	Title	Verification
1.Open	Chrome	browser
2.Go	to	https://www.google.com
3.Verify	title:	Expected:	Go
 */
public class Task {
    public static void main(String[] args) {

        //set up my webdriver
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
       driver.get("https://www.google.com");

       String actualTitle=driver.getTitle();
       String expectedTitle="Google";

       if(actualTitle.equals(expectedTitle)){
           System.out.println("Google title verification pass");
       }else {
           System.out.println("Google title verification faile");
       }

       driver.quit();
    }
}
