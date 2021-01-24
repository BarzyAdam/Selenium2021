package test.day11_page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Driver09;
import utilities.configurationReader;
public class NegativeLogin3 {

    LoginPage loginPage;
@Ignore
    @Test
    public void negstive_logon(){
        Driver09.getDriver().get(configurationReader.getproperty("vytrack_url"));

        WebElement username=Driver09.getDriver().findElement(By.id("prependedInput"));
        WebElement password=Driver09.getDriver().findElement(By.id("prependedInput2"));
        WebElement login=Driver09.getDriver().findElement(By.id("_submit"));

        String user=configurationReader.getproperty("storemanager_username");
        username.sendKeys(user);
        //that one incorect
        password.sendKeys("asdadfda");
        login.click();

        WebElement errorMass=Driver09.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));
        Assert.assertTrue(errorMass.isDisplayed(),"Assert Massage is not Display");
    }


    //we created thar method because we gonna use LoginPage under payges
    @Test
    public void negstive_ligin(){
    Driver09.getDriver().get(configurationReader.getproperty("vytrack_url"));

        String username=configurationReader.getproperty("storemanager_username");

        loginPage=new LoginPage();
        loginPage.usernameInput.sendKeys(username);

        //send our incorrect password
        loginPage.passwordInput.sendKeys("jaksddfh");

        //click using our loginpage object
        loginPage.loginButton.click();

        //asserting error message is displayed
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        //asserting the TEXT VALUE of the error message
        String actualText = loginPage.errorMessage.getText();
        String expectedText = "Invalid user name or password.";

        Assert.assertEquals(actualText, expectedText);

    }

  //  @Test
    public void tc31_wrong_username_test(){

        Driver09.getDriver().get(configurationReader.getproperty("vytrack_url"));

        loginPage=new LoginPage();

        String username = "asjdffhasf";
        String password = configurationReader.getproperty("storemanager_password");

        loginPage.login(password,username);//we usid login(its method from pages)

        //Asserting error message IS DISPLAYED
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        //Asserting the TEXT VALUE of the error message
        String actualText = loginPage.errorMessage.getText();
        String expectedText = "Invalid user name or password.";

        Assert.assertEquals(actualText, expectedText);




    }

}
