package bacarotech.serie.springboot.service.impl;

import bacarotech.serie.springboot.dto.todo.InsertTodoDTO;
import bacarotech.serie.springboot.dto.todo.TodoDTO;
import bacarotech.serie.springboot.dto.todo.UpdateTodoDTO;
import bacarotech.serie.springboot.model.Todo;
import bacarotech.serie.springboot.model.User;
import bacarotech.serie.springboot.repository.TodoRepository;
import bacarotech.serie.springboot.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements ITodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserService userService;


    @Override
    public TodoDTO insert(long userId, InsertTodoDTO dto) {
        User userFound = this.userService.getUser(userId);

        if (userFound == null) return null;

        Todo todo = this.todoRepository.save(dto.toTodo(userFound));

        return TodoDTO.fromTodo(todo);
    }

    @Override
    public TodoDTO get(long id) {
        Todo todo = this.todoRepository.findById(id).orElse(null);

        return todo != null ?
                TodoDTO.fromTodo(todo) :
                null;
    }

    @Override
    public List<TodoDTO> getByUserId(long userId) {
        User userFound = this.userService.getUser(userId);

        if (userFound == null) return null;

        List<Todo> todos = this.todoRepository.findByUser(userFound);

        return todos.stream().map(TodoDTO::fromTodo).toList();
    }

    @Override
    public TodoDTO update(long id, UpdateTodoDTO dto) {
        Todo todo = this.todoRepository.findById(id).orElse(null);

        if (todo == null) return null;

        todo = this.todoRepository.save(dto.toTodo(todo));

        return TodoDTO.fromTodo(todo);
    }

    @Override
    public int delete(long id) {
        return this.todoRepository.delete(id);
    }
}
