package test.day11_page_object_model;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.configurationReader;
import utilities.Driver09;
public class PosetiveLogin4 {




        LoginPage loginPage;

        @Test
        public void store_manager_login_test(){

            Driver09.getDriver().get(configurationReader.getproperty("vytrack_url"));
            loginPage = new LoginPage();

            String username = configurationReader.getproperty("storemanager_username");
            String password = configurationReader.getproperty("storemanager_password");

            loginPage.login(username, password);

            //title verification
            String expectedTitle = "Dashboard";

            //Thread.sleep(3000);
            String actualTitle = Driver09.getDriver().getTitle();

            Assert.assertEquals(actualTitle, expectedTitle);


        }



    }

