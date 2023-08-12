package com.mir.driver;

import com.mir.config.ConfigsFactory;
import org.openqa.selenium.WebDriver;

import static com.mir.config.ConfigsFactory.getConfig;
import static com.mir.driver.DriverFactory.getDriver;
import static com.mir.driver.DriverManager.*;

public final class Driver {

    private Driver() {
    }


    /**
     * An essential point to note is that this method initially checks for the availability
     * of a driver in DriverManager.getDriverThreadLocal(). If a driver is not present, it
     * proceeds to establish a driver using DriverManager.setDriverThreadLocal().
     * The driver utilized in this process is sourced from the DriverFactory
     * class via the DriverFactory.getDriver() method.
     */
    public static void initDriver() {
        String browser = getConfig().browser();
        if (getDriverThreadLocal() == null) {
            WebDriver driver = getDriver(browser);
            setDriverThreadLocal(driver);
            getDriverThreadLocal().manage().window().maximize();
            getDriverThreadLocal().get(ConfigsFactory.getConfig().url());
        }
    }

    public static void quitDriver() {
        if (getDriverThreadLocal() != null) {
            getDriverThreadLocal().quit();
            setDriverThreadLocal(null);
        }
    }
}
