package org.solidgate.api.dto.paymentpage.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public class PageCustomizationDto {

    @JsonProperty("order_title")
    private String orderTitle;

    @JsonProperty("payment_methods")
    private List<String> paymentMethods;

    @JsonProperty("button_color")
    private String buttonColor;

    @JsonProperty("is_cardholder_visible")
    private boolean isCardholderVisible;

    @JsonProperty("terms_url")
    private String termsUrl;

    @JsonProperty("order_description")
    private String orderDescription;

    @JsonProperty("button_font_color")
    private String buttonFontColor;

    @JsonProperty("back_url")
    private String backUrl;

    @JsonProperty("public_name")
    private String publicName;

    @JsonProperty("font_name")
    private String fontName;
}