package bacarotech.serie.springboot.dto.user;

import bacarotech.serie.springboot.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public record InsertUserDTO(
        @JsonProperty(value = "first_name", required = true)
        String firstName,
        @JsonProperty(value = "last_name", required = true)
        String lastName,
        @JsonProperty(value = "email", required = true)
        String email
) {

    public User toUser() {
        User user = new User();

        user.setFirstName(this.firstName());
        user.setLastName(this.lastName());
        user.setEmail(this.email());

        return user;
    }
}
