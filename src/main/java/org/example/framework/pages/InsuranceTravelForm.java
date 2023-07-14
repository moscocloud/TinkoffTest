package org.example.framework.pages;

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


    public InsuranceTravelForm checkOpenFormInsuranceTravel() {
        checkOpenWithText("Оформите страховку для путешествий", headerInsuranceTravel);
        return this;
    }

    public InsuranceTravelForm inputFieldCountry(String country) {

        fillingField(inputCountry, country);
        inputCountry.sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.ESCAPE);
        checkCurretText(country, fieldCountry);
        return this;
    }

    public InsuranceTravelForm inputFieldDate(String dayStart, String mountStart, String yearStart, String dayEnd, String mountEnd, String yearEnd) {

        LOGGER.info("Ввод даты начала и конца поездки");

        String[] dates = {dayStart, mountStart, yearStart, dayEnd, mountEnd, yearEnd};
        WebElement[] fieldDates = fieldDate.toArray(WebElement[]::new);

        for (int i = 0; i < fieldDates.length; i++) {
            fieldDates[i].sendKeys(dates[i]);
        }
        return this;
    }

    public InsuranceTravelForm clickButtonCalc() {
        LOGGER.info("Клик по кнопке\"К точному расчету\"");
        buttonCalc.click();
        return this;
    }
}

//
//        LOG.info("Ввод в поле \"Дата путешествия\"");
//        String partXpathStart = "//input[@name='vzr_calendar-start-%s']";
//        String partXpathEnd = "//input[@name='vzr_calendar-end-%s']";
//
//        driverManager.inputField(String.format(partXpathStart, "day"), "29");
//        driverManager.inputField(String.format(partXpathStart, "month"), "06");
//        driverManager.inputField(String.format(partXpathStart, "year"), "2023");
//        driverManager.inputField(String.format(partXpathEnd, "day"), "29");
//        driverManager.inputField(String.format(partXpathEnd, "month"), "08");
//        driverManager.inputField(String.format(partXpathEnd, "year"), "2023");
//