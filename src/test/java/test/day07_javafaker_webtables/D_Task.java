package test.day07_javafaker_webtables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
TC#2: Smartbear software order placing
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: "Tester"
4. Enter password: "test"
5. Click on Login button
6. Click on Order
7. Select familyAlbum from product, set quantity to 2
8. Click to "Calculate" button
9. Fill address Info with JavaFaker
• Generate: name, street, city, state, zip code
10. Click on "visa" radio button
11. Generate card number using JavaFaker
12. Click on "Process"
13.Verify success message "New order has been successfully added."
 */
public class D_Task {
    WebDriver driver;
    @BeforeMethod
    public void Setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
    }
    @Test
    public void method1() throws InterruptedException{
       /* Thread.sleep(2000);
        WebElement user=driver.findElement(By.xpath("//input[@type='text']"));
        user.sendKeys("Tester");
        //Thread.sleep(2000);
        WebElement pass=driver.findElement(By.xpath("//input[@type='password']"));
        pass.sendKeys("test");
        WebElement login=driver.findElement(By.xpath("//input[@value='Login']"));
        login.click();

        we created like that first ,then we created a SmartBearUtilities class inside utilities package
        and created all that steps that use for login
        so we just called  and it gonna do all things that we need for login
        */
        SmartBearUtilities.login(driver);  //we created that class under utilities package and called


//6. Click on Order
        driver.findElement(By.xpath("//a[.='Order']")).click();
        //driver.findElement(By.xpath("//*[@href='Process.aspx']")).click();  we can do it by both way

        //7. Select familyAlbum from product, set quantity to 2
        Select faimly=new Select(driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        faimly.selectByValue("FamilyAlbum");

//if we just write 2 it gonna put 02 ,so we should clear 0 at first ,and there are some ways we can use
        WebElement quantity=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys(Keys.BACK_SPACE);   // we use that one for removeing 0 from the box,then we gonna add 2
        //Keys.BACK_SPACE  it gonna remove anything
        quantity.sendKeys("2");

        //8. Click to "Calculate" button
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
       WebElement name= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
       WebElement street= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
       WebElement city= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        WebElement zip=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));


        Faker fake=new Faker();
        //• Generate: name, street, city, state, zip code
        name.sendKeys(fake.name().fullName());// it gonna inter rondam name
        //street
        street.sendKeys(fake.address().streetAddress());
        city.sendKeys(fake.address().city());
        zip.sendKeys(fake.address().zipCode().replace("-",""));
        //why we added replace?because it gonna add two zip code like 22030-22070  so most of sites not gonna accept it
        //so we did that it gonna by one zip code now like 22030


        //10. Click on "visa" radio button
        driver.findElement(By.xpath("//input[@value='Visa']")).click();

        //11. Generate card number using JavaFaker
       WebElement cardnum= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
       WebElement cvv= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));

       cardnum.sendKeys(fake.finance().creditCard().replace("-",""));
       cvv.sendKeys("12/22");

        //12. Click on "Process"
        driver.findElement(By.xpath("//a[.='Process']")).click();

//we created xpath like that (//div[@class='buttons_process']//strong) what is this?
        //we dont have any thing strong so we gonna create tha parent one (//div[@class='buttons_process'])
        //tha one is parent then we went to child by (//strong)

        WebElement success=driver.findElement(By.xpath("//div[@class='buttons_process']//strong"));
        String actual=success.getText();
        String expect="New order has been successfully added.";
        Assert.assertEquals(actual,expect);

    }
    }

