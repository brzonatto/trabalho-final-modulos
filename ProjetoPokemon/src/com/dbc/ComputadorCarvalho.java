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

    public void addPokemons() {
        scan.useLocale(Locale.US);
        System.out.println("Adicionar Pokemon");
        Integer numero = 1;
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

        this.pokemons.add(new Pokemon(numero++, nome, level, status, altura, peso, categoria, tipos, habilidades));
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
    }

    public void printPokemons() {
        for (Pokemon key : pokemons) {
            key.imprimirPokemon();
        }
    }
}
