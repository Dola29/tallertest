package Pages;

import BaseClasses.BasePage;
import DataModels.Temperature;

import org.openqa.selenium.Keys;

public class GooglePage extends BasePage {
        //Methods
    public void googleSearch(Temperature tempData){
        actions.sleep(5000);
        actions.sendKeys("//input[@name='q']", tempData.cityName +" weather"+ Keys.ENTER);
        actions.sleep(10000);
    }

    public void extractGoogleData(Temperature tempData){
       String value = actions.getText("//span[contains(@id,'wob_tm')]");
       tempData.degrees = Float.parseFloat(value);
    }

}
