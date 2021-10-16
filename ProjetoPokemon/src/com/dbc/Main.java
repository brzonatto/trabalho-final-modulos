package com.dbc;

import jdk.swing.interop.SwingInterOpUtils;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ComputadorCarvalho pcCarvalho = new ComputadorCarvalho();
        Scanner scan = new Scanner(System.in);

//        pcCarvalho.addPokemons();
//        pcCarvalho.addPokemons();
        pcCarvalho.addPokeTEst();

//        pcCarvalho.printPokemons();


        opcoes();
        System.out.print("Digite a opção: ");
        String opcao = scan.next();
        while (!opcao.equalsIgnoreCase("s")) {
            switch (opcao) {
                case "1":
//                    System.out.println("add poke");
                    pcCarvalho.addPokemons();
                    break;
                case "2":
//                    System.out.println("mostra pokes");
                    pcCarvalho.printPokemons();
                    break;
                case "3":
//                    System.out.println("remove poke");
                    System.out.print("Digite o número do pokemon a ser removido!");
                    Integer numero = scan.nextInt();
                    pcCarvalho.removePokemon(numero);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            System.out.println("");
            opcoes();
            System.out.println("Para encerrar digite (S/N)");
            System.out.print("Digite a opção: ");
            opcao = scan.next();
        }

    }

    public static void opcoes() {
        System.out.println("Opções: ");
        System.out.println("1 - Adicionar Pokemon");
        System.out.println("2 - Mostrar todos Pokemons cadastrados");
        System.out.println("3 - Remover Pokemon\n");
    }
}
