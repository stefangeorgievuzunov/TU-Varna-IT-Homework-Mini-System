package services;

import models.UserModel;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UsersService {
    void register(String name, String email, String password, String confirmPassword) throws Exception;
    UserModel login(String email, String password);
    UserModel edit(Integer id,String name, String job, String description, String city, String phoneNumber, String street);
    List<UserModel> getAllUsers();
    UserModel getUserById(Integer id);
}
