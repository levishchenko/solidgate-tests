package org.solidgate.api.dto.paymentpage.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.solidgate.api.dto.paymentpage.order.OrderDto;

@Builder
@Getter
public class PaymentPageDto {

    @JsonProperty("page_customization")
    private PageCustomizationDto pageCustomization;

    @JsonProperty("order")
    private OrderDto order;
}