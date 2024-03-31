package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.log.Log;
import pages.DashboardPage;
import pages.LoginPage;
import utils.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginTests extends TestBase {

    @Test()
    @DisplayName("LF1 - Verify Valid Login")
    public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        DashboardPage dashboardPage = loginPage.loginValidUser("Admin","admin123");
        assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", dashboardPage.getDashboardURL());
    }

    @Test()
    @DisplayName("LF2 - Verify Error Message for Invalid Credentials")
    public void verifyErrorMessageForInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.loginInvalidUser("root","123456");
        assertEquals("Invalid credentials", loginPage.getInvalidMessage());
    }
}
