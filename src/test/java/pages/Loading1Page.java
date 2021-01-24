package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver09;

public class Loading1Page {
    public Loading1Page(){
        PageFactory.initElements(Driver09.getDriver(),this);


    }
    @FindBy(xpath = "//button[.='Start']")
    public WebElement startButton;

    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "pwd")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;

    @FindBy(id = "loading")
    public WebElement loading;//what is this?its the loading picture that site gonna show us for a few second before running
    //so we wanna know its still available or not

    //we created that on after we put incorect password or username it gonna show us that message
    @FindBy(id = "flash")
    public WebElement errorMessage;

}
