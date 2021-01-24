package test.Day05_TestNGIntro;
/*
at the first we dounloadid TestNG in our intilJ by these ways

WE ARE NOW ADDING TESTNG LIBRARY TO OUR PROJECT
	1- GO TO MVNREPOSITORY.COM
	2- Type : "TestNG" into the search box
	3- Get the first dependency
	4- Add it into our project pom.xml file

	that things that start with @ it gonna call annotation
	annotation is use for controling running
 */
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestNGclass {
    //we created test method the we added @Test that directly it imported

    //@Bedoremethod woth this annotation any thing you in put it gonna run before every methods
    @BeforeMethod
    public void setUp(){
        System.out.println("running before");

    }
    //afterMethod its exactly oposite of Before it gonna run after all methods
    @AfterMethod
    public void tearDown(){
        System.out.println("run after all");
    }

    @Test
    public void test1(){
        System.out.println("Test one is runnign....");

    }//ny running TestNG gonna tell us how many test pass ,fail,skip
@Test
    public void Test2(){
        System.out.println("Teest 2 is running..");
    }
    /*
    @Test :Allows us to create TestNG tests

     */
}
