package com.dbc;

import com.dbc.model.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ComputadorCarvalho {
    private ArrayList<Pokemon> pokemons;
    private ArrayList<Tipo> tipos;
    private ArrayList<Habilidade> habilidades;
    private ArrayList<Evolucao> evolucoes;
    Scanner scan = new Scanner((System.in));

    public ComputadorCarvalho() {
        this.pokemons = new ArrayList<>();
        this.tipos = new ArrayList<>();
        this.habilidades = new ArrayList<>();
        this.evolucoes = new ArrayList<>();
    }

    public Status addStatus() {
        System.out.print("Digite o HP: ");
        Integer hp = scan.nextInt();
        System.out.print("Digite o ataque: ");
        Integer ataque = scan.nextInt();
        System.out.print("Digite a defesa: ");
        Integer defesa = scan.nextInt();
        System.out.print("Digite o ataque especial: ");
        Integer especialAtaque = scan.nextInt();
        System.out.print("Digite o defesa especial: ");
        Integer especialDefesa = scan.nextInt();
        System.out.print("Digite a velocidade: ");
        Integer velocidade = scan.nextInt();

        return new Status(hp, ataque, defesa, especialAtaque, especialDefesa, velocidade);
    }

    public Pokemon pegarPokemonPorNumero(Integer numero) {
        return pokemons.stream().filter(pokemon -> pokemon.getNumero().equals(numero))
                .findFirst().get();
    }

    public void editarNomePokemon(Integer numero, String nome) {
        Pokemon pokemonMOD = pegarPokemonPorNumero(numero);
        pokemonMOD.setNome(nome);
    }

    public void editarLevelPokemon(Integer numero, Integer level) {
        Pokemon pokemonMOD = pegarPokemonPorNumero(numero);
        pokemonMOD.setLevel(level);
    }

    public void editarStatusPokemon(Integer numero, Status status) {
        Pokemon pokemonMOD = pegarPokemonPorNumero(numero);
        pokemonMOD.setStatus(status);
    }

    public void editarAlturaPokemon(Integer numero, Double altura) {
        Pokemon pokemonMOD = pegarPokemonPorNumero(numero);
        pokemonMOD.setAltura(altura);
    }

    public void editarPesoPokemon(Integer numero, Double peso){
        Pokemon pokemonMOD = pegarPokemonPorNumero(numero);
        pokemonMOD.setPeso(peso);
    }

    public void editarCategoriaPokemon(Integer numero, String categoria) {
        Pokemon pokemonMOD = pegarPokemonPorNumero(numero);
        pokemonMOD.setCategoria(categoria);
    }

    public void editarTiposPokemon(Integer numero, ArrayList<Tipo> tipos) {
        Pokemon pokemonMOD = pegarPokemonPorNumero(numero);
        pokemonMOD.setTipos(tipos);
    }

    public void editarHabilidadesPokemon(Integer numero, ArrayList<Habilidade> habilidades) {
        Pokemon pokemonMOD = pegarPokemonPorNumero(numero);
        pokemonMOD.setHabilidades(habilidades);
    }

    public void addEvolucao(Integer numero, Pokemon um, Pokemon dois, Pokemon tres) {
        Pokemon pokemon = pegarPokemonPorNumero(numero);
        Evolucao evolucao = new Evolucao(um, dois, tres);
        pokemon.setEvolucao(evolucao);
    }

    public void editarPokemon() {
        scan.useLocale(Locale.US);
        System.out.print("Digite o número do pokemon a ser editado: ");
        Integer numero = scan.nextInt();
        System.out.println("O que você deseja editar? ");
        System.out.println("Opções:");
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
        String opcao = scan.next();

        switch (opcao) {
            case "1":
                System.out.print("Digite o novo nome: ");
                editarNomePokemon(numero, scan.next());
                break;
            case "2":
                System.out.print("Digite o novo level: ");
                editarLevelPokemon(numero, scan.nextInt());
                break;
            case "3":
                System.out.print("Digite o novo grupo de status: ");
                editarStatusPokemon(numero, addStatus());
                break;
            case "4":
                System.out.print("Digite a nova altura: ");
                editarAlturaPokemon(numero, scan.nextDouble());
                break;
            case "5":
                System.out.print("Digite o novo peso: ");
                editarPesoPokemon(numero, scan.nextDouble());
                break;
            case "6":
                System.out.print("Digite a nova categoria: ");
                editarCategoriaPokemon(numero, scan.next());
                break;
            case "7":
                ArrayList<Tipo> tipos = new ArrayList<>();
                String tipo;
                String sair;
                do {
                    System.out.print("Digite o tipo: ");
                    tipo = scan.next();
                    tipos.add(Tipo.valueOf(tipo.toUpperCase(Locale.ROOT)));
                    System.out.print("Deseja parar de digitar tipos? (S/N): ");
                    sair = scan.next();
                } while (!sair.equalsIgnoreCase("s"));
                editarTiposPokemon(numero, tipos);
                break;
            case "8":
                ArrayList<Habilidade> habilidades = new ArrayList<>();
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
                editarHabilidadesPokemon(numero, habilidades);
                break;
            case "9":
                removePokemon(numero);
                inseriPokemon();
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    public void removePokemon(Integer numero) {
        pokemons.removeIf(pokemon -> pokemon.getNumero() == numero);
    }

    public void addPokemon(Integer numero, String nome, Integer level, Status status,
                           Double altura, Double peso, String categoria, ArrayList<Tipo> tipos,
                           ArrayList<Habilidade> habilidades) {
        this.pokemons.add(new Pokemon(numero, nome, level, status, altura, peso,
                categoria, tipos, habilidades));
    }

    public void inseriPokemon() {
        System.out.print("Digite o numero: ");
        Integer numero = scan.nextInt();
        System.out.print("Digite o nome: ");
        String nome = scan.next();
        System.out.print("Digite o level: ");
        Integer level = scan.nextInt();
        System.out.println("Digite os status: ");
        Status status = addStatus();
        System.out.print("Digite a altura: ");
        Double altura = scan.nextDouble();
        System.out.print("Digite o peso: ");
        Double peso = scan.nextDouble();
        System.out.print("Digite a categoria: ");
        String categoria = scan.next();
        ArrayList<Tipo> tipos = new ArrayList<>();
        String tipo;
        String sair;

        do {
            System.out.print("Digite o tipo: ");
            tipo = scan.next();
            tipos.add(Tipo.valueOf(tipo.toUpperCase(Locale.ROOT)));
            System.out.print("Deseja parar de digitar tipos? (S/N): ");
            sair = scan.next();
        } while (!sair.equalsIgnoreCase("s"));

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

        if(status.calculaTotal() > 500){
            System.out.print("Este pokémon é lendário, devido seu número de status alto.\nAdicione sua região dominante");
            String regiaoDominante = scan.next();
            this.pokemons.add(new PokemonLendario(numero, nome, level, status, altura, peso, categoria,
                    tipos, habilidades, regiaoDominante));
        }else{
            addPokemon(numero, nome, level, status, altura, peso, categoria, tipos, habilidades);
        }

    }

    public void addPokeTEst() {
        Integer numero = 1;
        String nome = "Bulbassauro";
        Integer level = 1;
        Status status = new Status(3, 3, 3, 4, 4, 3);
        Double altura = 0.7;
        Double peso = 6.9;
        String categoria = "Semente";
        ArrayList<Tipo> tipos = new ArrayList<>();
        tipos.add(Tipo.PLANTA);
        tipos.add(Tipo.VENENOSO);
        ArrayList<Habilidade> habilidades = new ArrayList<>();
        habilidades.add(new Habilidade("Crescer", 2.0));

        this.pokemons.add(new Pokemon(numero, nome, level, status, altura, peso, categoria, tipos, habilidades));

        numero = 2;
        nome = "Ivyssauro";
        level = 12;
        status = new Status(4, 4, 4, 5, 5, 4);
        altura = 1.0;
        peso = 13.0;
        categoria = "Semente";
        ArrayList<Tipo> tipos2 = new ArrayList<>();
        tipos2.add(Tipo.PLANTA);
        tipos2.add(Tipo.VENENOSO);
        ArrayList<Habilidade> habilidades2 = new ArrayList<>();
        habilidades2.add(new Habilidade("Crescer", 2.0));

        this.pokemons.add(new Pokemon(numero, nome, level, status, altura, peso, categoria, tipos2, habilidades2));

        numero = 3;
        nome = "Venussauro";
        level = 26;
        status = new Status(5, 5, 5, 6, 6, 5);
        altura = 2.0;
        peso = 100.0;
        categoria = "Semente";
        ArrayList<Tipo> tipos3 = new ArrayList<>();
        tipos3.add(Tipo.PLANTA);
        tipos3.add(Tipo.VENENOSO);
        ArrayList<Habilidade> habilidades3 = new ArrayList<>();
        habilidades3.add(new Habilidade("Crescer", 2.0));

        this.pokemons.add(new Pokemon(numero, nome, level, status, altura, peso, categoria, tipos3, habilidades3));

        numero = 19;
        nome = "Ratata";
        level = 1;
        status = new Status(2, 4, 3, 2, 3, 5);
        altura = 0.3;
        peso = 3.5;
        categoria = "Rato";
        ArrayList<Tipo> tipos4 = new ArrayList<>();
        tipos4.add(Tipo.NORMAL);
        ArrayList<Habilidade> habilidades4 = new ArrayList<>();
        habilidades4.add(new Habilidade("Mordida", 2.0));
        habilidades4.add(new Habilidade("Aranhão", 2.0));

        this.pokemons.add(new Pokemon(numero, nome, level, status, altura, peso, categoria, tipos4, habilidades4));

        numero = 20;
        nome = "Raticate";
        level = 16;
        status = new Status(5, 5, 5, 6, 6, 5);
        altura = 0.7;
        peso = 18.5;
        categoria = "Rato";
        ArrayList<Tipo> tipos5 = new ArrayList<>();
        tipos5.add(Tipo.NORMAL);
        ArrayList<Habilidade> habilidades5 = new ArrayList<>();
        habilidades5.add(new Habilidade("Mordida", 2.0));
        habilidades5.add(new Habilidade("Aranhão", 2.0));
        habilidades5.add(new Habilidade("Rabada", 2.0));

        this.pokemons.add(new Pokemon(numero, nome, level, status, altura, peso, categoria, tipos5, habilidades5));
    }

    public void printPokemons() {
        this.pokemons.stream().sorted((a, b) -> a.getNumero().compareTo(b.getNumero()))
                .forEach(Pokemon::imprimir);
    }

    public void menu() {
        scan.useLocale(Locale.US);
        opcoes();
        System.out.print("Digite a opção: ");
        String opcao = scan.next();
        while (!opcao.equalsIgnoreCase("s")) {
            switch (opcao) {
                case "1":
                    inseriPokemon();
                    break;
                case "2":
                    if(this.pokemons.size() == 0) {
                        System.out.println("\nNão existem Pokemons cadastrados no momento!");
                    } else {
                        printPokemons();
                    }
                    break;
                case "3":
                    System.out.print("Digite o número do Pokemon a ser removido!");
                    Integer removerNumero = scan.nextInt();
                    removePokemon(removerNumero);
                    break;
                case "4":
                    editarPokemon();
                    break;
                case "5":
                    Pokemon stage2;
                    Pokemon stage3;
                    Integer numero3 = null;
                    System.out.print("Qual o número do Pokemon estagio 1: ");
                    Integer numero1 = scan.nextInt();
                    Pokemon stage1 = pegarPokemonPorNumero(numero1);
                    System.out.print("Qual o número do Pokemon estagio 2: ");
                    Integer numero2 = scan.nextInt();
                    stage2 = pegarPokemonPorNumero(numero2);
                    System.out.print("Deseja adicionar o estagio 3 (S/N): ");
                    if (scan.next().equalsIgnoreCase("s")) {
                        System.out.print("Qual o número do Pokemon estagio 3: ");
                        numero3 = scan.nextInt();
                        stage3 = pegarPokemonPorNumero(numero3);
                    } else {
                        stage3 = null;
                    }
                    addEvolucao(numero1 ,stage1, stage2, stage3);
                    addEvolucao(numero2 ,stage1, stage2, stage3);
                    if (stage3 != null) {
                        addEvolucao(numero3 ,stage1, stage2, stage3);
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

    public void opcoes() {
        System.out.println("Opções: ");
        System.out.println("  1  - Adicionar Pokemon");
        System.out.println("  2  - Mostrar todos Pokemons cadastrados");
        System.out.println("  3  - Remover Pokemon");
        System.out.println("  4  - Editar Pokemon");
        System.out.println("  5  - Adicionar Evolução");
        System.out.println("(S/N)- Sair/Continuar\n");
    }

}
