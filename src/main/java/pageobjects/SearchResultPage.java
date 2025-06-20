package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultPage extends BasePage{
    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    @FindBy(className = "cat-product")
    public List<WebElement> products;

    @Override
    public void waitForPageToBeLoaded(){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"cat-product card\"]")));
    }
}
