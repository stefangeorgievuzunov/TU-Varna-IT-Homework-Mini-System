package services.impl;

import models.entity.Users;
import services.UsersValidationService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UsersValidationServiceImplementation implements UsersValidationService {
    private final EntityManager entityManager;

    @Inject
    public UsersValidationServiceImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean isUsersInfoValid(String email, String password, String confirmPassword) {
        return  email != null && password != null && confirmPassword != null &&
                isPasswordFormatCorrect(password) && arePasswordMatching(password, confirmPassword) && isMailFree(email);
    }

    private boolean isPasswordFormatCorrect(String password) {
        return password != null && password.length() >= 8;
    }

    private boolean arePasswordMatching(String password, String confirmPassword) {
        return password != null && confirmPassword != null && password.equals(confirmPassword);
    }

    private boolean isMailFree(String email) {
        if (email == null)
            return false;
        List<Users> users = entityManager.createQuery(
                "select u from Users u where u.email=:email", Users.class)
                .setParameter("email", email)
                .getResultList();

        return users.isEmpty();
    }
}
