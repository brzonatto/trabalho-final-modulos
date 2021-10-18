package com.dbc;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;


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

    @Test
    public void deveTestarSePokemonEhLendarioComSucesso(){         // Teste relacionado com a classe Pokémon
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
