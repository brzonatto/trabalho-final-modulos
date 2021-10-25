package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Evolucao;
import com.dbc.model.Habilidade;
import com.dbc.repository.EvolucaoRepository;

import java.util.List;

public class EvolucaoService {
    private EvolucaoRepository evolucaoRepository;

    public EvolucaoService() {
        this.evolucaoRepository = new EvolucaoRepository();
    }

    public Evolucao adicionarEvolucao(Evolucao evolucao) {
        Evolucao evolucaoAdicionada = null;
        try {
            evolucaoAdicionada = evolucaoRepository.adicionar(evolucao);
            System.out.println("\nEvolucao adicinada com sucesso!" );
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

    public void listarEvolucoes() {
        try {
            List<Evolucao> listar = evolucaoRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void listarEvolucoesID() {
        try {
            List<Evolucao> listar = evolucaoRepository.listar();
            listar.forEach(Evolucao::imprimirID);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}
