package com.dbc;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class MainLeo {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        Status statusTeste = new Status(1, 1, 1, 1, 1, 1);  //Criando Bulbinha
        ArrayList<Tipo> tipos = new ArrayList<>();
        tipos.add(Tipo.PLANTA);
        tipos.add(Tipo.VENENOSO);
        ArrayList<Habilidade> habilidades = new ArrayList<>();
        habilidades.add(new Habilidade("Crescer", 2.0));
        Pokemon pokemonTeste = new Pokemon(1, "Bulbassaur", 15, statusTeste, 0.7, 6.9,
                "sapo", tipos, habilidades);


        ArrayList<Tipo> tipos2 = new ArrayList<>();                              // Criando Lapras
        tipos2.add(Tipo.AGUA);
        tipos2.add(Tipo.GELO);
        ArrayList<Habilidade> habilidades2 = new ArrayList<>();
        habilidades2.add(new Habilidade("Absrover Água", 2.0));
        Pokemon pokemonTeste2 = new Pokemon(131, "Lapras", 30, statusTeste, 2.5, 220.0,
                "transporte", tipos2, habilidades2);


        ArrayList<Tipo> tipos3 = new ArrayList<>();                              // Criando Rhydon
        tipos3.add(Tipo.TERRA);
        tipos3.add(Tipo.PEDRA);
        ArrayList<Habilidade> habilidades3 = new ArrayList<>();
        habilidades3.add(new Habilidade("Cabeça de rocha", 2.0));
        Pokemon pokemonTeste3 = new Pokemon(131, "Rhydon", 30, statusTeste, 1.9, 120.0,
                "broca", tipos3, habilidades3);



        ArrayList<Pokemon> listaTeste = new ArrayList<>();
        listaTeste.add(pokemonTeste);

/**
 * Pokedex pokedexTeste = new Pokedex(listaTeste);
 *
 *         pokedexTeste.addPokemon(pokemonTeste2);       // Add pokémon a pokédex
 *         pokedexTeste.addPokemon(pokemonTeste3);
 *
 *         pokedexTeste.imprimeTodosPokemon();           // Imprimindo os pokémon
 *
 *         Stream<Pokemon> listaAtualizada = pokedexTeste.getGrupoPokemon().stream();  // Transformei a lista em stream para testes
 *
 *         Stream<Pokemon> pokemonDeAgua = listaAtualizada.filter(pokemon -> pokemon.getTipos().get(0).equals(Tipo.AGUA) ||
 *                 pokemon.getTipos().get(1).equals(Tipo.AGUA));
 *
 *         pokemonDeAgua.forEach(System.out::println);
 *
 *        pokedexTeste.filtrarPorTipo(Tipo.AGUA);
 *        pokedexTeste.filtrarPorTipo(Tipo.PLANTA);
 *
 */
//        System.out.println("Digite o tipo a ser pesquisado");
//        String tipoDigitado = leia.nextLine();
    }
}
