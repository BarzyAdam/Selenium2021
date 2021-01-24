package test.Day04_findelements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/*
TC	#2:	SeleniumEasy	CheckboxVerification–Section	1
1.Open	Chrome	browser
2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
3.Verify	“Success	–Check	box	is	checked”	message	is	NOTdisplayed.
4.Click	to	checkbox	under	“Single	Checkbox	Demo”	section
5.Verify	“Success	–Check	box	is	checked”	message	isdisplayed
 */
public class P05_seleniumEasy_checkBox {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver=new WebDriverFactory().getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement seccessCheck=driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        WebElement successMessage = driver.findElement(By.xpath("//div[@id='txtAge']"));

        if(!seccessCheck.isSelected() && !successMessage.isDisplayed()){
            System.out.println("Default value verification PASSED!");
        }else{
            System.out.println("Default value verification FAILED!!!");
        }

        //4. Click to checkbox under “Single Checkbox Demo” section
        Thread.sleep(1000);
        seccessCheck.click();

        //5. Verify “Success – Check box is checked” message is displayed.
        if (successMessage.isDisplayed()){
            System.out.println("Success message is displayed! PASS!");
        }else{
            System.out.println("Success message is not displayed! FAILED!!!");
        }

    }
}
