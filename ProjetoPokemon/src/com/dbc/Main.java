package com.dbc;

public class Main {
    public static void main(String[] args) {
        ComputadorCarvalho pcCarvalho = new ComputadorCarvalho();

        pcCarvalho.addPokemons();
//        pcCarvalho.addPokemons();
        System.out.println("###################");
        pcCarvalho.printPokemons();

    }
}
