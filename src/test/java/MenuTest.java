import Pages.LoginPage;
import config.Config;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest{

    @Test
    public void menuTest() {
        new LoginPage(BaseTest.driver)
                .typeEmail(new Config().getApplicationUser())
                .typePassword(new Config().getApplicationPassword())
                .submitLogin()
                .goToProcesses()
                .assertProcessesURL()
                .assertProcessesHeader()
                .goToCharacteristics()
                .assertCharacteristicsHeader()
                .goToDashboard()
                .assertDashboardHeader()
                .assertDashboardURL();
    }
}
