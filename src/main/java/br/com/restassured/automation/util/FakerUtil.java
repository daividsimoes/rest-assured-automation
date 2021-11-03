package br.com.restassured.automation.util;

import com.github.javafaker.Faker;

import java.math.BigDecimal;
import java.util.Locale;

public class FakerUtil {

    private Faker faker;

    public FakerUtil(){

        this.faker = new Faker(new Locale("pt-BR"));
    }

    public String generateRandomName() {

        return faker.name().fullName();
    }

    public String generateRandomPassword() {

        return faker.internet()
                .password(8, 16,
                        true, false, true);
    }

    public String generateRandomEmail() {

        return faker.internet().emailAddress();
    }

    public String generateInvalidEmail() {

        return faker.name().username().concat("@");
    }

    public String generateRandomUuid() {

        return faker.internet().uuid();
    }

    public String generateRadomTextDescription() {

        return faker.lorem().sentence();
    }

    public String generateRadomProduct() {

        return faker.commerce().productName();
    }

    public BigDecimal generateRadomPrice() {

        return new BigDecimal(faker.commerce().price());
    }

    public int generateRadomQuantity() {

        return faker.number().randomDigitNotZero();
    }
}
