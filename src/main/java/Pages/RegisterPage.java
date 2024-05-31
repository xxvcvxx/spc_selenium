package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class RegisterPage {
    protected WebDriver driver;


    public RegisterPage(WebDriver driver) {
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

    public RegisterPage submitLoginWithFailure() {
        registerBtn.click();
        return this;
    }
    public HomePage submitLoginWithSuccess()
    {
        registerBtn.click();
        return new HomePage(driver);
    }

    public RegisterPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;
    }

    public RegisterPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public RegisterPage typeConfirmPassword(String confirmPassword) {
        confirmPasswordTxt.clear();
        confirmPasswordTxt.sendKeys(confirmPassword);
        return this;
    }

    public RegisterPage assertIncorrectEmail() {
        Assert.assertEquals(emailError.getText(), "The Email field is not a valid e-mail address.");
        return this;
    }

    public RegisterPage assertIncorrectEmailErrorOnList() {
        Assert.assertTrue(loginErrors.stream().anyMatch(validationError -> validationError.getText().equals("The Email field is not a valid e-mail address.")));
        return this;
    }
    public RegisterPage assertUnPass() {
        Assert.assertTrue(loginErrors.stream().anyMatch(validationError -> validationError.getText().equals("The password and confirmation password do not match.")));
        return this;
    }

    public RegisterPage assertIncorrectPasswordOnListToShort()
    {
        //The Password must be at least 6 and at max 100 characters long.
        Assert.assertTrue(loginErrors.stream().anyMatch(validationError -> validationError.getText().equals("The Password must be at least 6 and at max 100 characters long.")));
        return this;
    }

    public RegisterPage assertIncorrectPasswordOnListWithoutSpecial()
    {
        //The Password must be at least 6 and at max 100 characters long.
        Assert.assertTrue(loginErrors.stream().anyMatch(validationError -> validationError.getText().equals("Passwords must have at least one non alphanumeric character.")));
        return this;
    }
    public RegisterPage assertIncorrectPasswordOnListWithoutUppercase()
    {
        //The Password must be at least 6 and at max 100 characters long.
        Assert.assertTrue(loginErrors.stream().anyMatch(validationError -> validationError.getText().equals("Passwords must have at least one uppercase ('A'-'Z').")));
        return this;
    }
    public RegisterPage assertIncorrectPasswordOnListWithoutUnmatchedPassword()//popraw
    {
        //The Password must be at least 6 and at max 100 characters long.
        Assert.assertTrue(loginErrors.stream().anyMatch(validationError -> validationError.getText().equals("The password and confirmation password do not match.")));
        return this;
    }

}

