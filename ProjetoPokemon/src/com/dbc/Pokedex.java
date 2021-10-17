package com.dbc;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Pokedex {
    ArrayList<Pokemon> grupoPokemon;


    public Pokedex(ArrayList<Pokemon> grupoPokemon) {
        this.grupoPokemon= grupoPokemon;
    }

    public void addPokemon(Pokemon pokemonCriado) {
        grupoPokemon.add(pokemonCriado);
    }

    public void removePokemon(Pokemon pokemonRetirado) {
        grupoPokemon.remove(pokemonRetirado);

    }

    public void imprimeTodosPokemon(){
        for (Pokemon pokemon : grupoPokemon) {
            pokemon.imprimirPokemon();
        }
    }

    public ArrayList<Pokemon> getGrupoPokemon() {
        return grupoPokemon;
    }

    public void filtrarPorTipo(Tipo tipoPesquisado){
        Stream<Pokemon> pokemonFiltrados = grupoPokemon.stream().filter(pokemon -> pokemon.getTipos().get(0).
                equals(tipoPesquisado) || pokemon.getTipos().get(1).equals(tipoPesquisado));
        pokemonFiltrados.forEach(System.out::println);
    }
}


