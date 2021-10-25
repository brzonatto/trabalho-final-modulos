package com.dbc.view;

import com.dbc.model.*;
import com.dbc.repository.EvolucaoRepository;
import com.dbc.repository.PokemonRepository;
import com.dbc.service.EvolucaoService;
import com.dbc.service.HabilidadeService;
import com.dbc.service.PokemonService;
import com.dbc.service.TipoPokemonService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner((System.in));
        scan.useLocale(Locale.US);

        PokemonService pokemonService = new PokemonService();
        HabilidadeService habilidadeService = new HabilidadeService();
        TipoPokemonService tipoPokemonService = new TipoPokemonService();
        EvolucaoService evolucaoService = new EvolucaoService();
        System.out.println("\nBEM VINDO AO POKE CADASTRO!\n");
        opcoes();
        System.out.print("Digite a opção: ");
        String opcao = scan.next();
        String sair;
        while (!opcao.equalsIgnoreCase("s")) {
            switch (opcao) {
                case "1":
                    System.out.println("\nINSERIR POKÉMON");
                    try {
                        Pokemon pokemon = new Pokemon();
                        System.out.print("Digite o número do Pokémon: ");
                        pokemon.setNumero(scan.nextInt());
                        System.out.print("Digite o nome do Pokémon: ");
                        pokemon.setNome(scan.next());
                        System.out.print("Digite o level do Pokémon: ");
                        pokemon.setLevel(scan.nextInt());
                        System.out.print("Digite o peso do Pokémon: ");
                        pokemon.setPeso(scan.nextDouble());
                        System.out.print("Digite a altura do Pokémon: ");
                        pokemon.setAltura(scan.nextDouble());
                        System.out.print("Digite a categoria do Pokémon: ");
                        pokemon.setCategoria(scan.next());
                        Status status = new Status();
                        System.out.print("Digite o HP do Pokémon: ");
                        status.setHp(scan.nextInt());
                        System.out.print("Digite o ataque do Pokémon: ");
                        status.setAtaque(scan.nextInt());
                        System.out.print("Digite a defesa do Pokémon: ");
                        status.setDefesa(scan.nextInt());
                        System.out.print("Digite o ataque especial do Pokémon: ");
                        status.setEspecialAtaque(scan.nextInt());
                        System.out.print("Digite a defesa especial do Pokémon: ");
                        status.setEspecialDefesa(scan.nextInt());
                        System.out.print("Digite a velocidade do Pokémon: ");
                        status.setVelocidade(scan.nextInt());
                        pokemon.setStatus(status);
                        if (pokemonService.somaStatus(pokemon) >= 580) {
                            System.out.print("Devido ao seu número de status alto, este pokémon é lendário!\n");
                            System.out.print("Então, digite a Região Dominante do Pokémon: ");
                            pokemon.setRegiaoDominante(scan.next());
                        } else {
                            pokemon.setRegiaoDominante(null);
                        }

                        pokemonService.adicionarPokemon(pokemon);

                        int cont1 = 0;
                        do {
                            TipoPokemon tPokemon = new TipoPokemon();
                            System.out.print("Digite o tipo do Pokémon: ");
                            tPokemon.setTipo(Tipo.valueOf(scan.next().toUpperCase()));
                            tPokemon.setPokemon(pokemon);
                            tipoPokemonService.adicionarTipoPokemon(tPokemon);
                            cont1++;
                            System.out.print("Deseja digitar mais tipos? (S/N): ");
                            sair = scan.next();
                        } while (sair.equalsIgnoreCase("s") || cont1 > 2);

                        System.out.print("Deseja adicionar alguma habilidade? (S/N): ");
                        String opcao1 = scan.next();

                        while (opcao1.equalsIgnoreCase("s")) {
                            System.out.println("Opções");
                            System.out.println("  1  - Adicionar habilidades já existentes");
                            System.out.println("  2  - Adicionar nova habilidade");
                            System.out.println("  S  - Sair\n");
                            System.out.print("Digite a opção: ");
                            opcao1 = scan.next();
                            switch (opcao1) {
                                case "1":
                                    do {
                                        System.out.println("\nLista de habilidades existentes\n");
                                        habilidadeService.listarHabilidades();
                                        System.out.print("\nDigite o id da Habilidade: ");
                                        Integer idHab = scan.nextInt();
                                        habilidadeService.adicionarHabilidadeAoPokemon(idHab, pokemon.getIdPokemon());
                                        System.out.print("Deseja adicionar mais habilidades existentes? (S/N): ");
                                        sair = scan.next();
                                    } while (sair.equalsIgnoreCase("s"));
                                    break;
                                case "2":
                                    do {
                                        Habilidade habilidade3 = new Habilidade();
                                        System.out.print("Digite o nome da habilidade: ");
                                        habilidade3.setNome(scan.next());
                                        System.out.print("\nDigite o multiplicador de poder da habilidade: ");
                                        habilidade3.setMultiplicacaoDePoder(scan.nextDouble());

                                        habilidadeService.adicionarHabilidade(habilidade3);
                                        habilidadeService.adicionarHabilidadeAoPokemon(habilidade3.getIdHabilidade(), pokemon.getIdPokemon());
                                        System.out.print("Deseja adicionar outra nova habilidade? (S/N): ");
                                        sair = scan.next();
                                    } while (sair.equalsIgnoreCase("s"));
                                    break;
                                default:
                                    System.out.println("\nOpção inválida!");
                            }
                            System.out.println("Deseja continuar adicionando habilidades? (S/N): ");
                            opcao1 = scan.next();
                        }
                        System.out.println("\nPokemon adicionado com sucesso!");
                    }catch (InputMismatchException e){
                        System.out.println("Deve digitar apenas números nos dados númericos");
                    }finally {
                        System.out.print("\nDigite a opção: ");
                        opcao = scan.next();
                    }
                    break;
                case "2":
                    System.out.println("\nLISTAR POKEMONS");
                    System.out.println("Opções de filtro: ");
                    System.out.println("0 - Mostrar todos");
                    System.out.println("1 - Mostrar Pokémon por tipo");
                    System.out.println("2 - Mostrar Pokémon lendários");
                    System.out.println("3 - Mostrar toda Pokédex com detalhes");

                    System.out.print("\nDigite a opção: ");
                    opcao = scan.next();
                    switch (opcao) {
                        case "0":
                            System.out.print("\nMostrar todos\n\n");
                            pokemonService.listarNumeroNome();
                            break;
                        case "1":
                            System.out.print("Digite qual tipo quer listar: ");
                            tipoPokemonService.filtrarPokemonPorTipo(scan.next().toUpperCase());
                            break;
                        case "2":
                            pokemonService.listarLendarios();
                            break;
                        case "3":
                            System.out.println("\n###################################################\n");
//                            pokemonService.listarNumeroNomeDetalhado();
                            pokemonService.listarDetalhesEvo();
                            break;
                        default:
                            System.out.println("Opção Inválida");
                            break;
                    }
                    break;
                case "3":
                    System.out.println("REMOVER POKEMON");
                    System.out.print("Digite o id do pokémon a ser excluído: ");
                    try {
                        Integer id = scan.nextInt();
                        habilidadeService.removerPokemonDaHabilidade(id);
                        tipoPokemonService.remover(id);
                        pokemonService.remover(id);
                    }catch (InputMismatchException e){
                        System.out.println("Opção Inválida");
                    }
                    break;
                case "4":
                    System.out.println("EDITAR POKEMON");
                    System.out.print("Digite o id do pokémon a ser editado: ");
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
                    System.out.print("Digite a opção: ");
                    opcao = scan.next();

                    Habilidade hab = null;
                    TipoPokemon tPokemon = null;
                    Pokemon pokemonEditado = new Pokemon();
                    pokemonEditado.setIdPokemon(numero);
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

                            if (pokemonService.somaStatus(pokemonEditado) >= 580) {
                                System.out.print("Devido ao seu número de status alto, este pokemon é lendário!\n");
                                System.out.print("Então, digite a Região Dominante do Pokémon: ");
                                pokemonEditado.setRegiaoDominante(scan.next());
                            } else {
                                pokemonEditado.setRegiaoDominante(null);
                            }
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
                            tipoPokemonService.removerTipoDoPokemon(numero);
                            int cont2 = 0;               // Contador adicionado para não colocar mais tipos
                            do {
                                tPokemon = new TipoPokemon();
                                System.out.print("Digite o novo tipo do pokémon: ");
                                tPokemon.setTipo(Tipo.valueOf(scan.next().toUpperCase()));
                                tPokemon.setPokemon(pokemonEditado);
                                tipoPokemonService.adicionarTipoPokemon(tPokemon);
                                cont2++;
                                System.out.print("Deseja digitar mais tipos? (S/N): ");
                                sair = scan.next();
                            } while (sair.equalsIgnoreCase("s") || cont2 > 2);
                        case "8":
                            hab = new Habilidade();
                            habilidadeService.removerPokemonDaHabilidade(numero);
                            String opcao2 = "s";
                            while (opcao2.equalsIgnoreCase("s")) {
                                System.out.println("Opções");
                                System.out.println("  1  - Adicionar habilidades já existentes");
                                System.out.println("  2  - Adicionar nova habilidade");
                                System.out.println("  S  - Sair\n");
                                System.out.print("Digite a opção: ");
                                opcao2 = scan.next();
                                switch (opcao2) {
                                    case "1":
                                        do {
                                            System.out.println("\nLista de habilidades\n");
                                            habilidadeService.listarHabilidades();
                                            System.out.print("Digite o id da Habilidade: ");
                                            Integer idHab = scan.nextInt();
                                            habilidadeService.adicionarHabilidadeAoPokemon(idHab, numero);
                                            System.out.print("Deseja aplicar mais habilidades? (S/N): ");
                                            sair = scan.next();
                                        } while (sair.equalsIgnoreCase("s"));
                                        break;
                                    case "2":
                                        do {
                                            Habilidade habilidade4 = new Habilidade();
                                            System.out.print("Digite o nome da habilidade: ");
                                            habilidade4.setNome(scan.next());
                                            System.out.print("Digite o multiplicador de poder: ");
                                            habilidade4.setMultiplicacaoDePoder(scan.nextDouble());

                                            habilidadeService.adicionarHabilidade(habilidade4);
                                            habilidadeService.adicionarHabilidadeAoPokemon(habilidade4.getIdHabilidade(), numero);
                                            System.out.print("Deseja adicionar e aplicar uma nova habilidades? (S/N): ");
                                            sair = scan.next();
                                        } while (sair.equalsIgnoreCase("s"));
                                        break;
                                    default:
                                        System.out.println("Opção inválida!");
                                }
                                System.out.println("Deseja continuar adicionando habildiades? (S/N): ");
                                opcao2 = scan.next();
                            }
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                    if (tPokemon == null && hab == null) {
                        pokemonService.editar(numero, pokemonEditado);
                    }
                    break;
                case "5":
                    System.out.println("\nMenu Evolução\n");
                    System.out.println("Opções: ");
                    System.out.println("  1  - Adicionar evolução");
                    System.out.println("  2  - Remover evolução");
                    System.out.println("  3  - Listar evoluções");
                    System.out.print("\nDigite a opção: ");
                    String op = scan.next();
                    switch (op) {
                        case "1":
                            System.out.println("\nINSERIR EVOLUÇÃO\n");
                            Evolucao evolucao = new Evolucao();
                            pokemonService.listarIDNome();
                            System.out.print("\nQual id do Pokemon estágio 1: ");
                            Pokemon stage1 = pokemonService.pegarPokemonPorId(scan.nextInt());
                            System.out.print("Qual id do Pokemon estágio 2: ");
                            Pokemon stage2 = pokemonService.pegarPokemonPorId(scan.nextInt());
                            System.out.print("Qual id do Pokemon estágio 3: ");
                            Pokemon stage3 = pokemonService.pegarPokemonPorId(scan.nextInt());

                            evolucao.setEstagioUm(stage1);
                            evolucao.setEstagioDois(stage2);
                            evolucao.setEstagioTres(stage3);

                            Evolucao evolucaoAdicionada = evolucaoService.adicionarEvolucao(evolucao);

                            stage1.setEvolucao(evolucaoAdicionada);
                            stage2.setEvolucao(evolucaoAdicionada);
                            stage3.setEvolucao(evolucaoAdicionada);

                            pokemonService.editar(stage1.getIdPokemon(), stage1);
                            pokemonService.editar(stage2.getIdPokemon(), stage2);
                            pokemonService.editar(stage3.getIdPokemon(), stage3);
                            break;
                        case "2":
                            System.out.println("\nREMOVER EVOLUÇÃO\n");
                            evolucaoService.listarEvolucoesID();
                            System.out.print("\nDigite o id da evolução a ser removida: ");
                            Integer idEv = scan.nextInt();
                            pokemonService.removerEvolucaoPokemon(idEv);
                            evolucaoService.removerEvolucao(idEv);
                            break;
                        case "3":
                            System.out.println("MOSTRAR EVOLUÇÕES");
                            evolucaoService.listarEvolucoes();
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
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
        System.out.println("  2  - Mostrar Pokemons cadastrados");
        System.out.println("  3  - Remover Pokemon");
        System.out.println("  4  - Editar Pokemon");
        System.out.println("  5  - Menu de Evoluções");
        System.out.println("  6  - Menu de Habilidades");
        System.out.println("  S  - Sair\n");
    }
}
