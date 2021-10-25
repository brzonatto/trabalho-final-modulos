package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Pokemon;
import com.dbc.model.Tipo;
import com.dbc.model.TipoPokemon;
import com.dbc.repository.TipoPokemonRepository;

import java.util.ArrayList;
import java.util.List;

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

    public void listarTiposDoPokemon(Integer idPoke) {
        try {
            tipoPokemonRepository.listarTiposDoPokemon(idPoke).forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void removerTipoDoPokemon(Integer id) {
        try {
            boolean conseguiuRemover = tipoPokemonRepository.removerTipoDoPokemon(id);
            System.out.println("tipo removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void filtrarPokemonPorTipo(String tipoPesquisado){
        Tipo []todosOsTipos = Tipo.values();
        boolean resposta = false;

        try{
            for(int i = 0; i < todosOsTipos.length; i++) {
                if (tipoPesquisado.equals(todosOsTipos[i].getNome())) {
                    resposta = true;
                    int verificacao = tipoPokemonRepository.filtrarPokemonPorTipo(tipoPesquisado).size();
                    if (verificacao == 0) {
                        System.out.println("Não há pokémon registrados com este tipo.");
                    } else {
                        tipoPokemonRepository.filtrarPokemonPorTipo(tipoPesquisado).forEach(System.out::println);
                    }
                    break;
                }
            }if(!resposta){
                System.out.println("Tipo Inexistente");
            }
        }catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }
}
