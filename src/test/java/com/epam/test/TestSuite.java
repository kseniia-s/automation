package com.epam.test;

import com.epam.test.config.ChromeConfig;
import com.epam.test.page.GoogleHomePage;
import com.epam.test.page.GoogleResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestSuite {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeConfig().config();
    }

    @AfterClass
    public void cleanup() {
        driver.close();
    }

    @Test
    public void firstTest(){
        driver.get("http://www.google.com");
        GoogleHomePage page = new GoogleHomePage(driver);
        page.fillSearchRequest("automation");
        GoogleResultsPage resultsPage = new GoogleResultsPage(driver);
        resultsPage.firstLinkResults();
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("automation"), "Automation title was not found");
    }

    @Test
    public void secondTest(){
        driver.get("http://www.google.com");
        GoogleHomePage page = new GoogleHomePage(driver);
        page.fillSearchRequest("automation");
        GoogleResultsPage resultsPage = new GoogleResultsPage(driver);
        //Assert.assertTrue(resultsPage.isTextPresent("testautomationday.com")
        for (int i = 1; i < 5; i++) {
           if (!resultsPage.isTextPresent("testautomationday.com")) {
               resultsPage.nextPage();
           } else {
               return;
           }
        }
        Assert.fail("Domain not found.");
    }
}
