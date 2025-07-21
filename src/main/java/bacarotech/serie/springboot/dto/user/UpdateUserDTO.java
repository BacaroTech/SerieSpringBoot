package bacarotech.serie.springboot.dto.user;

import bacarotech.serie.springboot.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateUserDTO(
        @JsonProperty(value = "first_name", required = false)
        String firstName,
        @JsonProperty(value = "last_name", required = false)
        String lastName,
        @JsonProperty(value = "email", required = false)
        String email
) {

    public User fromUpdateUserDTO(User user) {
        if (this.firstName() != null && !this.firstName().isBlank()) {
            user.setFirstName(this.firstName());
        }

        if (this.lastName() != null && !this.lastName().isBlank()) {
            user.setLastName(this.lastName());
        }

        if (this.email() != null && !this.email().isBlank()) {
            user.setEmail(this.email());
        }

        return user;
    }
}
