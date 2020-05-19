package services;

import services.models.UserModel;

import java.util.List;

public interface UsersService {
    void register(String name, String email, String password, String confirmPassword) throws Exception;
    UserModel login(String email, String password);
    UserModel edit(Integer id,String name, String job, String description, String city, String phoneNumber, String street);
    UserModel skillsEdit(UserModel u);
    UserModel personalEdit(UserModel u);
    UserModel contactsEdit(UserModel u);
    List<UserModel> getAllUsers();
    UserModel getUserById(Integer id);
}
