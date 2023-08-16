package com.mir.pages.pagecomponent;

import com.mir.driver.DriverManager;
import org.openqa.selenium.By;

public class FooterMenuComponent {

    private static final By labelFooterMessage = By.id("footer");

    public String getFooterLabel(){
       return DriverManager.getDriverThreadLocal().findElement(labelFooterMessage).getText();
    }
}
