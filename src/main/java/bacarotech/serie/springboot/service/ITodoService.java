package bacarotech.serie.springboot.service;

import bacarotech.serie.springboot.dto.todo.InsertTodoDTO;
import bacarotech.serie.springboot.dto.todo.TodoDTO;
import bacarotech.serie.springboot.dto.todo.UpdateTodoDTO;

import java.util.List;

public interface ITodoService {

    public TodoDTO insert(long userId, InsertTodoDTO dto);

    public TodoDTO get(long id);

    public List<TodoDTO> getByUserId(long userId);

    public TodoDTO update(long id, UpdateTodoDTO dto);

    public int delete(long id);
}
