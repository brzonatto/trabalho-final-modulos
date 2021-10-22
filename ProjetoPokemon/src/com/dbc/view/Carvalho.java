package com.dbc.view;

import com.dbc.model.Habilidade;
import com.dbc.model.Pokemon;
import com.dbc.model.Status;
import com.dbc.model.Tipo;
import com.dbc.service.PokemonService;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Carvalho {
    static Scanner scan = new Scanner((System.in));

    PokemonService pokemonService = new PokemonService();

    public void menu() {
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
                        System.out.print("Devido ao seu número de status alto, este pokémon é lendário!\n");
                        System.out.print("Digite a Região Dominante: ");
                        pokemon.setRegiaoDominante(scan.next());
                    } else {
                        pokemon.setRegiaoDominante(null);
                    }

                    ArrayList<Tipo> tipos = new ArrayList<>();
                    String tipo;
                    String sair;
                    do {
                        System.out.print("Digite o tipo: ");
                        tipo = scan.next();
                        tipos.add(Tipo.valueOf(tipo.toUpperCase(Locale.ROOT)));
                        System.out.print("Deseja digitar mais tipos? (S/N): ");
                        sair = scan.next();
                    } while (sair.equalsIgnoreCase("s"));
                    pokemon.setTipos(tipos);

                    ArrayList<Habilidade> habilidades = new ArrayList<>();
                    System.out.println("Digite as Habilidades: ");
                    do {
                        System.out.print("Digite o nome: ");
                        String nomeHabilidade = scan.next();
                        System.out.print("Digite o multiplicador de poder: ");
                        Double multiplicadorDePoder = scan.nextDouble();
                        Habilidade habilidade = new Habilidade(nomeHabilidade, multiplicadorDePoder);
                        habilidades.add(habilidade);
                        System.out.print("Deseja parar de digitar habilidades? (S/N): ");
                        sair = scan.next();
                    } while (!sair.equalsIgnoreCase("s"));


                    contato.setTipoContato(TipoContato.ofTipo(scanner.nextInt()));
                    scanner.nextLine();


                    pokemon.setTipos(null);
                    pokemon.setHabilidade(null);
                    pokemon.setEvolucao(null);

                    pokemonService.adicionarPokemon(pokemon);
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

    public void opcoes() {
        System.out.println("Opções: ");
        System.out.println("  1  - Adicionar Pokemon");
        System.out.println("  2  - Mostrar todos Pokemons cadastrados");
        System.out.println("  3  - Remover Pokemon");
        System.out.println("  4  - Editar Pokemon");
        System.out.println("  5  - Adicionar Evolução");
        System.out.println("  6  - Adicionar Habilidade");
        System.out.println("  S  - Sair/Continuar\n");
    }
}
