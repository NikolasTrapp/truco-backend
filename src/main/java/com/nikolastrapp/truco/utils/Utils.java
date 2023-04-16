package com.nikolastrapp.truco.utils;

import com.nikolastrapp.truco.entities.Carta;
import com.nikolastrapp.truco.entities.Equipe;
import com.nikolastrapp.truco.entities.Jogador;

import java.util.*;

public abstract class Utils {

    public static final Map<String, Integer> forcaManilhas = new HashMap<>() {{
        put("Paus", 14);
        put("Copas", 13);
        put("Espadas", 12);
        put("Moles", 11);
    }};

    public static final Map<Integer, Integer> forcaCartas = new HashMap<>() {{
        put(4, 1);
        put(5, 2);
        put(6, 3);
        put(7, 4);
        put(10, 5);
        put(11, 6);
        put(12, 7);
        put(1, 8);
        put(2, 9);
        put(3, 10);
    }};

    public static final Map<Integer, Integer> maquinas = new HashMap<>() {{
        put(4, 5);
        put(5, 6);
        put(6, 7);
        put(7, 10);
        put(10, 11);
        put(11, 12);
        put(12, 1);
        put(1, 2);
        put(2, 3);
        put(3, 4);
    }};

    public static final List<Carta> cartas = new ArrayList<>(Arrays.asList(
            new Carta("Paus", 1),
            new Carta("Paus", 2),
            new Carta("Paus", 3),
            new Carta("Paus", 12),
            new Carta("Paus", 11),
            new Carta("Paus", 10),
            new Carta("Paus", 7),
            new Carta("Paus", 6),
            new Carta("Paus", 5),
            new Carta("Paus", 4),
            new Carta("Copas", 1),
            new Carta("Copas", 2),
            new Carta("Copas", 3),
            new Carta("Copas", 12),
            new Carta("Copas", 11),
            new Carta("Copas", 10),
            new Carta("Copas", 7),
            new Carta("Copas", 6),
            new Carta("Copas", 5),
            new Carta("Copas", 4),
            new Carta("Espadas", 1),
            new Carta("Espadas", 2),
            new Carta("Espadas", 3),
            new Carta("Espadas", 12),
            new Carta("Espadas", 11),
            new Carta("Espadas", 10),
            new Carta("Espadas", 7),
            new Carta("Espadas", 6),
            new Carta("Espadas", 5),
            new Carta("Espadas", 4),
            new Carta("Moles", 1),
            new Carta("Moles", 2),
            new Carta("Moles", 3),
            new Carta("Moles", 12),
            new Carta("Moles", 11),
            new Carta("Moles", 10),
            new Carta("Moles", 7),
            new Carta("Moles", 6),
            new Carta("Moles", 5),
            new Carta("Moles", 4)
    ));

    private static final Set<Carta> cartasEscolhidas = new HashSet<>();

    public static void setCartas(final Jogador jogador1, final Jogador jogador2,
                                 final Jogador jogador3, final Jogador jogador4, Integer maquina) {
        cartas.forEach(Carta::restaurarCarta);
        for (int i = 0; i < 3; i++) {
            adicionarCartaJogador(jogador1, maquina);
            adicionarCartaJogador(jogador2, maquina);
            adicionarCartaJogador(jogador3, maquina);
            adicionarCartaJogador(jogador4, maquina);
        }
        cartasEscolhidas.clear();
    }

    public static void setCartas(final Equipe equipe1, final Equipe equipe2, Integer maquina) {
        cartas.forEach(Carta::restaurarCarta);
        for (int i = 0; i < 3; i++) {
            equipe1.getJogadores().forEach(jogador -> adicionarCartaJogador(jogador, maquina));
            equipe2.getJogadores().forEach(jogador -> adicionarCartaJogador(jogador, maquina));
        }
        cartasEscolhidas.clear();
    }

    public static void adicionarCartaJogador(final Jogador jogador, Integer maquina) {
        Carta carta = cartas.get(getRandom(0, 40));
        while (!cartasEscolhidas.add(carta)) {
            carta = cartas.get(getRandom(0, 40));
        }
        if (maquinas.get(maquina) == carta.getNumero()) carta.setManilha(true);
        jogador.addCarta(carta);
        carta.setJogador(jogador);
    }

    public static Integer sortearMaquina() {
        return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 10, 11, 12).get(getRandom(0, 10));
    }

    public static int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
}
