package test.vytravk;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class fleet {
    WebDriver driver;
    Actions actions;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions=new Actions(driver);
        driver.get("http://qa2.vytrack.com/user/login");
        WebElement username=driver.findElement(By.id("prependedInput"));
        WebElement password=driver.findElement(By.id("prependedInput2"));
        WebElement loginButton=driver.findElement(By.id("_submit"));

        username.sendKeys("user160");
        password.sendKeys("UserUser123");
        loginButton.click();

    }

    //@Test
    public void scenario1()throws InterruptedException{


        Thread.sleep(2000);
        WebElement fleet=driver.findElement(By.xpath("(//span[@class = 'title title-level-1'])[1]"));
        fleet.click();
    }
   //@Test
    public void scenario2()throws InterruptedException{
        Thread.sleep(2000);
        WebElement fleet=driver.findElement(By.xpath("(//span[@class = 'title title-level-1'])[1]"));
        fleet.click();
       WebElement vehicle=driver.findElement(By.xpath("(//span[@class='title title-level-2'])[1]"));
       vehicle.click();

    }
   @Test
    public void scenario3()throws InterruptedException{
        WebDriverWait wait=new WebDriverWait(driver,10);


        WebElement fleet=driver.findElement(By.xpath("(//span[@class = 'title title-level-1'])[1]"));
        fleet.click();
        

        WebElement vehicle=driver.findElement(By.xpath("(//span[@class='title title-level-2'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(vehicle)).click();


        WebElement adam=driver.findElement(By.xpath("(//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-Location'])[2]"));
        wait.until(ExpectedConditions.visibilityOf(adam)).click();

       WebElement event=driver.findElement(By.xpath("//a[@title='Add an event to this record']"));

           wait.until(ExpectedConditions.visibilityOf(event)).click();

           String word="ok";
           WebElement title = driver.findElement(By.name("oro_calendar_event_form[title]"));
           title.sendKeys(word);

           WebElement save = driver.findElement(By.xpath("//button[.='Save']"));
           save.click();
WebElement activity=driver.findElement(By.linkText("Activity"));
activity.click();
         WebElement check=driver.findElement(By.xpath("//strong"));
         String expected=word;
         String actual=check.getText();
           Assert.assertTrue(actual.equals(expected));

    }
   // @Test
    public void reset(){
        WebDriverWait wait=new WebDriverWait(driver,10);


        WebElement fleet=driver.findElement(By.xpath("(//span[@class = 'title title-level-1'])[1]"));
        fleet.click();


        WebElement vehicle=driver.findElement(By.xpath("(//span[@class='title title-level-2'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(vehicle)).click();

        WebElement refresh=driver.findElement(By.xpath("//i[@class='fa-repeat']"));
        refresh.click();
    }
}
