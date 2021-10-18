package com.dbc;

import java.util.ArrayList;

public class PokemonLendario extends Pokemon implements Impressao {
    private String regiaoDominante;

    public PokemonLendario(){

    }

    public PokemonLendario(Integer numero, String nome, Integer level, Status status, Double altura, Double peso,
                           String categoria, ArrayList<Tipo> tipos, ArrayList<Habilidade> habilidades,
                           String regiaoDominante) {
        super(numero, nome, level, status, altura, peso, categoria, tipos, habilidades);
        this.regiaoDominante = regiaoDominante;
    }

    public String getRegiaoDominante() {
        return regiaoDominante;
    }

    public void setRegiaoDominante(String regiaoDominante) {
        this.regiaoDominante = regiaoDominante;
    }

    public Integer multiplicadorDeStatus(){
         Integer hp = super.getStatus().getHp() * 2;
         Integer ataque = super.getStatus().getAtaque() * 2;
         Integer defesa = super.getStatus().getDefesa() * 2;
         Integer especialAtaque = super.getStatus().getEspecialAtaque() *2;
         Integer especialDefesa = super.getStatus().getEspecialDefesa()*2;
         Integer velocidade = super.getStatus().getVelocidade()*2;
         Status status = new Status(hp, ataque, defesa, especialAtaque, especialDefesa, velocidade);
         return status.calculaTotal();
    }

    @Override
    public void imprimir(){
        System.out.println("\n##############################\n");
        System.out.println(this);
        System.out.println("\nTIPOS");
        for (Tipo key : this.getTipos()) {
            System.out.println(key);
        }
        System.out.println("\nHABILIDADES");
        for (Habilidade key : super.getHabilidades()) {
            System.out.println(key.getNome());
        }
        System.out.println();
        System.out.println("ESTE POKÉMON É LENDÁRIO WOOOOOW!");
    }
}
