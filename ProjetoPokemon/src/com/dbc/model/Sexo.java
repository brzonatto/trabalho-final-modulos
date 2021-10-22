package com.dbc.model;

public enum Sexo {
    MACHO("Macho"),
    FEMEA("Fêmea"),
    DESCONHECIDO("Desconhecido");

    private String nome;

    Sexo(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
