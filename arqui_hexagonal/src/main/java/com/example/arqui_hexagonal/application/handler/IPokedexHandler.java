package com.example.arqui_hexagonal.application.handler;

import com.example.arqui_hexagonal.application.dto.PokedexRequest;
import com.example.arqui_hexagonal.application.dto.PokedexResponse;

import java.util.List;

public interface IPokedexHandler {
    void savePokemonPokedex(PokedexRequest pokedexRequest);
    List<PokedexResponse> getAllPokemonFromPokedex();
    PokedexResponse getPokemonFromPokedex(Long pokemonNumber);
    void updatePokemonInPokedex(PokedexRequest pokedexRequest);
    void deletePokemonFromPokedex(Long pokemonNumber);
}
