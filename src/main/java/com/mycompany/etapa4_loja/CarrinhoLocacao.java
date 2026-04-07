package com.mycompany.etapa4_loja;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoLocacao {

    private static List<JogoLocavel> itens = new ArrayList<>();

    public static void adicionar(JogoLocavel jogo) {
        itens.add(jogo);
    }

    public static void remover(JogoLocavel jogo) {
        itens.remove(jogo);
    }

    public static List<JogoLocavel> getItens() {
        return itens;
    }
    
    public static void limpar() {
        itens.clear();
    }

}
