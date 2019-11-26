package com.epam.test.page;

import com.epam.test.config.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.List;

public class GoogleResultsPage extends BasePage {

    private WebElement allText;
    private WebElement nextPageElem;

    @FindBy(how = How.XPATH, using = "//h3[@class='r']/a")
    private WebElement searchResultLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\'rso\']/div")
    private WebElement elemOnPage;

    public void firstLinkResults() {
        searchResultLink.click();
    }

    public boolean isTextPresent(String text) {
        List<WebElement> elementsList = Browser.get().findElements(By.xpath("//*[contains(text(), \"" + text + "\")]"));
        return !elementsList.isEmpty();
    }

    public void nextPage() {
        nextPageElem = Browser.get().findElement(By.xpath("//*[@id=\'pnnext\']/span[2]"));
        nextPageElem.click();
    }
}

