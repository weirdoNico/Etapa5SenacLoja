package com.mycompany.etapa4_loja;

import com.mycompany.etapa4_loja.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;

public class locacaoJPA {

    public static void criar(Locacao locacao) {
        EntityManager manager = JPAUtil.conectar();

        try {
            manager.getTransaction().begin();

            manager.persist(locacao);

            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.desconectar();
        }
    }

}
