package bacarotech.serie.springboot.service;

import bacarotech.serie.springboot.dto.InsertUserDTO;
import bacarotech.serie.springboot.dto.UpdateUserDTO;
import bacarotech.serie.springboot.dto.UserDTO;
import bacarotech.serie.springboot.model.User;

public interface IUserService {
    public UserDTO insert(InsertUserDTO dto);

    public UserDTO get(long id);

    public UserDTO update(long id, UpdateUserDTO dto);

    public int delete(long id);
}
