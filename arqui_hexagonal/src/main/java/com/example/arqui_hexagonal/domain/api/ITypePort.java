package com.example.arqui_hexagonal.domain.api;

import com.example.arqui_hexagonal.domain.model.Pokemon;
import com.example.arqui_hexagonal.domain.model.Type;

import java.util.List;

public interface ITypePort {

    Type saveType(Type type);

    List<Type> getAllType();

    Pokemon getType(Long typeId);

    void updateType(Type type);

    void deleteType(Long typeId);

}
