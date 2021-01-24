package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver09;

//everytime when creating new page before anything you should create constructor
public class forgetPasswordPage {

    public forgetPasswordPage(){
        //second thing we should join driver by this class
        PageFactory.initElements(Driver09.getDriver(),this);
    }
    //then we gonna create locations
    //input Box
    @FindBy(id = "prependedInput")
    public WebElement inputbox;

    //request button
    @FindBy(xpath = "//button[.='Request']")
    public WebElement requestButton;

    //error message
    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errormessage;


}
