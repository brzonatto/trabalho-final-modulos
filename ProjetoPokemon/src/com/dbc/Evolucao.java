package com.dbc;

public class Evolucao {
    Pokemon estagioUm;
    Pokemon estagioDois;
    Pokemon estagioTres;

    public Evolucao(Pokemon estagioUm, Pokemon estagioDois, Pokemon estagioTres) {
        this.estagioUm = estagioUm;
        this.estagioDois = estagioDois;
        this.estagioTres = estagioTres;
    }

    public Pokemon getEstagioUm() {
        return estagioUm;
    }

    public void setEstagioUm(Pokemon estagioUm) {
        this.estagioUm = estagioUm;
    }

    public Pokemon getEstagioDois() {
        return estagioDois;
    }

    public void setEstagioDois(Pokemon estagioDois) {
        this.estagioDois = estagioDois;
    }

    public Pokemon getEstagioTres() {
        return estagioTres;
    }

    public void setEstagioTres(Pokemon estagioTres) {
        this.estagioTres = estagioTres;
    }

    public void imprimir() {
        System.out.println("Lv: " + this.estagioUm.getLevel() + " - " + this.estagioUm.getNome());
        System.out.println("Lv: " + this.estagioDois.getLevel() + " - " + this.estagioDois.getNome());
        if (this.estagioTres != null) {
            System.out.println("Lv: " + this.estagioDois.getLevel() + " - " + this.estagioDois.getNome());
        }
    }

    @Override
    public String toString() {
        return "Lv: " + this.estagioUm.getLevel() + " - " + this.estagioUm.getNome()
                + "\nLv: " + this.estagioDois.getLevel() + " - " + this.estagioDois.getNome()
                + "\nLv: " + this.estagioTres.getLevel() + " - " + this.estagioTres.getNome();
    }
}
