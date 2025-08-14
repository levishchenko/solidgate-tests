package org.solidgate.api.factory.page;

import org.solidgate.api.dto.paymentpage.page.PageCustomizationDto;

import java.util.List;

import static org.solidgate.utils.TestContext.faker;

public class PageCustomizationFactory {

    public static PageCustomizationDto randomPageCustomization() {
        return PageCustomizationDto.builder()
                .publicName(faker.company().name())
                .orderTitle("Order Title")
                .orderDescription(faker.commerce().productName())
                .paymentMethods(List.of("paypal"))
                .buttonFontColor("#FFFFFF")
                .buttonColor("#00816A")
                .fontName("Open Sans")
                .isCardholderVisible(faker.bool().bool())
                .termsUrl("https://solidgate.com/terms")
                .backUrl("https://solidgate.com")
                .build();
    }
}
