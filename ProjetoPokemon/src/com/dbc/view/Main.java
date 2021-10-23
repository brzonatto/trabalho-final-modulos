package com.dbc.view;

import com.dbc.model.Habilidade;
import com.dbc.model.Pokemon;
import com.dbc.model.Status;
import com.dbc.model.TipoPokemon;
import com.dbc.service.HabilidadeService;
import com.dbc.service.PokemonService;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner((System.in));
        scan.useLocale(Locale.US);

        PokemonService pokemonService = new PokemonService();
        HabilidadeService habilidadeService = new HabilidadeService();

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
                    System.out.print("Digite o id do Pokemon a ser exluido: ");
                    pokemonService.remover(scan.nextInt());
                    break;
                case "4":
                    System.out.println("EDITAR POKEMON");
                    System.out.print("Digite o id do pokemon a ser editado: ");
                    Integer numero = scan.nextInt();
                    System.out.println("O que você deseja editar? ");
                    System.out.println("Opções:");
                    System.out.println("0 - Número");
                    System.out.println("1 - Nome");
                    System.out.println("2 - Level");
                    System.out.println("3 - Status");
                    System.out.println("4 - Altura");
                    System.out.println("5 - Peso");
                    System.out.println("6 - Categoria");
                    System.out.println("7 - Tipos");
                    System.out.println("8 - Habilidades");
                    System.out.println("9 - TODOS");
                    System.out.print("Digite a opção: ");
                    opcao = scan.next();

                    Pokemon pokemonEditado = new Pokemon();
                    switch (opcao) {
                        case "0":
                            System.out.print("Digite o novo número: ");
                            pokemonEditado.setNumero(scan.nextInt());
                            break;
                        case "1":
                            System.out.print("Digite o novo nome: ");
                            pokemonEditado.setNome(scan.next());
                            break;
                        case "2":
                            System.out.print("Digite o novo level: ");
                            pokemonEditado.setLevel(scan.nextInt());
                            break;
                        case "3":
                            Status status1 = new Status();

                            System.out.print("Digite o novo grupo de status.\n");
                            System.out.print("Digite o HP: ");
                            status1.setHp(scan.nextInt());
                            System.out.print("Digite o ataque: ");
                            status1.setAtaque(scan.nextInt());
                            System.out.print("Digite a defesa: ");
                            status1.setDefesa(scan.nextInt());
                            System.out.print("Digite o ataque especial: ");
                            status1.setEspecialAtaque(scan.nextInt());
                            System.out.print("Digite o defesa especial: ");
                            status1.setEspecialDefesa(scan.nextInt());
                            System.out.print("Digite a velocidade: ");
                            status1.setVelocidade(scan.nextInt());
                            pokemonEditado.setStatus(status1);
                            break;
                        case "4":
                            System.out.print("Digite a nova altura: ");
                            pokemonEditado.setAltura(scan.nextDouble());
                            break;
                        case "5":
                            System.out.print("Digite o novo peso: ");
                            pokemonEditado.setPeso(scan.nextDouble());
                            break;
                        case "6":
                            System.out.print("Digite a nova categoria: ");
                            pokemonEditado.setCategoria(scan.next());
                            break;
                        case "7":

                        case "8":

                            break;
                        case "9":
                            System.out.println("EDITAR TUDO");

                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                    pokemonService.editar(numero, pokemonEditado);
                    break;
                case "5":
                    System.out.println("INSERIR EVOLUÇÃO"); //TODO
                    break;
                case "6":
                    System.out.println("INSERIR HABILIDADE"); // TODO
                    Habilidade habilidade = new Habilidade();

                    break;
                case "7":
                    System.out.println("INSERIR TIPO POKEMON"); // TODO



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
        System.out.println("  7  - Adicionar Tipo Pokemon");
        System.out.println("  S  - Sair/Continuar\n");
    }

    public static void editarPokemon() {

    }
}
