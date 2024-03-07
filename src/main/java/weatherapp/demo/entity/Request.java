package weatherapp.demo.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Request {
    private String city;
}
