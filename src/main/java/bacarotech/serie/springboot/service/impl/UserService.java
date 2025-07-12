package bacarotech.serie.springboot.service.impl;

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
    public User insert() {
        User user = new User();
        user.setFirstName("Moreno");
        user.setLastName("Frigo Turco");
        user.setEmail("mft@gmail.com");

        return this.userRepository.save(user);
    }

    @Override
    public User get(long id) {
        return this.userRepository.findById(id).orElse(null);
    }
}
