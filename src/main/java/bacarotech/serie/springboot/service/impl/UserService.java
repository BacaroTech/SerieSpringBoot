package bacarotech.serie.springboot.service.impl;

import bacarotech.serie.springboot.dto.InsertUserDTO;
import bacarotech.serie.springboot.dto.UpdateUserDTO;
import bacarotech.serie.springboot.dto.UserDTO;
import bacarotech.serie.springboot.model.User;
import bacarotech.serie.springboot.repository.UserRepository;
import bacarotech.serie.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDTO insert(InsertUserDTO dto) {
        User user = dto.toUser();

        user = this.userRepository.save(user);

        return UserDTO.fromUser(user);
    }

    @Override
    public UserDTO get(long id) {
        User user = this.userRepository.findById(id).orElse(null);
        return user != null ?
                UserDTO.fromUser(user) :
                null;
    }

    @Override
    public UserDTO update(long id, UpdateUserDTO dto) {
        User user = this.userRepository.findById(id).orElse(null);

        if (user == null) return null;

        user = this.userRepository.save(dto.fromUpdateUserDTO(user));

        return UserDTO.fromUser(user);
    }

    @Override
    public int delete(long id) {
        return this.userRepository.delete(id);
    }
}
