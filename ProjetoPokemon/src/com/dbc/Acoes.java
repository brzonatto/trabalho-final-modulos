package com.dbc;

public interface Acoes {
    void cadastrar(Pokemon poke);
    void listarPokemon();
    void alterarCadastro(Pokemon errado, Pokemon certo);
    void deletarCadastro(Pokemon errado);
}
