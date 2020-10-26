package com.webexuis.v1.adminWebex;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.initalStep.BaseStep;
import utilities.ui.Driver;

public class LoginPage{

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "md-input.ng-untouched.ng-pristine.ng-invalid")
    public WebElement email;

    @FindBy(className = "md-button--blue.md-button md-button--36.md-button--disabled")
    public WebElement buttonSignIn;

    public void login(String name, String password){

    }

}
