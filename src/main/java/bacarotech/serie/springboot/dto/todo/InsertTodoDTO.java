package bacarotech.serie.springboot.dto.todo;

import bacarotech.serie.springboot.model.Todo;
import bacarotech.serie.springboot.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public record InsertTodoDTO(
        @JsonProperty(value = "title", required = true)
        String title,
        @JsonProperty(value = "description", required = false)
        String description
) {

    public Todo toTodo(User user) {
        Todo todo = new Todo();

        todo.setTitle(this.title());
        todo.setDescription(this.description());
        todo.setUser(user);

        return todo;
    }
}
