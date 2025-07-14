package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class TopNavigationBarPage extends BasePage{

    public TopNavigationBarPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//header[@id=\"header\"]//input[@name=\"q\" and @type=\"search\"]")
    public WebElement searchInput;

    @FindBy(xpath = "//header[@id=\"header\"]//div[@class=\"h-quick-search-dropdown\"]//button[@id=\"d\"]")
    private WebElement searchCategoriesDropdownButton;

    @FindBy(xpath = "//header//ul[@class= \"md-list-collection\"]")
    private List<WebElement> categoriesList;

    @FindBy(name = "d")
    private WebElement categoriesDropdown;

    private final List<String> expectedValues = Arrays.asList("Wszystkie działy", "Komputery", "Telewizory i audio", "Foto i kamery", "AGD", "Smartfony i smartwatche", "Biuro i firma", "Gaming", "Laptopy", "Sport i turystyka", "Małe AGD", "Dom i ogród", "Podzespoły komputerowe", "Zabawki i dziecko", "Uroda i zdrowie", "Supermarket");

    @FindBy(xpath = "//header//button[@type=\"submit\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class=\"h-controls\"]//button[@data-ask-widget=\"help-center\"]")
    private WebElement contactButton;

    @FindBy(xpath = "//div[@class=\"h-control h-shopping-lists-control\"]//button")
    private WebElement shoppingListButton;

    @Override
    public void waitForPageToBeLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid=\"login-btn\"]")));
    }

    public void clickContactButton(){
        contactButton.click();
    }
    public void clickShoppingListButton(){
        shoppingListButton.click();
    }
    public void clickSearchCategoriesDropdownButton(){
        searchCategoriesDropdownButton.click();
    }
    public Select getCategoriesDropdown(){
        return new Select(categoriesDropdown);
    }
    public List<String> getExpectedValues(){return expectedValues;}
    public void insertStringToSearchInput(String phrase){
        searchInput.sendKeys(phrase);
    }
    public void clickSearchButton(){
        searchButton.click();
    }
    public SearchResultPage searchProduct(String phrase){
        searchInput.clear();
        insertStringToSearchInput(phrase);
        clickSearchButton();
        return new SearchResultPage(driver);
    }
}
