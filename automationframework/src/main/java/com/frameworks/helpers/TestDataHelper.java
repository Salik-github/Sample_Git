package com.frameworks.helpers;

import com.github.javafaker.Faker;

public class TestDataHelper {
    
    static Faker faker = new Faker();

    public static String getFirstName()
    {
        return faker.name().firstName();
    }
    public static String getLastName()
    {
        return faker.name().lastName();
    }
    public static String getEmail()
    {
        return faker.internet().emailAddress();
    }
    public static String getPassword()
    {
        return faker.internet().password();
    }
    public static String getCompanyName()
    {
        return faker.company().name();
    }
}
