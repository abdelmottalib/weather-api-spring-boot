package weatherapp.demo.service;


import org.springframework.stereotype.Service;
import weatherapp.demo.entity.*;
import weatherapp.demo.provider.GeocodingProvider;
import weatherapp.demo.provider.WeatherProvider;

@Service
public class WeatherService {
    private final GeocodingProvider geocodingProvider;
    private final WeatherProvider weatherProvider;

    public WeatherService(GeocodingProvider geocodingProvider, WeatherProvider weatherProvider) {
        this.geocodingProvider = geocodingProvider;
        this.weatherProvider = weatherProvider;
    }

    public WeatherResponse getWeather(Request request) {
        //get latitude and altitude
        final CityCoordinates cityCoordinates = geocodingProvider.getCoordinates(request);
        //get weather
        final OpenWeatherResponse cityWeather = weatherProvider.getWeather(cityCoordinates);
        return WeatherResponse.builder().
                weather(cityWeather.getWeather()[0].getMain())
                .details(cityWeather.getWeather()[0].getDescription()).build();
    }
}
