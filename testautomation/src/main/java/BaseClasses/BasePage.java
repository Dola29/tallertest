package BaseClasses;

import org.openqa.selenium.WebDriver;

public class BasePage{
    protected Actions actions = WebDriverActionsManager.getWebDriverActions();
    protected WebDriver driver;
    public BasePage() {
        this.driver = this.actions.getDriver();
    }


}
