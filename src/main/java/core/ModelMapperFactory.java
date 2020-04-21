package core;

import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;

public class ModelMapperFactory {
    @Produces
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        return mapper;
    }
}
