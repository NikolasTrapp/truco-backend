package com.nikolastrapp.truco.entities;

import com.nikolastrapp.truco.utils.Utils;

public class Carta {

    private String naipe;
    private Integer numero;
    private Integer forca;
    private boolean isManilha = false;
    private Jogador jogador;


    public Carta(String naipe, Integer numero) {
        this.naipe = naipe;
        this.numero = numero;
        this.forca = Utils.forcaCartas.get(getNumero());
    }

    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getForca() {
        if (isManilha()) setForca(Utils.forcaManilhas.get(getNaipe()));
        return forca;
    }

    private void setForca(Integer forca) {
        this.forca = forca;
    }

    public boolean isManilha() {
        return isManilha;
    }

    public void setManilha(boolean manilha) {
        isManilha = manilha;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void restaurarCarta() {
        this.jogador = null;
        this.isManilha = false;
    }

    @Override
    public String toString() {
        return getNumero() + " de " + getNaipe() + " e seu valor é: " + getForca() + "     ";
    }
}
