package com.dbc;

public class Evolucao implements Impressao{
    Pokemon estagioUm;
    Pokemon estagioDois;
    Pokemon estagioTres;

    public Evolucao(Pokemon estagioUm, Pokemon estagioDois, Pokemon estagioTres) {
        this.estagioUm = estagioUm;
        this.estagioDois = estagioDois;
        this.estagioTres = estagioTres;
    }

    public void imprimir() {
        System.out.println("Lv: " + this.estagioUm.getLevel() + " - " + this.estagioUm.getNome());
        System.out.println("Lv: " + this.estagioDois.getLevel() + " - " + this.estagioDois.getNome());
        if (this.estagioTres != null) {
            System.out.println("Lv: " + this.estagioTres.getLevel() + " - " + this.estagioTres.getNome());
        }
    }
}