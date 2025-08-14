package org.solidgate.utils;

import com.github.javafaker.Faker;
import org.aeonbits.owner.ConfigFactory;

public class TestContext {

    public static final Faker faker = new Faker();

    public static final ProjectConfig config =
            ConfigFactory.create(ProjectConfig.class, System.getProperties());
}
