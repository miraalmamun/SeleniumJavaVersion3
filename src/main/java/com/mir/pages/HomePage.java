package com.mir.pages;


import com.mir.driver.DriverManager;
import com.mir.pages.pagecomponent.FooterMenuComponent;
import com.mir.pages.pagecomponent.TopMenuComponent;

public class HomePage { // IS A

    //ul[@class='oxd-main-menu']/li//*[text()='Admin']
    //HomePage has TopMenu  ->composition
    // HomepageTest IS A Test --> inheritance

    private final TopMenuComponent topMenuComponent;
    private final FooterMenuComponent footerMenuComponent;

    public HomePage(){
        topMenuComponent = new TopMenuComponent();
        footerMenuComponent = new FooterMenuComponent();
    }

    public String getHomePageTitle() {
        return DriverManager.getDriverThreadLocal().getTitle();
    }

    public void clickOnAdmin(){

        topMenuComponent.clickOnMenu("value");
    }
    public String getFooterText(){
        return footerMenuComponent.getFooterLabel();
    }
}