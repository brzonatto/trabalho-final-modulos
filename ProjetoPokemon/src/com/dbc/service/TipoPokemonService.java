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
}
