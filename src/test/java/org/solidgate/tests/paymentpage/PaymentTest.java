package org.solidgate.tests.paymentpage;

import org.junit.jupiter.api.Test;
import org.solidgate.api.dto.cardpayment.StatusDto;
import org.solidgate.api.dto.cardpayment.response.PaymentResponseDto;
import org.solidgate.api.dto.cardpayment.response.TransactionResponseDto;
import org.solidgate.api.dto.paymentpage.page.PaymentPageDto;
import org.solidgate.api.dto.paymentpage.resposes.PageResponseDto;
import org.solidgate.api.services.CardPaymentService;
import org.solidgate.api.services.PaymentPageService;
import org.solidgate.tests.BaseTest;
import org.solidgate.web.pages.PaymentPage;

import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.solidgate.api.conditions.ConditionUtils.bodyField;
import static org.solidgate.api.conditions.ConditionUtils.statusCode;
import static org.solidgate.api.factory.page.PaymentPageFactory.generatePaymentPageDto;

public class PaymentTest extends BaseTest {

    private final PaymentPageService paymentPageService = new PaymentPageService();
    private final CardPaymentService cardPaymentService = new CardPaymentService();

    @Test
    void userCanProceedPayment() {
        PaymentPageDto paymentPageDto = generatePaymentPageDto();
        PageResponseDto pageResponse = paymentPageService.createPage(paymentPageDto)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("url", not(blankOrNullString())))
                .asPojo(PageResponseDto.class);

        PaymentPage.open(pageResponse.getUrl())
                .fillPaymentFormWithValidDate()
                .clickPay()
                .checkBrowserUrl(paymentPageDto.getOrder().getSuccessUrl());

        PaymentResponseDto paymentResponseDto = cardPaymentService.getOrderStatus(StatusDto.from(paymentPageDto))
                .shouldHave(statusCode(200))
                .asPojo(PaymentResponseDto.class);

        checkPaymentResponse(paymentPageDto, paymentResponseDto);
    }

    private static void checkPaymentResponse(PaymentPageDto paymentPageDto, PaymentResponseDto paymentResponseDto) {
        TransactionResponseDto transaction = paymentResponseDto.getTransactions().values().stream()
                .findFirst()
                .orElseThrow(() -> new AssertionError("No transaction found in response"));
        assertAll(
                () -> assertEquals(paymentPageDto.getOrder().getAmount(), paymentResponseDto.getOrder().getAmount(),
                        "Incorrect order amount"),
                () -> assertEquals(paymentPageDto.getOrder().getCurrency(), paymentResponseDto.getOrder().getCurrency(),
                        "Incorrect order currency"),
                () -> assertEquals("success", transaction.getStatus(),
                        "Incorrect transaction status")
        );
    }
}
