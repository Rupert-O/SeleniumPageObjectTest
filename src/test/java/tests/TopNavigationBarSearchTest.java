package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.SearchResultPage;
import pageobjects.TopNavigationBarPage;

public class TopNavigationBarSearchTest extends BaseTest{

    @Test
    public void findExistingProduct(){
        TopNavigationBarPage topNavigationBarPage = new TopNavigationBarPage(driver);
        topNavigationBarPage.searchInput.clear();
        topNavigationBarPage.searchProduct("iPhone");
        SearchResultPage resultPage = new SearchResultPage(driver);
        resultPage.waitForPageToBeLoaded();
        Assert.assertFalse(resultPage.products.isEmpty());
    }
    @Test
    public void findNonExistingProduct(){
        TopNavigationBarPage topNavigationBarPage = new TopNavigationBarPage(driver);
        topNavigationBarPage.searchInput.clear();
        topNavigationBarPage.searchProduct("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        SearchResultPage resultPage = new SearchResultPage(driver);
        resultPage.waitForPageToBeLoaded();
        Assert.assertTrue(resultPage.noProductMessage.isDisplayed());
    }
}
