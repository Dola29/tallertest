import BaseClasses.BaseTest;
import DataModels.Temperature;
import static Helpers.APIRequests.APIRequest;
import Pages.GooglePage;
import static Helpers.Miscellaneous.showWeatherDataResult;
import org.testng.annotations.Test;

public class WeatherTests extends BaseTest {

    @Test
    void temperatureTest(){
        setUp();

        Temperature googleTemperature = new Temperature();
        Temperature apiTemperature = new Temperature();
        googleTemperature.cityName =  "Los Angeles";
        apiTemperature.cityName =  "Los Angeles";

        GooglePage googlePage = new GooglePage();
        googlePage.googleSearch(googleTemperature);
        googlePage.extractGoogleData(googleTemperature);

        tearDown();

        APIRequest(apiTemperature);

        showWeatherDataResult(googleTemperature,apiTemperature);
    }
}
