package bacarotech.serie.springboot.dto;

import bacarotech.serie.springboot.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDTO(
        @JsonProperty(value = "id", required = true)
        long id,
        @JsonProperty(value = "first_name", required = true)
        String firstName,
        @JsonProperty(value = "last_name", required = true)
        String lastName,
        @JsonProperty(value = "email", required = true)
        String email
) {

    public static UserDTO fromUser(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }
}
