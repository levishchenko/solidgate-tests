package org.solidgate.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.solidgate.utils.TestContext.config;

public class BaseTest {

    @BeforeAll
    static void setUp() {
        Configuration.browser = config.browser();
        Configuration.timeout = 10000;
        Configuration.headless = config.headless();
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
