package com.dbc;

import java.util.ArrayList;

public class PokemonLendario extends Pokemon {
    private String regiaoDominante;

    public PokemonLendario(Integer numero, String nome, Integer level, Status status, Double altura, Double peso,
                           String categoria, ArrayList<Tipo> tipos, ArrayList<Habilidade> habilidades,
                           String regiaoDominante) {
        super(numero, nome, level, status, altura, peso, categoria, tipos, habilidades);
        this.regiaoDominante = regiaoDominante;
    }

    public String getRegiaoDominante() {
        return regiaoDominante;
    }

    public void setRegiaoDominante(String regiaoDominante) {
        this.regiaoDominante = regiaoDominante;
    }
}
