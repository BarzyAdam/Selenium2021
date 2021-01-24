package test.day12_synchronization;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver09;
import utilities.configurationReader;
import pages.forgetPasswordPage;

/*
TC#36: Vytrack forgot password pageverificationàERROR MESSAGE
1.Go to https://qa3.vytrack.com/user/reset-request
2.Enter random username
3. Click to request button
4. Verifyerror message is displayed
5. Verify error message text is as expected.
    Expected: There is no active user with username or email address “given text”.
    Note: Follow Page Object Model design pattern
 */
public class A_TC36_PAGEverification {
    @Test
    public void test(){
        //do that insode Reader
        Driver09.getDriver().get("https://qa2.vytrack.com/user/reset-request");

        forgetPasswordPage forgetPassword=new forgetPasswordPage();

        String randomone="aadafa";

        //sending a random String into input box
        forgetPassword.inputbox.sendKeys(randomone);

        //click to request button
        forgetPassword.requestButton.click();

        //verify error massage is diplayed
        Assert.assertTrue(forgetPassword.errormessage.isDisplayed());

        //verify error message text value is expected nad contains random String
                      //by normal is like that.
        //String expectedMess="There is no active user with username or email address \"aadafa\".";

        //but we wanna change to if we changed the randomone to any .the text become true ,so what gonna do?
                    //we gonna change that "aadafa\" to our randomone
        String expectedMess="There is no active user with username or email address \""+randomone+"\".";
        String actual=forgetPassword.errormessage.getText();
        Assert.assertTrue(actual.equals(expectedMess));



    }
}
