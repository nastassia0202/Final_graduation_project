package baseEntities;

import core.DriverService;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

import java.io.*;
import java.util.Set;

import static core.DriverService.currentDriver;
import static core.DriverService.open;


public class BaseTest {



    @BeforeClass
    public void setUp() {
        DriverService.initDriver();
    }

    @BeforeClass(dependsOnMethods = "setUp")
    public void login() throws InterruptedException, IOException, ClassNotFoundException {
        //LoginPage loginPage = new LoginPage();
        //loginPage.loginWithUser(loginPage.getUser());
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Cookies.txt"));
        Set<Cookie> cookies = (Set<Cookie>) in.readObject();
        System.out.println(cookies.size());
        for(Cookie cookie: cookies){
            currentDriver().manage().addCookie(cookie);
        }
        open("/");
        Thread.sleep(8000);

    }

    @AfterClass
    public void tearDown() {
        DriverService.close();
    }
}
