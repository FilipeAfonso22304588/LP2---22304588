package pt.ulusofona.lp2.greatprogrammingjourney;

import javax.swing.*;
import java.util.ArrayList;
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

        Jogador jogadorEscolhido = null;

        for (Jogador jogador : this.jogadores) {
            if (jogador.getId() == id) {
                jogadorEscolhido = jogador;
            }
        }

        if (jogadorEscolhido == null) {
            return null;
        } else {
            String[] resultado = {jogadorEscolhido.id, jogadorEscolhido.getNome(), jogadorEscolhido.getLinguagemFavorita(),
                    jogadorEscolhido.getCor(), jogadorEscolhido.getPosicao()};
            return resultado;
        }
    }

    public String getProgrammerInfoAsStr(int id) {

        return "";
    }

    public String[] getSlotInfo(int position) {
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
