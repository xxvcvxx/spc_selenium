package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Dashboard {
    protected WebDriver driver;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".x_title>h2")
    public WebElement header;

    public Dashboard assertDashboardURL() {
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:4444/");
        return this;
    }

    public Dashboard assertDashboardHeader() {
        Assert.assertEquals(header.getText(), "DEMO PROJECT");
        return this;
    }
}

