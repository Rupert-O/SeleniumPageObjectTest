package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.TopNavigationBarPage;

public class TopNavigationBarTest extends BaseTest{

    @Test
    public void findExistingProduct(){
        TopNavigationBarPage topNavigationBarPage = new TopNavigationBarPage(driver);
        topNavigationBarPage.insertStringToSearchInput("test");
        topNavigationBarPage.clickSearchButton();
        System.out.println("gdgdf");

    }
}
