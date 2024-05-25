package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.xml.xpath.XPath;

public class CharacteristicsPage extends HomePage{
    private String GENERIC_CHARACTERISTIC_ROW_XPATH = "//td[text()='%s']/..";

    public CharacteristicsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".title_left>h3")
    public WebElement header;

    @FindBy(css="a[class='btn btn-success'")
    public WebElement createNewCharButton;

    public CharacteristicsPage assertCharacteristicsPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:4444/Characteristics");
        return this;
    }

    public CharacteristicsPage assertCharacteristicsHeader() {
        Assert.assertEquals(header.getText(), "Characteristics");
        return this;
    }

    //public CreateCharacteristicsPage createCharacteristics() {
    //    createNewCharButton.click();
    //    return new CreateCharacteristicsPage(driver);
    //}

    public CharacteristicsPage assertCharacteristic(String expName, String expLsl, String expUsl, String expBinCount) {
        String characteristicXpath = String.format(GENERIC_CHARACTERISTIC_ROW_XPATH, expName);
        WebElement characteristicRow = driver.findElement(By.xpath(characteristicXpath));

        String actlsl = characteristicRow.findElement(By.xpath("./td[3]")).getText();
        String actUsl = characteristicRow.findElement(By.xpath("./td[4]")).getText();
        String actBinCount = characteristicRow.findElement(By.xpath("./td[5]")).getText();
        Assert.assertEquals(actlsl, expLsl);
        Assert.assertEquals(actUsl, expUsl);
        Assert.assertEquals(actBinCount, expBinCount);
        return this;
    }
}
