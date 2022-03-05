package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class InvoicesImportPage{

    private final SelenideElement PAGE_OPENED_IDENTIFIER = $x("//h1[.='Импорт счетов']");
    private final SelenideElement loadFileButton = $x("//span[.='Выберите файл…']");
    private final SelenideElement otherServicesChoice = $x("//div[@class='row']//button[.='Далее']");


}
