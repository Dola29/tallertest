package BaseClasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class WebDriverFactory {
    public WebDriverFactory() {
    }

    //this method initialize the webdriver depending on the browser we are going to use.
    public static WebDriver initWebDriver(WebDriverType webDriverType, String driverPath) {
        if (Objects.nonNull(driverPath)) {
            System.setProperty(webDriverType.driverName(), driverPath);
        }

        Object driver;
        switch(webDriverType) {
            case IE:
                driver = new InternetExplorerDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                String downloadFilepath = System.getProperty("user.dir") + "\\target\\excels";
                HashMap<String, Object> chromePrefs = new HashMap();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", downloadFilepath);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", chromePrefs);
                driver = new ChromeDriver(options);
        }

        ((WebDriver)driver).manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        ((WebDriver)driver).manage().window().maximize();
        ((WebDriver)driver).manage().deleteAllCookies();
        return (WebDriver)driver;
    }

    public static enum WebDriverType {
        CHROME("webdriver.chrome.driver"),
        IE("webdriver.ie.driver"),
        EDGE("webdriver.edge.driver"),
        FIREFOX("webdriver.gecko.driver");

        private String driverString;

        private WebDriverType(String driverString) {
            this.driverString = driverString;
        }

        public String driverName() {
            return this.driverString;
        }
    }
}
