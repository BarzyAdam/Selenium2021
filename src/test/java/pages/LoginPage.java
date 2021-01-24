package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver09;

/*
we will store all login page related web element and method into this
 */
public class LoginPage {
    public  LoginPage(){
        //what we are doing here?
        //we import PageFactory from selenium ,and used Driver09 for crearing driver
        //and this (this)keyword we dont care how to happen but its use for by using it that driver that created before it
        //it not gonna lose anything that created inside that class
        PageFactory.initElements(Driver09.getDriver(),this);

    }

    //we will not use findelement anymore we gonna use that FIndBy
    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    //locating input password
    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    //locating login button
    @FindBy(id = "_submit")
    public WebElement loginButton;

    //locating error message
    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgetpass;

    public void login(String username, String password){

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

    }

}