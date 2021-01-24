package test.Day04_findelements_checkbox_radio;
/* NOTE
    absolute xpath:
    -> Starts with : /
    ->Starts from the very begining of <html>
    ->you can only go from parent to child

-----------------------------------------------
relative xpath:
    -> Starts with: //
    -> Looks through everything in the html code
    -> Returns all matching
    -> You can start from anywhere in the html code
    -> Where ever you use // (relative path) is looking to jump and return all the matching results
        ex : //body//a

     */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*   TASK
TC #0: FINDELEMENTS
1.Open Chrome browser
2.Go to https://www.merriam-webster.com/
3.Print out the texts of all links
4.Print out how many link is missing text
5.Print out how many link has text
6.Print out how many total link
 */
public class P01_MerriamWebster {
    public static void main(String[] args) {
        //TC #0: FINDELEMENTS
        //1. Open Chrome browser
        //2. Go to https://www.merriam-webster.com/
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //Implicit wait will wait UPTO given seconds.
        //If page is loaded before it will continue.
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.merriam-webster.com");
        //3. Print out the texts of all links
        // we are creating a List of WebElements and storing values returned
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
        //option + enter to import in Mac
        //alt + enter for Windows

        int linksWithoutText = 0;
        int linksWithText = 0;

        for (WebElement eachLink : listOfLinks) {
            //System.out.println(eachLink.getText());
            String textOfEachLink = eachLink.getText();
            //4. Print out how many link is missing text

            if (textOfEachLink.isEmpty()){
                linksWithoutText++;
            }else{
                //System.out.println(eachLink.getText());
                linksWithText++;
            }


        }

        System.out.println("The number of links does not have text: "+linksWithoutText);
        //5. Print out how many link has text
        System.out.println("The number of links that has text: "+linksWithText);
        //6. Print out how many total link
        System.out.println("The number of links that has not text: "+listOfLinks.size());
    }
}


