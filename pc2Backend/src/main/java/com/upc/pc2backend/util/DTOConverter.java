package com.upc.pc2backend.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTOConverter {
    @Autowired
    private ModelMapper paModelMapper;

    public <T, U> T convertToDto(U entity, Class<T> dtoClass) {
        return paModelMapper.map(entity, dtoClass);
    }
    public <T, U> U convertToEntity(T dto, Class<U> entityClass) {
        return paModelMapper.map(dto, entityClass);
    }
}
