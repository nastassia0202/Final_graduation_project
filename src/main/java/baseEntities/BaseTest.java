package baseEntities;

import com.codeborne.selenide.Selenide;
import core.BrowsersService;
import core.ReadProperties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utils.Listener;


@Listeners(Listener.class)
public class BaseTest {
protected BrowsersService browsersService;


@BeforeClass
public void openPage() {
    browsersService = new BrowsersService();
}

@AfterClass
public void closePage() {
    Selenide.closeWebDriver();
}
}
