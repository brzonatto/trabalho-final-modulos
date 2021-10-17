package com.dbc;

import java.util.ArrayList;

public interface Catalogar {

    Boolean registro(Pokemon poke);

    Boolean alterarRegistro(Pokemon errado, Pokemon certo);

    ArrayList<Pokemon> listarRegistros();

    Boolean deletarRegistro(Pokemon poke);
}
