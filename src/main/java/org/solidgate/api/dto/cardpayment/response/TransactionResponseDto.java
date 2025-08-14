package org.solidgate.api.dto.cardpayment.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionResponseDto {

    private String id;
    private String operation;
    private String status;
    private String descriptor;
    private int amount;
    private String currency;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("marketing_amount")
    private int marketingAmount;

    @JsonProperty("marketing_currency")
    private String marketingCurrency;

    @JsonProperty("scheme_transaction_id")
    private String schemeTransactionId;
}
