package com.dbc;

import java.util.ArrayList;

public class Pokemon {
    private String nome;
    private Integer numero;
    private Double altura;
    private Double peso;
    private String categoria;
    private Integer sexo;
    private ArrayList<Tipo> tipos;
    private Integer level;
    private ArrayList<Habilidade> habilidades;
    private Status status;
    private Evolucao evolucao;

    public Pokemon(){

    }

    public Pokemon(String nome, Integer numero, Double altura, Double peso, String categoria, Integer sexo, ArrayList<Tipo> tipos, Integer level, ArrayList<Habilidade> habilidades, Status status, Evolucao evolucao) {
        this.nome = nome;
        this.numero = numero;
        this.altura = altura;
        this.peso = peso;
        this.categoria = categoria;
        this.sexo = sexo;
        this.tipos = tipos;
        this.level = level;
        this.habilidades = habilidades;
        this.status = status;
        this.evolucao = evolucao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public ArrayList<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<Tipo> tipos) {
        this.tipos = tipos;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public ArrayList<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Evolucao getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(Evolucao evolucao) {
        this.evolucao = evolucao;
    }
}
