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
        WebElement logoBank = driverManager.instance().findElement(By.xpath("//img[@alt='Tinkoff']"));
        Assertions.assertTrue(logoBank.isDisplayed(), "Страница не загрузилась");

        LOG.info("Клик по вкладке \"Страхование\"");
        WebElement insuranceSection = driverManager.instance().findElement(By.xpath("//a[contains(@href, '/insurance/?internal_source') and @data-qa-type='uikit/clickable']"));
        insuranceSection.click();

        LOG.info("Проверка перехода по вкладке \"Страхование\"");

        /*Можно выполнить проверку при помощи объекта wait*/
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@data-test]")));

        WebElement headerInsuranceSection = driverManager.instance().findElement(By.xpath("//h2[@data-test]"));
        Assertions.assertTrue(headerInsuranceSection.isDisplayed(), "Страница не загрузилась");

        LOG.info("Клик по ссылке \"Расчитать стоймость\" в \"Страхование для туристов\"");
        driverManager.clickElement("//a[contains(@href, 'travel/#form')]");

        LOG.info("Проверка перехода по ссылке \"Расчитать стоймость\"");
        WebElement headerTravelInsurance = driverManager.instance().findElement(By.xpath("//h2[@data-test]"));
        Assertions.assertEquals(headerTravelInsurance.getText(), "Оформите страховку для путешествий");

        LOG.info("Ввод в поле \"Страна поездки\"");
        String country = "Швеция";
        driverManager.inputField("//input[@name='vzr_region']", country);

        LOG.info("Подтверждение выбора страны поездки");
        driverManager.clickElement("//span[@data-qa-type=\"uikit/multiSelectTagged.dropdown.item.title\" and text()='" + country + "']");

        LOG.info("Закрытие дропдауна кликом");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Выберите параметры страховки']")));
        driverManager.clickElement("//div[text()='Выберите параметры страховки']");

        LOG.info("Ввод в поле \"Дата путешествия\"");

        String partXpathStart = "//input[@name='vzr_calendar-start-";
        String partXpathEnd = "//input[@name='vzr_calendar-end-";

        driverManager.inputField(partXpathStart + "day']", "29");
        driverManager.inputField(partXpathStart + "month']", "06");
        driverManager.inputField(partXpathStart + "year']", "2023");
        driverManager.inputField(partXpathEnd + "day']", "29");
        driverManager.inputField(partXpathEnd + "month']", "08");
        driverManager.inputField(partXpathEnd + "year']", "2023");

        LOG.info("Нажатие на кнопку \"К точному расчету\"");
        driverManager.clickElement("//button[@name='goForward']");

        System.out.println("Пока всё");

    }


}

