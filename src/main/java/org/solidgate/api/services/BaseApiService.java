package org.solidgate.api.services;

import com.google.common.hash.Hashing;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

import static org.solidgate.utils.TestContext.config;

@Slf4j
public class BaseApiService {

    @SneakyThrows
    protected RequestSpecification requestSpecificationPaymentPageService(String body) {
        return RestAssured.given().baseUri(config.paymentPageApiUrl())
                .contentType(ContentType.JSON)
                .header("merchant", config.publicKey())
                .header("signature", generateSignature(body))
                .filters(getFilters());
    }

    @SneakyThrows
    protected RequestSpecification requestSpecificationCardPaymentService(String body) {
        return RestAssured.given().baseUri(config.cardPaymentApiUrl())
                .contentType(ContentType.JSON)
                .header("merchant", config.publicKey())
                .header("signature", generateSignature(body))
                .filters(getFilters());
    }

    protected String generateSignature(String jsonString) {
        String text = config.publicKey() + jsonString + config.publicKey();
        byte[] hashedBytes = Hashing.hmacSha512(config.secretKey().getBytes())
                .hashString(text, StandardCharsets.UTF_8).toString().getBytes();
        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    private List<Filter> getFilters() {
        if (config.logging()) {
            return List.of(new RequestLoggingFilter(), new ResponseLoggingFilter());
        }
        return Collections.emptyList();
    }
}
