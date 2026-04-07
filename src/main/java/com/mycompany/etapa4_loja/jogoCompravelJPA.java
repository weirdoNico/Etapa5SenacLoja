package com.mycompany.etapa4_loja;

import com.mycompany.etapa4_loja.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;

public class jogoCompravelJPA {

    public static void criar(JogoCompravel jogo) {
        EntityManager manager = JPAUtil.conectar();

        try {
            manager.getTransaction().begin();

            manager.persist(jogo);

            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static void registrarVenda(JogoCompravel jogo) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();

            JogoCompravel jogoManaged = manager.merge(jogo);

            if (jogoManaged.getQuantidadeEstoque() > 0) {
                jogoManaged.setQuantidadeEstoque(jogoManaged.getQuantidadeEstoque() - 1);
                manager.getTransaction().commit();
            } else {
                manager.getTransaction().rollback();
            }
        } finally {
            JPAUtil.desconectar();
        }

    }
}
