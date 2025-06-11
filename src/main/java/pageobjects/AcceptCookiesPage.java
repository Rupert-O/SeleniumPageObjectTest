package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AcceptCookiesPage extends BasePage{
    public AcceptCookiesPage(WebDriver driver){
        super(driver);
    }
    private String pageUrl = "https://www.morele.net";

    @FindBy(xpath = "//div[contains(@class, \"actions\")]//button[contains(@data-action, \"onApproveAll\")]")
    protected WebElement acceptAllCookiesButton;

    @FindBy(xpath = "//div[contains(@class, \"actions\")]//button[contains(@data-action, \"onToggleShowManager\")]")
    protected WebElement displayCookiesManagerButton;

    @FindBy(xpath = "//div[@id=\"cookie-consent\"]")
    public List<WebElement> cookieConsentPopUp;

    public void openPage(){
        driver.get(pageUrl);
    }
    public void clickAcceptAllCookiesButton(){
        acceptAllCookiesButton.click();
    }

    @Override
    public void waitForPageToBeLoaded(){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[starts-with(@data-action, \"cookie-consent#onApproveAll\")]")));
    }
}
