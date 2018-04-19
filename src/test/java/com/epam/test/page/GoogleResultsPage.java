package com.epam.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class GoogleResultsPage {

    private WebDriver webDriver;
    private WebElement searchResultLink;
    private WebElement elemOnPage;
    private WebElement allText;
    private WebElement nextPageElem;

    public GoogleResultsPage(WebDriver driver) {
        this.webDriver = driver;
        initElements();
    }

    private void initElements() {
        searchResultLink = webDriver.findElement(By.xpath("//h3[@class='r']/a"));
        elemOnPage = webDriver.findElement(By.xpath("//*[@id=\'rso\']/div"));
    }

    public void firstLinkResults(){
        searchResultLink.click();
    }

    public boolean isTextPresent(String text){
        List<WebElement> elementsList = webDriver.findElements(By.xpath("//*[contains(text(), \""+text+"\")]"));
        return !elementsList.isEmpty();
    }

    public void nextPage(){
        nextPageElem = webDriver.findElement(By.xpath("//*[@id=\'pnnext\']/span[2]"));
        nextPageElem.click();
    }
}

