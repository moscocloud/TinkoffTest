package org.example.framework.pages;

import managers.DriverManager;
import managers.PageManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected DriverManager driverManager = DriverManager.getInstance();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(),10,1000);
    protected PageManager pageManager = PageManager.getInstance();

    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(),this);
    }
}
