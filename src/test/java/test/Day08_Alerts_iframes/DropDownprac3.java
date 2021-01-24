package test.Day08_Alerts_iframes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class DropDownprac3 {

/*
TC#7: Cybertek “month”dropdown default value
1.Open browser
2.Go to website: http://practice.cybertekschool.com/dropdowns
3.Verify default value is always showing the current month
oExpected: If currently in June, should show June selected
 */


        WebDriver driver;

        @BeforeMethod
        public void setUp(){

            driver = WebDriverFactory.getDriver("chrome");
            driver.get("http://practice.cybertekschool.com/dropdown");

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
    @Test
    public void P7_dropdown(){
            //locating the dropdown
            Select month=new Select(driver.findElement(By.xpath("//select[@id='month']")));

            //We need to create our actual and expected values.
            String actual=month.getFirstSelectedOption().getText();
           // String expected="June"; //why June?because now its June
            //or we can by this way its more better
            String expected= LocalDateTime.now().getMonth().name();
            System.out.println("actual  is: "+actual+"\n eXpected: "+expected);
            //they are different from capitalization
            //1-First way to doing assertion
            Assert.assertEquals(actual.toLowerCase(),expected.toLowerCase());

            //2-second way
            Assert.assertTrue(actual.equalsIgnoreCase(expected));

            /*
            TC#8: Cybertek “month”dropdown list of default values verification
            1.Do both verifications in the same test
            2.Verify list of months are correct as expected.
            oExpected: Options should contain all 12 months of the year.
             */
            List<WebElement>actualDrop=month.getOptions();

            List<String> expectedDropdownOptions = Arrays.asList("January", "February", "March", "April", "May", "June", "July"
                    , "August", "September", "October", "November", "December");

            //We create a list of Strings just as to use as a container to the texts of actual dropdown values
            List<String> actualMonthsText = new ArrayList<>();

            for (WebElement each : actualDrop) {

                actualMonthsText.add(each.getText());

            }


            Assert.assertEquals(actualMonthsText, expectedDropdownOptions);
        }
}
