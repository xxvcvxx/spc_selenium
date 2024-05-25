package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProcessesPageCreate extends HomePage {

    public ProcessesPageCreate(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#Name")
    public WebElement nameTxt; //input[class='form-control reset']
    @FindBy(css = "body > div > div > div.right_col > div > div.row > div > div > div.x_content > div > form > div:nth-child(6) > div > input")
    public WebElement createButton; //textarea[class='form-control reset']

   //@FindBy(css = "body > div > div > div.right_col > div > div.row > div > div > div.x_content > div > form > div:nth-child(2) > span")
   //public WebElement errorMsg;

    @FindBy(css="body > div > div > div.right_col > div > div.row > div > div > div.x_content > div > form > div:nth-child(6) > div > a")
    public WebElement backToListButton;

    public ProcessesPageCreate addProcessName(String name) {
        nameTxt.clear();
        nameTxt.sendKeys(name);
        return this;
    }

    public ProcessesPage clickCreateProcess() {
        createButton.click();
        return new ProcessesPage(driver);
    }
    public ProcessesPageCreate clickFailCreateProcess() {
        createButton.click();
        return this;
    }
    //public ProcessesPageCreate assertProcessNameError(String expErrorMsg)
    //{
    //    Assert.assertEquals(errorMsg.getText(),expErrorMsg);
    //    return this;
    //}
    public ProcessesPage backToList()
    {
        backToListButton.click();
        return new ProcessesPage(driver);
    }
}
