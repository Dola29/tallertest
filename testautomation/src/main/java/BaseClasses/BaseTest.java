package BaseClasses;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;
    protected static String CHROME_DRIVER_PATH;


    public void setUp() {
        String baseUrl = "https://www.google.com";
        CHROME_DRIVER_PATH = "src/main/resources/chromedriver.exe";
        driver = WebDriverFactory.initWebDriver(WebDriverFactory.WebDriverType.CHROME, CHROME_DRIVER_PATH);
        WebDriverActionsManager.setWebDriverActions(driver);
        driver.get(baseUrl);
    }

    public void tearDown(){
        WebDriverActionsManager.closeDriver();
    }
}

