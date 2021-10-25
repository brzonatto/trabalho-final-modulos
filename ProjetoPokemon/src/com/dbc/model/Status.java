package com.dbc.model;

public class Status {
    private Integer hp;
    private Integer ataque;
    private Integer defesa;
    private Integer especialAtaque;
    private Integer especialDefesa;
    private Integer velocidade;

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

    @Override
    public String toString() {
        return "HP: " + this.hp + " | Ataque: " + this.ataque + " | Defesa: " + this.defesa
                + "\nAtaque Especial: " + this.especialAtaque + " | Defesa Especial: " + this.especialDefesa
                + " | Velocidade: " + this.velocidade;
    }
}
