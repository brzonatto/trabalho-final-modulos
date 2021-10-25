package com.dbc.model;

import java.util.Arrays;

public enum Tipo {

    NORMAL("NORMAL", "", "PEDRA,FANTASMA,AÇO", "FANTASMA", "LUTADOR"),
    LUTADOR("LUTADOR", "NORMAL,PEDRA,AÇO,GELO,ESCURIDÃO", "VOADOR,VENENOSO,PSÍQUICO,INSETO,FANTASMA,FADA", "PEDRA,INSETO,ESCURIDÃO", "VOADOR,PSÍQUICO,FADA"),
    VOADOR("VOADOR", "LUTADOR,INSETO,PLANTA", "PEDRA,AÇO,ELÉTRICO", "LUTADOR,TERRA,INSETO,PLANTA", "PEDRA,ELÉTRICO,GELO"),
    VENENOSO("VENENOSO", "PLANTA,FADA", "VENENOSO,TERRA,PEDRA,FANTASMA,AÇO", "LUTADOR,VENENOSO,PLANTA,FADA", "TERRA,PSÍQUICO"),
    TERRA("TERRA", "VENENOSO,PEDRA,AÇO,FOGO,ELÉTRICO", "VOADOR,INSETO,PLANTA", "VENENOSO,PEDRA,ELÉTRICO", "ÁGUA,PLANTA,GELO"),
    PEDRA("PEDRA", "VOADOR,INSETO,FOGO,GELO", "LUTADOR,TERRA,AÇO", "NORMAL,VOADOR,VENENOSO,FOGO", "LUTADOR,TERRA,AÇO,ÁGUA,PLANTA"),
    INSETO("INSETO", "PLANTA,PSÍQUICO,ESCURIDÃO", "LUTADOR,VOADOR,VENENOSO,FANTASMA,AÇO,FOGO,FADA", "LUTADOR,TERRA,PLANTA", "VOADOR,PEDRA,FOGO"),
    FANTASMA("FANTASMA", "FANTASMA,PSÍQUICO", "NORMAL,ESCURIDÃO", "NORMAL,LUTADOR,VENENOSO,INSETO", "FANTASMA,ESCURIDÃO"),
    ACO("AÇO", "PEDRA,GELO,FADA", "AÇO,FOGO,ÁGUA,ELÉTRICO", "NORMAL,VOADOR,VENENOSO,PEDRA,INSETO,AÇO,PLANTA,PSÍQUICO,GELO,DRAGÃO,FADA", "LUTADOR,TERRA,FOGO"),
    FOGO("FOGO", "INSETO,AÇO,PLANTA,GELO", "PEDRA,FOGO,ÁGUA,DRAGÃO", "INSETO,AÇO,FOGO,PLANTA,GELO", "TERRA,PEDRA,ÁGUA"),
    AGUA("ÁGUA", "TERRA,PEDRA,FOGO", "ÁGUA,PLANTA,DRAGÃO", "AÇO,FOGO,ÁGUA,GELO", "PLANTA,ELÉTRICO"),
    PLANTA("PLANTA", "TERRA,PEDRA,ÁGUA", "VOADOR,VENENOSO,INSETO,AÇO,FOGO,PLANTA,DRAGÃO", "TERRA,ÁGUA,PLANTA,ELÉTRICO", "VOADOR,VENENOSO,INSETO,FOGO,GELO"),
    ELETRICO("ELÉTRICO", "VOADOR,ÁGUA", "TERRA,PLANTA,ELÉTRICO,DRAGÃO", "VOADOR,AÇO,ELÉTRICO", "TERRA"),
    PSIQUICO("PSÍQUICO", "LUTADOR,VENENOSO", "AÇO,PSÍQUICO,ESCURIDÃO", "LUTADOR,PSÍQUICO", "INSETO,FANTASMA,ESCURIDÃO"),
    GELO("GELO", "VOADOR,TERRA,PLANTA,DRAGÃO", "AÇO,FOGO,ÁGUA,GELO", "GELO", "LUTADOR,PEDRA,AÇO,FOGO"),
    DRAGAO("DRAGÃO", "DRAGÃO", "AÇO,FADA", "FOGO,ÁGUA,PLANTA,ELÉTRICO", "GELO,DRAGÃO,FADA"),
    FADA("FADA", "LUTADOR,DRAGÃO,ESCURIDÃO", "VENENOSO,AÇO,FOGO", "LUTADOR,INSETO,DRAGÃO,ESCURIDÃO", "VENENOSO,AÇO"),
    ESCURIDAO("ESCURIDÃO", "FANTASMA,PSÍQUICO", "LUTADOR,ESCURIDÃO,FADA", "FANTASMA,PSÍQUICO,ESCURIDÃO", "LUTADOR,INSETO,FADA");


    private String nome;
    private String forteContra;
    private String fracoContra;
    private String resistenteA;
    private String vulneravelA;

    Tipo(String nome, String forteContra, String fracoContra, String resistenteA, String vulneravelA) {
        this.nome = nome;
        this.forteContra = forteContra;
        this.fracoContra = fracoContra;
        this.resistenteA = resistenteA;
        this.vulneravelA = vulneravelA;
    }

    public String getNome() {
        return nome;
    }

    public String getForteContra() {
        return forteContra;
    }

    public String getFracoContra() {
        return fracoContra;
    }

    public String getResistenteA() {
        return resistenteA;
    }

    public String getVulneravelA() {
        return vulneravelA;
    }

    public static Tipo ofTipo(String tipo) {
        return Arrays.stream(Tipo.values())
                .filter(tp -> tp.getNome().equalsIgnoreCase(tipo))
                .findFirst()
                .get();
    }

    @Override
    public String toString() {
        return  this.nome +
                "\nForte contra:" + this.forteContra +
                "\nFraco contra:" + this.fracoContra +
                "\nResistente a:" + this.resistenteA +
                "\nVulneravel a:" + this.vulneravelA;
    }
}
