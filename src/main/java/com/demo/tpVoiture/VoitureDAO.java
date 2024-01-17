package com.demo.tpVoiture;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class VoitureDAO {
    private static EntityManager entityManager = EntityManagerSingletonVoiture.getEntityManager("tpVoitures");
    public static void save(Voiture voiture) {
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            entityManager.persist(voiture);
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de l'enregistrement !");
            tx.rollback();
        }
    }

    public static Voiture findById(Integer id){
        return entityManager.find(Voiture.class, id);
    }

    public static List<Voiture> findAll(){
        Query query  = entityManager.createQuery("SELECT v FROM Voiture v");
        return query.getResultList();
    }


    public static void delete(Voiture voiture) {
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            entityManager.remove(voiture);
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
            Query query = entityManager.createQuery("DELETE FROM Voiture v WHERE v.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de la suppression avec params !");
            tx.rollback();
        }
    }

    public static void update(Voiture voiture){
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            entityManager.merge(voiture);
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Erreur lors de la modification !");
            tx.rollback();
        }
    }
}
