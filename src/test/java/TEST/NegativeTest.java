package TEST;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.HomeBar;
import pages.LoginPage;

public class NegativeTest extends BaseTest {

    @Test(dataProvider = "data-provider", dataProviderClass = BaseTest.class)
    public void dataOverageTest(String string) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.LoginWithUser(validUser);
        HomeBar homeBar = new HomeBar();
        homeBar.searchItem(string);

        Thread.sleep(20000);
    }
}
