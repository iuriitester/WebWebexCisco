package com.webexuis.v1.developWebex;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ui.BrowserUtils;
import utilities.ui.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[.='Log in'])[2]")
    public WebElement logInButton;

    @FindBy(id = "IDToken1")
    public WebElement emailAddress;

    @FindBy(id = "IDButton2")
    public WebElement buttonNext;

    @FindBy(id="IDToken2")
    public WebElement passwordIntrans;

    @FindBy(id = "Button1")
    public WebElement buttonSignIn;

    @FindBy(id="copy-token-modal-button")
    public  WebElement tokenButton;

    @FindBy(xpath = "//span[.='Ok']")
    public WebElement okButton;

    public void login(String email,String password){
        logInButton.click();
        BrowserUtils.waitForVisibility(emailAddress,3);
        emailAddress.sendKeys(email);
        buttonNext.click();
        BrowserUtils.waitForVisibility(passwordIntrans,2);
        passwordIntrans.sendKeys(password);
        buttonSignIn.click();

    }
}
