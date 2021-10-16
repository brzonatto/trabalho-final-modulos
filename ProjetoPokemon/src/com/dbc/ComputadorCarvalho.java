package com.dbc;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ComputadorCarvalho {
    private ArrayList<Pokemon> pokemons;
    private ArrayList<Tipo> tipos;
    private ArrayList<Habilidade> habilidades;
    Scanner scan = new Scanner((System.in));

    public ComputadorCarvalho() {
        this.pokemons = new ArrayList<>();
        this.tipos = new ArrayList<>();
        this.habilidades = new ArrayList<>();
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public ArrayList<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<Tipo> tipos) {
        this.tipos = tipos;
    }

    public ArrayList<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidade> habilidades) {
        this.habilidades = habilidades;
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
                String tipo = "";
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
                //addPokemon();
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
                           Double altura, Double peso, String categoria, ArrayList<Tipo> tipos, ArrayList<Habilidade> habilidades) {
        this.pokemons.add(new Pokemon(numero, nome, level, status, altura, peso,
                categoria, tipos, habilidades));
    }

    public void addPokeTEst() {
        Integer numero = 1;
        String nome = "Bulbasauro";
        Integer level = 1;
        Status status = new Status(10, 10, 10, 10, 10, 10);
        Double altura = 0.9;
        Double peso = 5.0;
        String categoria = "Semente";
        ArrayList<Tipo> tipos = new ArrayList<>();
        tipos.add(Tipo.PLANTA);
        tipos.add(Tipo.VENENOSO);
        ArrayList<Habilidade> habilidades = new ArrayList<>();
        habilidades.add(new Habilidade("Crescer", 2.0));

        this.pokemons.add(new Pokemon(numero, nome, level, status, altura, peso, categoria, tipos, habilidades));

        numero = 125;
        nome = "Bulbasauro";
        level = 1;
        status = new Status(10, 10, 10, 10, 10, 10);
        altura = 0.9;
        peso = 5.0;
        categoria = "Semente";
        ArrayList<Tipo> tipos2 = new ArrayList<>();
        tipos2.add(Tipo.PLANTA);
        tipos2.add(Tipo.VENENOSO);
        ArrayList<Habilidade> habilidades2 = new ArrayList<>();
        habilidades2.add(new Habilidade("Crescer", 2.0));

        this.pokemons.add(new Pokemon(numero, nome, level, status, altura, peso, categoria, tipos2, habilidades2));
    }

    public void printPokemons() {
        for (Pokemon key : pokemons) {
            key.imprimirPokemon();
        }
    }

    public void menu() {
        opcoes();
        System.out.print("Digite a opção: ");
        String opcao = scan.next();
        while (!opcao.equalsIgnoreCase("s")) {
            switch (opcao) {
                case "1":
                    scan.useLocale(Locale.US);
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
                    String tipo = "";
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

                    addPokemon(numero, nome, level, status, altura, peso, categoria, tipos, habilidades);
                    break;
                case "2":
                    printPokemons();
                    break;
                case "3":
                    System.out.print("Digite o número do Pokemon a ser removido!");
                    numero = scan.nextInt();
                    removePokemon(numero);
                    break;
                case "4":
                    editarPokemon();
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
        System.out.println("(S/N)- Sair/Continuar\n");
    }

}
