package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    private final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private final By usernameLocator = By.name("username");
    private final By passwordLocator = By.name("password");
    private final By loginButton = By.tagName("button");
    private final By invalidMessage = By.xpath("//p[text() = 'Invalid credentials']");
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        driver.get(url);
    }

    public DashboardPage loginValidUser(String username, String password) {
        login(username, password);
        return new DashboardPage(driver);
    }

    public void loginInvalidUser(String username, String password) {
        login(username, password);
    }

    private void login(String username, String password) {
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getInvalidMessage() {
        return driver.findElement(invalidMessage).getText();
    }

}
