package services.impl;

import entities.User;
import services.CustomEntityManager;
import services.UsersValidationService;

import javax.annotation.ManagedBean;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.List;

@Default
public class UsersValidationServiceImpl implements UsersValidationService {
    private final CustomEntityManager entityManager;

    @Inject
    public UsersValidationServiceImpl(CustomEntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean isUsersInfoValid(String email, String password, String confirmPassword) {
        return isPasswordFormatCorrect(password) && arePasswordsMatching(password, confirmPassword) && isMailFree(email);
    }

    private boolean isPasswordFormatCorrect(String password) {
        return password != null && password.length() >= 8;
    }

    private boolean arePasswordsMatching(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    private boolean isMailFree(String email) {
        List<User> users=entityManager.selectAll();
        for (User user:users){
            if(user.getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }
}
