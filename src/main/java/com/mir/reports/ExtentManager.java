package com.mir.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private ExtentManager(){}

    private static final ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

    /**
     *
     * In version V1, the visibility of a certain element was set to "public,"
     * allowing it to be accessed from any part of the codebase. However, in
     * this updated version (V2), its visibility has been changed to "default."
     * Consequently, it is now only accessible within the same package.
     *
     * Specifically, access to the getExtentTest() and setExtentTest(ExtentTest test)
     * methods is restricted to within the reports package. These methods cannot be
     * accessed from outside the reports package. To perform logging operations,
     * one is required to use the ExtentLogger class. This design ensures controlled
     * and encapsulated access, promoting the appropriate use of these methods and
     * maintaining code organization
     *  ExtentManager.getExtentTest().assignAuthor("Mir").assignCategory("Smoke").assignCategory("Regression");
     */

      static ExtentTest getExtentTest(){
        return threadLocal.get();
    }

     static void setExtentTest(ExtentTest test){
        threadLocal.set(test);

    }
}