package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

public class LoginTest extends BaseTest{
    String VALID_USER_LOGIN = "108916054";
    String VALID_USER_PASSWORD = "Haslo111";
//TODO: fix login test
    //TODO: add few login tests
    @Test
    public void successfulLoginTest() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.openPage();
            loginPage.waitForPageToBeLoaded();
            loginPage.insertLogin(VALID_USER_LOGIN);
            loginPage.insertPassword(VALID_USER_PASSWORD);
            loginPage.clickLoginButton();
            //loginPage.logIn(VALID_USER_LOGIN, VALID_USER_PASSWORD);
            Assert.assertEquals(true, true, "ok message");
        } catch (Exception e) {
            System.out.println(">>> EXCEPTION THROWN <<<");
            e.printStackTrace();  // <--- kluczowe!
            Assert.fail("Exception thrown: " + e.getMessage());
        }
        //div[@data-dropdown-id="user_dropdown"]
    }
}
