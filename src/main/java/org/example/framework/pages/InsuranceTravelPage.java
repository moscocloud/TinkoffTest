package org.example.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsuranceTravelPage {

    @FindBy(xpath = "//h1[@data-test]")
    private WebElement headerInsuranceSection;
    @FindBy(xpath = "//a[contains(@href, 'travel/#form')]")
    private WebElement calcCount;


    public void checkOpenPage(){
        Assertions.assertTrue(headerInsuranceSection.isDisplayed(), "Страница не загрузилась");
    }

    public void clickCalculatedCount() {
        calcCount.click();
    }
}
