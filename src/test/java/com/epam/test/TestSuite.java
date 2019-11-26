package com.epam.test;

import com.epam.test.config.Browser;
import com.epam.test.page.GoogleHomePage;
import com.epam.test.page.GoogleResultsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestSuite {

    @AfterClass
    public void cleanup() {
        Browser.get().close();
    }

    @Test
    public void firstTest(){
        Browser.get().get("http://www.google.com");
        GoogleHomePage page = new GoogleHomePage();
        page.fillSearchRequest("automation");
        GoogleResultsPage resultsPage = new GoogleResultsPage();
        resultsPage.firstLinkResults();
        Assert.assertTrue(Browser.get().getTitle().toLowerCase().contains("automation"), "Automation title was not found");
    }

    @Test
    public void secondTest(){
        Browser.get().get("http://www.google.com");
        GoogleHomePage page = new GoogleHomePage();
        page.fillSearchRequest("automation");
        GoogleResultsPage resultsPage = new GoogleResultsPage();
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
