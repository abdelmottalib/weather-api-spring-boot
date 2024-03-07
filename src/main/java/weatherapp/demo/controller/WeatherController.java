package weatherapp.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import weatherapp.demo.entity.Request;
import weatherapp.demo.entity.WeatherResponse;
import weatherapp.demo.service.WeatherService;

@RestController
@RequestMapping("/api/v1")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(final WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("weather/{city}")
    public @ResponseBody ResponseEntity<Object> weather(@PathVariable("city") String city) {
        WeatherResponse weather;
        final Request request = Request.builder()
                .city(city)
                .build();
        try {
            weather = weatherService.getWeather(request);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(weather);
    }
}
