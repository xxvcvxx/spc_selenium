package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LoginPage {
    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(id = "Email-error")
    private WebElement emailError;

    @FindBy(id = "Password")
    private WebElement passwordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement loginBtn;

    @FindBy(css = "a[href*=Register]")
    private WebElement registerLnk;

    @FindBy(css = ".validation-summary-errors>ul>li")
    public List<WebElement> loginErrors;

    public LoginPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public HomePage submitLogin() {
        loginBtn.click();
        return new HomePage(driver);
    }

    public AccountPage clickRegister() {
        registerLnk.click();
        return new AccountPage(driver);
    }

    public LoginPage submitLoginWithFailure() {
        loginBtn.click();
        return this;
    }

    public LoginPage assertIncorrectEmail() {
        Assert.assertEquals(emailError.getText(), "The Email field is not a valid e-mail address.");
        return this;
    }

    public LoginPage assertIncorrectEmailErrorOnList() {
        Assert.assertTrue(loginErrors.stream().anyMatch(validationError -> validationError.getText().equals("The Email field is not a valid e-mail address.")));
        return this;
    }

    public LoginPage assertInvalidLoginAttempt() {
        Assert.assertTrue(loginErrors.stream().anyMatch(validationError -> validationError.getText().equals("Invalid login attempt.")));
        return this;
    }
}
