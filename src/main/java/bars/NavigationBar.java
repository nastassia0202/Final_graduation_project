package bars;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class NavigationBar {

    @FindBy(className = "current")
    @CacheLookup
    public SelenideElement mainButton;
    @FindBy(xpath = "//a[text()='Платежи']")
    @CacheLookup
    public SelenideElement paymentsButton;
    @FindBy(xpath = "//div/a[@href='/settings/personal']")
    @CacheLookup
    public SelenideElement personalSettingsLink;
    @FindBy (linkText = "/home/logout")
    @CacheLookup
    private SelenideElement logoutLink;

    

}
