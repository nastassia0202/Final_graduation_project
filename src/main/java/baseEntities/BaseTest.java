package baseEntities;

import core.DriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;


public class BaseTest {

    @BeforeClass
    public void setUp() {
        DriverService.initDriver();

        LoginPage loginPage = new LoginPage();
        loginPage.LoginWithUser(loginPage.getUser());
    }

    @AfterClass
    public void tearDown() {
        DriverService.close();
    }


    public void waits(int t){
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
