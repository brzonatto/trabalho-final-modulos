package com.dbc;

public class Main {
    public static void main(String[] args) {
        ComputadorCarvalho pcCarvalho = new ComputadorCarvalho();
        pcCarvalho.addPokeTEst();
//        pcCarvalho.menu();


        pcCarvalho.addEvolucao(pcCarvalho.pegarPokemonPorNumero(1), pcCarvalho.pegarPokemonPorNumero(2), pcCarvalho.pegarPokemonPorNumero(3));
        System.out.println(pcCarvalho.getEvolucoes().get(0));
    }
}
