package test.Day08_Alerts_iframes;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;
public class A_Webtableprac {





        WebDriver driver;

        @BeforeMethod
        public void setUp(){
            //TC #1: Smartbear software link verification
            //1. Open browser
            //2. Go to website:
            //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
            driver = WebDriverFactory.getDriver("chrome");
            driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

@Test
    public void verification()throws InterruptedException{
            SmartBearUtilities2.login(driver);

    Thread.sleep(1000);

    //Call my method the verify if given name is in the list or not.
    SmartBearUtilities.verifyOrder(driver, "Paul Brown");



}


    @Test
    public void p5_print_names_cities_test(){
        SmartBearUtilities.login(driver);
        SmartBearUtilities.printNamesAndCities(driver);

    }


}
