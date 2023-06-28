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

    public void clickElement(String xpath) {
        WebElement element = instance().findElement((By.xpath(xpath)));
        element.click();
    }

    public void inputField(String xpath, String value) {
        WebElement element = instance().findElement((By.xpath(xpath)));
        element.click();
        element.clear();
        element.sendKeys(value);
        Assertions.assertEquals(value, value, "Поле было введено некорректно");
    }
}
