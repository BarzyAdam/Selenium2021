package test.day09_TestBase;

import org.testng.annotations.Test;
//.getProperty it accept a Key and returns its value like for (OS, or User name)
public class LearningProperties2 {
    @Test
    public void Java_properties(){
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));//it shows us
        //what type of operartion system(OS) do we use  ->Mac OS
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));//barzyadam

        /*
        what is test data?
        -The data we use to test our application.
        ex: username , password ,and ANY OTHER information we pass

         */
    }
}
