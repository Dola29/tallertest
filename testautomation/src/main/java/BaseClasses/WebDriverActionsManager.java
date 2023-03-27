package BaseClasses;

import org.openqa.selenium.WebDriver;


public class WebDriverActionsManager {

    private static ThreadLocal<Actions> webDriverActions = new ThreadLocal();

    public WebDriverActionsManager() {
    }

    public static void setWebDriverActions(WebDriver driver) {
        webDriverActions.set(new Actions(driver));
    }

    public static Actions getWebDriverActions() {
        return (Actions) webDriverActions.get();
    }

    public static void closeDriver() {
        ((Actions) webDriverActions.get()).getDriver().quit();
        webDriverActions.remove();
    }
}
