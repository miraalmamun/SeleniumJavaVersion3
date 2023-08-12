package com.mir.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager() {
    }

    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static WebDriver getDriverThreadLocal() {
        return DRIVER_THREAD_LOCAL.get();
    }

    public static void setDriverThreadLocal(WebDriver driver) {
        DRIVER_THREAD_LOCAL.set(driver);
    }
}
