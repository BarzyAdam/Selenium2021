package test.day07_javafaker_webtables;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerPractice {
    @Test
    public void faker(){
        Faker faker = new Faker();
        String name = faker.name().fullName(); // Miss Samanta Schmidt
        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton
        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
        System.out.println("firstName = " + firstName);

        String gameofthrone=faker.gameOfThrones().quote();
        System.out.println("gameofthrone = " + gameofthrone);

        //faker its like library that contains alot of values that we need
//faker is use for creating fake things like we wanna inter address (street,zip,city) it gonna create for us
        //that is contain alot of different values like you can write name,then it gonna ask you which name do you
        //want like full name
        //or address wich type?i want street or zip code ,and so one we gonna use faker for that
    }
}
