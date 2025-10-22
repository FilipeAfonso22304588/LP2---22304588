package pt.ulusofona.lp2.greatprogrammingjourney;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> idJaUtilizados = new ArrayList<>();
        ArrayList<String> coresPossiveis = new ArrayList<>();

        coresPossiveis.add("Green");
        coresPossiveis.add("Blue");
        coresPossiveis.add("Brown");
        coresPossiveis.add("Purple");

        Jogador teste = new Jogador("123","123","","Orange");
        Jogador teste2 = new Jogador("526","123","Java;C","Green");

        System.out.println(teste.isAtributosInvalido(idJaUtilizados,coresPossiveis));
        System.out.println(teste2.isAtributosInvalido(idJaUtilizados,coresPossiveis));

    }
}
