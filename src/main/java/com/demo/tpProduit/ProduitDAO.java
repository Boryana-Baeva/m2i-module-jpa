package com.demo.tpProduit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class ProduitDAO {
    private static EntityManager entityManager = EntityManagerSingleton.getEntityManager("tpProduit");

    public static void save(Produit produit){
        EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();
            entityManager.persist(produit);
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Error during SAVE");
            tx.rollback();
        }
    }

    public static List<Produit> findAll() {
        Query query = entityManager.createQuery("SELECT p FROM Produit p");

        return query.getResultList();
    }

    public static Produit findById(Integer id) {
        return entityManager.find(Produit.class, id);
    }

    public static void delete(Produit produit) {
        EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();
            entityManager.remove(produit);
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Error during DELETE");
            tx.rollback();
        }
    }

    public static void update(Produit produit) {
        EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();
            entityManager.merge(produit);
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Error during UPDATE");
            tx.rollback();
        }
    }
}
