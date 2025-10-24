package pt.ulusofona.lp2.greatprogrammingjourney;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Jogador {
    String id;
    String nome;
    String linguagemFavorita;
    String cor;
    int posicao;
    String estado;

    public Jogador(String id, String nome, String linguagemFavorita, String cor) {
        this.id = id;
        this.nome = nome;
        this.linguagemFavorita = formataLinguagens(linguagemFavorita);
        this.cor = cor;
    }

    String formataLinguagens(String linguagemNaoFormatada){

        String linguagensFormatadas = "";

        if (linguagemNaoFormatada != null && !linguagemNaoFormatada.isEmpty()) {

            String[] linguagensDiferentes = linguagemNaoFormatada.split(";");
            Arrays.sort(linguagensDiferentes);

            for (int i = 0; i < linguagensDiferentes.length; i++) {
                linguagensFormatadas += linguagensDiferentes[i];
                if (i != linguagensDiferentes.length - 1 ){
                    linguagensFormatadas += ";";
                }
            }
        }
        return linguagensFormatadas;
    }

    boolean isAtributosInvalido(ArrayList<Integer> idsJaUtilizados, ArrayList<String> coresPossiveis) {

        int id = Integer.parseInt(this.id);

        if ((id <= 0 || idsJaUtilizados.contains(id)) || nome == null || nome.isEmpty() || linguagemFavorita == null ||
                linguagemFavorita.isEmpty() || cor == null || cor.isEmpty() || !coresPossiveis.contains(cor)) {
            return true;
        } else {
            idsJaUtilizados.add(id);
            coresPossiveis.remove(cor);
            return false;
        }
    }

    void inicializaJogador() {
        this.posicao = 1;
        this.estado = "Em Jogo";
    }
    void moveJogador(int resultadoDado){
        this.posicao += resultadoDado;
    }
    void setPosicao(int posicao){
        this.posicao = posicao;
    }

    int getId() {
        return Integer.parseInt(this.id);
    }

    String getNome() {
        return this.nome;
    }

    String getLinguagemFavorita() {
        return this.linguagemFavorita;
    }

    String getCor() {
        return this.cor.toUpperCase();
    }

    int getPosicao() {
        return this.posicao;
    }

    String getEstado() {
        return this.estado;
    }

}
