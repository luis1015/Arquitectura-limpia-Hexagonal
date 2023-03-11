package com.example.arqui_hexagonal.application.handler;

import com.example.arqui_hexagonal.application.dto.PokedexRequest;
import com.example.arqui_hexagonal.application.dto.PokedexResponse;
import com.example.arqui_hexagonal.application.mapper.PokedexRequestMapper;
import com.example.arqui_hexagonal.application.mapper.PokedexResponseMapper;
import com.example.arqui_hexagonal.application.mapper.TypeDtoMapper;
import com.example.arqui_hexagonal.domain.api.IPhotoServicePort;
import com.example.arqui_hexagonal.domain.api.IPokemonServicePort;
import com.example.arqui_hexagonal.domain.api.ITypePort;
import com.example.arqui_hexagonal.domain.model.Photo;
import com.example.arqui_hexagonal.domain.model.Pokemon;
import com.example.arqui_hexagonal.domain.model.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor //inyeccion de depencias
@Transactional //
public class PokedexHandler implements IPokedexHandler{

    private final IPokemonServicePort pokemonServicePort;
    private final ITypePort typePort;
    private final IPhotoServicePort photoServicePort;
    private final PokedexRequestMapper pokedexRequestMapper;
    private final PokedexResponseMapper pokedexResponseMapper;
    private final TypeDtoMapper typeDtoMapper;


    @Override
    public void savePokemonPokedex(PokedexRequest pokedexRequest) {
        Type type = typePort.saveType(pokedexRequestMapper.toType(pokedexRequest));
        Photo photo = photoServicePort.savePhoto(pokedexRequestMapper.toPhoto(pokedexRequest));
        Pokemon pokemon = pokedexRequestMapper.toPokemon(pokedexRequest);
        pokemon.setTypeId(type.getId());
        pokemon.setPhotoId(photo.getId());
        pokemonServicePort.savePokemon(pokemon);
    }

    @Override
    public List<PokedexResponse> getAllPokemonFromPokedex() {
        return pokedexResponseMapper.toResponseList(pokemonServicePort.getAllPokemon(), typePort.getAllType(),photoServicePort.getAllPhoto());
    }

    @Override
    public PokedexResponse getPokemonFromPokedex(Long pokemonNumber) {
        Pokemon pokemon = pokemonServicePort.getPokemon(pokemonNumber);
        return pokedexResponseMapper.toResponse(pokemon
                ,typeDtoMapper.toTypeDto(typePort.getType(pokemon.getTypeId()))
                ,photoServicePort.getPhoto(pokemon.getPhotoId()));
    }

    @Override
    public void updatePokemonInPokedex(PokedexRequest pokedexRequest) {
        Pokemon oldPokemon = pokemonServicePort.getPokemon(pokedexRequest.getNumber());

        Type newType = pokedexRequestMapper.toType(pokedexRequest);
        newType.setId(oldPokemon.getTypeId());
        typePort.updateType(newType);

        Photo newPhoto = pokedexRequestMapper.toPhoto(pokedexRequest);
        newPhoto.setId(oldPokemon.getPhotoId());
        photoServicePort.updatePhoto(newPhoto);

        Pokemon newPokemon = pokedexRequestMapper.toPokemon(pokedexRequest);
        newPokemon.setId(oldPokemon.getId());
        newPokemon.setTypeId(oldPokemon.getTypeId());
        newPokemon.setPhotoId(oldPokemon.getPhotoId());
        pokemonServicePort.updatePokemon(newPokemon);
    }

    @Override
    public void deletePokemonFromPokedex(Long pokemonNumber) {
        Pokemon pokemon = pokemonServicePort.getPokemon(pokemonNumber);
        typePort.deleteType(pokemon.getTypeId());
        photoServicePort.deletePhoto((pokemon.getPhotoId()));
        pokemonServicePort.deletePokemon(pokemonNumber);

    }
}
