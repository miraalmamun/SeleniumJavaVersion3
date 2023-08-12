package com.mir.utiles;

import com.mir.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotUtils {

    private ScreenshotUtils(){}

    public static String getScreenshot(){
        return ((TakesScreenshot) DriverManager.getDriverThreadLocal()).getScreenshotAs(OutputType.BASE64);
    }

//    public static String getScreenshot() {
//        try {
//            TakesScreenshot threadLocal = (TakesScreenshot) DriverManager.getDriverThreadLocal();
//            String screenshotAs = threadLocal.getScreenshotAs(OutputType.BASE64);
//            return screenshotAs;
//        } catch (Exception e) {
//            LOGGER.log(Level.SEVERE, "Error while capturing screenshot: " + e.getMessage());
//            return null;
//        }
//    }

}