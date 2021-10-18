package com.dbc;

import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;


public class StatusTest {

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

}
