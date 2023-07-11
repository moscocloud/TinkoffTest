package managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static DriverManager INSTANCE = null;
    private WebDriver driver;



    public static DriverManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
            return INSTANCE;
    }
    public WebDriver getDriver() {
        if(driver == null) {
            initDriver();
        }
        return driver;
    }

    private void initDriver() {
        driver = WebDriverManager.chromedriver().create();
    }

    public void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver=null;
        }
    }
}




































//    /**
//     * Выбор элимента и клик по элементу. Выбор осущетвляется при помощи Xpath
//     */
//    public void clickElement(String xpath) {
//        instance().findElement(By.xpath(xpath)).click();
//
//    }
//
//    /**
//     * Выбор элимента и клик по элементу. Выбор осущетвляется при помощи Css
//     */
//    public void clickElementByCss(String cssSelector) {
//        instance().findElement(By.cssSelector(cssSelector)).click();
//    }
//
//    /**
//     * Поиск элемента по Xpath. Возвращает элемент типа "WebElement"
//     */
//    public WebElement findXpath(String xpath) {
//        return instance().findElement(By.xpath(xpath));
//    }
//
//    /**
//     * Поиск элемента по Css. Возвращает элемент типа "WebElement"
//     */
//    public WebElement findCss(String cssSelector) {
//        return instance().findElement(By.cssSelector(cssSelector));
//    }
//
//    /**
//     * Ввод в поле значения. Метод принимает два параметра строку xpath и строку value.
//     * Первый параметр указывает путь до элемента в формате Xpath. Второй параметр
//     * передает строку которую нужно вставать в поле.
//     * <p>
//     * Метод сначала кликает по элементу. Потом очищает элемент, после вставляет значение
//     * переданое вторым параметром и в конце сверяет значение поля после написания с значением
//     * которое передали
//     */
//    public void inputField(String xpath, String value) {
//        WebElement element = instance().findElement((By.xpath(xpath)));
//        element.click();
//        element.clear();
//        element.sendKeys(value);
//        Assertions.assertEquals(value, value, "Поле было введено некорректно");
//    }
//
//    /**
//     * Выполяет ту же функциональность что и метод inputField, но находит элемент по css селектору.
//     */
//    public void inputFieldByCssSelector(String cssSelector, String value) {
//        WebElement element = instance().findElement((By.cssSelector(cssSelector)));
//        element.click();
//        element.clear();
//        element.sendKeys(value);
//        Assertions.assertEquals(value, value, "Поле было введено некорректно");
//    }
//}

