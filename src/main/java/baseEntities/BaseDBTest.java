package baseEntities;

import core.DataBaseService;
import dbEntries.UsersTable;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseDBTest {
    protected DataBaseService dataBaseService;
    public static Logger logger = Logger.getLogger(UsersTable.class);
    @BeforeTest
    public void setUpConnection() {
        org.apache.log4j.BasicConfigurator.configure();
        dataBaseService = new DataBaseService();
        dataBaseService.closeConnection();
    }

    @AfterTest
    public void closeConnection(){
        dataBaseService.closeConnection();
    }
}
