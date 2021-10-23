package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Pokemon;
import com.dbc.model.TipoPokemon;
import com.dbc.repository.TipoPokemonRepository;

public class TipoPokemonService {
    private TipoPokemonRepository tipoPokemonRepository;

    public TipoPokemonService() {
        this.tipoPokemonRepository = new TipoPokemonRepository();
    }

    public void adicionarTipoPokemon(TipoPokemon tipoPokemon) {
        try {
            TipoPokemon tipoPokemonAdicionado = tipoPokemonRepository.adicionar(tipoPokemon);
            System.out.println("Tipo Pokémon adicinado com sucesso! " + tipoPokemonAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void remover(Integer id) {
        try {
            boolean conseguiuRemover = tipoPokemonRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void editar(Integer id, TipoPokemon tipoPokemon) {
        try {
            boolean conseguiuEditar = tipoPokemonRepository.editar(id, tipoPokemon);
            System.out.println("editado? " + conseguiuEditar + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            tipoPokemonRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}
