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
    private String regiaoDominante;
    private Status status;
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

    public Evolucao getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(Evolucao evolucao) {
        this.evolucao = evolucao;
    }

    public void imprimirNumeroNome() {
        System.out.println(this.numero + " - " + this.nome);
    }

    public void imprimirIDNome() {
        System.out.println("ID: " + this.idPokemon + " - " + this.nome);
    }

    public void imprimirDadosCompletos() {
        System.out.println("ID: " + this.idPokemon + " | N??mero: " + this.numero + " | "
                + this.nome + " | Level: " + this.level);
        System.out.println("Peso: " + this.peso + " | Altura: " + this.altura + " | Categoria: " + this.categoria);
        System.out.println("\nStatus: ");
        System.out.println(this.status);
        System.out.println("\nEvolu????es: ");
        if (this.evolucao != null) {
            System.out.println(this.evolucao);
        } else {
            System.out.println("Este Pokemon n??o possui evolu????es!");
        }

        System.out.println("\n###################################################\n");
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
                '}';
    }
}
