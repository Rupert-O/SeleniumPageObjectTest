package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.SearchResultPage;
import pageobjects.TopNavigationBarPage;

import java.time.Duration;

public class TopNavigationBarSearchTest extends BaseTest{

    @Test
    public void searchExistingProduct(){
        TopNavigationBarPage topNavigationBarPage = new TopNavigationBarPage(driver);
        topNavigationBarPage.searchInput.clear();
        topNavigationBarPage.searchProduct("iPhone");
        SearchResultPage resultPage = new SearchResultPage(driver);
        resultPage.waitForPageToBeLoaded();
        Assert.assertFalse(resultPage.products.isEmpty());
    }
    @Test
    public void searchNonExistingProduct(){
        TopNavigationBarPage topNavigationBarPage = new TopNavigationBarPage(driver);
        topNavigationBarPage.searchInput.clear();
        topNavigationBarPage.searchProduct("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        SearchResultPage resultPage = new SearchResultPage(driver);
        resultPage.waitForPageToBeLoaded();
        Assert.assertTrue(resultPage.noProductMessage.isDisplayed());
    }
    @Test
    public void searchNullValue(){
        TopNavigationBarPage topNavigationBarPage = new TopNavigationBarPage(driver);
        topNavigationBarPage.searchInput.clear();
        topNavigationBarPage.clickSearchButton();
        SearchResultPage resultPage = new SearchResultPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, \"mn-item\")]")));
        Assert.assertTrue(resultPage.getWrongSearchQueryPopUp().isDisplayed(), "No notify pop-up");
        Assert.assertTrue(resultPage.getAlertText().contains("Szukana fraza jest za krótka. Wpisz przynajmniej dwa znaki."), "Incorrect message");
    }
    //div[contains(text(), "Szukana fraza jest za krótka. Wpisz przynajmniej dwa znaki.")]
}
