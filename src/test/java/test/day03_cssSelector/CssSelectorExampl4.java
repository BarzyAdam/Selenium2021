package test.day03_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

/*
Search Amazon
1.Open browser
2. Go to https://amazon.com
3. Enter any search term (use cssSelector to locate search box)
4.Verify title contains the search term
 */
public class CssSelectorExampl4 {
    public static void main(String[] args) throws Exception {
        WebDriver driver= WebDriverFactory.getDriver("chrome");//we created inside utilities so we dont need it anymore
        driver.get("https://amazon.com");
        /*that one is search box off amazon all webelements
        <input type="text" id="twotabsearchtextbox"
        value="" name="field-keywords" autocomplete="off" placeholder=""
         class="nav-input" dir="auto" tabindex="19">
         */
        Thread.sleep(2000);
       WebElement amazonsearch= driver.findElement(By.cssSelector("input[tabindex='19']"));
       amazonsearch.sendKeys("wooden spoon"+ Keys.ENTER);

       String actul=driver.getTitle();
       String expectedTitle="wooden spoon";
       Thread.sleep(1000);
       if(actul.contains(expectedTitle)){
           System.out.println("Title verification is PASSED");
       }else {
           System.out.println("Verification FAILED");
       }

    }
}
