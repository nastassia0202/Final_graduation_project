package baseEntities;

import core.DriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {



    @BeforeClass
    public void setUp() {
        DriverService.initDriver();
    }


    @AfterClass
    public void tearDown() {
        DriverService.close();
    }
}
