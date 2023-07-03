package managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverManager {
    WebDriver driver;

    private WebDriver getDriver() {

        return driver = WebDriverManager.chromedriver().create();
    }

    public WebDriver instance() {
        if (driver == null) {
            return getDriver();
        } else {
            return driver;
        }
    }

    /**
     * Выбор элимента и клик по элементу. Выбор осущетвляется при помощи Xpath
     */
    public void clickElement(String xpath) {
        instance().findElement(By.xpath(xpath)).click();

    }

    /**
     * Выбор элимента и клик по элементу. Выбор осущетвляется при помощи Css
     */
    public void clickElementByCss(String cssSelector) {
        instance().findElement(By.cssSelector(cssSelector)).click();
    }

    /**
     * Поиск элемента по Xpath. Возвращает элемент типа "WebElement"
     */
    public WebElement findXpath(String xpath) {
        return instance().findElement(By.xpath(xpath));
    }

    /**
     * Поиск элемента по Css. Возвращает элемент типа "WebElement"
     */
    public WebElement findCss(String cssSelector) {
        return instance().findElement(By.cssSelector(cssSelector));
    }

    /**
     * Ввод в поле значения. Метод принимает два параметра строку xpath и строку value.
     * Первый параметр указывает путь до элемента в формате Xpath. Второй параметр
     * передает строку которую нужно вставать в поле.
     * <p>
     * Метод сначала кликает по элементу. Потом очищает элемент, после вставляет значение
     * переданое вторым параметром и в конце сверяет значение поля после написания с значением
     * которое передали
     */
    public void inputField(String xpath, String value) {
        WebElement element = instance().findElement((By.xpath(xpath)));
        element.click();
        element.clear();
        element.sendKeys(value);
        Assertions.assertEquals(value, value, "Поле было введено некорректно");
    }

    /**
     * Выполяет ту же функциональность что и метод inputField, но находит элемент по css селектору.
     */
    public void inputFieldByCssSelector(String cssSelector, String value) {
        WebElement element = instance().findElement((By.cssSelector(cssSelector)));
        element.click();
        element.clear();
        element.sendKeys(value);
        Assertions.assertEquals(value, value, "Поле было введено некорректно");
    }
}

