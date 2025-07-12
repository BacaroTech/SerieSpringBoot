package bacarotech.serie.springboot.controller;

import bacarotech.serie.springboot.model.User;
import bacarotech.serie.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<User> insertUser() {
        return new ResponseEntity<>(this.userService.insert(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(
            @PathVariable("id") long id
    ) {
        User userFound = this.userService.get(id);

        return userFound != null ?
                new ResponseEntity<>(this.userService.get(id), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
