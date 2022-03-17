package TEST;

import baseEntities.BaseTest;
import dbEntries.UsersTable;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Positive extends BaseTest {

    @Test // тест на проверку создания сущности
    public void test1(){

        waits(5000);
        $(By.className("account")).shouldBe(visible).shouldHave(text("Alexandr Lisovsky"));
    }

    @Test // тест на добавление товара в корзину
    public void test2() {

        CartPage cartPage = new CartPage();
        cartPage.cartIsEmptyAlertIsVisible();

        AddProductPage addProductPage = new AddProductPage();
        addProductPage.addToCart();

        $(By.className("icon-ok")).isDisplayed();
    }

    @Test  // uploadFileTest
    public void test3() {

        ContactPage contactPage = new ContactPage();
        contactPage.sendMail();

        contactPage.successAlertIsVisible();
    }

    @Test // тест на добавление товара в корзину
    public void test4() {

        CartPage cartPage = new CartPage();
        cartPage.cartIsEmptyAlertIsVisible();

        AddProductPage addProductPage = new AddProductPage();
        addProductPage.addToCart();

        $(By.className("icon-ok")).isDisplayed();
        $(By.className("cross")).click();

        cartPage.checkCartPageIsOpen();
        cartPage.deleteProduct();

        cartPage.cartIsEmptyAlertIsVisible();
    }


}
