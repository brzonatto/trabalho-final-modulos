package com.dbc;

import java.util.ArrayList;

public class ComputadorCarvalho {
    private ArrayList<Pokemon> pokemons;
    private ArrayList<Tipo> tipos;
    private ArrayList<Habilidade> habilidades;

    public ComputadorCarvalho() {

    }

    public ComputadorCarvalho(ArrayList<Pokemon> pokemons, ArrayList<Tipo> tipos, ArrayList<Habilidade> habilidades) {
        this.pokemons = pokemons;
        this.tipos = tipos;
        this.habilidades = habilidades;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public ArrayList<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<Tipo> tipos) {
        this.tipos = tipos;
    }

    public ArrayList<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }
}
