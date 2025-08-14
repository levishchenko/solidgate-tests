package org.solidgate.api.assertions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.solidgate.api.conditions.Condition;

@RequiredArgsConstructor
public class AssertableResponse {

    private final Response response;

    public AssertableResponse shouldHave(Condition condition) {
        condition.check(response);
        return this;
    }

    public <T> T asPojo(Class<T> tClass) {
        return response.as(tClass);
    }
}
