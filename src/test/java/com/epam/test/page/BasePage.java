package com.epam.test.page;

import com.epam.test.config.Browser;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage()
    {
        PageFactory.initElements(Browser.get(), this);
    }
}
