package com.dbc;

import java.util.ArrayList;

public class Tipo {
    private String nome;
    private ArrayList<Tipo> fraquezas;
    private ArrayList<Tipo> efetividades;

    public Tipo() {

    }

    public Tipo(String nome, ArrayList<Tipo> fraquezas, ArrayList<Tipo> efetividades) {
        this.nome = nome;
        this.fraquezas = fraquezas;
        this.efetividades = efetividades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Tipo> getFraquezas() {
        return fraquezas;
    }

    public void setFraquezas(ArrayList<Tipo> fraquezas) {
        this.fraquezas = fraquezas;
    }

    public ArrayList<Tipo> getEfetividades() {
        return efetividades;
    }

    public void setEfetividades(ArrayList<Tipo> efetividades) {
        this.efetividades = efetividades;
    }
}
