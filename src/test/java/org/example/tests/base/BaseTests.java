package org.example.tests.base;

import managers.DriverManager;
import managers.InitManager;
import managers.PageManager;
import managers.TestPropManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import utils.PropsConst;

public class BaseTests {

    private DriverManager driverManager = DriverManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();
    private TestPropManager propManager = TestPropManager.getInstance();

    @BeforeAll
    public static void beforeClass() {
        InitManager.initFramework();
    }
    @BeforeEach
    public void before() {
        driverManager.getDriver().get(propManager.getProperty(PropsConst.BASE_URL));
    }

    @AfterEach
    public void after() {
    InitManager.quitFramework();
    }
}
