package com.mir.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private ExtentManager(){}

    private static final ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

    /**
     *
     * @return important note in V1 it was public
     * in this version(V2) now default. Now it is only accessible within same package
     * Here only allow to access ExtentLogger class. Outside reports package not allow
     * to access getExtentTest() and setExtentTest(ExtentTest test). If someone want to
     * log then have to use ExtentLogger class
     */
     static ExtentTest getExtentTest(){
        return threadLocal.get();
    }

     static void setExtentTest(ExtentTest test){
        threadLocal.set(test);

    }
}