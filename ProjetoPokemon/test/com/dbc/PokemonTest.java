package com.dbc;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class PokemonTest {
    @Test
    public void deveTestarSePokemonEhLendarioComSucesso(){
        PokemonLendario pokemonLendario = new PokemonLendario();
        pokemonLendario.setNumero(10);
        pokemonLendario.setNome("Mew");
        pokemonLendario.setLevel(100);
        pokemonLendario.setStatus(new Status());
        pokemonLendario.getStatus().setHp(100);
        pokemonLendario.getStatus().setAtaque(100);
        pokemonLendario.getStatus().setDefesa(100);
        pokemonLendario.getStatus().setEspecialAtaque(100);
        pokemonLendario.getStatus().setVelocidade(100);
        pokemonLendario.getStatus().setEspecialDefesa(100);
        pokemonLendario.setAltura(10.0);
        pokemonLendario.setPeso(10.0);
        pokemonLendario.setCategoria("Bichinho");
        ArrayList<Tipo> tipoArrayList;
        tipoArrayList = new ArrayList<Tipo>();
        tipoArrayList.add(Tipo.AGUA);
        pokemonLendario.setTipos(tipoArrayList);
        ArrayList<Habilidade> habilidadeArrayList;
        habilidadeArrayList = new ArrayList<Habilidade>();
        habilidadeArrayList.add(new Habilidade("Chute", 10.0));
        pokemonLendario.setHabilidades(habilidadeArrayList);

        Boolean resultadoTeste = pokemonLendario.ehLendario();

        assertTrue(resultadoTeste);
    }
}
