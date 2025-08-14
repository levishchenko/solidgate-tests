package org.solidgate.web.pages;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class BasePage<T extends BasePage<T>> {

    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }

    public void checkBrowserUrl(String expectedUrl) {
        webdriver().shouldHave(url(expectedUrl));
    }
}
