package pages;

import baseEntities.BaseTest;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static constant.EndPointsUrl.CART_PAGE;
import static constant.EndPointsUrl.DRESSES_PAGE;


public class CartPage extends BaseTest {
    private final SelenideElement deleteItemButton = $(By.className("icon-trash"));
    private final SelenideElement cartIsEmptyAlert = $x("//*[.='Your shopping cart is empty.']");
    private final SelenideElement cartPageIsOpen = $(By.id("cart_title"));

    public CartPage() {
        open(CART_PAGE);
    }

    public boolean checkCartPageIsOpen() {
        return cartPageIsOpen.isDisplayed();
    }

    public boolean cartIsEmptyAlertIsVisible() {
        return cartIsEmptyAlert.isDisplayed();
    }

    public void deleteProduct() {
        deleteItemButton.click();
    }
}
