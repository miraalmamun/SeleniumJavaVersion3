package com.mir.pages;

import com.mir.enums.WaitType;
import org.openqa.selenium.By;

import static com.mir.utiles.SeleniumAction.click;
import static com.mir.utiles.SeleniumAction.sendKeys;

public class LoginPage {
    /**
     * //Keep all your locators and methods in one class
     */

    private static final By INPUT_TEXT_USERNAME = By.name("username");
    private static final By INPUT_TEXT_PASSWORD = By.name("password");
    private static final By BTN_LOGIN = By.xpath("//div[@class='orangehrm-login-slot-wrapper']");

    private LoginPage setUserName(String username) {
        sendKeys(INPUT_TEXT_USERNAME, username, "Username");
        return this;
    }

    private LoginPage setPassword(String password) {
        sendKeys(INPUT_TEXT_PASSWORD, password, "Password");
        return this;
    }

    private HomePage setLogin() {
        click(BTN_LOGIN, "Login Button");
        return new HomePage();
    }

    /**
     *
     * @return HomePage
     */
    private HomePage clickBtnLogin() {
        click(BTN_LOGIN, WaitType.VISIBLE);
        return new HomePage();
    }

    public  HomePage loginToApplication(String username, String password) {
        return setUserName(username)
                .setPassword(password)
                .setLogin();
    }
}