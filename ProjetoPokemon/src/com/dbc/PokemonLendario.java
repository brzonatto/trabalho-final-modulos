package com.dbc;

import java.util.ArrayList;

public class PokemonLendario extends Pokemon implements Impressao {
    private String regiaoDominante;
    private Sexo sexo;

    public PokemonLendario(Integer numero, String nome, Integer level, Status status, Double altura, Double peso,
                           String categoria, ArrayList<Tipo> tipos, ArrayList<Habilidade> habilidades,
                           String regiaoDominante, Sexo sexo) {
        super(numero, nome, level, status, altura, peso, categoria, tipos, habilidades);
        this.regiaoDominante = regiaoDominante;
        this.sexo = sexo;
    }

    public String getRegiaoDominante() {
        return regiaoDominante;
    }

    public void setRegiaoDominante(String regiaoDominante) {
        this.regiaoDominante = regiaoDominante;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public void imprimir(){

    }
}
