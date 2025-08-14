package org.solidgate.utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface ProjectConfig extends Config {

    String paymentPageApiUrl();

    String cardPaymentApiUrl();

    boolean logging();

    String publicKey();

    String secretKey();

    String validCard();

    String browser();

    boolean headless();
}
