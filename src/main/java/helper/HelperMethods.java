package helper;

import com.github.javafaker.Faker;

import java.util.Locale;

public class HelperMethods {

    public static String getRandomString(){
       Faker faker = new Faker();

        return faker.dog().name().toLowerCase(Locale.ROOT);
    }
}
