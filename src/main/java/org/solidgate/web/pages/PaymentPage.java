package org.solidgate.web.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static org.solidgate.utils.BankCardUtils.getValidCardExpiry;
import static org.solidgate.utils.BankCardUtils.getValidCardNumber;
import static org.solidgate.utils.TestContext.faker;

public class PaymentPage extends BasePage<PaymentPage> {

    private static final String CARD_NUMBER = "[data-testid='cardNumber']";
    private static final String CARD_EXPIRY_DATE = "[data-testid='cardExpiryDate']";
    private static final String CARD_CVV = "[data-testid='cardCvv']";
    private static final String CARD_HOLDER = "[data-testid='cardHolder']";
    private static final String SUBMIT_BUTTON = "[data-testid='submit']";

    public static PaymentPage open(String url) {
        Selenide.open(url);
        return Selenide.page(PaymentPage.class);
    }

    public PaymentPage fillPaymentFormWithValidDate() {
        $(CARD_NUMBER).setValue(getValidCardNumber());
        $(CARD_EXPIRY_DATE).setValue(getValidCardExpiry());
        $(CARD_CVV).setValue(String.valueOf(faker.number().numberBetween(100, 1000)));
        if ($(CARD_HOLDER).isDisplayed()) {
            $(CARD_HOLDER).setValue(faker.name().firstName());
        }
        return this;
    }

    public PaymentPage clickPay() {
        $(SUBMIT_BUTTON).click();
        return this;
    }
}
