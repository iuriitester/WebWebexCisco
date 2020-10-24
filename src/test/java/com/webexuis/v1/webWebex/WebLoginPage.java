package com.webexuis.v1.webWebex;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ui.Driver;

public class WebLoginPage {

    public WebLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "md-input")
    public WebElement email;

    @FindBy(xpath = "//*[@id=\"md-button-3\"]")
    public WebElement buttonNext;
}
