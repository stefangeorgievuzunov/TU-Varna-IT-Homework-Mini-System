package services.impl;

import models.UserModel;
import models.entity.Users;
import org.modelmapper.ModelMapper;
import services.UsersService;
import services.UsersValidationService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

public class UsersServiceImplementation implements UsersService {
    private final ModelMapper modelMapper;
    private final EntityManager entityManager;
    private final UsersValidationService usersValidationService;

    @Inject
    public UsersServiceImplementation(ModelMapper modelMapper, EntityManager entityManager, UsersValidationService usersValidationService) {
        this.modelMapper = modelMapper;
        this.entityManager = entityManager;
        this.usersValidationService = usersValidationService;
    }

    @Override
    public void register(String name, String email, String password, String confirmPassword) throws Exception {
        if (!usersValidationService.isUsersInfoValid(email, password, confirmPassword)) {
            throw new Exception("Corrupted user's data.");
        }

        Users user = new Users();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public UserModel login(String email, String password) {
        if (email == null || password == null) return null;

        List<Users> users = entityManager.createQuery(
                "select u from Users u where u.email=:email and u.password=:password", Users.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getResultList();

        if (users.isEmpty()) {
            return null;
        }

        return modelMapper.map(users.get(0), UserModel.class);
    }

    @Override
    public UserModel edit(HttpServletRequest req, String name, String job, String description, String city, String phoneNumber, String street) {
        if (req == null) return null;

        UserModel loggedUser = (UserModel) req.getSession(false).getAttribute("user");
        if (loggedUser == null) return null;

        Users user = entityManager.find(Users.class, loggedUser.getId());
        if(user==null) return null;

        user.setName(name);
        user.setJob(job);
        user.setDescription(description);
        user.setCity(city);
        user.setPhoneNumber(phoneNumber);
        user.setStreet(street);

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        return modelMapper.map(user, UserModel.class);
    }
}
