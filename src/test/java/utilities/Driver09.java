package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver09 {
    //1- make constructor private
    private Driver09(){

    }
    private static WebDriver driver;

    //2- creating getter
    public static WebDriver getDriver(){
        if(driver==null){
            String browser=configurationReader.getproperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.chromedriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "chrome-headless"://headless browser the only different between regular chrome,firefox
//and chrome-headless ,firefoxheadless it happen everything without visually it gonna happen inside memory
                    //you wanna test so u dont need to see it,so we gonna use that and we wont see actions

                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));//for being headlees we should do some thing inside()
                    //chromeoption lets you for doing some advince options in  the chrome browser
                    break;
                case "firefox-headless":
                    driver=new FirefoxDriver(new FirefoxOptions().setHeadless(true));//now its headless
                    break;
            }
        }
        return driver;
    }
    public static void closeDriver(){
        if(driver !=null){  //what does mean if the driver not equal null?it means we created before so we
                            //wanna reset and asigne it to null like brand new ,we created that for this action
            driver.quit();
            driver=null;
        }
    }
}
