package test.day01_Selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium {
    public static void main(String[] args) throws InterruptedException {
        //1-this line create the connection between driver and selenium
        WebDriverManager.chromedriver().setup();

        //and set up the driver
//2-creating the instance of chromeDriver to be able to do action ChromeBrowser
        WebDriver driver=new ChromeDriver();
        driver.manage().window().fullscreen();//these two code do same work

        //3- we get google.com
        driver.get("https://www.google.com");

//this line does not open the page just it maximize the page because when we open the page it is small windows
        driver.manage().window().maximize();

        //System.out.println(driver.getTitle());

        //browser navigation
    //this line will take user to the previous page
        Thread.sleep(2000);//we added this for waiting 2 sec .we just added just to aBLE to see selenium movement
        driver.navigate().back();

        Thread.sleep(3000);
        driver.navigate().forward();

        /*
        driver navigate.to it same as driver.get but
        driver.get will wait the page to be loeaded before continuing
        but the other will not wait just it gonna do what you added,which some time get issue
         */
        Thread.sleep(2000);
        driver.navigate().refresh();//this line will refresh page

        Thread.sleep(3000);
        driver.navigate().to("https://www.youtube.com");


//this one returns the title of the current page as a string
        //it doese not accept any parameter  driver.getTitle()
        System.out.println("Driver name is: "+ driver.getTitle());

        //that one returns what page user is on  driver.getCurrentUrl()
        System.out.println(driver.getCurrentUrl());

        System.out.println(driver.getPageSource());
        //driver.quit it will close all the tabs,and ends session
Thread.sleep(3000);
        driver.close();

    }
}
