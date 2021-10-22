package com.dbc.view;

import java.util.Locale;
import java.util.Scanner;

public class Carvalho {
    static Scanner scan = new Scanner((System.in));


    public static void menu() {
        scan.useLocale(Locale.US);
        opcoes();
        System.out.print("Digite a opção: ");
        String opcao = scan.next();
        while (!opcao.equalsIgnoreCase("s")) {
            switch (opcao) {
                case "1":
                    System.out.println("INSERIR POKEMON");
                    break;
                case "2":
                    System.out.println("LISTAR POKEMONS");
                    break;
                case "3":
                    System.out.println("REMOVER POKEMON");
                    break;
                case "4":
                    System.out.println("EDITAR POKEMON");
                    break;
                case "5":
                    System.out.println("INSERIR EVOLUÇÃO");
                    break;
                case "6":
                    System.out.println("INSERIR HABILIDADE");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println("");
            opcoes();
            System.out.print("Digite a opção: ");
            opcao = scan.next();
        }
    }

    public static void opcoes() {
        System.out.println("Opções: ");
        System.out.println("  1  - Adicionar Pokemon");
        System.out.println("  2  - Mostrar todos Pokemons cadastrados");
        System.out.println("  3  - Remover Pokemon");
        System.out.println("  4  - Editar Pokemon");
        System.out.println("  5  - Adicionar Evolução");
        System.out.println("  6  - Adicionar Habilidade");
        System.out.println("(S/N)- Sair/Continuar\n");
    }
}
