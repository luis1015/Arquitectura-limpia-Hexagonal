package com.example.arqui_hexagonal.domain.usecase;

import com.example.arqui_hexagonal.domain.api.IPokemonServicePort;
import com.example.arqui_hexagonal.domain.model.Pokemon;
import com.example.arqui_hexagonal.domain.spi.IPokemonPersistencesPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PokemonUseCase implements IPokemonServicePort {

    private final IPokemonPersistencesPort pokemonPersistencesPort;

    public PokemonUseCase(IPokemonPersistencesPort pokemonPersistencesPort) {
        this.pokemonPersistencesPort = pokemonPersistencesPort;
    }

    //Reglas de negocio
    @Override
    public void savePokemon(Pokemon pokemon) {
        pokemonPersistencesPort.savePokemon(pokemon);

    }

    @Override
    public List<Pokemon> getAllPokemon() {
        return pokemonPersistencesPort.getAllPokemon();
    }

    @Override
    public Pokemon getPokemon(Long pokemonNumber) {
        return pokemonPersistencesPort.getPokemon(pokemonNumber);
    }

    @Override
    public void updatePokemon(Pokemon pokemon) {
        pokemonPersistencesPort.updatePokemon(pokemon);
    }

    @Override
    public void deletePokemon(Long pokemonNumber) {
        pokemonPersistencesPort.deletePokemon(pokemonNumber);
    }
}
