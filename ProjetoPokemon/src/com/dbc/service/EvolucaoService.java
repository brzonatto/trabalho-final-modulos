package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Evolucao;
import com.dbc.repository.EvolucaoRepository;

public class EvolucaoService {
    private EvolucaoRepository evolucaoRepository;

    public EvolucaoService() {
        this.evolucaoRepository = new EvolucaoRepository();
    }

    public Evolucao adicionarEvolucao(Evolucao evolucao) {
        Evolucao evolucaoAdicionada = null;
        try {
            evolucaoAdicionada = evolucaoRepository.adicionar(evolucao);
            System.out.println("Evolucao adicinada com sucesso! " + evolucaoAdicionada);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
        return evolucaoAdicionada;
    }

    public void removerEvolucao(Integer id) {
        try {
            boolean conseguiuRemover = evolucaoRepository.remover(id);
            System.out.println("Evolucao removida? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}
