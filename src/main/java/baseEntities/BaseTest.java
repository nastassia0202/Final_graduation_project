package baseEntities;

import core.DriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {



    @BeforeClass
    public void setUp() {
        DriverService.initDriver();
    }

    @BeforeClass(dependsOnMethods = "setUp")
    public void login() {

    }

    @AfterClass
    public void tearDown() {
        DriverService.close();
    }
}
