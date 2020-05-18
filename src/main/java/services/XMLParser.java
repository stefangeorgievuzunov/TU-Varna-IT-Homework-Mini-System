package services;

import entities.UsersList;

import javax.validation.constraints.NotNull;

public interface XMLParser {
    void writeToXMLFile(@NotNull UsersList users);
    UsersList readFromXMLFile();
}
