package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.AcceptCookiesPage;

public class AcceptCookiesTest extends BaseTest{
    @Test
    public void acceptCookies(){
        AcceptCookiesPage acceptcookiesPage = new AcceptCookiesPage(driver);
//        acceptcookiesPage.openPage();
        acceptcookiesPage.waitForPageToBeLoaded();
        acceptcookiesPage.clickAcceptAllCookiesButton();
        Assert.assertTrue(acceptcookiesPage.cookieConsentPopUp.isEmpty());
    }
}
