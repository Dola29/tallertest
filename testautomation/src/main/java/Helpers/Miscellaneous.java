package Helpers;

import DataModels.Temperature;

public class Miscellaneous {
    public static void showWeatherDataResult(Temperature googleData, Temperature apiData){
        float difference = googleData.degrees - apiData.degrees;

        System.out.println("Google Data");
        System.out.println("Temperature: " + googleData.cityName + " -> "+ googleData.degrees);
        System.out.println("API Data");
        System.out.println("Temperature: " + apiData.cityName + " -> "+ apiData.degrees);
        System.out.println("The difference: " + difference);
    }
}
