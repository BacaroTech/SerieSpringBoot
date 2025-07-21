package bacarotech.serie.springboot.dto.todo;

import bacarotech.serie.springboot.model.Todo;
import com.fasterxml.jackson.annotation.JsonProperty;

public record TodoDTO(
        @JsonProperty(value = "id", required = true)
        long id,
        @JsonProperty(value = "title", required = true)
        String title,
        @JsonProperty(value = "description", required = false)
        String description,
        @JsonProperty(value = "user_id", required = true)
        long userId
) {

    public static TodoDTO fromTodo(Todo todo) {
        return new TodoDTO(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getUser().getId()
        );
    }
}
