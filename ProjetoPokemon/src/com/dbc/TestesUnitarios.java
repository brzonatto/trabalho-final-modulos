package com.dbc;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

public class TestesUnitarios {

    @Test
    public void deveTestarTotalStatusComSucesso() {
        Status statusTeste = new Status(20, 10, 30, 40, 10, 10);
        Integer totalEsperado = statusTeste.calculaTotal();
        assertEquals(120.0, totalEsperado, 0);
    }

    @Test
    public void deveTestarTotalStatusSemSucesso() {
        Status statusTeste = new Status(20, 10, 30, 40, 10, 10);
        Integer totalEsperado = statusTeste.calculaTotal();
        assertNotEquals(160.0, totalEsperado, 0);
    }

    @Test
    public void deveTestarMediaStatusComSucesso() {
        Status statusTeste = new Status(20, 10, 30, 40, 10, 10);
        Double mediaEsperada = statusTeste.calculaMedia();
        assertEquals(20.0, mediaEsperada, 0);
    }

    @Test
    public void deveTestarMediaStatusSemSucesso() {
        Status statusTeste = new Status(20, 10, 30, 40, 10, 10);
        Double mediaEsperada = statusTeste.calculaMedia();
        assertNotEquals(25.0, mediaEsperada, 0);
    }

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
