package com.mir.utiles;

import com.mir.config.ConfigsFactory;
import com.mir.driver.DriverManager;
import com.mir.enums.WaitType;
import com.mir.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class SeleniumAction {

    private static final Logger LOGGER = Logger.getLogger(SeleniumAction.class.getName());

    private SeleniumAction() {
    }

    public static void click(By by, String elementName) {
        WebElement element = waitUntilElementPresent(by);
        element.click();
         //ExtentLogger.pass(elementName + " is clicked successfully");
    }

    public static void click(WebElement element) {
        element.click();
    }


    public static void click(By by, WaitType waitType) {
        WebElement element = switch (waitType) {
            case PRESENCE -> waitUntilElementPresent(by);
            case CLICKABLE -> waitUntilElementToBeClickable(by);
            case VISIBLE -> waitUntilElementToBeVisible(by);
        };
        LOGGER.log(Level.INFO, "Element click for locator: " + by);
        element.click();
    }


    public static void sendKeys(By by, String value, String elementName) {
        WebElement element = waitUntilElementToBeVisible(by);
        element.sendKeys(value);
        // ExtentLogger.pass(value + " is entered "+ " successfully in "+elementName);
    }


    private static WebElement waitUntilElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriverThreadLocal(), Duration.ofSeconds(ConfigsFactory.getConfig().timeout()));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private static WebElement waitUntilElementToBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriverThreadLocal(), Duration.ofSeconds(ConfigsFactory.getConfig().timeout()));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    private static WebElement waitUntilElementToBeVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriverThreadLocal(), Duration.ofSeconds(ConfigsFactory.getConfig().timeout()));

        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            LOGGER.log(Level.WARNING, "Timeout waiting for element presence. " + by);
            throw new NoSuchElementException("Element not visible or not intractable for locator: " + by);
        }
    }


}
