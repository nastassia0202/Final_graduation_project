package baseEntities;


import core.ApiService;
import core.DriverService;
import model.ItemDress;
import model.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;




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
}
