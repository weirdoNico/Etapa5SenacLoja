package com.mycompany.etapa4_loja;

import com.mycompany.etapa4_loja.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class clienteJPA {

    public static void criar(Cliente cliente) {
        EntityManager manager = JPAUtil.conectar();

        try {
            manager.getTransaction().begin();

            manager.persist(cliente);

            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static List<Cliente> listarTodos() {

        EntityManager manager = JPAUtil.conectar();
        List<Cliente> lista;

        try {
            String jpql = "SELECT c FROM cliente c";
            Query consulta = manager.createQuery(jpql);
            lista = consulta.getResultList();

        } finally {
            JPAUtil.desconectar();
        }

        return lista;
    }

}
