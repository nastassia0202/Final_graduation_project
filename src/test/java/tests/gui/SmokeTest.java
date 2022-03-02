package tests.gui;

import baseEntities.BasePage;
import baseEntities.BaseTest;
import model.User;
import org.testng.annotations.Test;
import pages.LoginPage;

public class SmokeTest extends BaseTest {

    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithUser(loginPage.getUser());
    }
}
