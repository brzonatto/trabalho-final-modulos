package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Habilidade;
import com.dbc.repository.HabilidadeRepository;

import java.util.List;

public class HabilidadeService {
    private HabilidadeRepository habilidadeRepository;

    public HabilidadeService() {
        habilidadeRepository = new HabilidadeRepository();
    }

    // criação de um objeto
    public void adicionarHabilidade(Habilidade habilidade) {
        try {
            Habilidade habilidadeAdicionada = habilidadeRepository.adicionar(habilidade);
            System.out.println("Habilidade adicinada com sucesso! " + habilidadeAdicionada);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // remoção
    public void removerHabilidade(Integer id) {
        try {
            boolean conseguiuRemover = habilidadeRepository.remover(id);
            System.out.println("Habilidade removida? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // atualização de um objeto
    public void editarHabilidade(Integer id, Habilidade habilidade) {
        try {
            boolean conseguiuEditar = habilidadeRepository.editar(id, habilidade);
            System.out.println("Habilidade editada? " + conseguiuEditar + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // leitura
    public void listarHabilidades() {
        try {
            List<Habilidade> listar = habilidadeRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void adicionarHabilidadeAoPokemon(Integer idHab, Integer idPoke) {
        try {
            habilidadeRepository.adicionarHabilidadeAoPokemon(idHab, idPoke);
            System.out.println("Habilidade ao pokemon adicinada com sucesso! ");
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void removerHabilidadeDoPokemon(Integer id) {
        try {
            boolean conseguiuRemover = habilidadeRepository.removerHabilidadeDoPokemon(id);
            System.out.println("Habilidade removida? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void removerPokemonDaHabilidade(Integer id) {
        try {
            boolean conseguiuRemover = habilidadeRepository.removerPokemonDaHabilidade(id);
            System.out.println("Habilidade removida? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}
