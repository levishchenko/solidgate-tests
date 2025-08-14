package org.solidgate.api.dto.cardpayment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.solidgate.api.dto.paymentpage.page.PaymentPageDto;

@Getter
@Setter
@AllArgsConstructor
public class StatusDto {

    @JsonProperty("order_id")
    private String orderId;

    public static StatusDto from(PaymentPageDto dto) {
        return new StatusDto(dto.getOrder().getOrderId());
    }
}
