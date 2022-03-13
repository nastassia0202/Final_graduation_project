package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class CartPage {
    private final SelenideElement deleteItemButton = $(By.className("icon-trash"));
    private final SelenideElement cartIsEmptyAlert = $x("//*[.='Your shopping cart is empty.']");

}
