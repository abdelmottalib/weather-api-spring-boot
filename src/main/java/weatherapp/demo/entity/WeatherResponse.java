package weatherapp.demo.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class WeatherResponse {
    private String weather;
    private String details;

    public WeatherResponse(String weather, String details) {
        this.weather = weather;
        this.details = details;
    }
}
