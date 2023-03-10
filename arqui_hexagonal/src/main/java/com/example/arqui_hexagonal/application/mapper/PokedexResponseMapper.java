package com.example.arqui_hexagonal.application.mapper;

import com.example.arqui_hexagonal.application.dto.PokedexRequest;
import com.example.arqui_hexagonal.application.dto.PokedexResponse;
import com.example.arqui_hexagonal.application.dto.TypeDto;
import com.example.arqui_hexagonal.domain.model.Photo;
import com.example.arqui_hexagonal.domain.model.Pokemon;
import com.example.arqui_hexagonal.domain.model.Type;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Base64;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {TypeDtoMapper.class})

public interface PokedexResponseMapper {

    TypeDtoMapper INSTANCE = Mappers.getMapper(TypeDtoMapper.class); // creamos una instacia por que tenemos que utilizar el typeDTo y no el modelo
    @Mapping(target = "types.firtType", source = "typeDto.firtType")
    @Mapping(target = "types.secondType", source = "typeDto.secondType")
    @Mapping(target = "photo", qualifiedByName = "byteArrayToBase64")
    PokedexResponse toResponse(Pokemon pokemon, TypeDto typeDto, Photo photo);

    @Named("byteArrayToBase64")
    static String byteArrayToBase64(byte[] byteArrayPhoto){
        return Base64.getEncoder().encodeToString(byteArrayPhoto);
    }

    default List<PokedexResponse> toResponseList(List<Pokemon> pokemon, List<Type> typeList, List<Photo> photoList) {
        return pokemon.stream()
                .map(pokemon1 -> {
                    PokedexResponse pokedexResponse = new PokedexResponse();
                    pokedexResponse.setNumber(pokedexResponse.getNumber());
                    pokedexResponse.setName(pokedexResponse.getName());
                    pokedexResponse.setTypes(INSTANCE.toTypeDto(typeList.stream()
                                                                        .filter(type -> type.getId()
                                                                                            .equals(pokemon1
                                                                                                    .getTypeId())).findFirst().orElse(null)));

                    pokedexResponse.setPhoto(byteArrayToBase64(photoList.stream()
                            .filter(photo -> photo.getId()
                                    .equals(pokemon1.getPhotoId()))
                            .findFirst()
                            .orElse(null).getPhoto()));
                    return pokedexResponse;
                }).toList();
    }

}
