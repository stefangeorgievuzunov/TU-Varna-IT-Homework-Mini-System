package services;

import entities.User;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface CustomEntityManager {
    void persist(@NotNull User user);
    User find(@NotNull Integer id);
    List<User> selectAll();
}
