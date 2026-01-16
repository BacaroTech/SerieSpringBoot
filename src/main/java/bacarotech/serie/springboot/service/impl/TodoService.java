package bacarotech.serie.springboot.service.impl;

import bacarotech.serie.springboot.dto.PaginationDTO;
import bacarotech.serie.springboot.dto.todo.InsertTodoDTO;
import bacarotech.serie.springboot.dto.todo.TodoDTO;
import bacarotech.serie.springboot.dto.todo.UpdateTodoDTO;
import bacarotech.serie.springboot.model.Todo;
import bacarotech.serie.springboot.model.User;
import bacarotech.serie.springboot.repository.TodoRepository;
import bacarotech.serie.springboot.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
    public PaginationDTO<TodoDTO> getByUserId(long userId, int pageSize, int pageNumber) {
        User userFound = this.userService.getUser(userId);

        if (userFound == null) return null;

        Page<Todo> todos = this.todoRepository.findByUser(userFound, PageRequest.of(pageNumber, pageSize));

        return PaginationDTO.fromPage(todos, TodoDTO::fromTodo);
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
