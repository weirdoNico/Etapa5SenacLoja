package com.mycompany.etapa4_loja;

import com.mycompany.etapa4_loja.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;

public class compraJPA {

    public static void criar(Compra compra) {
        EntityManager manager = JPAUtil.conectar();

        try {
            manager.getTransaction().begin();

            manager.persist(compra);

            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.desconectar();
        }
    }
    }
