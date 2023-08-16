package com.mir.tests;

import com.mir.annotations.FrameworkAnnotation;
import com.mir.pages.LoginPage;
import com.mir.reports.ExtentManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @DataProvider
    public static Object[][] getData() {
        return new Object[][]{{"Admin", "admin123", "OrangeHRM"}};
    }
   @FrameworkAnnotation(author = "Mir A Mamun")
    @Test(description = "To check whether the user the title of orangehrm website homepage is displayed correctly"
            , dataProvider = "getData")
    public void titleValidationTest(String username, String password, String expected) {
        LoginPage loginPage = new LoginPage();
        String actualTitle = loginPage
                .loginToApplication(username, password)
                .getHomePageTitle();

        Assert.assertEquals(actualTitle, expected);

    }
}
