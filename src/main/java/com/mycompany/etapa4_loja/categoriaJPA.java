package com.mycompany.etapa4_loja;

import com.mycompany.etapa4_loja.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class categoriaJPA {

    public static void criar(Categoria categoria) {
        EntityManager manager = JPAUtil.conectar();

        try {
            manager.getTransaction().begin();

            manager.persist(categoria);

            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static List<Categoria> listar() {

        EntityManager manager = JPAUtil.conectar();
        List<Categoria> lista;

        try {
            String jpql = "SELECT c FROM categoria c";
            Query consulta = manager.createQuery(jpql);
            lista = consulta.getResultList();

        } finally {
            JPAUtil.desconectar();
        }

        return lista;
    }

}
