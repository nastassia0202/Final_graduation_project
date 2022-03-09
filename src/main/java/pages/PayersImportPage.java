package pages;



import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class PayersImportPage {

    private final SelenideElement PAGE_OPENED_IDENTIFIER = $x("//h1[.='Импорт плательщиков']");
    private final SelenideElement loadFileButton = $("#csvFile" );
    private final SelenideElement loadFileButton1 = $x("//*[@for='csvFile']");
    private final SelenideElement followButton = $x("//button[.='Далее']");
    private final SelenideElement importButton = $x("//button[.='Импорт']");
    private final SelenideElement errorPopup = $x("//span[.='Не выбран csv-файл с данными для импорта']");
    private final SelenideElement importMessage = $(By.id("import_message"));


    public void uploadFile(){
        //loadFileButton.click();
        //loadFileButton.setValue("file://D:/import.csv");
        followButton.scrollTo().click();
        //importButton.click();

    }

    public void callPopup(){
        followButton.scrollTo().click();
    }

    public SelenideElement getPAGE_OPENED_IDENTIFIER() {
        return PAGE_OPENED_IDENTIFIER;
    }

    public SelenideElement getImportMessage() {
        return importMessage;
    }

    public SelenideElement getErrorPopup() {
        return errorPopup;
    }
}
