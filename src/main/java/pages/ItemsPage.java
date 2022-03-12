package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ItemsPage {

    private final SelenideElement casualDressesOption = $(By.id("layered_category_9"));
    private final SelenideElement eveningDressesOption = $(By.id("uniform-layered_category_10"));
    private final SelenideElement SummerDresses = $(By.id("layered_category_11"));
    private final SelenideElement addToCardButton = $(By.className("Submit"));


    //   //a[contains(text(),'White')]
}
