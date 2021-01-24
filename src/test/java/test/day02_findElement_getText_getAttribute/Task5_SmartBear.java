package test.day02_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC#5:	Basic	login	authentication
1-Open	a	chrome	browser
2-Go	to:	http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3-Verify	title	equals:Expected:	Web	Orders	Login
4-Enter	username:	Tester
5-Enter	password:	test
6-Click	“Sign	In”	button7-Verify	titleequals:Expected:	Web	Orders
 */
public class Task5_SmartBear {
    public static void main(String[] args) throws Exception {
        //1-Open	a	chrome	browser

        WebDriverManager.chromedriver().setup();
        WebDriver sample=new ChromeDriver();
        sample.manage().window().maximize();

        Thread.sleep(2000);
        //2-Go	to:	http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        sample.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        Thread.sleep(3000);
        //3-Verify	title	equals:Expected:	Web	Orders	Login
        String actual=sample.getTitle();
        String expect="Web Order";
        if(actual.startsWith(expect)){
            System.out.println("Home title page pass");
        }else{
            System.out.println("Home title page Fail");
        }

        Thread.sleep(1000);
        //4-Enter	username:	Tester
        //at first we should look at actual page and see html for knowing what should we write
        sample.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        //where we brought (ctl00$MainContent$username) we went to that link and by using INSpect we found name

        Thread.sleep(1000);
        //5-Enter	password:	test
        sample.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        //also we brought that name in the html of actual page


        Thread.sleep(1000);
        //6-Click	“Sign	In”	button7-Verify	titleequals:Expected:	Web	Order
        sample.findElement(By.name("ctl00$MainContent$login_button")).click();

        Thread.sleep(3000);
        sample.findElement(By.linkText("Order")).click();


    }
}
