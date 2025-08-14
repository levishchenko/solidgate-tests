package org.solidgate.api.dto.cardpayment.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Map;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentResponseDto {

    private OrderResponseDto order;

    @JsonProperty("redirect_url")
    private String redirectUrl;

    private Map<String, TransactionResponseDto> transactions;
}
