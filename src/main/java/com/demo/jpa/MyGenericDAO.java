package com.demo.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class MyGenericDAO {
    private static EntityManager entityManager = EntityManagerSingleton.getEntityManager("demojpa");
    public static <T> void save(T var1) {
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            entityManager.persist(var1);
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de l'enregistrement !");
            tx.rollback();
        }
    }

    public static <T> T findById(Class<T> var1, Integer id){
        return entityManager.find(var1, id);
    }

    public static <T> List<T> findAll(Class<T> var1){
        Query query  = entityManager.createQuery("SELECT t FROM " + var1.getSimpleName() + " t");
        return query.getResultList();
    }


    public static <T> void delete(T var1) {
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            entityManager.remove(var1);
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de la suppression !");
            tx.rollback();
        }
    }

    public static <T> void deleteById(Class<T> var1, Integer id) {
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            Query query = entityManager.createQuery("DELETE FROM " + var1.getSimpleName() + " t WHERE t.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de la suppression avec params !");
            tx.rollback();
        }
    }

    public static <T> void update(T var1){
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            entityManager.merge(var1);
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de la modification !");
            tx.rollback();
        }
    }
}
