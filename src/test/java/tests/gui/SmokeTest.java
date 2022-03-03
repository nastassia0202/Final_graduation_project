package tests.gui;

import baseEntities.BaseTest;
import org.testng.annotations.Test;


public class SmokeTest extends BaseTest {

        @Test
        public void test1(){
                initPages.loginPage.open();
                initPages.loginPage.loginWithUser();
        }


}
