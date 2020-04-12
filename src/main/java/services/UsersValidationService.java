package services;

public interface UsersValidationService {
    boolean isUsersInfoValid(String email,String password,String confirmPassword);
}
