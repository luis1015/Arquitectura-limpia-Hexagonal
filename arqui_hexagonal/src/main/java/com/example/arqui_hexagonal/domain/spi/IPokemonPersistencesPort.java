package com.example.arqui_hexagonal.domain.spi;

import com.example.arqui_hexagonal.domain.model.Pokemon;

import java.util.List;

public interface IPokemonPersistencesPort {

    void savePokemon(Pokemon pokemon);

    List<Pokemon> getAllPokemon();

    Pokemon getPokemon(Long PokemonId);

    void updatePokemon(Pokemon Pokemon);

    void deletePokemon(Long PokemonNumber);
}
