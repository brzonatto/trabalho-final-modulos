package com.dbc;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class PokemonLendarioTest {
    @Test
    public void deveTestarMultiplicadorDeStatusPokemonLendario() {
        //SETUP CENARIO
        PokemonLendario pokemonLendario = new PokemonLendario();
        pokemonLendario.setNumero(10);
        pokemonLendario.setNome("BABAOVO");
        pokemonLendario.setLevel(100);
        pokemonLendario.setStatus(new Status());
        pokemonLendario.getStatus().setHp(10);
        pokemonLendario.getStatus().setAtaque(10);
        pokemonLendario.getStatus().setDefesa(10);
        pokemonLendario.getStatus().setEspecialAtaque(10);
        pokemonLendario.getStatus().setVelocidade(10);
        pokemonLendario.getStatus().setEspecialDefesa(10);
        pokemonLendario.setAltura(10.0);
        pokemonLendario.setPeso(10.0);
        pokemonLendario.setCategoria("CAT5");
        ArrayList<Tipo> tipoArrayList;
        tipoArrayList = new ArrayList<Tipo>();
        tipoArrayList.add(Tipo.AGUA);
        pokemonLendario.setTipos(tipoArrayList);
        ArrayList<Habilidade> habilidadeArrayList;
        habilidadeArrayList = new ArrayList<Habilidade>();
        habilidadeArrayList.add(new Habilidade("Chute", 10.0));
        pokemonLendario.setHabilidades(habilidadeArrayList);
        //ACT ACIONE
        Integer totalStatus = pokemonLendario.multiplicadorDeStatus();
        //ASSERT
        assertEquals(120, totalStatus, 0);


    }
}
