package com.webexuis.v1._generalApp;

import com.webexuis.v1.adminWebex.AdminWebexPages;
import com.webexuis.v1.developWebex.DevelopWebexPages;
import com.webexuis.v1.webWebex.WebWebexPages;
import com.webexuis.v1.zpersonalWebex.PersonWebexPages;
import utilities.dictionary.Applications;

// Based class for all framework pages

public class Pages {
    private Applications app;
    private AdminWebexPages adminWebexPages;
    private DevelopWebexPages developWebexPages;
    private WebWebexPages webWebexPages;
    private PersonWebexPages personWebexPages;

    // app param defines a tested application
    // after creating applicationPage object creating pages of the application
    public Pages(Applications app) {
        this.app = app;
        switch (app){
            case admin: this.adminWebexPages = new AdminWebexPages(); break;
            case web: this.webWebexPages = new WebWebexPages(); break;
            case develop: this.developWebexPages = new DevelopWebexPages(); break;
            case person: this.personWebexPages = new PersonWebexPages(); break;
        }

    }

    public Applications getApp() {
        return app;
    }

    public AdminWebexPages getAdminWebexPages() {
        return adminWebexPages;
    }

    public DevelopWebexPages getDevelopWebexPages() {
        return developWebexPages;
    }

    public WebWebexPages getWebWebexPages() {
        return webWebexPages;
    }

    public PersonWebexPages getPersonWebexPages() {
        return personWebexPages;
    }
}
