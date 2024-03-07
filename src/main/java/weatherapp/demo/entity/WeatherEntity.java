package weatherapp.demo.entity;


import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WeatherEntity {
    private String main;
    private String id;
    private String description;
    private String icon;
}
