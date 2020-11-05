package com.webexuis.v1.developWebex.pageFrames;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ui.Driver;

// Frame for all application pages. Similar class is in each web application.
// Class contains same elements for all pages of web application
// for example: side menu, header, footer
// I tried to separate each element of the pages (side menu, header, footer in the separate class, but
// multiple inheritance is prohibited in Java so solution for it is searched)

public abstract class PageFrame {

        public PageFrame(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    // ===========      =================   SideMenu   ================       =================  //

    @FindBy(xpath = "//*[@class='page-content-wrapper']//a[@href='/docs/platform-introduction']")
    public WebElement menuOverviewPlatformIntrodution;

    @FindBy(xpath = "//*[@class='page-content-wrapper']//a[@href='/docs/bots']")
    public WebElement menuOverviewBots;

    @FindBy(xpath = "//*[@class='page-content-wrapper']//a[@href='/docs/integrations']")
    public WebElement menuOverviewIntegrations;

    @FindBy(xpath = "//*[@class='page-content-wrapper']//a[@href='/docs/widgets']")
    public WebElement menuOverviewWidgets;

    @FindBy(xpath = "//*[@class='page-content-wrapper']//a[@class='md-submenu__item' and @href='/docs/guest-issuer']")
    public WebElement menuOverviewGuestIssuer;

    @FindBy(xpath = "//*[@class='page-content-wrapper']//a[@href='/docs/api/getting-started']")
    public WebElement menuApiGettingStarted;

    @FindBy(xpath = "//*[@class='page-content-wrapper']//a[@href='/docs/api/basics']")
    public WebElement menuApiBasics;

    @FindBy(xpath = "//*[@class='page-content-wrapper']//div[@class='md-list-item active']")
    public WebElement menuApiGuides;

    @FindBy(xpath = "//*[@class='page-content-wrapper']//div[@id='md-sidebar__nav-item-2-4']")
    public WebElement menuApiAPIReference;

// ================== Start Group menu People ========================//
        @FindBy(xpath = "//*[@class='page-content-wrapper']//a[@href='/docs/api/v1/people']")
        public WebElement menuApiAPIReferencePeople;

            @FindBy(xpath = "//div[@class='md-list md-list--vertical md-submenu menu-People']//a[@href='/docs/api/v1/people/list-people']")
            public WebElement menuApiAPIReferencePeopleGetList;
    // ================== End Group menu People ========================//

    @FindBy(xpath = "//*[@class='page-content-wrapper']//a[@href='/docs/api/changelog']")
    public WebElement menuApiAPIChangelog;
}
