package com.epam.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage {

    private WebDriver webDriver;
    private WebElement searchField;

    public GoogleHomePage(WebDriver driver) {
        this.webDriver = driver;
        initElements();
    }

    private void initElements() {
        searchField = webDriver.findElement(By.name("q"));
    }

    public void fillSearchRequest(String text) {
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.ENTER);
    }
}
