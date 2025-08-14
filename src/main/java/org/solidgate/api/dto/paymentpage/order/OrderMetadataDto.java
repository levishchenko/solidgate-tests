package org.solidgate.api.dto.paymentpage.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class OrderMetadataDto {

    @JsonProperty("coupon_code")
    private String couponCode;

    @JsonProperty("partner_id")
    private String partnerId;
}