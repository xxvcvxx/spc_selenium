package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class AccountPage {
    protected WebDriver driver;


    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement emailTxt;
    @FindBy(id = "Email-error")
    private WebElement emailError;
    @FindBy(id = "Password")
    private WebElement passwordTxt;
    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTxt;
    @FindBy(id = "Email-error")
    public WebElement emailerrorTxt;
    @FindBy(css = ".validation-summary-errors>ul>li")
    public List<WebElement> loginErrors;
    @FindBy(css = "button[type=submit]")
    private WebElement registerBtn;

    public AccountPage submitLoginWithFailure() {
        registerBtn.click();
        return this;
    }

    public AccountPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;
    }

    public AccountPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public AccountPage typeConfirmPassword(String confirmPassword) {
        confirmPasswordTxt.clear();
        confirmPasswordTxt.sendKeys(confirmPassword);
        return this;
    }

    public AccountPage assertIncorrectEmail() {
        Assert.assertEquals(emailError.getText(), "The Email field is not a valid e-mail address.");
        return this;
    }

    public AccountPage assertIncorrectEmailErrorOnList() {
        Assert.assertTrue(loginErrors.stream().anyMatch(validationError -> validationError.getText().equals("The Email field is not a valid e-mail address.")));
        return this;
    }

}

