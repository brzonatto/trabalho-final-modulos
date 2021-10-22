package com.dbc.model;

public class Habilidade {
    private Integer idHabilidade;
    private String nome;
    private Double multiplicacaoDePoder;

    public Integer getIdHabilidade() {
        return idHabilidade;
    }

    public void setIdHabilidade(Integer idHabilidade) {
        this.idHabilidade = idHabilidade;
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
        return "Habilidade{" +
                "nome='" + nome + '\'' +
                ", multiplicacaoDePoder=" + multiplicacaoDePoder +
                '}';
    }
}
