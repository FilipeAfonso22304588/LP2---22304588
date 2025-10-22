package pt.ulusofona.lp2.greatprogrammingjourney;

import java.util.ArrayList;

public class Jogador {
    String id;
    String nome;
    String linguagemFavorita;
    String cor;

    public Jogador(String id, String nome, String linguagemFavorita, String cor) {
        this.id = id;
        this.nome = nome;
        this.linguagemFavorita = linguagemFavorita;
        this.cor = cor;
    }
    boolean isAtributosInvalido(ArrayList<Integer> idsJaUtilizados, ArrayList<String> coresPossiveis) {

        int id = Integer.parseInt(this.id);

        if ((id <= 0 || idsJaUtilizados.contains(id)) || nome == null || nome.isEmpty() || linguagemFavorita == null ||
                linguagemFavorita.isEmpty() || cor == null || cor.isEmpty() || !coresPossiveis.contains(cor)) {
            return true;
        } else {
            idsJaUtilizados.add(id);
            return false;
        }
    }
}
