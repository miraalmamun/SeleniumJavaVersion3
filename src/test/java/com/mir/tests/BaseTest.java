package com.mir.tests;

import com.mir.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void setUp() {
        Driver.initDriver();
    }
    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}