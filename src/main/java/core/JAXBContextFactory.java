package core;

import entities.UsersList;

import javax.enterprise.inject.Produces;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class JAXBContextFactory {
    @Produces
    public JAXBContext jaxbContext() throws JAXBException {
        return JAXBContext.newInstance(UsersList.class);
    }
}
