package test.day12_synchronization;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Driver09;
import utilities.configurationReader;

/*
TC#35: Vytrack forgot password page verificationsàTITLE andURL
1. Go to https://qa2.vytrack.com
2. Click to “Forgot your password?”link
3. Verify title changed to expectedExpected:
      “Forgot Password”
4. Verify url is as expected:
  Expected: “https://qa3.vytrack.com/user/reset-request”
  Note: Follow Page Object Model design pattern
 */
public class A_TC35_vytruck_forgetPass {
@Test
    public void test(){
    //we siged into vytruck site by using "configurationReader.getproperty" in the utilitya pACKage
    //and we putted "vytrack_url" in the configuration.properties that we created the site there
    Driver09.getDriver().get(configurationReader.getproperty("vytrack_url"));

//so we gonna create forgetpass inside LoginPage in the pages package ,by that waY we dont need to use findelement
        //what should we do now?we gonna create object under LoginPage
    LoginPage loginPage=new LoginPage();

    //so by that object we can call forget password ,object is(loginPage) that have all things inside that class
    loginPage.forgetpass.click();
                               //it gonna go to the new page by click on it

    //how do we know we are in the new page?
    //if the title or url change

    //first way    1-verify title as expected
    String expected="Forgot Password";
    String actual=Driver09.getDriver().getTitle();
    Assert.assertEquals(actual,expected);

    //2-Verifying the URL is as expected
    String expectedUrl="https://qa2.vytrack.com/user/reset-request";
    String actualURL=Driver09.getDriver().getCurrentUrl();
    Assert.assertEquals(actualURL,expectedUrl,"Veryfiong Url");

}
}
