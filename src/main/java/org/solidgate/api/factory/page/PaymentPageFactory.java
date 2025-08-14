package org.solidgate.api.factory.page;

import org.solidgate.api.dto.paymentpage.page.PaymentPageDto;
import org.solidgate.api.factory.order.OrderFactory;

public class PaymentPageFactory {

    public static PaymentPageDto generatePaymentPageDto() {
        return PaymentPageDto.builder()
                .order(OrderFactory.randomOrder())
                .pageCustomization(PageCustomizationFactory.randomPageCustomization())
                .build();
    }
}
