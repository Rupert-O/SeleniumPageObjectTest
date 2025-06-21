package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AcceptCookiesPage;

public class AcceptCookiesTest extends BaseTest{

    WebDriver driver;

    public AcceptCookiesTest(WebDriver driver) {
        this.driver = driver;
    }
    @Test
    public void acceptCookies(){
        AcceptCookiesPage acceptcookiesPage = new AcceptCookiesPage(driver);
//        acceptcookiesPage.openPage();
        acceptcookiesPage.waitForPageToBeLoaded();
        acceptcookiesPage.clickAcceptAllCookiesButton();
        Assert.assertTrue(acceptcookiesPage.cookieConsentPopUp.isEmpty());
    }
}
