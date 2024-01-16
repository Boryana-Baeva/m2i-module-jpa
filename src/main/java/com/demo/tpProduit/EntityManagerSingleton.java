package com.demo.tpProduit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerSingleton {
    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        if(entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpProduit");
            entityManager = emf.createEntityManager();
        }

        return entityManager;

    }
}
