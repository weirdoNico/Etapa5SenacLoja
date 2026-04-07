package com.mycompany.etapa4_loja;

import com.mycompany.etapa4_loja.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;

public class jogoLocavelJPA {

    public static void criar(JogoLocavel jogo) {
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

    public static void registrarLocacao(JogoLocavel jogo) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();

            JogoLocavel jogoManaged = manager.merge(jogo);

            jogoManaged.setLocarStatus(false);

            manager.getTransaction().commit();

        } finally {
            JPAUtil.desconectar();
        }

    }
}
