package BaseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions {

    protected WebDriver driver;
    public WebDriverWait wait;
    public WebDriverWait immediateWait;

    public Actions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10L);
        this.immediateWait = new WebDriverWait(driver, 0L);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebElement click(By locator) {
        return this.click(locator, false);
    }

    public WebElement click(String locatorTemplate, Object... valuesToInsert) {
        return this.click(By.xpath(String.format(locatorTemplate, valuesToInsert)));
    }

    public WebElement click(By locator, boolean useActions) {
        WebElement clickableElement = this.driver.findElement(locator);
        return this.click(clickableElement, useActions);
    }


    public WebElement click(WebElement clickableElement, boolean useActions) {
        if (!useActions) {
            clickableElement.click();
            return clickableElement;
        } else {
            org.openqa.selenium.interactions.Actions seleniumActions = new org.openqa.selenium.interactions.Actions(this.driver);
            seleniumActions.moveToElement(clickableElement);
            this.sleep(250);
            seleniumActions.click(clickableElement);
            Action b = seleniumActions.build();
            b.perform();
            return clickableElement;
        }
    }

    public WebElement setText(WebElement inputElement, String text, boolean clearTextFirst) {
        if (clearTextFirst) {
            inputElement.clear();
        }

        inputElement.sendKeys(new CharSequence[]{text});
        return inputElement;
    }

    public WebElement setText(By locator, String text, boolean clearTextFirst) {
        WebElement inputElement = this.driver.findElement(locator);
        return this.setText(inputElement, text, clearTextFirst);
    }

    public WebElement setText(By locator, String text) {
        return this.setText(locator, text, true);
    }

    public WebElement setText(String locatorTemplate, String text, Object... valuesToInsert) {
        return this.setText(By.xpath(String.format(locatorTemplate, valuesToInsert)), text);
    }

    public String getText(WebElement textElement) {
        return textElement.getText();
    }

    public String getText(By locator) {
        return this.getText(this.driver.findElement(locator));
    }

    public String getText(String locatorTemplate, Object... valuesToInsert) {
        return this.getText(By.xpath(String.format(locatorTemplate, valuesToInsert)));
    }

    public void sleep(int msToSleep) {
        try {
            Thread.sleep((long) msToSleep);
        } catch (Exception var3) {

        }

    }

    public void wait(int waitingTime) throws InterruptedException {
        driver.wait(waitingTime);
    }

    public void waitForVisible(By locator, boolean immediate) {
        if (immediate) {
            this.immediateWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void waitForVisible(String locatorTemplate, Object... valuesToInsert) {
        this.waitForVisible(By.xpath(String.format(locatorTemplate, valuesToInsert)), false);
    }

    public void sendKeys(String inputElement, String text){
        WebElement element = driver.findElement(By.xpath(inputElement));
        element.click();
        element.clear();
        element.sendKeys(Keys.HOME);
        element.sendKeys(text);
    }

    public void sendKeys(WebElement element, Keys text){
        element.click();
        element.clear();
        element.sendKeys(Keys.HOME);
        element.sendKeys(text);
    }

}