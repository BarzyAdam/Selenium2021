package test.day06_TestNG_dropDowns;

import org.testng.Assert;
import org.testng.annotations.*;


public class A_TestNGprac {
  //if we dont have main here we cant run it but here we  add annotation @Test it allows us for running it gives us TestNG

  @BeforeMethod  //doesnt matter where do you store that ,always it gonna run at the first of all @Test mehtods
  public void setUp(){
      System.out.println("Before method is running ");
  }

  @AfterMethod
  public void tearDown(){
      System.out.println("After method is running");
  }
@BeforeClass //we have another annotation call BeforeClass
// ->this one gonna run before all things and one time ,even before BeforeMethod

public void set(){
    System.out.println("Before class is running...");
}

@AfterClass  //that gonna run at the end of all class
public void after_class(){
    System.out.println("After class");
}
    @Test  //if we dont have that @Test it not gonna run
public void test1(){

   String actualTitle="HomePage";  //driver.getTitle();
        String expected="HomePage";

        //that one come frome TestNG its for knowing eqauility of things
        Assert.assertEquals(actualTitle,expected);

        //if assertion pass there will be no output in console
        //if fail it will tell us what is fail and why

       /* if (actualTitle.equalsIgnoreCase(expected)){
            System.out.println("PAss");
        }else {
            System.out.println("Fail!!");
        }

        */
       //we have assertTrue ->this method expects you to pass a boolean value
        //it return boolean value
}

@Test   //for each methods we must add @test if we dont it will not run
public void test2(){
    System.out.println("Test2 is running...");

    Assert.assertEquals("String1","string1","String verification on test2");
    //assert.Equals accept first one(actual)second(expected) and after tha message that you want to show
    //message is optional if you want you can write it

    //methods return boolean value :isSelected, isDisplayed ,isEmpty,contains
}

@Test
public void test3(){
    System.out.println("Test 3 is running");
//we have asserTrue that return boolean and it pass when its true
    String title="Amazon prime";
    String expectedTitle="prime";
    Assert.assertTrue(title.contains(expectedTitle));
    System.out.println("I wanna know after true gonna run that?");
    //we have assertFalse it return boolean and it pass when its faile
    Assert.assertFalse(title.contains(expectedTitle));
    System.out.println("I wanna know after false gonna run that?");
    //we saw that after false after it nothing will run ,coz this you cant use any number of assertTrue or False
}
}
