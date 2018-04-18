package com.epam.test.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public class ChromeConfig {

    public WebDriver config() {
        URL url = ChromeConfig.class.getClassLoader().getResource("chromedriver.exe");

        System.setProperty("webdriver.chrome.driver", url.getPath());
        return new ChromeDriver();
    }
}
