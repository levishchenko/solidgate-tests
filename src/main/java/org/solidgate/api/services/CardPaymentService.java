package org.solidgate.api.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.solidgate.api.assertions.AssertableResponse;
import org.solidgate.api.dto.cardpayment.StatusDto;

public class CardPaymentService extends BaseApiService {

    @SneakyThrows
    public AssertableResponse getOrderStatus(StatusDto body) {
        return new AssertableResponse(requestSpecificationCardPaymentService(new ObjectMapper().writeValueAsString(body))
                .body(body)
                .when()
                .post("api/v1/status"));
    }
}
