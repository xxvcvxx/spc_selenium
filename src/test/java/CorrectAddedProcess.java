import Pages.LoginPage;
import config.Config;
import org.testng.annotations.Test;

public class CorrectAddedProcess extends BaseTest{
    @Test
    public void addProcessTest() {
        new LoginPage(BaseTest.driver)
                .typeEmail(new Config().getApplicationUser())
                .typePassword(new Config().getApplicationPassword())
                .submitLogin()
                .goToProcesses()
                .clickAddProcess()
                .addProcessName("Olgowy")
                .clickCreateProcess()
                .assertProcess("Olgowy","","");
    }
}
