package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");// Bypass OS security model
        options.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
        options.addArguments("ignore-certificate-errors");
        options.addArguments("ignore-ssl-errors");
        //options.addArguments("--headless");//run test without opening browser window
        options.addArguments("--remote-allow-origins=*");//added to avoid issue org.openqa.selenium.remote.http.ConnectionFailedException: Unable to establish websocket connection to http://localhost:50499/devtools/browser/cc27ed5e-dbe2-4bb0-a690-3d976e8312ec

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.morele.net/");

    }
    @AfterClass
    public void teardown(){
        //driver.quit();
    }
}
