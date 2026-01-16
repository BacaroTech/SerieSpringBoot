package bacarotech.serie.springboot.controller;

import bacarotech.serie.springboot.dto.PaginationDTO;
import bacarotech.serie.springboot.dto.todo.InsertTodoDTO;
import bacarotech.serie.springboot.dto.todo.TodoDTO;
import bacarotech.serie.springboot.dto.todo.UpdateTodoDTO;
import bacarotech.serie.springboot.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private ITodoService todoService;

    @PostMapping("/user/{userId}")
    public ResponseEntity<TodoDTO> insertTodo(
            @PathVariable("userId") long userId,
            @RequestBody InsertTodoDTO dto
            ) {
        return new ResponseEntity<>(this.todoService.insert(userId, dto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> getTodo(
            @PathVariable("id") long id
    ) {
        TodoDTO todoFound = this.todoService.get(id);

        return todoFound != null ?
                new ResponseEntity<>(todoFound, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<PaginationDTO<TodoDTO>> getUserTodos(
            @PathVariable("userId") long userId,
            @RequestParam(value = "pageSize", required = true) int pageSize,
            @RequestParam(value = "pageNumber", required = true) int pageNumber
    ) {
        PaginationDTO<TodoDTO> todos = this.todoService.getByUserId(userId, pageSize, pageNumber);

       return todos != null ?
               new ResponseEntity<>(todos, HttpStatus.OK) :
               new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> updateTodo(
            @PathVariable("id") long id,
            @RequestBody UpdateTodoDTO dto
    ) {
        TodoDTO todo = this.todoService.update(id, dto);

        return todo != null ?
                new ResponseEntity<>(todo, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(
            @PathVariable("id") long id
    ) {
        int count = this.todoService.delete(id);

        if (count == 1) return new ResponseEntity<>("Todo deleted", HttpStatus.OK);
        else if (count == 0) return new ResponseEntity<>("Todo not found", HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>("Error", HttpStatus.MULTI_STATUS);
    }
}
