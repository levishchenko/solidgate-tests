package org.solidgate.api.dto.paymentpage.resposes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageResponseDto {

    private String guid;
    private String id;
    private String url;
}