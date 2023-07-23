package data.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    private int id;
    private String name;
    private String username;

    private String email;

    private String birthdate;

    private String phone;
}

