package org.example.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TinkoffBankTest extends BaseTest {
    @Test
    public void checkInsurance() {
        WebDriverWait wait = new WebDriverWait(driverManager.instance(), 10, 2000);

        LOG.info("Проверка открытия сайта");
        WebElement logoBank = driverManager.findXpath("//img[@alt='Tinkoff']");
        Assertions.assertTrue(logoBank.isDisplayed(), "Страница не загрузилась");

        LOG.info("Клик по вкладке \"Страхование\"");
        WebElement insuranceSection = driverManager.findXpath("//a[contains(@href, '/insurance/?internal_source') and @data-qa-type='uikit/clickable']");
        insuranceSection.click();

        LOG.info("Проверка перехода по вкладке \"Страхование\"");
        WebElement headerInsuranceSection = driverManager.findXpath("//h1[@data-test]");
        Assertions.assertTrue(headerInsuranceSection.isDisplayed(), "Страница не загрузилась");

        LOG.info("Клик по ссылке \"Расчитать стоймость\" в \"Страхование для туристов\"");
        driverManager.clickElement("//a[contains(@href, 'travel/#form')]");

        LOG.info("Проверка перехода по ссылке \"Расчитать стоймость\"");
        WebElement headerTravelInsurance = driverManager.findXpath("//h2[@data-test]");
        Assertions.assertEquals(headerTravelInsurance.getText(), "Оформите страховку для путешествий");

        String country = "Швеция";
        LOG.info("Ввод в поле \"Страна поездки\" значение - " + country);
        driverManager.inputField("//input[@name='vzr_region']", country);

        LOG.info("Подтверждение выбора страны поездки");
        driverManager.clickElement("//span[@data-qa-type=\"uikit/multiSelectTagged.dropdown.item.title\" and text()='" + country + "']");

        LOG.info("Закрытие дропдауна кликом");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Выберите параметры страховки']")));
        driverManager.clickElement("//div[text()='Выберите параметры страховки']");

        LOG.info("Ввод в поле \"Дата путешествия\"");
        String partXpathStart = "//input[@name='vzr_calendar-start-%s']";
        String partXpathEnd = "//input[@name='vzr_calendar-end-%s']";

        driverManager.inputField(String.format(partXpathStart, "day"), "29");
        driverManager.inputField(String.format(partXpathStart, "month"), "06");
        driverManager.inputField(String.format(partXpathStart, "year"), "2023");
        driverManager.inputField(String.format(partXpathEnd, "day"), "29");
        driverManager.inputField(String.format(partXpathEnd, "month"), "08");
        driverManager.inputField(String.format(partXpathEnd, "year"), "2023");

        LOG.info("Нажатие на кнопку \"К точному расчету\"");
        driverManager.clickElement("//button[@name='goForward']");
        System.out.println("Пока всё");
    }
}

