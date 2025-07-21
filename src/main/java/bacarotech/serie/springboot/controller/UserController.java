package bacarotech.serie.springboot.controller;

import bacarotech.serie.springboot.dto.user.InsertUserDTO;
import bacarotech.serie.springboot.dto.user.UpdateUserDTO;
import bacarotech.serie.springboot.dto.user.UserDTO;
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
    public ResponseEntity<UserDTO> insertUser(
            @RequestBody InsertUserDTO dto
        ) {
        return new ResponseEntity<>(this.userService.insert(dto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(
            @PathVariable("id") long id
    ) {
        UserDTO userFound = this.userService.get(id);

        return userFound != null ?
                new ResponseEntity<>(userFound, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable("id") long id,
            @RequestBody UpdateUserDTO dto
        ) {
        UserDTO userUpdated = this.userService.update(id, dto);

        return userUpdated != null ?
                new ResponseEntity<>(userUpdated, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable("id") long id
    ) {
        int count = this.userService.delete(id);

        if (count == 1) return new ResponseEntity<>("User deleted", HttpStatus.OK);
        else if (count == 0) return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>("Error", HttpStatus.MULTI_STATUS);
    }

}
