package com.dbc.view;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.*;
import com.dbc.service.HabilidadeService;
import com.dbc.service.PokemonService;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Carvalho {
    static Scanner scan = new Scanner((System.in));

    PokemonService pokemonService = new PokemonService();
    HabilidadeService habilidadeService = new HabilidadeService();

    public void menu() throws BancoDeDadosException {
        scan.useLocale(Locale.US);
        opcoes();
        System.out.print("Digite a opção: ");
        String opcao = scan.next();
        while (!opcao.equalsIgnoreCase("s")) {
            switch (opcao) {
                case "1":
                    System.out.println("INSERIR POKÉMON");
                    Pokemon pokemon = new Pokemon();
                    System.out.print("Digite o número: ");
                    pokemon.setNumero(scan.nextInt());
                    System.out.print("Digite o nome: ");
                    pokemon.setNome(scan.next());
                    System.out.print("Digite o level: ");
                    pokemon.setLevel(scan.nextInt());
                    System.out.print("Digite o peso: ");
                    pokemon.setPeso(scan.nextDouble());
                    System.out.print("Digite a altura: ");
                    pokemon.setAltura(scan.nextDouble());
                    System.out.print("Digite a categoria: ");
                    pokemon.setCategoria(scan.next());
                    Status status = new Status();
                    System.out.print("Digite o HP: ");
                    status.setHp(scan.nextInt());
                    System.out.print("Digite o ataque: ");
                    status.setAtaque(scan.nextInt());
                    System.out.print("Digite a defesa: ");
                    status.setDefesa(scan.nextInt());
                    System.out.print("Digite o ataque especial: ");
                    status.setEspecialAtaque(scan.nextInt());
                    System.out.print("Digite a defesa especial: ");
                    status.setEspecialDefesa(scan.nextInt());
                    System.out.print("Digite a velocidade: ");
                    status.setVelocidade(scan.nextInt());
                    pokemon.setStatus(status);
                    if (pokemonService.somaStatus(pokemon) > 580) {
                        System.out.print("Devido ao seu número de status alto, este pokemon é lendário!\n");
                        System.out.print("Digite a Região Dominante: ");
                        pokemon.setRegiaoDominante(scan.next());
                    } else {
                        pokemon.setRegiaoDominante(null);
                    }


                    pokemonService.adicionarPokemon(pokemon);
                    break;
                case "2":
                    System.out.println("LISTAR POKEMONS");
                    pokemonService.listar();
                    break;
                case "3":
                    System.out.println("REMOVER POKEMON");
                    System.out.println();
                    break;
                case "4":
                    System.out.println("EDITAR POKEMON");
                    break;
                case "5":
                    System.out.println("INSERIR EVOLUÇÃO");
                    break;
                case "6":
                    System.out.println("INSERIR HABILIDADE");
                    Habilidade habilidade = new Habilidade();

                    break;
                case "7":
                    System.out.println("INSERIR TIPO POKEMON");
                    System.out.println("Digite o numero do Pokemon que você quer adicionar o tipo: ");
                    Pokemon pokemon2 = new Pokemon();
                    pokemon2 = pokemonService.pegarPokemonPorNumero(scan.nextInt());
                    TipoPokemon tipoPokemon = new TipoPokemon();
                    System.out.println("Digite o nome do tipo: ");


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

    public void opcoes() {
        System.out.println("Opções: ");
        System.out.println("  1  - Adicionar Pokemon");
        System.out.println("  2  - Mostrar todos Pokemons cadastrados");
        System.out.println("  3  - Remover Pokemon");
        System.out.println("  4  - Editar Pokemon");
        System.out.println("  5  - Adicionar Evolução");
        System.out.println("  6  - Adicionar Habilidade");
        System.out.println("  7  - Adicionar Tipo Pokemon");
        System.out.println("  S  - Sair/Continuar\n");
    }
}
