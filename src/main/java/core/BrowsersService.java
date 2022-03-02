package core;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.AssertionMode.SOFT;
import static constant.Urls.BASE_URL;

public class BrowsersService {

    public BrowsersService() {
        this(ReadProperties.getBrowserName());
    }

    public BrowsersService(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                org.apache.log4j.BasicConfigurator.configure();
                Configuration.baseUrl = BASE_URL;
                Configuration.browser = "chrome";
                Configuration.fastSetValue = true;
                Configuration.timeout = 8000;
                Configuration.headless = false;
                Configuration.assertionMode = SOFT;
                break;

            case "firefox":
                org.apache.log4j.BasicConfigurator.configure();
                Configuration.baseUrl = BASE_URL;
                Configuration.browser = "firefox";
                Configuration.fastSetValue = true;
                Configuration.timeout = 8000;
                Configuration.headless = false;
                Configuration.assertionMode = SOFT;
                break;

                default:
                System.out.println("Browser " + browserName + " is not supported.");
                break;
        }
    }
}
