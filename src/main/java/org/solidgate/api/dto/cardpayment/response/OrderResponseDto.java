package org.solidgate.api.dto.cardpayment.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResponseDto {

    @JsonProperty("order_id")
    private String orderId;

    private int amount;
    private String currency;
    private String mid;
    private String descriptor;
    private boolean fraudulent;

    @JsonProperty("marketing_amount")
    private int marketingAmount;

    @JsonProperty("marketing_currency")
    private String marketingCurrency;

    @JsonProperty("processing_amount")
    private int processingAmount;

    @JsonProperty("processing_currency")
    private String processingCurrency;

    private String status;

    @JsonProperty("refunded_amount")
    private int refundedAmount;

    @JsonProperty("order_description")
    private String orderDescription;

    @JsonProperty("traffic_source")
    private String trafficSource;

    @JsonProperty("customer_email")
    private String customerEmail;

    @JsonProperty("auth_code")
    private String authCode;

    @JsonProperty("ip_address")
    private String ipAddress;

    @JsonProperty("psp_order_id")
    private String pspOrderId;

    @JsonProperty("provider_payment_id")
    private String providerPaymentId;
}
