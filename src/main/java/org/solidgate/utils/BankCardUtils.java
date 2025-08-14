package org.solidgate.utils;

import java.time.LocalDate;

import static org.solidgate.utils.TestContext.config;
import static org.solidgate.utils.TestContext.faker;

public class BankCardUtils {

    public static String getValidCardNumber() {
        return config.validCard();
    }

    public static String getValidCardExpiry() {
        int month = faker.number().numberBetween(1, 13);
        int year = LocalDate.now().getYear() + faker.number().numberBetween(1, 6);
        return String.format("%02d/%02d", month, year % 100);
    }
}
