package org.example.framework.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsuranceTravelPage extends BasePage {
    @FindBy(xpath = "//h1[@data-test]")
    private WebElement headerInsuranceSection;
    @FindBy(xpath = "//a[contains(@href, 'travel/#form')]")
    private WebElement calcCount;


    /**
     * Открытие страницы страхование
     *
     * @return InsuranceTravelPage - т.е. this
     */
    @Step("Открытие страницы \"Страхование\"")
    public InsuranceTravelPage checkOpenInsuranceSection() {
        checkOpenWithText("Страховые продукты Тинькофф", headerInsuranceSection);
        return this;
    }

    /**
     * Нажатие по кнопке расчитать стоймость
     *
     * @return InsuranceTravelForm.class
     */
    @Step("Нажатие по кнопке \"Расчитать стоймость\" в блоке \"Страхование для туристов\"")
    public InsuranceTravelForm clickCalculatedCount() {
        LOGGER.info("Клик по ссылке \"Расчитать стоймость\" в \"Страхование для туристов\"");
        calcCount.click();
        return pageManager.getPage(InsuranceTravelForm.class);
    }
}
