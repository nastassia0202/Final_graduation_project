package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomeBar extends BasePage {
    private final SelenideElement addToCartSuccessPopup = $(By.className("icon-ok"));
    private final SelenideElement searchInput = $(By.id("search_query_top"));
    private final SelenideElement searchButton = $(By.className("submit_search"));


    public void searchItem(String string){
        searchInput.sendKeys(string);
        searchButton.click();
    }

    public void getValueBySearchField(){

    }


    public boolean successPopupIsDisplayed(){
        return addToCartSuccessPopup.isDisplayed();
    }
}
