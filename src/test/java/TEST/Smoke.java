package TEST;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.DressesCatalogPage;
import pages.ItemForm;
import pages.LoginPage;


public class Smoke extends BaseTest {

    @Test
    public void test() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.LoginWithUser(loginPage.getUser());
        DressesCatalogPage dressesCatalogPage = new DressesCatalogPage();
        dressesCatalogPage.addDressToCard(dressesCatalogPage.getItemDress());
        Thread.sleep(20000);
    }

    @Test
    public void test1() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.LoginWithUser(loginPage.getUser());
        ContactPage contactPage = new ContactPage();
        contactPage.sendMail();
        Assert.assertTrue(contactPage.successAlertIsVisible());
        Thread.sleep(20000);
    }

    @Test
    public void test3() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.LoginWithUser(loginPage.getUser());
        DressesCatalogPage dressesCatalogPage = new DressesCatalogPage();
        dressesCatalogPage.addDressToCard(dressesCatalogPage.getItemDress());
        Thread.sleep(10000);
        ItemForm itemForm = new ItemForm();
        itemForm.itemFormIsOpen();
        itemForm.addToCart();
        Assert.assertTrue(dressesCatalogPage.addToCardSuccessPopup.isDisplayed());
    }
}
