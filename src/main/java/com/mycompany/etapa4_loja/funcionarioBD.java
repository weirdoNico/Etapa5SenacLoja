
package com.mycompany.etapa4_loja;

import com.mycompany.etapa4_loja.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class funcionarioBD {
    
    public static Funcionario validarUsuarioSeguro(Funcionario funcionario) {
        EntityManager manager = JPAUtil.conectar();
        try {
            String jpql = "SELECT f FROM funcionario f WHERE f.email = :email AND f.senha = :senha";
            Query consulta = manager.createQuery(jpql, Funcionario.class);
            consulta.setParameter("email", funcionario.getEmail());
            consulta.setParameter("senha", funcionario.getSenha());

            return (Funcionario) consulta.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            JPAUtil.desconectar();
        }
    }
}
