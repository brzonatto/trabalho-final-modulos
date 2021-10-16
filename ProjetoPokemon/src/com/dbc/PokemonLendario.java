package com.dbc;

import java.util.ArrayList;

public class PokemonLendario extends Pokemon {
    private String regiaoDominante;

    public PokemonLendario(String nome, Integer numero, Double altura, Double peso, String categoria,
                           Sexo sexo, ArrayList<Tipo> tipos, Integer level, ArrayList<Habilidade> habilidades,
                           Status status, Evolucao evolucao, String regiaoDominante) {
        super(nome, numero, altura, peso, categoria, sexo, tipos, level, habilidades, status, evolucao);
        this.regiaoDominante = regiaoDominante;
    }

    public String getRegiaoDominante() {
        return regiaoDominante;
    }

    public void setRegiaoDominante(String regiaoDominante) {
        this.regiaoDominante = regiaoDominante;
    }
}
