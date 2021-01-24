package test.day12_synchronization;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loading1Page;
import pages.Loading7Page;
import utilities.Driver09;

/*
        TC#40 : Dynamically Loaded Page Elements 7
        1. Go to http://practice.cybertekschool.com/dynamic_loading/7
        2. Wait until title is “Dynamic Title”
        3. Assert : Message “Done” is displayed.
        4. Assert : Image is displayed.
        Note: Follow POM

 */
public class ExplicitWaitPract {

    @Test
    public void tc40(){
        String url="http://practice.cybertekschool.com/dynamic_loading/7";
        Driver09.getDriver().get(url);
        //we gonna create a class in page for running that test

        Loading7Page loading=new Loading7Page();

        //that step for creating the instance webdriverWait to use its methods
        WebDriverWait wait=new WebDriverWait(Driver09.getDriver(),10);

        //why we used explicing wait?why not htread? because if we use Thread everywhere maybe some time it need
        //just 2 sec it gonna loss our time maybe some time need 10 sec ,at that time or we should use 10 and thats alot or it gonna give use error

                  //we are using the object to setup our expected condition
        wait.until(ExpectedConditions.titleIs("Dynamic title")); //by using object(wait) it gonna give us all methods
        //and we gonna use "until" one and until contains so many things we used "ExpectedConditions" with end(s) because
        //it also contains a lot of things and we wann check title so we gonna use "titlIs" and we gonna write
        //expected title here is "Dynamic title"

        //done message is displayed
        Assert.assertTrue(loading.doneMessage.isDisplayed());

        //image is display
        Assert.assertTrue(loading.spongebobImage.isDisplayed());


//we putted 10 sec ,but at once the title appeare it not gonna wait till the end of 10 sec ,like Thread do
    }


    //TC41
    /*
    TC#41 : Dynamically Loaded Page Elements 1
1. Go to http://practice.cybertekschool.com/dynamic_loading/1
2. Click to start
3. Wait until loading bar disappears
4. Assert username inputbox is displayed
5. Enter username: tomsmith
6. Enter password: incorrectpassword
7. Click to Submit button
8. Assert “Your username is invalid!” text is displayed.
Note: Follow POM
     */
    @Test
    public void tc41_dynamic(){
Driver09.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");

        Loading1Page loading1Page=new Loading1Page();

        loading1Page.startButton.click();
//if we do like that it gonna give us error because the username and password gonna show after  while
       // Assert.assertTrue(loading1Page.usernameInput.isDisplayed());  //so what should we do?we gotta wait

        //that one comes form selemium just like WebElement
        WebDriverWait wait=new WebDriverWait(Driver09.getDriver(),10);

        //we created the Findby of loading in the loading1page under pages package that loading is shows us till
        //it gonna show us username then it not gonna visible anymore ,so we used wait for that till its visiblie
        wait.until(ExpectedConditions.invisibilityOf(loading1Page.loading));

        //it gonna wait ,and it not gonna go to the next step till that "loading" still display .after it gone it gonna go to the next steps
        Assert.assertTrue(loading1Page.usernameInput.isDisplayed(),"Username input box is not Display");

        loading1Page.usernameInput.sendKeys("tomsmith");
        loading1Page.passwordInput.sendKeys("lofshay");//we putted invalid password because we gonna use negative test
        loading1Page.submitButton.click();

        Assert.assertTrue(loading1Page.errorMessage.isDisplayed());
    }
}
