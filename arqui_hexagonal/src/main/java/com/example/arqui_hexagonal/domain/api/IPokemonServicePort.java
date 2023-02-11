package com.example.arqui_hexagonal.domain.api;

import com.example.arqui_hexagonal.domain.model.Pokemon;

import java.util.List;

public interface IPokemonServicePort { //expone los servicios del pokemon

    void savePokemon(Pokemon pokemon);

    List<Pokemon> getAllPokemon();

    Pokemon getPokemon(Long pokemonNumber);

    void updatePokemon(Pokemon pokemon);

    void deletePokemon(Long pokemonNumber);

}
