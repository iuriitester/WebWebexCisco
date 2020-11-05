package com.webexuis.v1.developWebex;

import com.webexuis.v1.developWebex.pageFrames.PageFrame;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// web application page
public class GettingStartedPage extends PageFrame {

    @FindBy(id="copy-token-modal-button")
    public WebElement bodyTokenButton;

    @FindBy(id = "confirm-copy-button")
    public WebElement okButton;

}
