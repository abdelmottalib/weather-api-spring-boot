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
import weatherapp.demo.entity.Request;
import weatherapp.demo.entity.WeatherEntity;

import java.util.Objects;

@Service
public class GeocodingProvider {
    @Value("${api.key}")
    private String apiKey;
    @Value("${geocoding.url}")
    private String url;
    public CityCoordinates getCoordinates(Request request) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> requestEntity = new HttpEntity<>(null, null);
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("q", request.getCity())
                .queryParam("appid", apiKey).build();
        return Objects.requireNonNull(restTemplate.getForObject(uriComponents.toUriString(), CityCoordinates[].class))[0];
    }
}
