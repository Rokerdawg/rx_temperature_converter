package com.converter.temperature.temperatureconverter;

/**
 * Created by rmcg2 on 22/08/2016.
 */
public class ConvertUtils {

    public static float convertFahrenheitToCelcius(float fahrenheit){
        return ((fahrenheit - 32) * 5/9);
    }

    public static float convertCelciusToFahrenheit(float celsius){
        return ((celsius * 9) / 5 ) + 32;
    }
}
