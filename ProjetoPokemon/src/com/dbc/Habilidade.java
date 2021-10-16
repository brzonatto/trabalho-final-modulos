package com.dbc;

public class Habilidade {
    private String nome;
    private Double multiplicacaoDePoder;

    public Habilidade() {

    }

    public Habilidade(String nome, Double multiplicacaoDePoder) {
        this.nome = nome;
        this.multiplicacaoDePoder = multiplicacaoDePoder;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Habilidade: " + this.nome + "\nMultiplicacao de poder: " + this.multiplicacaoDePoder;
    }
}
