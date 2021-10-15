package com.dbc;

import java.util.ArrayList;

public class Evolucao {
    private ArrayList<Pokemon> pokemons;

    public Evolucao() {
    }

    public Evolucao(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
