package org.example.tests;

import logger.Logger;
import managers.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    Logger LOG = new Logger();
    DriverManager driverManager = new DriverManager();

    @BeforeEach
    public void beforeEach() {

        driverManager.instance().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driverManager.instance().manage().window().maximize();

        LOG.info("Открытие сайта Тинькофф");
        driverManager.instance().get("https://www.tinkoff.ru/");
    }

    @AfterEach
    public void after() {
        driverManager.instance().close();
    }
}
