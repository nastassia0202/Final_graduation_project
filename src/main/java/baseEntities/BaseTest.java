package baseEntities;


import core.ApiService;
import core.DriverService;
import model.ItemDress;
import model.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import utils.Randomization;

import java.lang.reflect.Method;


public class BaseTest {

    public User validUser;
    public ItemDress validDress;


    @BeforeClass
    public void setUp() {
        DriverService.initDriver();
        ApiService.initApi();
       validUser = ApiService.getUser();
       validDress = ApiService.getDress();

    }


    @AfterClass
    public void tearDown() {
        DriverService.close();
    }


    @DataProvider(name = "data-provider")
    public Object[][] dpMethod (Method m){
        switch (m.getName()) {
            case "limitValueTest":
                return new Object[][] {{Randomization.randomString(1)}, {Randomization.randomString(30)}};
            case "dataOverageTest":
                return new Object[][] {{Randomization.randomString(100)}};
        }
        return null;

    }
}
