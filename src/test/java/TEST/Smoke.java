package TEST;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.DressesCatalogPage;
import pages.ItemForm;
import pages.LoginPage;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Selenide.*;


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
//        LoginPage loginPage = new LoginPage();
//        loginPage.LoginWithUser(loginPage.getUser());
        DressesCatalogPage dressesCatalogPage = new DressesCatalogPage();
        dressesCatalogPage.addDressToCard(dressesCatalogPage.getItemDress());
        Thread.sleep(10000);

//        switchTo().frame($x("//*[@id=\"add_to_cart\"]/button"));
//        $("#add_to_card").shouldBe(Condition.visible, Duration.of(1, ChronoUnit.MINUTES,));
        ItemForm itemForm = new ItemForm();
        itemForm.itemFormIsOpen();
        itemForm.addToCart();

        //Assert.assertTrue(dressesCatalogPage.addToCardSuccessPopup.isDisplayed());
    }
}
