package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
        //PageFactory.initElements(driver, this);
    }

    private String loginPageUrl = "https://allegro.pl.allegrosandbox.pl/logowanie";

    @FindBy(name = "login")
    protected WebElement loginInput;

    @FindBy(id = "password")
    protected WebElement passwordInput;

    @FindBy(xpath = "//button[@data-testid=\"login-btn\"]")
    protected WebElement logInButton;

    @Override
    public void waitForPageToBeLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid=\"login-btn\"]")));
    }

    public void openPage(){
        driver.get(loginPageUrl);
    }
    public void insertLogin(String login){
        loginInput.sendKeys();
    }
    public void insertPassword(String password){
        passwordInput.sendKeys();
    }
    public void clickLoginButton(){
        logInButton.click();
    }

//    public String getErrorMessage() {
//        return driver.findElement(errorTextBy).getText();
//    }
}