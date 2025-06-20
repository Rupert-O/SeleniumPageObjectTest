package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.SearchResultPage;
import pageobjects.TopNavigationBarPage;

public class TopNavigationBarTest extends BaseTest{

    @Test
    public void findExistingProduct(){
        TopNavigationBarPage topNavigationBarPage = new TopNavigationBarPage(driver);
        topNavigationBarPage.searchProduct("iPhone");
        SearchResultPage tst = new SearchResultPage(driver);
        Assert.assertTrue(!tst.products.isEmpty());

    }
}
