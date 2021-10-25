package com.dbc.model;


public class Evolucao {
    private Integer idEvolucao;
    private Pokemon estagioUm; // sem evolução
    private Pokemon estagioDois; // com 1 evolução
    private Pokemon estagioTres; // com 2 evoluções

    public Integer getIdEvolucao() {
        return idEvolucao;
    }

    public void setIdEvolucao(Integer idEvolucao) {
        this.idEvolucao = idEvolucao;
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

    public String imprimir() {
        if (this.estagioTres != null) {
            return "Lv: " + this.estagioUm.getLevel() + " - " + this.estagioUm.getNome()
                    + " >>> Lv: " + this.estagioDois.getLevel() + " - " + this.estagioDois.getNome()
                    + " >>> Lv: " + this.estagioTres.getLevel() + " - " + this.estagioTres.getNome();
        }
        return "Lv: " + this.estagioUm.getLevel() + " - " + this.estagioUm.getNome()
                + "\nLv: " + this.estagioDois.getLevel() + " - " + this.estagioDois.getNome();
    }

    public void imprimirID() {
        if (this.estagioTres != null) {
            System.out.println( "ID: " + this.idEvolucao + " | Lv: " + this.estagioUm.getLevel() + " - " + this.estagioUm.getNome()
                    + " >>> Lv: " + this.estagioDois.getLevel() + " - " + this.estagioDois.getNome()
                    + " >>> Lv: " + this.estagioTres.getLevel() + " - " + this.estagioTres.getNome());
        } else {
            System.out.println( "Lv: " + this.estagioUm.getLevel() + " - " + this.estagioUm.getNome()
                    + "\nLv: " + this.estagioDois.getLevel() + " - " + this.estagioDois.getNome());
        }
    }

    @Override
    public String toString() {
        return imprimir();
    }
}
