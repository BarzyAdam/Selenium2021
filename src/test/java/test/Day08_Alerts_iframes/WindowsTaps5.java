package test.Day08_Alerts_iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/*
TC	#	:	Window	Handlepractice
1.Create	a	new	class	called:	WindowHandlePractice
2.Create	new	test	and	make	set	ups
3.Go	to	:	http://practice.cybertekschool.com/windows
4.Assert:	Title	is	“Practice”
5.Click	to:	“Click	Here”text
6.Switch	to	new	Window.
7.Assert:	Title	is	“New	Window”
 */
public class WindowsTaps5 {


   

        WebDriver driver;

        @BeforeMethod
        public void setUp()  {
            driver = WebDriverFactory.getDriver("chrome");
            driver.get("http://practice.cybertekschool.com/windows");

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

        @Test
        public void p5_window_handle_practice() throws Exception{

            String currentWindowHandle = driver.getWindowHandle();

            System.out.println("currentWindowHandle = " + currentWindowHandle);

            WebElement clickHereLink = driver.findElement(By.xpath("//a[.='Click Here']"));

            System.out.println("BEFORE CLICKING: " + driver.getTitle());
Thread.sleep(2000);
            clickHereLink.click();
            Thread.sleep(2000);
            System.out.println("AFTER CLICKING: " + driver.getTitle());

            //driver.getWindowHandles() --> returns us A SET of Strings

            Set<String> windowHandles = driver.getWindowHandles();
            Thread.sleep(2000);

            for (String each : windowHandles) {
                driver.switchTo().window(each);
                System.out.println(driver.getTitle());
            }
            Thread.sleep(2000);
            driver.switchTo().window(currentWindowHandle);
            System.out.println(driver.getTitle());
        }

    }