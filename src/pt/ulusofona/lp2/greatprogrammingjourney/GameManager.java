package pt.ulusofona.lp2.greatprogrammingjourney;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class GameManager {
    ArrayList<Jogador> jogadores = new ArrayList<>();
    boolean jogoFinalizado;
    int tamanhoTabuleiro;

    public GameManager() {
    }

    public boolean createInitialBoard(String[][] playerInfo, int worldSize) {

        ArrayList<Integer> idJaUtilizados = new ArrayList<>();
        ArrayList<String> coresPossiveis = new ArrayList<>();

        coresPossiveis.add("Green");
        coresPossiveis.add("Blue");
        coresPossiveis.add("Brown");
        coresPossiveis.add("Purple");

        //verifica se espaço do tabuleiro é suficiente e o número de jogadores necessário
        if (worldSize < playerInfo.length * 2 || playerInfo.length < 2 || playerInfo.length > 4) {
            return false;
        }

        //Verifica jogador a jogador se os dados estão bem
        for (String[] jogadores : playerInfo) {

            if (jogadores == null) {
                return false;
            }

            String id = jogadores[0];
            String nome = jogadores[1];
            String linguagemFavorita = jogadores[2];
            String cor = jogadores[3];

            Jogador jogadorTeste = new Jogador(id, nome, linguagemFavorita, cor);

            if (jogadorTeste.isAtributosInvalido(idJaUtilizados, coresPossiveis)) {
                return false;
            } else {
                jogadorTeste.inicializaJogador();
                this.jogadores.add(jogadorTeste);
            }
        }
        this.jogoFinalizado = false;
        jogadores.sort(Comparator.comparingInt(j -> Integer.parseInt(j.id)));
        return true;
    }

    public String getImagePng(int nrSquare) {
        if (nrSquare == this.tamanhoTabuleiro) {
            return "glory.png";
        } else {
            return null;
        }
    }

    public String[] getProgrammerInfo(int id) {

        if (id <= 0) {
            return null;
        }

        String[] resultado = null;

        for (Jogador jogador : this.jogadores) {
            if (jogador.getId() == id) {
                resultado = new String[]{String.valueOf(jogador.getId()), jogador.getNome(), jogador.getLinguagemFavorita(),
                        jogador.getCor(), jogador.getPosicao()};
            }
        }
        return resultado;
    }

    public String getProgrammerInfoAsStr(int id) {

        if (id <= 0) {
            return null;
        }

        String resultado = null;

        for (Jogador jogador : this.jogadores) {
            if (jogador.getId() == id) {
                resultado = jogador.id + " | " + jogador.getNome()+ " | " + jogador.getPosicao() + " | " +
                        jogador.getLinguagemFavorita()+ " | " + jogador.getEstado();
            }
        }
        return resultado;

}

    public String[] getSlotInfo(int position) {

        if (position < 1 || position > this.tamanhoTabuleiro){
            return null;
        }
        
        return null;
    }

    public int getCurrentPlayerID() {
        return 0;
    }

    public boolean moveCurrentPlayer(int nrSpaces) {
        return true;
    }

    public boolean gameIsOver() {
        return true;
    }

    public ArrayList<String> getGameResults() {
        return null;
    }

    public JPanel getAuthorsPanel() {
        return null;
    }

    public HashMap<String, String> customizeBoard() {
        return null;
    }


}
