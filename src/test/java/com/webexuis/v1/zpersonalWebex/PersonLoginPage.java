package com.webexuis.v1.zpersonalWebex;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ui.Driver;

public class PersonLoginPage {

    @FindBy(className = "el-button el-button--primary el-button--medium")
    public static WebElement buttonSingIn;

    @FindBy(className = "el-button el-button--primary el-button--medium")
    public static WebElement buttonSingIn1;

    public PersonLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



}

