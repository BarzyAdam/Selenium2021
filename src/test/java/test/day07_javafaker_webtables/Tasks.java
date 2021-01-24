package test.day07_javafaker_webtables;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
TC#6: Cybertek registration form confirmation
Note: Use JavaFaker when possible.
1.Open browser
2.Go to website: http://practice.cybertekschool.com/registration_form
3.Enter first name
4.Enter last name
5.Enter username
6.Enter email address
7.Enter password
8.Enter phone number
9.Select a gender from radio buttons
10.Enter date of birth
11.Select Department/Office
12.Select Job Title
13.Select programming language from checkboxes
14.Clickto sign up button
15.Verify success message “You’ve successfully completed registration.”is displayed.
 */
public class Tasks {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

    }

    @Test
    public void method1() throws  InterruptedException{
        Faker faker=new Faker();
        driver.get("http://practice.cybertekschool.com/registration_form");
        WebElement name=driver.findElement(By.xpath("//input[@name='firstname']"));
        WebElement last=driver.findElement(By.xpath("//input[@name='lastname']"));
        WebElement userName=driver.findElement(By.xpath("//input[@name='username']"));
        WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
        WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
        WebElement phone=driver.findElement(By.xpath("//input[@name='phone']"));
        WebElement gender=driver.findElement(By.xpath("//input[@name='gender']"));
        WebElement birthday=driver.findElement(By.xpath("//input[@name='birthday']"));

        //Thread.sleep(500);
        name.sendKeys(faker.name().firstName());
        last.sendKeys(faker.name().lastName());
        //Thread.sleep(500);
        userName.sendKeys(faker.name().username().replace(".",""));
        email.sendKeys(faker.internet().emailAddress());
        password.sendKeys(faker.internet().password());
        //Thread.sleep(500);
        phone.sendKeys(faker.phoneNumber().phoneNumber().replace("x",""));
        gender.click();
       // Thread.sleep(500);
        birthday.sendKeys("12/22/2020");
        Select select=new Select(driver.findElement(By.xpath("//select[@name='department']")));
       // Thread.sleep(500);
        select.selectByValue("DE");
        //Thread.sleep(500);
        Select job=new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
       // Thread.sleep(500);
        job.selectByVisibleText("Manager");
        driver.findElement(By.xpath("//input[@value='java']")).click();
        //Thread.sleep(2000);
driver.findElement(By.xpath("//button[@id='wooden_spoon']")).click();

WebElement result=driver.findElement(By.xpath("//div[@class='alert alert-success']//p"));
String actual=result.getText();
String expec="You've successfully completed registration!";
        Assert.assertEquals(actual,expec);
    }
    @AfterMethod
    public void last()throws InterruptedException{
        //Thread.sleep(2000);
        driver.close();
    }


}
