package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class ItemForm extends BasePage {

    private final SelenideElement sizeOptionDropdown = $(By.id("layered_category_9"));
    private final SelenideElement addToCardButton = $(By.id("add_to_cart")); //*[@id="add_to_cart"]/button
    private final SelenideElement openIdent = $x("//h1[@itemprop='name']");

    public boolean itemFormIsOpen(){
        return openIdent.isDisplayed();
    }

    public void chooseSizeDress(String size){
        switch (size) {
            case "S":
                sizeOptionDropdown.selectOption(1);
                break;
            case "M":
                sizeOptionDropdown.selectOption(2);
                break;
            case "L":
                sizeOptionDropdown.selectOption(3);
                break;
            default:
                System.out.println("No dress size found!");
                break;
        }

    }

    public void chooseColorDress(String color){
        $(By.name(color)).click();
    }

    public void addToCart(){
        addToCardButton.click();
    }
}
