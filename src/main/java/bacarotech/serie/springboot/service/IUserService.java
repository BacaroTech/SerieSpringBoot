package bacarotech.serie.springboot.service;

import bacarotech.serie.springboot.dto.user.InsertUserDTO;
import bacarotech.serie.springboot.dto.user.UpdateUserDTO;
import bacarotech.serie.springboot.dto.user.UserDTO;

public interface IUserService {
    public UserDTO insert(InsertUserDTO dto);

    public UserDTO get(long id);

    public UserDTO update(long id, UpdateUserDTO dto);

    public int delete(long id);
}
