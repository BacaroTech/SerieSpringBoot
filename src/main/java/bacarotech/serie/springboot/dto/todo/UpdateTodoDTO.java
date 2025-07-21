package bacarotech.serie.springboot.dto.todo;

import bacarotech.serie.springboot.model.Todo;
import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateTodoDTO(
        @JsonProperty(value = "title", required = false)
        String title,
        @JsonProperty(value = "description", required = false)
        String description
) {

    public Todo toTodo(Todo todo) {
        if (this.title() != null && !this.title().isBlank()) {
            todo.setTitle(this.title());
        }

        if (this.description() != null && !this.description().isBlank()) {
            todo.setDescription(this.description());
        }

        return todo;
    }
}
