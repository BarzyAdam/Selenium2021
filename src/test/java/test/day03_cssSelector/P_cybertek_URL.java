package test.day03_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #3: PracticeCybertek/ForgotPassword URL verification
1.Open Chrome browser
2.Go to http://practice.cybertekschool.com/forgot_password
3.Enter any email into input box
4.Click on Retrieve password
5.Verify URL contains: Expected: “email_sent”
6.Verify textbox displayed the content as expected.
Expected: “Your e-mail’s been sent!

”Hint: You need to use getText method for this practice
 */
public class P_cybertek_URL {
    public static void main(String[] args) {
        //1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //2.Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //3.Enter any email into input box
        WebElement emailInput= driver.findElement(By.name("email"));
        emailInput.sendKeys("anyemail@emai.com");

        //4.Click on Retrieve password
        WebElement retrivePass=driver.findElement(By.id("form_submit"));
        retrivePass.click();

        //5.Verify URL contains: Expected: “email_sent”
        String actual=driver.getCurrentUrl();
        String expected="email_sent";
        if(actual.equals(expected)){
            System.out.println("email verification Pass");
        }else{
            System.out.println("email verification Fail");
        }

        //6.Verify textbox displayed the content as expected.
        WebElement confirmMess=driver.findElement(By.name("confirmation_message"));

       // String confermess=driver.findElement(By.name("confirmation_message")).getText();  //why we stored here in string?
        //because if we wanna text that gives us we should add .getText(),if we dont it will give us the page type
        //and when we added .getText it become text so wecant store in webPage we should store as a text in string

        String actualres=confirmMess.getText(); //we do here insteade of in the top
        String expecte="Your e-mail's been sent!";

        if(actualres.equals(expecte)){
            System.out.println("display message is Pass");
        }else {
            System.out.println("display message Failed");
        }

        /*
        .isDisplayed();
    -> Check if a web element is displayed on the page or not
    -> Return type is boolean
    -> If web element is displayed, it returns true
    -> If web element is not displayed, it returns false
    -> It does not accept any arguments

         */
    }
}
