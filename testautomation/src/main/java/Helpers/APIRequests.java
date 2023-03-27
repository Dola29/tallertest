package Helpers;

import DataModels.Temperature;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.get;

public class APIRequests {
    public static void APIRequest(Temperature tempData){
        String URL = "https://api.openweathermap.org/data/2.5/weather?q=";
        String params = tempData.cityName+"&units=metric&appid=d80f92b7a39c43da727078f17b544ad3";
        Response response = get(URL + params);
        JsonPath jsonPathEvaluator = response.jsonPath();
        tempData.degrees = jsonPathEvaluator.get("main.temp");
    }
}
