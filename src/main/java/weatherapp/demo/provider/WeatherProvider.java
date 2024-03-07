package weatherapp.demo.provider;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import weatherapp.demo.entity.CityCoordinates;
import weatherapp.demo.entity.OpenWeatherResponse;

@Service
public class WeatherProvider {
    @Value("${api.key}")
    private String apiKey;
    @Value("${weather.url}")
    private String url;

    public OpenWeatherResponse getWeather(CityCoordinates cityCoordinates) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> requestEntity = new HttpEntity<>(null, null);
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("lat", cityCoordinates.getLatitude())
                .queryParam("lon", cityCoordinates.getLongitude())
                .queryParam("appid", apiKey).build();
        return restTemplate.getForObject(uriComponents.toUriString(), OpenWeatherResponse.class);
    }
}
