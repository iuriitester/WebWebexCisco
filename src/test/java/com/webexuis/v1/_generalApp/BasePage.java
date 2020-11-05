package com.webexuis.v1._generalApp;

import org.openqa.selenium.support.PageFactory;
import utilities.ui.Driver;

public abstract class BasePage {

    // getting singleton WebDriver
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
