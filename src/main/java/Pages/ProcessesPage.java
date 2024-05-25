package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProcessesPage extends HomePage {
    public ProcessesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".title_left>h3")
    public WebElement header;

    @FindBy(css = "a[class='btn btn-success'")
    //@FindBy(css="button[type=")
    public WebElement createProcessButton;

    public ProcessesPage assertProcessesURL() {
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:4444/Projects");
        return this;
    }

    public ProcessesPage assertProcessesHeader() {
        Assert.assertEquals(header.getText(), "Processes");
        return this;
    }

    private String GENERIC_PROCESS_ROW_XPATH = "//td[text()='%s']/..";

    public ProcessesPage assertProcess(String expName, String expDescription, String expNotes) {
        String processXpath = String.format(GENERIC_PROCESS_ROW_XPATH, expName);
        WebElement processRow = driver.findElement(By.xpath(processXpath));
        String actDescription = processRow.findElement(By.xpath("./td[2]")).getText();
        String actNotes = processRow.findElement(By.xpath("./td[3]")).getText();
        Assert.assertEquals(actDescription, expDescription);
        Assert.assertEquals(actNotes, expNotes);
        return this;
    }

    public ProcessesPageCreate clickAddProcess() {
        createProcessButton.click();
        return new ProcessesPageCreate(driver);
    }

    public ProcessesPage assertProcessIsNotShown(String processName) {
        String processXpath = String.format(GENERIC_PROCESS_ROW_XPATH, processName);
        List<WebElement> process = driver.findElements(By.xpath(processXpath));
        return this;
    }
}
