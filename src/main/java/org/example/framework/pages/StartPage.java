package org.example.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StartPage extends BasePage{
    private static final Logger LOGGER = LoggerFactory.getLogger(StartPage.class);

    @FindBy(xpath = "//img[@alt='Tinkoff']")
    private WebElement logo;

    @FindBy(xpath = "//div[@data-test='panel slides']/ul/li")
    private List<WebElement> baseMenu;

    /**
     * Проверка логотипа на отображение
     */
    public StartPage logoIsDisplayed() {
       LOGGER.info("Проверка открытия сайта");
       logo.isDisplayed();
       return this;
    }

    /**
     * Клик по базовому меню - меню выбирается по тексту переданному на вход
     * @param nameMenu Текст переданный пользователеми
     */
    public void selectBaseMenuByText(String nameMenu){
        LOGGER.info(String.format("Клик по вкладке \"%s\"",nameMenu));
        for(WebElement itemMenu :baseMenu) {
            if(itemMenu.getText().contains(nameMenu)){
                itemMenu.click();
                return;
            }
        }
        Assertions.fail("Меню с текстом " + nameMenu + " не найдено");
    }
}
