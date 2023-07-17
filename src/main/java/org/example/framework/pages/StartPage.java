package org.example.framework.pages;


import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StartPage extends BasePage {

    @FindBy(xpath = "//img[@alt='Tinkoff']")
    private WebElement logo;

    @FindBy(xpath = "//div[@data-test='panel slides']/ul/li")
    private List<WebElement> baseMenu;


    /**
     * Открытие сайта Тинькофф
     *
     * @return this - т.е. BasePage
     */
    @Step("Открытие сайта Тинькофф")
    public StartPage checkLogoIsDisplayed() {
        LOGGER.info("Проверка открытия сайта");
        logo.isDisplayed();
        return this;
    }


    /**
     * Нажатие на кнопку "name menu"
     *
     * @param nameMenu - раздел
     * @return InsuranceTravelPage.class
     */
    @Step("Нажатие по кнопке \"{nameMenu}\"")
    public InsuranceTravelPage selectBaseMenuByText(String nameMenu) {

        LOGGER.info(String.format("Клик по вкладке \"%s\"", nameMenu));

        for (WebElement itemMenu : baseMenu) {
            if (itemMenu.getText().contains(nameMenu)) {
                itemMenu.click();
                return pageManager.getPage(InsuranceTravelPage.class);
            }
        }
        Assertions.fail("Меню с текстом " + nameMenu + " не найдено");
        return null;
    }
}
