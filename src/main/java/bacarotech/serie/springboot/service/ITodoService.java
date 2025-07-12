package bacarotech.serie.springboot.service;

import bacarotech.serie.springboot.model.Todo;

public interface ITodoService {

    public Todo insert(long userId);

    public Todo get(long id);
}
