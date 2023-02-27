package com.example.arqui_hexagonal.domain.usecase;

import com.example.arqui_hexagonal.domain.api.ITypePort;
import com.example.arqui_hexagonal.domain.model.Pokemon;
import com.example.arqui_hexagonal.domain.model.Type;
import com.example.arqui_hexagonal.domain.spi.ITypePersistencesPort;

import java.util.List;

public class TypeUseCase implements ITypePort {

    private final ITypePersistencesPort typePersistences;

    public TypeUseCase(ITypePersistencesPort typePersistences) {
        this.typePersistences = typePersistences;
    }

    @Override
    public Type saveType(Type type) {
        return typePersistences.saveType(type);
    }

    @Override
    public List<Type> getAllType() {
        return typePersistences.getAllType();
    }

    @Override
    public Pokemon getType(Long typeId) {
        return typePersistences.getType(typeId);
    }

    @Override
    public void updateType(Type type) {
        typePersistences.updateType(type);
    }

    @Override
    public void deleteType(Long typeId) {
        typePersistences.deleteType(typeId);
    }
}
