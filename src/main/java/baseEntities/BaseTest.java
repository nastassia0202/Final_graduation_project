package baseEntities;

import core.DriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.asserts.SoftAssert;



public class BaseTest {
    protected InitPages initPages;
    protected SoftAssert softAssert;
    //protected Logger logger;

    @BeforeClass
    public void setUp() {

        DriverService.initDriver();

        initPages = new InitPages();
        softAssert = new SoftAssert();

        //logger = LogManager.getLogger("");
        //DOMConfigurator.configure("src/main/resources/log4j.xml");
    }

    @AfterMethod
    public void clearCookies() {
        DriverService.clearCookies();
    }

    @AfterClass
    public void tearDown() {
        DriverService.close();
    }
}
