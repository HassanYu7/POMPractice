package pages;

import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getDashboardURL() {
        return driver.getCurrentUrl();
    }
}
