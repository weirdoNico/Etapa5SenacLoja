
package com.mycompany.etapa4_loja;

import com.mycompany.etapa4_loja.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class jogoJPA {

    public static List<Jogo> buscar(String pesquisa, String filtro) {
        EntityManager manager = JPAUtil.conectar();

        try {
            StringBuilder jpql = new StringBuilder("SELECT j FROM jogo j LEFT JOIN FETCH j.categorias WHERE 1=1");

            if (filtro.equals("Locáveis")) {
                jpql.append(" AND TYPE(j) = jogoLocavel AND j.locarStatus = true");

            } else if (filtro.equals("Compráveis")) {
                jpql.append(" AND TYPE(j) = jogoCompravel AND j.quantidadeEstoque > 0");
            }

            if (pesquisa != null && !pesquisa.isEmpty()) {
                jpql.append(" AND LOWER(j.nome) LIKE :nome");
            }

            Query consulta = manager.createQuery(jpql.toString());

            if (pesquisa != null && !pesquisa.isEmpty()) {
                consulta.setParameter("nome", "%" + pesquisa.toLowerCase() + "%");
            }

            return consulta.getResultList();

        } finally {
            JPAUtil.desconectar();
        }
    }

    public static void excluir(Jogo jogo) {
        EntityManager manager = JPAUtil.conectar();

        try {
            manager.getTransaction().begin();

            jogo = manager.merge(jogo);
            manager.remove(jogo);

            manager.getTransaction().commit();

        } finally {
            JPAUtil.desconectar();
        }
    }

}
