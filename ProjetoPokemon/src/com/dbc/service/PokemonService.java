package com.dbc.service;
import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Pokemon;
import com.dbc.model.Status;
import com.dbc.repository.PokemonRepository;

import java.util.List;

public class PokemonService {
    private PokemonRepository pokemonRepository;

    public PokemonService() {
        pokemonRepository = new PokemonRepository();
    }


    // Criação do Pokémon
    public void adicionarPokemon(Pokemon pokemon) {
        try {
            Pokemon pokemonAdicionado = pokemonRepository.adicionar(pokemon);
            System.out.println("Pokémon adicinado com sucesso! " + pokemonAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // Remoção de Pokémon

    public void remover(Integer id) {
        try {
            boolean conseguiuRemover = pokemonRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // Atualização de um Pokémon
    public void editar(Integer id, Pokemon pokemon) {
        try {
            boolean conseguiuEditar = pokemonRepository.editar(id, pokemon);
            System.out.println("editado? " + conseguiuEditar + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // leitura
    public void listar() {
        try {
            List<Pokemon> listar = pokemonRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public Integer somaStatus(Pokemon pokemon) {
        Status status = pokemon.getStatus();
        Integer soma = status.getHp() + status.getAtaque() + status.getDefesa() + status.getEspecialAtaque()
                + status.getEspecialDefesa() + status.getVelocidade();
        return soma;
    }
}




