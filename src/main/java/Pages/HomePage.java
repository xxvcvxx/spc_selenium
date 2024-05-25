package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".profile_info>h2")
    public WebElement welcomeElm;
    @FindBy(css = ".menu-workspace")
    public WebElement workspaceNav;

    @FindBy(css = "a[href$=Projects]")
    public WebElement processesMenu;
    @FindBy(css = "a[href$='/']")
    public WebElement dashboardMenu;
    @FindBy(css = "a[href$=Characteristics]")
    public WebElement characteristicsMenu;


    private boolean isParentExpanded(WebElement menuLink) {
        WebElement parent = menuLink.findElement(By.xpath("./.."));
        return parent.getAttribute("class").contains("active");
    }

    //public ProcessesPage goToProcesses() {
    //    if (!isParentExpanded(workspaceNav)) {
    //        workspaceNav.click();
    //    }
    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    //    processesMenu.click();
    //    return new ProcessesPage(driver);
    //}
//
    //public CharacteristicsPage goToCharacteristics() {
    //    if (!isParentExpanded(workspaceNav)) {
    //        workspaceNav.click();
    //    }
    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    //    characteristicsMenu.click();
    //    return new CharacteristicsPage(driver);
    //}
    //public Dashboard goToDashboard() {
    //    if (!isParentExpanded(workspaceNav)) {
    //        workspaceNav.click();
    //    }
    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    //    dashboardMenu.click();
    //    return new Dashboard(driver);
    //}

    public HomePage assertWelcomeElementIsShow() {
        Assert.assertTrue(welcomeElm.isDisplayed(), "Welcome element is not shown.");
        Assert.assertTrue(welcomeElm.getText().contains("Welcome"), "Welcome element text: '"
                + welcomeElm.getText() + "' does not contain word 'Welcome'");
        return this;
    }
}
