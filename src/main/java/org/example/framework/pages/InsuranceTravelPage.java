package org.example.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsuranceTravelPage extends BasePage {
    @FindBy(xpath = "//h1[@data-test]")
    private WebElement headerInsuranceSection;
    @FindBy(xpath = "//a[contains(@href, 'travel/#form')]")
    private WebElement calcCount;

    /**
     * Метод проверяет открытие страницы страхования.
     *
     * @return - this
     */
    public InsuranceTravelPage checkOpenInsuranceSection() {
        checkOpenWithText("Страховые продукты Тинькофф", headerInsuranceSection);
        return this;
    }

    /**
     * @return
     */
    public InsuranceTravelForm clickCalculatedCount() {
        LOGGER.info("Клик по ссылке \"Расчитать стоймость\" в \"Страхование для туристов\"");
        calcCount.click();
        return pageManager.getPage(InsuranceTravelForm.class);
    }
}
