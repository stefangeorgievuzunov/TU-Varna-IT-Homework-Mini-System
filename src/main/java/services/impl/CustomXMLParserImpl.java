package services.impl;

import entities.UsersList;
import services.XMLParser;

import javax.annotation.ManagedBean;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Default
public class CustomXMLParserImpl implements XMLParser {
    private static final String XML_FILE_NAME="D:\\TU VARNA\\TRETI KYRS\\SEMESTUR 2\\ИТ\\UPRS\\src\\main\\resources\\META-INF\\users.xml";
    private final JAXBContext context;
    @Inject
    public CustomXMLParserImpl(JAXBContext context) {
        this.context = context;
    }

    @Override
    public void writeToXMLFile(@NotNull UsersList users) {
        try {
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            m.marshal(users,new File(XML_FILE_NAME));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UsersList readFromXMLFile() {
        try {
            Unmarshaller um = context.createUnmarshaller();
            return (UsersList) um.unmarshal(new FileReader(XML_FILE_NAME));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
