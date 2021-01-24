package test.day03_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;
/*
who can you write accurate xpath?you can by write click on what you want then copy after copy Xpath,but that on isnt accurate
its better writing by yourself like that
/html/head/body/ul/li/a  as the thing that you wanted have path ,you should look at it then creating that pathway
 */
public class AbsoluteXpath5 {
    public static void main(String[] args) {
        //Go to http://practice.cybertekschool.com/multiple_buttons
        //Verify "Home" link is displayed on the page
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement homeLink = driver.findElement(By.xpath("/html/body/nav/ul/li/a"));
        if (homeLink.isDisplayed()){
            System.out.println("Home link is displayed on the page. PASS!");
        }else{
            System.out.println("Home link is NOT displayed on the page. FAIL!");
        }
    }
}

