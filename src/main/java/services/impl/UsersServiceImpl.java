package services.impl;

import entities.Address;
import services.CustomEntityManager;
import services.models.UserModel;
import entities.User;
import org.modelmapper.ModelMapper;
import services.UsersService;
import services.UsersValidationService;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@Default
public class UsersServiceImpl implements UsersService {
    private final ModelMapper modelMapper;
    private final CustomEntityManager entityManager;
    private final UsersValidationService usersValidationService;

    @Inject
    public UsersServiceImpl(ModelMapper modelMapper, CustomEntityManager entityManager, UsersValidationService usersValidationService) {
        this.modelMapper = modelMapper;
        this.entityManager = entityManager;
        this.usersValidationService = usersValidationService;
    }

    @Override
    public void register(String name, String email, String password, String confirmPassword) throws Exception {

        if (!usersValidationService.isUsersInfoValid(email, password, confirmPassword)) {
            throw new Exception("Corrupted user's data.");
        }

        int id=entityManager.selectAll().size()+1;

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setId(id);

        entityManager.persist(user);
    }

    @Override
    public UserModel login(String email, String password) {
        List<User> users = entityManager.selectAll();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return modelMapper.map(user, UserModel.class);
            }
        }
        return null;
    }

    @Override
    public UserModel edit(Integer id, String name, String job, String description, String city, String phoneNumber, String street) {
        User user = entityManager.find(id);

        if (user != null) {

            user.setName(name);
            user.setJob(job);
            user.setDescription(description);
            user.setPhoneNumber(phoneNumber);
            Address address = new Address();
            address.setCity(city);
            address.setStreet(street);
            user.setAddress(address);

            entityManager.persist(user);

            return modelMapper.map(user, UserModel.class);
        }
        return null;
    }

    @Override
    public UserModel skillsEdit(UserModel u) {
        User user=entityManager.find(u.getId());

        user.setSocialSkills(u.getSocialSkills());
        user.setProgrammingSkills(u.getProgrammingSkills());

        entityManager.persist(user);
        return modelMapper.map(user, UserModel.class);
    }

    @Override
    public UserModel personalEdit(UserModel u) {
        User user=entityManager.find(u.getId());

        user.setName(u.getName());
        user.setJob(u.getJob());
        user.setDescription(u.getDescription());

        entityManager.persist(user);
        return modelMapper.map(user, UserModel.class);
    }

    @Override
    public UserModel contactsEdit(UserModel u) {
        User user=entityManager.find(u.getId());
        user.setAddress(u.getAddress());
        user.setPhoneNumber(u.getPhoneNumber());
        entityManager.persist(user);
        return modelMapper.map(user, UserModel.class);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return entityManager.selectAll()
                .stream()
                .map(user -> modelMapper.map(user, UserModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserModel getUserById(Integer id) {
        User user = entityManager.find(id);
        if (user != null)
            return modelMapper.map(user, UserModel.class);
        return null;
    }
}
