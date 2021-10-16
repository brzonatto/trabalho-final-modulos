package com.dbc;

import java.util.ArrayList;
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
        System.out.println("Adicionar Pokemon");
        Integer numero = 1;
        System.out.println("Digite o nome: ");
        String nome = scan.nextLine();
        System.out.println("Digite o level: ");
        Integer level = scan.nextInt();
        System.out.println("Digite os status: ");
        Status status = addStatus();
        System.out.println("Digite a altura: ");
        Double altura = scan.nextDouble();
        System.out.println("Digite o peso: ");
        Double peso = scan.nextDouble();
        System.out.println("Digite a categoria: ");
        String categoria = scan.nextLine();
        ArrayList<Tipo> tipos = null;
        String tipo = "";
        do {
            System.out.println("Digite os tipos (digite parar para encerrar a adição de tipos): ");
            tipo = scan.nextLine();
            tipos.add(Tipo.valueOf(tipo));
        } while (tipo.equalsIgnoreCase("parar"));
        ArrayList<Habilidade> habilidades = null;
        System.out.println("Digite as Habilidades: ");
        String sair;
        do {
            System.out.print("Digite o nome: ");
            nome = scan.nextLine();
            System.out.print("Digite o multiplicador de poder: ");
            Double multiplicadorDePoder = scan.nextDouble();
            Habilidade habilidade = new Habilidade(nome, multiplicadorDePoder);
            habilidades.add(habilidade);
            System.out.println("Deseja parar de digitar habilidades? (S/N): ");
            sair = scan.nextLine();
        } while (sair.equalsIgnoreCase("parar"));

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
}
