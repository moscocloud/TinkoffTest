package org.example.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InsuranceTravelForm extends BasePage {
    @FindBy(xpath = "//h2[@data-test]")
    private WebElement headerInsuranceTravel;
    @FindBy(xpath = "//input[@name='vzr_region']")
    private WebElement inputCountry;
    @FindBy(xpath = "//span[@aria-label='Удалить']/..")
    private WebElement fieldCountry;
    @FindBy(xpath = "//input[@inputmode='numeric']")
    List<WebElement> fieldDate;

    @FindBy(xpath = "//button[@name='goForward']")
    private WebElement buttonCalc;

    /**
     * Проверка открыти страницы оформления страховки для путешествий
     *
     * @return InsuranceTravelForm - т.е. this
     */
    @Step("Открытия страницы оформления страховки для путешествий")
    public InsuranceTravelForm checkOpenFormInsuranceTravel() {
        checkOpenWithText("Оформите страховку для путешествий", headerInsuranceTravel);
        return this;
    }

    /**
     * Ввод страны поездки
     *
     * @param country Страна поездки
     * @return this
     */
    @Step("Ввод в поле страна поездки \"{country}\"")
    public InsuranceTravelForm inputFieldCountry(String country) {
        LOGGER.info("Ввод страны поездки");
        fillingField(inputCountry, country);
        inputCountry.sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.ESCAPE);
        checkCurretText(country, fieldCountry);
        return this;
    }

    /**
     * Ввод даты начала и конца поездки
     *
     * @param dayStart   День начала поездки
     * @param mountStart Месяц начала поездки
     * @param yearStart  Год начала поездки
     * @param dayEnd     День окончания поездки
     * @param mountEnd   Месяц окончания поездки
     * @param yearEnd    Год окончания поездки
     * @return this
     */
    @Step("Ввод даты начала ({dayStart}.{mountStart}.{yearStart})" +
            " и окончания ({dayEnd}.{mountEnd}.{yearEnd}) поездки")
    public InsuranceTravelForm inputFieldDate(String dayStart, String mountStart, String yearStart, String dayEnd, String mountEnd, String yearEnd) {

        LOGGER.info("Ввод даты начала и конца поездки");

        String[] dates = {dayStart, mountStart, yearStart, dayEnd, mountEnd, yearEnd};
        WebElement[] fieldDates = fieldDate.toArray(WebElement[]::new);

        for (int i = 0; i < fieldDates.length; i++) {
            fieldDates[i].sendKeys(dates[i]);
        }
        return this;
    }

    /**
     * Нажатие на кнопку к точному рассчету
     *
     * @return this
     */
    @Step("Нажатие по кнопке \"К точному расчету\"")
    public InsuranceTravelForm clickButtonCalculated() {
        LOGGER.info("Клик по кнопке\"К точному расчету\"");
        buttonCalc.click();
        return this;
    }
}