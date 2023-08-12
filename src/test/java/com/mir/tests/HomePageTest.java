package com.mir.tests;

import com.mir.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(description = "To check whether the user the title of orangehrm website homepage is displayed correctly")
    public void titleValidationTest() {

        LoginPage loginPage = new LoginPage();
        String actualTitle = loginPage
                .loginToApplication("Admin","admin123")
                .getHomePageTitle();

        Assert.assertEquals(actualTitle, "OrangeHRM");

    }
}
