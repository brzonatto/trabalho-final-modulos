package com.dbc.view;

import com.dbc.model.*;
import com.dbc.service.HabilidadeService;
import com.dbc.service.PokemonService;
import com.dbc.service.TipoPokemonService;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner((System.in));
        scan.useLocale(Locale.US);

        PokemonService pokemonService = new PokemonService();
        HabilidadeService habilidadeService = new HabilidadeService();
        TipoPokemonService tipoPokemonService = new TipoPokemonService();

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

                    ArrayList<TipoPokemon> tiposPokemon = new ArrayList<>();
                    String sair;

                    do {
                        TipoPokemon tPokemon = new TipoPokemon();
                        System.out.print("Digite o tipo do Pokemon: ");
                        tPokemon.setTipo(Tipo.ofTipo(scan.next().toUpperCase()));
                        tPokemon.setPokemon(pokemon);
                        tiposPokemon.add(tPokemon);
                        System.out.print("Deseja digitar mais tipos? (S/N): ");
                        sair = scan.next();
                    } while (sair.equalsIgnoreCase("s"));

                    pokemon.setTiposPokemon(tiposPokemon);
                    pokemonService.adicionarPokemon(pokemon);

                    for ( TipoPokemon key : tiposPokemon) {
                        tipoPokemonService.adicionarTipoPokemon(key);
                    }

                    break;
                case "2":
                    System.out.println("LISTAR POKEMONS");
                    pokemonService.listar();
                    break;
                case "3":
                    System.out.println("REMOVER POKEMON");
                    System.out.print("Digite o id do Pokémon a ser excluído: ");
                    Integer id = scan.nextInt();
                    habilidadeService.removerPokemonDaHabildiade(id);
                    tipoPokemonService.remover(id);
                    pokemonService.remover(id);
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
                    System.out.println("INSERIR EVOLUÇÃO");// TODO
                    break;
                case "6":
                    System.out.println("MENU HABILIDADES");
                    System.out.println("Opções: ");
                    System.out.println("  1  - Adicionar Habilidade");
                    System.out.println("  2  - Editar Habilidade");
                    System.out.println("  3  - Remover Habilidade");
                    System.out.println("  4  - Listar Habilidades");
                    System.out.println("  5  - Adicionar habilidade ao Pokemon");
                    System.out.print("\nDigite a opção: ");
                    opcao = scan.next();
                    switch (opcao) {
                        case "1":
                            System.out.println("ADICIONAR HABILIDADE");
                            Habilidade habilidade = new Habilidade();
                            System.out.print("Digite o nome da habilidade: ");
                            habilidade.setNome(scan.next());
                            System.out.print("Digite o multiplicador de poder: ");
                            habilidade.setMultiplicacaoDePoder(scan.nextDouble());

                            habilidadeService.adicionarHabilidade(habilidade);
                            break;
                        case "2":
                            System.out.println("EDITAR HABILIDADE");
                            System.out.print("Digite o id da habilidade a ser editada: ");
                            Integer id2 = scan.nextInt();
                            Habilidade habilidade1 = new Habilidade();
                            System.out.print("Digite o novo nome da habilidade: ");
                            habilidade1.setNome(scan.next());
                            System.out.print("Digite o novo multiplicador de poder da habilidade: ");
                            habilidade1.setMultiplicacaoDePoder(scan.nextDouble());

                            habilidadeService.editarHabilidade(id2, habilidade1);
                            break;
                        case "3":
                            System.out.println("REMOVER HABILIDADE");
                            System.out.print("Digite o id da habilidade a ser removida: ");
                            Integer id3 = scan.nextInt();

                            habilidadeService.removerHabilidadeDoPokemon(id3);
                            habilidadeService.removerHabilidade(id3);
                            break;
                        case "4":
                            System.out.println("LISTAR HABILIDADE");
                            habilidadeService.listarHabilidades();
                            break;
                        case "5":
                            System.out.println("ADICIONAR HABILIDADE AO POKEMON");
                            System.out.print("Digite o id do Pokemon: ");
                            Integer idPoke = scan.nextInt();
                            System.out.print("Digite o id da Habilidade: ");
                            Integer idHab = scan.nextInt();

                            habilidadeService.adicionarHabilidadeAoPokemon(idHab, idPoke);
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
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
        System.out.println("  6  - Menu de Habilidades");
        System.out.println("  S  - Sair/Continuar\n");
    }
}
