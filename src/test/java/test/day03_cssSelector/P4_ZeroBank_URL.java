package test.day03_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #4: Zero Bank URLverification
1.Open Chrome browser
2.Go to http://zero.webappsecurity.com/login.html
3.Get attribute value of href from the “forgot your password”link
4.Verify attribute value contains
Expected: “/forgot-password.html”
 */
public class P4_ZeroBank_URL {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //3.Get attribute value of href from the “forgot your password”link
        WebElement forget =driver.findElement(By.linkText("Forgot your password ?"));
        //WebElement forgotPasswordLink = driver.findElement(By.partialLinkText("Forgot"));
        //WebElement forgotPasswordLink = driver.findElement(By.partialLinkText("your"));
        //WebElement forgotPasswordLink = driver.findElement(By.partialLinkText("password"));
        //WebElement forgotPasswordLink = driver.findElement(By.partialLinkText("?"));

      String actualhref= forget.getAttribute("href");
      String expected="forgot-password.html";
        if(actualhref.contains(expected)){
            System.out.println("verification PASSED");
        }else {
            System.out.println("FAILED");
        }
    }
}
