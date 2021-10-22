package com.dbc.old;

public class Habilidade {
    private String nome;
    private Double multiplicacaoDePoder;

    public Habilidade(String nome, Double multiplicacaoDePoder) {
        this.nome = nome;
        this.multiplicacaoDePoder = multiplicacaoDePoder;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Habilidade: " + this.nome;
    }
}
