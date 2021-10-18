package com.dbc;

import java.util.ArrayList;

public class Pokemon implements Impressao {
    private Integer numero;
    private String nome;
    private Integer level;
    private Status status;
    private Double altura;
    private Double peso;
    private String categoria;
    private ArrayList<Tipo> tipos;
    private ArrayList<Habilidade> habilidades;
    private Evolucao evolucao;

    public Pokemon() {

    }

    public Pokemon(Integer numero, String nome, Integer level, Status status, Double altura, Double peso,
                   String categoria, ArrayList<Tipo> tipos,
                   ArrayList<Habilidade> habilidades) {
        this.numero = numero;
        this.nome = nome;
        this.level = level;
        this.status = status;
        this.altura = altura;
        this.peso = peso;
        this.categoria = categoria;
        this.tipos = tipos;
        this.habilidades = habilidades;
        this.evolucao = null;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public ArrayList<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<Tipo> tipos) {
        this.tipos = tipos;
    }

    public ArrayList<Habilidade> getHabilidades() {
        return habilidades;
    }

    public Evolucao getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(Evolucao evolucao) {
        this.evolucao = evolucao;
    }

    public void setHabilidades(ArrayList<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

//    public void imprimirPokemon() {
//        System.out.println("\n##############################\n");
//        System.out.println(this);
//        System.out.println("\nTIPOS");
//        for (Tipo key : this.tipos) {
//            System.out.println(key);
//        }
//        System.out.println("\nHABILIDADES");
//        for (Habilidade key : this.habilidades) {
//            System.out.println(key.getNome());
//        }
//        if(this.evolucao != null) {
//            System.out.println("\nEVOLUÇOES");
//            this.evolucao.imprimir();
//        }
//    }

    @Override
    public String toString() {
        return  "Numero: " + this.numero +
                "\n\nNome: " + this.nome +
                "\nLevel: " + this.level +
                "\nAltura: " + this.altura +
                "\nPeso: " + this.peso +
                "\nCategoria: " + this.categoria +
                "\n\nStatus: " + this.status;
    }

    @Override
    public void imprimir() {
        System.out.println("\n##############################\n");
        System.out.println(this);
        System.out.println("\nTIPOS");
        for (Tipo key : this.tipos) {
            System.out.println(key);
        }
        System.out.println("\nHABILIDADES");
        for (Habilidade key : this.habilidades) {
            System.out.println(key.getNome());
        }
        if(this.evolucao != null) {
            System.out.println("\nEVOLUÇOES");
            this.evolucao.imprimir();
        }
    }

    public Boolean ehLendario(){
        if(this.getStatus().calculaTotal() > 500){
            return true;
        }
        return false;
    }
}
