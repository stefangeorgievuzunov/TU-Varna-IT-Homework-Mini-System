package services.impl;

import entities.UsersList;
import services.XMLParser;

import javax.validation.constraints.NotNull;

public class CustomXMLParserImpl implements XMLParser {

    @Override
    public void writeToXMLFile(@NotNull UsersList users) {

    }

    @Override
    public UsersList readFromXMLFile() {
        return null;
    }
}
