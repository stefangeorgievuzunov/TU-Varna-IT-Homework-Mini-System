package services.impl;

import entities.User;
import entities.UsersList;
import services.CustomEntityManager;
import services.XMLParser;

import javax.annotation.ManagedBean;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.List;

@Default
public class CustomEntityManagerImpl implements CustomEntityManager {
    private final XMLParser parser;

    @Inject
    public CustomEntityManagerImpl(XMLParser parser) {
        this.parser = parser;
    }

    @Override
    public void persist(@NotNull User user) {
        UsersList users=parser.readFromXMLFile();
        if(users.getUsers().contains(user)){
            int index=users.getUsers().indexOf(user);
            users.getUsers().set(index,user);
        }else{
            users.getUsers().add(user);
        }
        parser.writeToXMLFile(users);
    }

    @Override
    public User find(@NotNull Integer id) {
        UsersList users=parser.readFromXMLFile();
        for (User user:users.getUsers()){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> selectAll() {
        UsersList users=parser.readFromXMLFile();
        return users.getUsers();
    }
}
