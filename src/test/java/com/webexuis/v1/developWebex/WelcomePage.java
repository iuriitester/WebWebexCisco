package com.webexuis.v1.developWebex;

import com.webexuis.v1.adminWebex.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.applications.develop.initialSteps.DevelopBasePages;
import utilities.ui.Driver;

public class WelcomePage {
    public WelcomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='md-list-item' and @href='/docs/platform-introduction']")
    public WebElement documentation;

    @FindBy(id = "header-login-link")
    public WebElement logIn;

    @FindBy(id = "header-logout-link")
    public WebElement logOut;

    @FindBy(className = "md-avatar__letter user-image")
    public WebElement avatar;



}
