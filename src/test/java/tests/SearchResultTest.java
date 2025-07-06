package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.SearchResultPage;
import pageobjects.TopNavigationBarPage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchResultTest extends BaseTest{
    @Test
    public void verifyMaxAmountOfItemsOnResultPage(){
        driver.findElement(By.xpath("//button[@title='zamknij']")).click();//TEMPORARY !!
        TopNavigationBarPage searchProduct = new TopNavigationBarPage(driver);
        SearchResultPage results = searchProduct.searchProduct("iPhone");
        Assert.assertEquals(results.getProducts().size(), 30, "Max number of items different than 30");
    }
    @Test
    public void productsNameContainsQueryWord(){
        int productTitlesWithKeyWord = 0;
        if(driver.findElement(By.xpath("//button[@title='zamknij']")).isDisplayed()){
            driver.findElement(By.xpath("//button[@title='zamknij']")).click();
        }//TEMPORARY !!
        TopNavigationBarPage searchProduct = new TopNavigationBarPage(driver);
        SearchResultPage results = searchProduct.searchProduct("pralka");

        Pattern pattern = Pattern.compile("(?i)pralk([aię])\\b");

        for(WebElement i: results.getProductsTitles()){
            if(!i.getText().isEmpty() && pattern.matcher(i.getText()).find()){//if string not empty AND match to REGEX
                productTitlesWithKeyWord++;

                System.out.print(pattern.matcher(i.getText()).find() + " ");
                System.out.println(i.getText());
            }
        }

        Assert.assertEquals(productTitlesWithKeyWord, results.getProductsTitles().size(), "Not every product contains key wor");
    }
}
