package org.solidgate.api.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.solidgate.api.assertions.AssertableResponse;
import org.solidgate.api.dto.paymentpage.page.PaymentPageDto;

public class PaymentPageService extends BaseApiService {

    @SneakyThrows
    public AssertableResponse createPage(PaymentPageDto body) {
        return new AssertableResponse(requestSpecificationPaymentPageService(new ObjectMapper().writeValueAsString(body))
                .body(body)
                .when()
                .post("api/v1/init"));
    }
}
