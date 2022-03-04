package baseEntities;

import core.DriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;


public class BaseTest {



    @BeforeClass
    public void setUp() {
        DriverService.initDriver();
    }

    @BeforeClass(dependsOnMethods = "setUp")
    public void login() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithUser(loginPage.getUser());
    }

    @AfterClass
    public void tearDown() {
        DriverService.close();
    }
}
