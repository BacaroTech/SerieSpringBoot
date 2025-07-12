package bacarotech.serie.springboot.service.impl;

import bacarotech.serie.springboot.model.Todo;
import bacarotech.serie.springboot.model.User;
import bacarotech.serie.springboot.repository.TodoRepository;
import bacarotech.serie.springboot.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService implements ITodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserService userService;

    @Override
    public Todo insert(long userId) {
        User userFound = this.userService.get(userId);

        if (userFound != null) {
            Todo todo = new Todo();

            todo.setTitle("Titolo");
            todo.setDescription("Descrizione");
            todo.setUser(userFound);

            return this.todoRepository.save(todo);
        }
        else {
            return null;
        }
    }

    @Override
    public Todo get(long id) {
        return this.todoRepository.findById(id).orElse(null);
    }
}
