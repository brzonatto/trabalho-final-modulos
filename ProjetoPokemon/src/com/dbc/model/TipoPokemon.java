package com.dbc.model;

public class TipoPokemon {
    private Integer idTipoPokemon;
    private Tipo tipo;
    private Pokemon pokemon;

    public Integer getIdTipoPokemon() {
        return idTipoPokemon;
    }

    public void setIdTipoPokemon(Integer idTipoPokemon) {
        this.idTipoPokemon = idTipoPokemon;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public String toString() {
        return "TipoPokemon{" +
                "idTipoPokemon=" + idTipoPokemon +
                ", tipo=" + tipo +
                ", pokemon=" + pokemon +
                '}';
    }
}
