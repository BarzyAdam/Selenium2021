package test.day02_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC#4:	Google	search
1-Open	a	chrome	browser
2-Go	to:	https://google.com
3-Write	“apple”	in	search	box
4-Click	google	search	button
5-Verify	title:Expected:	Title	should	start	with	“apple”
 */
public class P4_googleTitleVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver chrome=new ChromeDriver();
        chrome.get("https://www.google.com");

        //for writing any word we want in the web driver we should write "findElement" and we should select type by using"By"
        //we selected By.name  then we gonna select sendKey any thing we will write there it gona search for it
        //but it just type it will not run till we will tell it
        //so we gonna add Keys.Enter for searching
        chrome.findElement(By.name("q")).sendKeys("apple"+ Keys.ENTER);
        //why we used "q" becuase in the google location they used name="q" so we gonna search like this


       String actualtitle= chrome.getTitle();//that one compiler gives us
       String expectedTitle="apple";//that one we gonna write it
        if(actualtitle.startsWith(expectedTitle)){
            //why we wrote startwith?because it gives us title like that{apple-Google search}
            System.out.println("Google search title f=verification pass");
        }else{
            System.out.println("Google search title f=verification fail");
        }

    }
}
