package com.epam.test.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;

public class GoogleHomePage extends BasePage{

    @FindBy(how = How.NAME, using = "q")
    private WebElement searchField;

    public void fillSearchRequest(String text) {
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.ENTER);
    }
}
