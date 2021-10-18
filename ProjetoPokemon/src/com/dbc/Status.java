package com.dbc;

public class Status {
    private Integer hp;
    private Integer ataque;
    private Integer defesa;
    private Integer especialAtaque;
    private Integer especialDefesa;
    private Integer velocidade;

    public Status() {

    }

    public Status(Integer hp, Integer ataque, Integer defesa, Integer especialAtaque, Integer especialDefesa, Integer velocidade) {
        this.hp = hp;
        this.ataque = ataque;
        this.defesa = defesa;
        this.especialAtaque = especialAtaque;
        this.especialDefesa = especialDefesa;
        this.velocidade = velocidade;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public Integer getEspecialAtaque() {
        return especialAtaque;
    }

    public void setEspecialAtaque(Integer especialAtaque) {
        this.especialAtaque = especialAtaque;
    }

    public Integer getEspecialDefesa() {
        return especialDefesa;
    }

    public void setEspecialDefesa(Integer especialDefesa) {
        this.especialDefesa = especialDefesa;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }

    public Integer calculaTotal(){
        return this.hp + this.ataque + this.defesa + this.especialAtaque + this.especialDefesa + this.velocidade;
    }

    public Double calculaMedia(){
        return calculaTotal().doubleValue() / 6;
    }

    @Override
    public String toString() {
        return  "\nHP: " + this.hp +
                "\nAtaque: " + this.ataque +
                "\nDefesa: " + this.defesa +
                "\nAtaque Especial: " + this.especialAtaque +
                "\nDefesa Especial: " + this.especialDefesa +
                "\nVelocidade: " + this.velocidade;
    }
}
