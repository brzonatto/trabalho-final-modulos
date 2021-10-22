package com.dbc.model;

import java.util.ArrayList;

public class Pokemon {
    private Integer idPokemon;
    private Integer numero;
    private String nome;
    private Integer level;
    private Double peso;
    private Double altura;
    private String categoria;
    private Status status;
    private String regiaoDominante;
    private ArrayList<Tipo> tipos;
    private ArrayList<Habilidade> habilidade;
    private Evolucao evolucao;

    public Integer getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(Integer idPokemon) {
        this.idPokemon = idPokemon;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getRegiaoDominante() {
        return regiaoDominante;
    }

    public void setRegiaoDominante(String regiaoDominante) {
        this.regiaoDominante = regiaoDominante;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ArrayList<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<Tipo> tipos) {
        this.tipos = tipos;
    }

    public ArrayList<Habilidade> getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(ArrayList<Habilidade> habilidade) {
        this.habilidade = habilidade;
    }

    public Evolucao getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(Evolucao evolucao) {
        this.evolucao = evolucao;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "idPokemon=" + idPokemon +
                ", numero=" + numero +
                ", nome='" + nome + '\'' +
                ", level=" + level +
                ", peso=" + peso +
                ", altura=" + altura +
                ", categoria='" + categoria + '\'' +
                ", status=" + status +
                ", tipos=" + tipos +
                ", habilidade=" + habilidade +
                ", evolucao=" + evolucao +
                '}';
    }
}
