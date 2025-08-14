package org.solidgate.api.factory.order;

import org.solidgate.api.dto.paymentpage.order.OrderDto;
import org.solidgate.api.dto.paymentpage.order.OrderMetadataDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import static org.solidgate.utils.TestContext.faker;

public class OrderFactory {

    public static OrderDto randomOrder() {
        return OrderDto.builder()
                .orderId(UUID.randomUUID().toString())
                .amount(faker.number().numberBetween(100, 5000))
                .currency(faker.currency().code())
                .orderDescription(faker.commerce().productName())
                .orderItems("item 1 x " + faker.number().numberBetween(1, 10) +
                        ", item 2 x " + faker.number().numberBetween(1, 10))
                .orderDate(LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .orderNumber(faker.number().numberBetween(1, 1000))
                .type("auth")
                .settleInterval(0)
                .force3ds(faker.bool().bool())
                .googlePayAllowedAuthMethods(List.of("PAN_ONLY"))
                .customerDateOfBirth(faker.date().birthday(18, 65).toInstant()
                        .toString().substring(0, 10))
                .customerEmail(faker.internet().emailAddress())
                .customerFirstName(faker.name().firstName())
                .customerLastName(faker.name().lastName())
                .customerPhone(faker.phoneNumber().cellPhone())
                .trafficSource("facebook")
                .transactionSource("main_menu")
                .purchaseCountry("USA")
                .geoCountry("USA")
                .geoCity(faker.address().cityName())
                .language("en")
                .website("https://solidgate.com")
                .orderMetadata(OrderMetadataDto.builder()
                        .couponCode("NY2024")
                        .partnerId(String.valueOf(faker.number().randomNumber()))
                        .build())
                .successUrl("http://merchant.example/success")
                .failUrl("http://merchant.example/fail")
                .build();
    }
}
