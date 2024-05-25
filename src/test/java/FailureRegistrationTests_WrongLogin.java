import Pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FailureRegistrationTests_WrongLogin extends BaseTest {

    @DataProvider
    public Object[][] getWrongEmails() {
        return new Object[][]{
                {"test"},
                {"admin"},
                {"@test"}};
    }

    @Test(dataProvider = "getWrongEmails")
    public void registrationFailureTest_WrongLogin(String wrongEmails) {

        new LoginPage(BaseTest.driver)
                .clickRegister()
                .typeEmail(wrongEmails)
                .typePassword("blabla!123")
                .typeConfirmPassword("blabla!123")
                .submitLoginWithFailure()
                .assertIncorrectEmail()
                .assertIncorrectEmailErrorOnList();
    }
}

