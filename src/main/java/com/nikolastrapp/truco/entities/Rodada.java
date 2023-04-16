package com.nikolastrapp.truco.entities;

import com.nikolastrapp.truco.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Rodada {

    private Integer pontuacao = 1;
    private Jogador vencedor;
    private Integer maquina;
    private Integer manilha;
    List<Equipe> equipes = new ArrayList<>();
    List<Carta> cartasJogadas = new ArrayList<>();

    public Rodada(Equipe equipe1, Equipe equipe2) {
        equipes.add(equipe1);
        equipes.add(equipe2);
        setMaquina(Utils.sortearMaquina());
        setManilha(Utils.maquinas.get(getMaquina()));
        Utils.setCartas(equipe1, equipe2, getMaquina());
    }

    public void aumentarPotuacaoRodada() {
        if (getPontuacao() == 1) this.pontuacao += 2;
        else if (getPontuacao() > 1 && getPontuacao() < 12) this.pontuacao += 3;
        else return;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    private void setVencedor(Jogador vencedor) {
        this.vencedor = vencedor;
    }

    public Integer getMaquina() {
        return maquina;
    }

    private void setMaquina(Integer maquina) {
        this.maquina = maquina;
    }

    public Integer getManilha() {
        return manilha;
    }

    private void setManilha(Integer manilha) {
        this.manilha = manilha;
    }

    public void addCarta(Carta carta) {
        this.cartasJogadas.add(carta);
    }

    public Jogador getVencedor() {
        Integer maior = 0;
        for (Carta carta : getCartasJogadas()) {
            if (carta.getForca() > maior) {
                setVencedor(carta.getJogador());
            } else if (carta.getForca() == maior && !carta.getJogador().getEquipe().equals(vencedor.getEquipe())) {
                setVencedor(null);
            }
        }
        return vencedor;
    }

    public List<Carta> getCartasJogadas() {
        return cartasJogadas;
    }

}
