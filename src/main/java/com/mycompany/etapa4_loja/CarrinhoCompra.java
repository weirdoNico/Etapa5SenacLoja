package com.mycompany.etapa4_loja;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompra {

    private static List<JogoCompravel> itens = new ArrayList<>();

    public static void adicionar(JogoCompravel jogo) {
        itens.add(jogo);
    }

    public static void remover(JogoCompravel jogo) {
        itens.remove(jogo);
    }

    public static List<JogoCompravel> getItens() {
        return itens;
    }

    public static void limpar() {
        itens.clear();
    }

}
