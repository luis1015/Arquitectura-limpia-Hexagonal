package com.example.arqui_hexagonal.domain.spi;

import com.example.arqui_hexagonal.domain.model.Pokemon;
import com.example.arqui_hexagonal.domain.model.Type;

import java.util.List;

public interface ITypePersistencesPort {

    Type saveType(Type type);

    List<Type> getAllType();

    Pokemon getType(Long typeId);

    void updateType(Type type);

    void deleteType(Long typeId);
}
