package tests.gui;

import baseEntities.BasePage;
import model.User;
import org.testng.annotations.Test;
import pages.LoginPage;

public class SmokeTest extends BasePage {

    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithUser(loginPage.getUser());
    }
}
