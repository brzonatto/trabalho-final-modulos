package com.dbc;

import java.util.ArrayList;

public class Pokedex {
    ArrayList<Pokemon> Pokemons;
    ArrayList<Tipo> Tipos;
    ArrayList<Habilidade> Habilidades;

    public Pokedex() {

    }

    public Pokedex(ArrayList<Pokemon> pokemons, ArrayList<Tipo> tipos, ArrayList<Habilidade> habilidades) {
        Pokemons = pokemons;
        Tipos = tipos;
        Habilidades = habilidades;
    }

    public ArrayList<Pokemon> getPokemons() {
        return Pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        Pokemons = pokemons;
    }

    public ArrayList<Tipo> getTipos() {
        return Tipos;
    }

    public void setTipos(ArrayList<Tipo> tipos) {
        Tipos = tipos;
    }

    public ArrayList<Habilidade> getHabilidades() {
        return Habilidades;
    }

    public void setHabilidades(ArrayList<Habilidade> habilidades) {
        Habilidades = habilidades;
    }

     public void addPokemon(Pokemon pokemon) {

     }

     public void removePokemon(Pokemon pokemon) {

     }

    public void addTipo(Tipo tipo) {

    }

    public void removeTipo(Tipo tipo) {

    }

    public void addHabilidade(Habilidade habilidade) {

    }

    public void removeHabilidade(Habilidade habilidade) {

    }
}



