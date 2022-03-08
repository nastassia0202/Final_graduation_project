package baseEntities;

import core.DriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.*;
import static core.DriverService.*;

public class BaseTest {



    @BeforeClass
    public void setUp() {
        DriverService.initDriver();
    }

    @BeforeClass(dependsOnMethods = "setUp")
    public void login() throws IOException, ClassNotFoundException, InterruptedException {
        addCookie();
    }

    @AfterClass
    public void tearDown() {
        DriverService.close();
    }
}
