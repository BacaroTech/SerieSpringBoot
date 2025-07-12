package bacarotech.serie.springboot.service;

import bacarotech.serie.springboot.model.User;

public interface IUserService {
    public User insert();

    public User get(long id);
}
