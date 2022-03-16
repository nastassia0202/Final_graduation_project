package TEST;

import baseEntities.BaseTest;
import dbEntries.UsersTable;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DressesCatalogPage;
import pages.LoginPage;

public class Positive extends BaseTest {

    @Test // тест на проверку создания сущности
    public void test() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.LoginWithUser(loginPage.getUser());
        Thread.sleep(1000);
        Assert.assertEquals(loginPage.userName.getText(), "Alexandr Lisovsky");
    }

    @Test
    public void test2() {
//        LoginPage loginPage = new LoginPage();
//        loginPage.LoginWithUser(loginPage.getUser());

    }
}
