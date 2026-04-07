/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.etapa4_loja.persistencia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


// Classe responsável pela configuração da persistência.
public class JPAUtil {
    private static String PERSISTENCE_UNIT = "Loja-PU";
    private static EntityManager manager;
    private static EntityManagerFactory factory;

    public static EntityManager conectar() {
        if (factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }

        if (manager == null || !manager.isOpen()) {
            manager = factory.createEntityManager();
        }

        return manager;
    }
    
    public static void desconectar() {
    if (manager.isOpen() && manager != null) {
        manager.close();
    }
    factory.close();
}
}
