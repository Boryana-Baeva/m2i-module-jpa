package com.demo.tpVoiture;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerSingletonVoiture {

    private static EntityManager entityManager;

    public static EntityManager getEntityManager(String dataSourceName) {

        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(dataSourceName);
            entityManager = emf.createEntityManager();
        }

        return entityManager;
    }
}