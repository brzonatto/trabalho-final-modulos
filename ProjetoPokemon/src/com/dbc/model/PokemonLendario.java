package com.dbc.model;

public class PokemonLendario extends Pokemon {
    private String regiaoDominante;

    public String getRegiaoDominante() {
        return regiaoDominante;
    }

    public void setRegiaoDominante(String regiaoDominante) {
        this.regiaoDominante = regiaoDominante;
    }

    @Override
    public String toString() {
        return "PokemonLendario{" +
                "regiaoDominante='" + regiaoDominante + '\'' +
                '}';
    }
}
