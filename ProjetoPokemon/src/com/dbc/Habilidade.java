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

    public Double getMultiplicacaoDePoder() {
        return multiplicacaoDePoder;
    }

    public void setMultiplicacaoDePoder(Double multiplicacaoDePoder) {
        this.multiplicacaoDePoder = multiplicacaoDePoder;
    }

    @Override
    public String toString() {
        return "Habilidade: " + this.nome;
    }
}
