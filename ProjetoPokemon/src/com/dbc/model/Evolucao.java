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

    @Override
    public String toString() {
        return "Evolucao{" +
                "idEvolucao=" + idEvolucao +
                ", estagioUm=" + estagioUm +
                ", estagioDois=" + estagioDois +
                ", estagioTres=" + estagioTres +
                '}';
    }
}
