package pages;

import com.codeborne.selenide.SelenideElement;
import model.ItemDress;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ItemPage {

    private final SelenideElement sizeOptionDropdown = $(By.id("group_1"));
    private final SelenideElement addToCardButton = $x("//*[.='Add to cart']");
    private final SelenideElement openIdent = $x("//h1[@itemprop='name']");
    private final SelenideElement addToCardSuccessPopup = $(By.className("icon-ok"));

    public boolean itemFormIsOpen(){
        return openIdent.isDisplayed();
    }

    public boolean successPopupIsDisplayed(){
        return addToCardSuccessPopup.isDisplayed();
    }

    public void chooseSizeDress(String size){
        switch (size) {
            case "S":
                sizeOptionDropdown.scrollTo().selectOption(0);
                break;
            case "M":
                sizeOptionDropdown.scrollTo().selectOption(1);
                break;
            case "L":
                sizeOptionDropdown.scrollTo().selectOption(2);
                break;
            default:
                System.out.println("No dress size found!");
                break;
        }

    }

    public void chooseColorDress(String color){
        $(By.name(color)).scrollTo().click();
    }

    public void addToCart(ItemDress itemDress){
        chooseSizeDress(itemDress.getSize());
        chooseColorDress(itemDress.getColor());
        addToCardButton.scrollTo().click();
    }



}
