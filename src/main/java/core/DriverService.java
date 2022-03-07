package core;


import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static constant.Urls.BASE_URL;

public class DriverService {

    public static void initDriver() {

        // Set settings for selenide browser
        org.apache.log4j.BasicConfigurator.configure();
        Configuration.baseUrl = BASE_URL;
        Configuration.browser = Browsers.CHROME;
        Configuration.headless = false;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.screenshots = false;
        open("/");
        
    }

    public static WebDriver currentDriver() {
        return WebDriverRunner.getWebDriver();
    }

    public static void open(String url) {
        Selenide.open(url);
    }

    public static void refresh() {
        Selenide.refresh();
    }

    public static void executeJs(String script) {
        JavascriptExecutor js = (JavascriptExecutor)currentDriver();
        try {
            js.executeScript(script);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForUrlContains(String urlChunk) {
        WebDriverWait wait = new WebDriverWait(currentDriver(), 10);
        wait.until(ExpectedConditions.urlContains(urlChunk));
    }

    public static void waitForUrlDoesNotContain(String urlChunk) {
        int maxTime = 20;
        while(  currentDriver().getCurrentUrl().contains(urlChunk)  && maxTime > 0) {
            wait(1);
            maxTime--;
        }
    }

    public static void maximize() {
        currentDriver().manage().window().maximize();
    }

    public static void changeWindowSize(int width, int height) {
        currentDriver().manage().window().setSize(new Dimension(width, height));
    }

    public static void clearCookies() {
        open(BASE_URL);
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    public static void close() {
        currentDriver().quit();
    }

    public static void wait(int seconds)
    {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void takeScreenshot() {

        File scrFile = ((TakesScreenshot) currentDriver()).getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir")
                + File.separator + "test-output"
                + File.separator + "screenshots"
                + File.separator + " " + "screenshot_" +  (new SimpleDateFormat("HHmmssSSS").format(new Date())) + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<LogEntry> getBrowserLogs() {
        LogEntries log = currentDriver().manage().logs().get("browser");
        List<LogEntry> logList = log.getAll();
        return logList;
    }

    // COOKIES

    public static void addCookie() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Cookies.txt"));
        Set<Cookie> cookies = (Set<Cookie>) in.readObject();
        for(Cookie cookie: cookies){
            currentDriver().manage().addCookie(cookie);
        }
        open("/");
    }

    public static void getCookie() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithUser(loginPage.getUser());
        Set<Cookie> cookies = currentDriver().manage().getCookies();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Cookies.txt"));
        out.writeObject(cookies);
    }

    public static void deleteCookie(String cookieName) {
        currentDriver().manage().deleteCookieNamed(cookieName);
    }

}
