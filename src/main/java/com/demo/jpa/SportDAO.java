package com.demo.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class SportDAO {
    private static EntityManager entityManager = EntityManagerSingleton.getEntityManager("demojpa");
    public static void save(Sport s) {
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            entityManager.persist(s);
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de l'enregistrement !");
            tx.rollback();
        }
    }

    public static Sport findById(Integer id){
        return entityManager.find(Sport.class, id);
    }

    public static List<Sport> findAll(){
        // JPQL : sorte de requete SQL mais avec les classes Java
        Query query  = entityManager.createQuery("SELECT s FROM Sport s");// SELECT * FROM persons;
        return query.getResultList();
    }


    public static void delete(Sport s) {
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            entityManager.remove(s);
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de la suppression !");
            tx.rollback();
        }
    }

    public static void deleteById(Integer id) {
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            Query query = entityManager.createQuery("DELETE FROM Sport s WHERE s.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de la suppression avec params !");
            tx.rollback();
        }
    }

    public static void update(Sport s){
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            entityManager.merge(s);
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de la modification !");
            tx.rollback();
        }
    }
}
