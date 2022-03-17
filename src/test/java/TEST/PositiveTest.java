package TEST;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static constant.EndPointsUrl.ITEM_PAGE;
import static com.codeborne.selenide.Selenide.open;

public class PositiveTest extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.LoginWithUser(validUser);
        Thread.sleep(20000);
    }

    @Test
    public void entityAdditionTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.LoginWithUser(validUser);
        DressesCatalogPage dressesCatalogPage = new DressesCatalogPage();
        dressesCatalogPage.addDressToCard(validDress);
        ItemPage itemPage = new ItemPage();
        Assert.assertTrue(itemPage.itemFormIsOpen());
        itemPage.addToCart(validDress);
        itemPage.successPopupIsDisplayed();
        Thread.sleep(20000);
    }

    @Test(dependsOnMethods = "entityAdditionTest")
    public void entityDeletingTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.LoginWithUser(validUser);
        CartPage cartPage = new CartPage();
        cartPage.deleteItem();
        cartPage.alertIsDisplayed();
        Thread.sleep(20000);
    }

    @Test
    public void uploadFileTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.LoginWithUser(loginPage.getUser());
        ContactPage contactPage = new ContactPage();
        contactPage.sendMail();
        Assert.assertTrue(contactPage.successAlertIsVisible());
        Thread.sleep(20000);
    }

    @Test
    public void dialogBoxTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.LoginWithUser(validUser);
        DressesCatalogPage dressesCatalogPage = new DressesCatalogPage();
        dressesCatalogPage.clickForItem();
        dressesCatalogPage.itemFormIsDisplayed();
        Thread.sleep(20000);
    }

    @Test
    public void popUpTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.LoginWithUser(validUser);
        open(ITEM_PAGE);
        ItemPage itemPage = new ItemPage();
        itemPage.clickToAddButton();
        itemPage.successPopupIsDisplayed();
        Thread.sleep(20000);
    }

    @Test(dataProvider = "data-provider", dataProviderClass = BaseTest.class)
    public void limitValueTest(String string) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.LoginWithUser(validUser);
        HomeBar homeBar = new HomeBar();
        homeBar.searchItem(string);

        Thread.sleep(20000);
    }


}
