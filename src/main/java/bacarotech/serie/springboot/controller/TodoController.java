package bacarotech.serie.springboot.controller;

import bacarotech.serie.springboot.model.Todo;
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
    public ResponseEntity<Todo> insertTodo(
            @PathVariable("userId") long userId
    ) {
        return new ResponseEntity<>(this.todoService.insert(userId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(
            @PathVariable("id") long id
    ) {
        Todo todoFound = this.todoService.get(id);

        return todoFound != null ?
                new ResponseEntity<>(todoFound, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
