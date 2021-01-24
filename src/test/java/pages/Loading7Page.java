package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver09;

public class Loading7Page {
    //page 7 is in the dynamic it gonna open after while we gonna test wait on it

    public Loading7Page(){
        PageFactory.initElements(Driver09.getDriver(),this);
    }

    @FindBy(xpath = "//strong")   //why we used strong alone?because there isnt any other strong there
    public WebElement doneMessage;

    @FindBy(xpath = "//img[@class='rounded mx-auto d-block']")
    public WebElement spongebobImage;

}
