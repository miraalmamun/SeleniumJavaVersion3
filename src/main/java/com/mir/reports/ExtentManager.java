package com.mir.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private ExtentManager(){}

    private static final ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

    public static ExtentTest getExtentTest(){
        return threadLocal.get();
    }

    public static void setExtentTest(ExtentTest test){
        threadLocal.set(test);

    }
}