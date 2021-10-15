package com.dbc;

import java.util.ArrayList;

public class Pokedex {
    ArrayList <Pokemon> listaPokemon;
    ArrayList <Tipo> listaTipos;
    ArrayList <Habilidade> listaHabilidades;

    public Pokedex(ArrayList<Pokemon> listaPokemon, ArrayList<Tipo> listaTipos, ArrayList<Habilidade> listaHabilidades) {
        this.listaPokemon = listaPokemon;
        this.listaTipos = listaTipos;
        this.listaHabilidades = listaHabilidades;
    }

    public ArrayList<Pokemon> getListaPokemon() {
        return listaPokemon;
    }

    public void setListaPokemon(ArrayList<Pokemon> listaPokemon) {
        this.listaPokemon = listaPokemon;
    }

    public ArrayList<Tipo> getListaTipos() {
        return listaTipos;
    }

    public void setListaTipos(ArrayList<Tipo> listaTipos) {
        this.listaTipos = listaTipos;
    }

    public ArrayList<Habilidade> getListaHabilidades() {
        return listaHabilidades;
    }

    public void setListaHabilidades(ArrayList<Habilidade> listaHabilidades) {
        this.listaHabilidades = listaHabilidades;
    }

    public void adicionaPokemon(Pokemon novoPokemon){
        listaPokemon.add(novoPokemon);
    }

    public void retiraPokemon(Pokemon pokemonRetirado){
        Integer guardaIndice = -1;
        for(int i = 0; i < listaPokemon.size();i++){
            if (listaPokemon.get(i).equals(pokemonRetirado)){
                guardaIndice = i;
            }
        }
        if(guardaIndice == -1){
            System.out.println("Pokémon não encontrado");
        }else{
            listaPokemon.remove(pokemonRetirado);
        }
    }

    public void adicionaTipo(Tipo novoTipo){
        listaTipos.add(novoTipo);
    }

    public void retiraTipo(Tipo tipoRetirado){
        Integer guardaIndice = -1;
        for(int i = 0; i < listaPokemon.size();i++){
            if (listaPokemon.get(i).equals(tipoRetirado)){
                guardaIndice = i;
            }
        }
        if(guardaIndice == -1){
            System.out.println("Tipo não encontrado");
        }else{
            listaPokemon.remove(tipoRetirado);
        }
    }

    public void adicionaHabilidade(Habilidade novaHabilidade) {
        listaHabilidades.add(novaHabilidade);
    }

    public void retiraHabilidade(Habilidade habildiadeRetirada) {
        Integer guardaIndice = -1;
        for (int i = 0; i < listaPokemon.size(); i++) {
            if (listaPokemon.get(i).equals(habildiadeRetirada)) {
                guardaIndice = i;
            }
        }
        if (guardaIndice == -1) {
            System.out.println("Tipo não encontrado");
        } else {
            listaPokemon.remove(habildiadeRetirada);
        }
    }
}
