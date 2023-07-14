package org.example.framework.pages;

import managers.DriverManager;
import managers.PageManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    protected static final Logger LOGGER = LoggerFactory.getLogger(StartPage.class);
    protected DriverManager driverManager = DriverManager.getInstance();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), 10, 1000);
    protected PageManager pageManager = PageManager.getInstance();

    Actions actions = new Actions(driverManager.getDriver());

    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    /**
     * Метод для сокрашения копипаста методов в пейджах. Проверка открытия страницы
     *
     * @param expect     Проверяемое значение текста
     * @param webElement Элемент с текстом
     */
    public void checkOpenWithText(String expect, WebElement webElement) {
        LOGGER.info("Проверка открытия страницы");
        Assertions.assertEquals(expect, webElement.getText(), "Страница не открылась");
    }

    /**
     * Метод для сокрашения копипаста методов в пейджах. Проверка введенного текста.
     *
     * @param expect     Проверяемое значение текста
     * @param webElement Элемент с текстом
     */
    public void checkCurretText(String expect, WebElement webElement) {
        LOGGER.info("Проверка введеных значений");
        Assertions.assertEquals(expect, webElement.getText(), "Страница не открылась");
    }

    /**
     * Метод ввода в поля значений.
     *
     * @param webElement - поле в которое вводим
     * @param value      вводимое значение
     */
    public void fillingField(WebElement webElement, String value) {
        webElement.click();
        webElement.clear();
        webElement.sendKeys(value);
    }

    public void waitting() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
